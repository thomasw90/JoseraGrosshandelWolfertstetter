package com.example.thomas.joseragrosshandelwolfertstetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.TextView;


public class daten extends AppCompatActivity {
    private TextView vorname;
    private TextView nachname;
    private TextView strasse;
    private TextView plz;
    private TextView telNr;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daten);

        vorname = (TextView) findViewById(R.id.eingabeVorname);
        nachname = (TextView) findViewById(R.id.eingabeNachname);
        strasse = (TextView) findViewById(R.id.eingabeStrasse);
        plz = (TextView) findViewById(R.id.eingabePlz);
        telNr = (TextView) findViewById(R.id.eingabeTelNr);
        pref = getApplicationContext().getSharedPreferences("JoseraW", MODE_PRIVATE);
        editor = pref.edit();

        erstelleButtonListeners();
        ladeDaten();
    }

    private void erstelleButtonListeners()
    {
        Button buttonZurueck = (Button) findViewById(R.id.buttonZurueck);
        buttonZurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        Button buttonSpeichern = (Button) findViewById(R.id.buttonSpeichern);
        buttonSpeichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                speichereDaten();
            }
        });
    }

    private void speichereDaten()
    {
        editor.putString("vorname", vorname.getText().toString());
        editor.putString("nachname", nachname.getText().toString());
        editor.putString("strasse", strasse.getText().toString());
        editor.putString("plz", plz.getText().toString());
        editor.putString("telnr", telNr.getText().toString());
        editor.commit();
        finish();
    }

    private void ladeDaten()
    {
        vorname.setText(pref.getString("vorname", ""));
        nachname.setText(pref.getString("nachname", ""));
        strasse.setText(pref.getString("strasse", ""));
        plz.setText(pref.getString("plz", ""));
        telNr.setText(pref.getString("telnr", ""));
    }
}
