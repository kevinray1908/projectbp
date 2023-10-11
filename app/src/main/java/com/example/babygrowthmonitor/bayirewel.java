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

public class bayirewel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayirewel);

        ListView rewellist = findViewById(R.id.Listrewel);

        Item[] items = {
                new Item ("Coba gendong bayi"),
                new Item("Berikan ASI"),
                new Item("Ayunkan bayi")
        };

        ArrayAdapter<Item> itemArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        rewellist.setAdapter(itemArrayAdapter);

        rewellist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Item item = itemArrayAdapter.getItem(position);}
        });

        Button btnback = findViewById(R.id.btnbackrewel);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bayirewel.this, TipsActivity.class);
                startActivity(intent);
            }
        });
    }
}