package com.example.thomas.joseragrosshandelwolfertstetter.UserManagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.TextView;

import com.example.thomas.joseragrosshandelwolfertstetter.R;


public class PersonalData extends AppCompatActivity {
    private TextView prename;
    private TextView name;
    private TextView street;
    private TextView zipcode;
    private TextView phoneNumber;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_personaldata);

        setTitle("Daten ändern");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prename = (TextView) findViewById(R.id.inputPrename);
        name = (TextView) findViewById(R.id.inputName);
        street = (TextView) findViewById(R.id.inputStreet);
        zipcode = (TextView) findViewById(R.id.inputZipcode);
        phoneNumber = (TextView) findViewById(R.id.inputPhonenumber);
        pref = getApplicationContext().getSharedPreferences("JoseraW", MODE_PRIVATE);

        createButtonListeners();
        loadData();
    }

    private void createButtonListeners()
    {
        Button buttonZurueck = (Button) findViewById(R.id.btnBack);
        buttonZurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        Button buttonSpeichern = (Button) findViewById(R.id.btnSave);
        buttonSpeichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                saveData();
            }
        });
    }

    private void saveData()
    {
        pref.edit().putString("prename", prename.getText().toString());
        pref.edit().putString("name", name.getText().toString());
        pref.edit().putString("street", street.getText().toString());
        pref.edit().putString("zipcode", zipcode.getText().toString());
        pref.edit().putString("phoneNumber", phoneNumber.getText().toString());
        pref.edit().commit();
        finish();
    }

    private void loadData()
    {
        prename.setText(pref.getString("prename", ""));
        name.setText(pref.getString("name", ""));
        street.setText(pref.getString("street", ""));
        zipcode.setText(pref.getString("zipcode", ""));
        phoneNumber.setText(pref.getString("phonenumber", ""));
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
