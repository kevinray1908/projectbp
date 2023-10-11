package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipsActivity extends AppCompatActivity {

    CardView bayirewel;
    CardView bayidemam;
    CardView bayikembung;
    CardView bayiruam;
    CardView bayisusahtidur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        bayirewel = findViewById(R.id.cardview_bayirewel);
        bayidemam = findViewById(R.id.demam);
        bayikembung = findViewById(R.id.card_view_kembung);
        bayiruam = findViewById(R.id.card_view_ruam);
        bayisusahtidur = findViewById(R.id.card_view_tidur);

        bayirewel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(TipsActivity.this, bayirewel.class);
                startActivity(startersActivityIntent);
            }
        });
        bayidemam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(TipsActivity.this, demam.class);
                startActivity(startersActivityIntent);
            }
        });
        bayikembung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(TipsActivity.this, kembung.class);
                startActivity(startersActivityIntent);
            }
        });
        bayiruam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(TipsActivity.this, ruam.class);
                startActivity(startersActivityIntent);
            }
        });
        bayisusahtidur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(TipsActivity.this, tidur.class);
                startActivity(startersActivityIntent);
            }
        });
        Button btnback = findViewById(R.id.btnbackawal);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TipsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}