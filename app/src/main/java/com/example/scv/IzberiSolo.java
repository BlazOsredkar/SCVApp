package com.example.scv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class IzberiSolo extends AppCompatActivity {
    private Sole sole = new Sole();
    private Spinner spiner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izberi_solo);

        sole.Load();

        spiner = (Spinner) findViewById(R.id.spinner);

        SharedPreferences prefs = getSharedPreferences(sole.PREFS_NAME, MODE_PRIVATE);
        String krajsava = prefs.getString(sole.PREF_IZBRANA_SOLA_KEY,"ERŠ");
        sole.shraniIzbranoSolo(krajsava);
        Sola izbranaSola = sole.dobiTrenutnoSolo();

        List<String> imena = new ArrayList<String>();



        for(Sola so: sole.Sole){
            imena.add(so.krajsava + " - " + so.ime);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,imena);

        spiner.setAdapter(adapter);

        ImageView imgView = findViewById(R.id.imageView);

        spiner.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                String[] selectedItem = spiner.getSelectedItem().toString().split(" ");
                String krajsnica = selectedItem[0];
                if(!krajsnica.equals("Izberi")){
                    sole.shraniIzbranoSolo(krajsnica);
                    Sola izbranaSola = sole.dobiTrenutnoSolo();
                    imgView.setImageResource(izbranaSola.slika);
                }
            }
        });

    }


    public void onBtnClick(View view){
        String[] selectedItem = spiner.getSelectedItem().toString().split(" ");
        String krajsnica = selectedItem[0];
        SharedPreferences prefs = getSharedPreferences(sole.PREFS_NAME, MODE_PRIVATE);
        prefs.edit().putString(sole.PREF_IZBRANA_SOLA_KEY,krajsnica).apply();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}