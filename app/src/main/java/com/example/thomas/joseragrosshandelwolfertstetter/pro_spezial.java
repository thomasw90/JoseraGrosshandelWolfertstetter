package com.example.thomas.joseragrosshandelwolfertstetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.text.Spanned;
import android.text.Html;

public class pro_spezial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_spezial);

        TextView view = (TextView)findViewById(R.id.pro_spezial_beschreibung);
        String formattedText = getString(R.string.pro_spezial_lang);
        Spanned result = Html.fromHtml(formattedText);
        view.setText(result);


        setTitle("Pro Spezial");
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
