package com.example.thomas.joseragrosshandelwolfertstetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.widget.TextView;

public class frumi_plus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frumi_plus);

        TextView view = (TextView)findViewById(R.id.frumi_plus_beschreibung);
        String formattedText = getString(R.string.frumi_plus_lang);
        Spanned result = Html.fromHtml(formattedText);
        view.setText(result);


        setTitle("Frumi Plus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
