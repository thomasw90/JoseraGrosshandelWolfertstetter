package com.example.thomas.joseragrosshandelwolfertstetter.UserManagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.thomas.joseragrosshandelwolfertstetter.R;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_sign_up);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        setTitle("Registrierung");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button createAccount = (Button) findViewById(R.id.createAccount);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                register();
            }
        });
    }

    private void register(){
        String email = ((EditText) findViewById(R.id.email)).getText().toString();
        String passwort = ((EditText) findViewById(R.id.passwort)).getText().toString();

        if(email.isEmpty()){
            Toast.makeText(getApplicationContext(), "Email eingeben!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(passwort.isEmpty()){
            Toast.makeText(getApplicationContext(), "Passwort eingeben!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(passwort.length() < 6){
            Toast.makeText(getApplicationContext(), "Passwortlänge mindestens 6 Zeichen!", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email, passwort)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            if(user != null){
                                user.sendEmailVerification();
                            }
                            startActivity(new Intent(SignUp.this, Login.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Registrierung fehlgeschlagen!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
