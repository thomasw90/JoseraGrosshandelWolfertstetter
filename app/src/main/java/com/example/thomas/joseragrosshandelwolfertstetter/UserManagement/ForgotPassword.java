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

import com.example.thomas.joseragrosshandelwolfertstetter.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_forgot_password);

        setTitle("Passwort zurücksetzen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        Button btnResetPw = (Button) findViewById(R.id.btnResetPw);
        btnResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                resetPW();
            }
        });
    }

    private void resetPW(){
        String email = ((EditText) findViewById(R.id.forgotEmail)).getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(getApplication(), "Email eingeben!", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(ForgotPassword.this, Login.class));
                } else {
                    Toast.makeText(ForgotPassword.this, "Fehlgeschlagen!", Toast.LENGTH_SHORT).show();
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
