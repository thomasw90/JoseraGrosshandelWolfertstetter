package com.example.thomas.joseragrosshandelwolfertstetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button datenAendernBtn = (Button) findViewById(R.id.datenAendern);
        datenAendernBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                starteDatenAendern();
            }
        });
    }

    private void starteDatenAendern()
    {
        Intent intent = new Intent(this, daten.class);
        startActivity(intent);
    }
}
