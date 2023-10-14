package com.example.babygrowthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.net.URLEncoder;
import android.view.View;
import android.widget.Toast;

public class HubungiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi);

        CardView cardViewig = findViewById(R.id.cardview_hubungi_ig);
        cardViewig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String instagramUsername = "ebyy28"; // Replace USERNAME with the target Instagram username
                Uri uri = Uri.parse("http://instagram.com/_u/" + instagramUsername);
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                // Check if Instagram app is installed, if not, open Instagram website
                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    // Instagram app is not installed, open Instagram website
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/" + instagramUsername)));
                }
            }
        });
        CardView orderText = findViewById(R.id.cardview_hubungi_email);
        orderText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                launchEmailAppIntent.setData(Uri.parse("mailto:kondisisibayi@gmail.com"));
                startActivity(launchEmailAppIntent);
            }
        });
        CardView cardViewwa = findViewById(R.id.cardview_hubungi_wa);
        cardViewwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "+62895805106666";
                String message = "Halo, saya ingin berkonsultasi.";
                try {
                    String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + URLEncoder.encode(message, "UTF-8");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Failed to open WhatsApp.", Toast.LENGTH_SHORT).show();
                }
            }
    });
}}