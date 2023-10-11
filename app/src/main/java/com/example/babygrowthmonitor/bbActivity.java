package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bbActivity extends AppCompatActivity {
    Button button;
    TextView Hasil;
    EditText nama, etBB, etTB, etU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb);

        nama = findViewById(R.id.EditTextnama);
        Hasil = findViewById(R.id.textviewhasil);
        etBB = findViewById(R.id.editTextBeratBadan);
        etTB = findViewById(R.id.editTextTinggiBadan);
        etU = findViewById(R.id.editTextumur);
        button = findViewById(R.id.btnsubmit);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Nama = nama.getText().toString();
                String beratbadan = etBB.getText().toString();
                String tinggibadan = etTB.getText().toString();
                String umur = etU.getText().toString();

                // Validasi umur maksimal 5 tahun
                if (isValidAge(umur)) {
                    String hasil = "Nama : " + Nama + "\nUmur : " + umur + " tahun" + "\nTinggi Badan : " + tinggibadan + " cm" + "\nBerat Badan : " + beratbadan + " kg";
                    Hasil.setText(hasil);

                    Intent intent = new Intent(bbActivity.this, suhuActivity.class);
                    intent.putExtra("key_Nama", Nama);
                    intent.putExtra("key_beratbadan", beratbadan);
                    intent.putExtra("key_tinggibadan", tinggibadan);
                    intent.putExtra("key_umur", umur);
                    startActivity(intent);
                } else {
                    // Umur tidak valid, tampilkan pesan kesalahan
                    etU.setError("Umur maksimal 5 tahun!");
                }
            }
        });
    }

    // Fungsi untuk memvalidasi umur maksimal 5 tahun
    private boolean isValidAge(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 1 && ageValue <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}