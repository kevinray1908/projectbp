package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class suhuActivity extends AppCompatActivity {

    EditText edit_text_suhu;
    Button button_suhu;
    TextView textsuhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suhu);

        edit_text_suhu = findViewById(R.id.edit_text_suhu);
        button_suhu = findViewById(R.id.button_suhu);
        textsuhu = findViewById(R.id.textsuhu);

        String Nama = getIntent().getStringExtra("key_Nama");
        String beratbadan = getIntent().getStringExtra("key_beratbadan");
        String tinggibadan = getIntent().getStringExtra("key_tinggibadan");
        String umur = getIntent().getStringExtra("key_umur");

        button_suhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suhu = edit_text_suhu.getText().toString();

                // Check if the input is not empty and is a valid number
                if (suhu.isEmpty() || !isValidTemperature(suhu)) {
                    textsuhu.setText("Masukkan suhu yang valid (0-100)!");
                } else {
                    // Save data to SharedPreferences
                    saveDataToSharedPreferences(Nama, beratbadan, tinggibadan, umur, suhu);
                    Intent datasuhu = new Intent(suhuActivity.this, dataActivity.class);
                    datasuhu.putExtra("key_Nama", Nama);
                    datasuhu.putExtra("key_beratbadan", beratbadan);
                    datasuhu.putExtra("key_tinggibadan", tinggibadan);
                    datasuhu.putExtra("key_umur", umur);
                    datasuhu.putExtra("key_suhu", suhu);
                    startActivity(datasuhu);
                }
            }
        });
    }

    // Function to validate temperature input
    private boolean isValidTemperature(String temperature) {
        try {
            double tempValue = Double.parseDouble(temperature);
            return tempValue >= 0 && tempValue <= 100; // Validate within a reasonable range
        } catch (NumberFormatException e) {
            return false; // Invalid input if parsing fails
        }
    }

    // Save data to SharedPreferences
    private void saveDataToSharedPreferences(String nama, String berat, String tinggi, String umur, String suhu) {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("key_Nama", nama);
        editor.putString("key_beratbadan", berat);
        editor.putString("key_tinggibadan", tinggi);
        editor.putString("key_umur", umur);
        editor.putString("key_suhu", suhu);
        editor.apply();
    }
}
