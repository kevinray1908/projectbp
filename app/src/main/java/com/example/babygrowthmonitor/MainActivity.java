package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearSharedPreferences();

        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE); // Initially set ProgressBar to VISIBLE

        handler = new Handler();

        // Delay starting the new activity for 1.5 seconds (1500 milliseconds)
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE); // Hide ProgressBar after the delay
                Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(menuIntent);
                finish(); // Finish the current activity so the user can't navigate back
            }
        }, 2000); // Delayed for 1.5 seconds (1500 milliseconds)
    }

    private void clearSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
