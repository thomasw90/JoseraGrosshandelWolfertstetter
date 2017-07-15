package com.example.thomas.joseragrosshandelwolfertstetter.UserManagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.example.thomas.joseragrosshandelwolfertstetter.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_settings);

        setTitle("Einstellungen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnPersonalData = (Button) findViewById(R.id.personalData);
        btnPersonalData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openPersonalData();
            }
        });
    }

    private void openPersonalData(){
        Intent intent = new Intent(this, PersonalData.class);
        startActivity(intent);
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
