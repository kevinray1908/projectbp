package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class dataActivity extends AppCompatActivity {
    TextView dataStatus;
    Button button_monitoring;
    String DM, DBB, DTB, DU, DS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        // Retrieve data from intent
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        DM = preferences.getString("key_Nama", getIntent().getStringExtra("key_Nama"));
        DBB = preferences.getString("key_beratbadan", getIntent().getStringExtra("key_beratbadan"));
        DTB = preferences.getString("key_tinggibadan", getIntent().getStringExtra("key_tinggibadan"));
        DU = preferences.getString("key_umur", getIntent().getStringExtra("key_umur"));
        DS = preferences.getString("key_suhu", getIntent().getStringExtra("key_suhu"));

        // Initialize UI elements
        TextView dataNama = findViewById(R.id.dataNama);
        TextView databeratbadan = findViewById(R.id.dataBB);
        TextView datatinggibadan = findViewById(R.id.dataTB);
        TextView dataumur = findViewById(R.id.dataumur);
        TextView datasuhu = findViewById(R.id.datasuhu);
        dataStatus = findViewById(R.id.datastatus);
        button_monitoring = findViewById(R.id.btnbackmenu);

        // Set data to TextViews
        dataNama.setText("Nama : " + DM);
        dataumur.setText("Umur : " + DU + " tahun");
        datatinggibadan.setText("Tinggi Badan : " + DTB + " cm");
        databeratbadan.setText("Berat Badan : " + DBB + " kg");
        datasuhu.setText("Suhu : " + DS + " C");

        // Check and set dataStatus based on temperature
        double suhu = 0.0;
        if (DS != null && !DS.trim().isEmpty()) {
            suhu = Double.parseDouble(DS);
            if (suhu < 35) {
                dataStatus.setText("Status: Bayi Kedinginan (Hipotermia)");
            } else if (suhu >= 35 && suhu <= 38) {
                dataStatus.setText("Status: Bayi Sehat");
            } else {
                dataStatus.setText("Status: Bayi demam (Hipertermia)");
            }
        }else{Toast.makeText(this, "Data not received", Toast.LENGTH_SHORT).show();
            finish();}

        button_monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save data to SharedPreferences before navigating to MenuActivity
                saveDataToSharedPreferences();
                Intent monitoring = new Intent(dataActivity.this, MenuActivity.class);
                startActivity(monitoring);
            }
        });
    }

    // Save data to SharedPreferences
    private void saveDataToSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("key_Nama", DM);
        editor.putString("key_beratbadan", DBB);
        editor.putString("key_tinggibadan", DTB);
        editor.putString("key_umur", DU);
        editor.putString("key_suhu", DS);
        editor.apply();
    }
}