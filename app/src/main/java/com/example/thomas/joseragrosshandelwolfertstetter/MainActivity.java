package com.example.thomas.joseragrosshandelwolfertstetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import com.example.thomas.joseragrosshandelwolfertstetter.UserManagement.PersonalData;
import com.example.thomas.joseragrosshandelwolfertstetter.UserManagement.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button datenAendernBtn = (Button) findViewById(R.id.settings);
        datenAendernBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openSettings();
            }
        });

        Button artikelBtn = (Button) findViewById(R.id.artikel);
        artikelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                starteArtikel();
            }
        });

        Button bestellenBtn = (Button) findViewById(R.id.bestellen);
        bestellenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                starteBestellen();
            }
        });

    }

    private void openSettings()
    {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    private void starteArtikel()
    {
        Intent intent = new Intent(this, Artikel.class);
        startActivity(intent);
    }

    private void starteBestellen()
    {
        Intent intent = new Intent(this, Bestellen.class);
        startActivity(intent);
    }
}
