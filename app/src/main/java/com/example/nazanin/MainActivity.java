package com.example.nazanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView card = findViewById(R.id.card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "JANUARY!", Toast.LENGTH_LONG).show();
            }
        });
        CardView card2 = findViewById(R.id.card2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FEBRUARY!", Toast.LENGTH_LONG).show();
            }
        });

        CardView card3 = findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MARCH!", Toast.LENGTH_LONG).show();
            }
        });

        CardView card4 = findViewById(R.id.card4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "APRIL!", Toast.LENGTH_LONG).show();
            }
        });

        CardView card5 = findViewById(R.id.card5);
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MAY!", Toast.LENGTH_LONG).show();
            }
        });
        VideoView video = findViewById(R.id.video);
       String url ="https://as6.cdn.asset.aparat.com/aparat-video/54c56db10702a6117bc6828b31dc48ec20050579-360p.mp4";
        video.setMediaController(new MediaController(MainActivity.this));
        video.setVideoURI(Uri.parse(url));
        video.start();

        WebView web = findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);web.setWebViewClient(new WebViewClient());
        web.loadUrl ("https://www.rapidtables.com");
    }




}