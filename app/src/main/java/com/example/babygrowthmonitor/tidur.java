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

public class tidur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tidur);

        ListView rewellist = findViewById(R.id.Listtidur);

        Item[] items = {
                new Item ("Rutinitas Tidur yang Tepat"),
                new Item("Kenali Tanda Bayi Mengatuk"),
                new Item("Perhatikan Pola Makan"),
                new Item("Pijat atau Sentuhan Lembut"),
                new Item("Konsultasikan pada Dokter")
        };

        ArrayAdapter<Item> itemArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        rewellist.setAdapter(itemArrayAdapter);

        rewellist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Item item = itemArrayAdapter.getItem(position);}
        });

        Button btnback = findViewById(R.id.btnbacktidur);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tidur.this, TipsActivity.class);
                startActivity(intent);
            }
        });
    }
}