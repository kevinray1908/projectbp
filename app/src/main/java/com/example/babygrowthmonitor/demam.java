package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class demam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demam);

        ListView rewellist = findViewById(R.id.Listdemam);

        Item[] items = {
                new Item ("Pantau suhu tubuh"),
                new Item("Perhatikan kelembaban ruangan"),
                new Item("Berikan cairan yang cukup"),
                new Item("Kompres dingin"),
                new Item("Ikuti petunjuk dokter")
        };

        ArrayAdapter<Item> itemArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        rewellist.setAdapter(itemArrayAdapter);

        rewellist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Item item = itemArrayAdapter.getItem(position);}
        });

        Button btnback = findViewById(R.id.btnbackdemam);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(demam.this, TipsActivity.class);
                startActivity(intent);
            }
        });
    }
}