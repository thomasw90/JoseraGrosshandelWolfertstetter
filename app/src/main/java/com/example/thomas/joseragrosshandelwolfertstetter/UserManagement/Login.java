package com.example.thomas.joseragrosshandelwolfertstetter.UserManagement;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thomas.joseragrosshandelwolfertstetter.MainActivity;
import com.example.thomas.joseragrosshandelwolfertstetter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth auth;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    public void onStart() {
        super.onStart();

        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // Automatischer Login möglich
                    boolean isLoggedIn = pref.getBoolean("speicherelogin", false);
                    if(isLoggedIn){
                        // Checkbox "Eingeloggt bleiben" ausgewählt
                        startActivity(new Intent(Login.this, MainActivity.class));
                    }
                }
                else {
                    // Login nicht möglich
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_login);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        // Shared Preferences
        pref = getSharedPreferences("JoseraW", MODE_PRIVATE);
        editor = pref.edit();

        setTitle("Login");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                login();
            }
        });

        TextView jetztRegistrieren = (TextView) findViewById(R.id.jetztRegistrieren);
        jetztRegistrieren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });

        TextView passwortVergessen = (TextView) findViewById(R.id.passwortVergessen);
        passwortVergessen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Login.this, ForgotPassword.class));
            }
        });
    }

    private void login(){
        String email = ((EditText) findViewById(R.id.emailLogin)).getText().toString();
        String passwort = ((EditText) findViewById(R.id.passwortLogin)).getText().toString();

        if(email.isEmpty()){
            Toast.makeText(getApplicationContext(), "Email eingeben!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(passwort.isEmpty()){
            Toast.makeText(getApplicationContext(), "Passwort eingeben!", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(email, passwort)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            if(user != null && user.isEmailVerified()){

                                // Speichere ob Login gespeichert werden soll
                                editor.putBoolean("speicherelogin", ((CheckBox)findViewById(R.id.checkboxLogin)).isChecked());
                                editor.commit();

                                // Wenn Login erfolgreich, starte MainActivity
                                startActivity(new Intent(Login.this, MainActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(), "Email noch nicht verifiziert!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Login fehlgeschlagen!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
