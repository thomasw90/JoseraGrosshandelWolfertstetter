package com.example.thomas.joseragrosshandelwolfertstetter;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ImageButton;
import android.util.TypedValue;
import android.content.res.Resources;
import android.widget.ArrayAdapter;
import android.graphics.PorterDuff;
import android.graphics.Color;
import android.view.WindowManager;

public class Bestellen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestellen);

        setTitle("Bestellen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton artikelHinzufuegenBtn = (ImageButton) findViewById(R.id.artikelHinzufuegen);
        artikelHinzufuegenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                neuerArtikel();
            }
        });
        neuerArtikel();
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    class MeinArtikel
    {
        private LinearLayout layout;
        private Spinner dropdown;
        private EditText anzahl;
        private Button loescheArtikel;


        public MeinArtikel(Bestellen bestellen)
        {
            Resources r = getResources();
            int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());

            layout = new LinearLayout(bestellen);
            dropdown = new Spinner(bestellen);
            anzahl = new EditText(bestellen);
            loescheArtikel = (Button) getLayoutInflater().inflate(R.layout.button_loeschen, null);

            ///////////////////////////////////////////////////////////////////////////
            // DROPDOWN
            LinearLayout.LayoutParams dropdownParam = new LinearLayout.LayoutParams(
                    0,
                    px,
                    6.0f
            );
            dropdown.setLayoutParams(dropdownParam);

            ArrayAdapter adapter = ArrayAdapter.createFromResource(bestellen,
                    R.array.josera_artikel, R.layout.spinner_item);

            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
            dropdown.setAdapter(adapter);
            // PFEIL-FARBE
            dropdown.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);

            ///////////////////////////////////////////////////////////////////////////
            // ANZAHL
            LinearLayout.LayoutParams anzahlParam = new LinearLayout.LayoutParams(
                    0,
                    px,
                    1.0f
            );
            anzahl.setLayoutParams(anzahlParam);
            anzahl.setTextColor(Color.parseColor("#ffffff"));
            anzahl.setInputType(InputType.TYPE_CLASS_NUMBER);

            ///////////////////////////////////////////////////////////////////////////
            // LÖSCHBUTTON
            LinearLayout.LayoutParams buttonParam = new LinearLayout.LayoutParams(
                    px,
                    px
            );
            loescheArtikel.setLayoutParams(buttonParam);
            loescheArtikel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
                    loescheArtikel(mainLayout.indexOfChild(layout));
                }
            });

            ///////////////////////////////////////////////////////////////////////////
            // ITEMS HINZUFÜGEN
            layout.addView(dropdown);
            layout.addView(anzahl);
            layout.addView(loescheArtikel);
        }

        public LinearLayout getLayout()
        {
            return layout;
        }
    }

    public void neuerArtikel()
    {
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        mainLayout.addView(new MeinArtikel(this).getLayout(), mainLayout.getChildCount() - 2);
    }

    public void loescheArtikel(int i)
    {
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        mainLayout.removeViewAt(i);
    }

    public void bestelleArtikel()
    {

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
