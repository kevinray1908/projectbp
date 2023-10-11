package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    CardView bb;
    CardView suhu;
    CardView monitoring;
    CardView tips;
    TextView lokasiText, hubungiText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bb = findViewById(R.id.card_view_bb);
        suhu = findViewById(R.id.card_view_makanan);
        monitoring = findViewById(R.id.card_view_monitoring);
        tips = findViewById(R.id.card_view_tips);
        lokasiText = findViewById(R.id.text_view_lokasi);
        hubungiText = findViewById(R.id.text_view_hubungi);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pembukaActivityIntent = new Intent(MenuActivity.this,
                        bbActivity.class);
                startActivity(pembukaActivityIntent);
            }
        });

        suhu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent utamaActivityIntent = new Intent(MenuActivity.this, suhuActivity.class);
                startActivity(utamaActivityIntent);
            }
        });

        monitoring.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent DataActivityIntent = new Intent(MenuActivity.this, dataActivity.class);
                startActivity(DataActivityIntent);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Tips = new Intent(MenuActivity.this, TipsActivity.class);
                startActivity(Tips);
            }
        });

        lokasiText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchermap = new Intent(Intent.ACTION_VIEW);
                launchermap.setData(Uri.parse
                        ("geo:-7.273946852840151, 112.79371116759155?q=Politeknik+Elektronika+Negeri+Surabaya"));
                startActivity(launchermap);
            }
        });

        TextView hubungiText = findViewById(R.id.text_view_hubungi);
        hubungiText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startersActivityIntent = new Intent(MenuActivity.this, HubungiActivity.class);
                startActivity(startersActivityIntent);
            }
        });
    }
}