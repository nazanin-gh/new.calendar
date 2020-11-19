package com.example.nazanin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
  boolean isbackpresed = false;
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
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 2500);
        }

        Button btnDialog = findViewById(R.id.btn1);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this , dialog.class );
               startActivity(intent);
            }
        });

        Button shared = findViewById(R.id.btn1);
        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, dialog.class);
            startActivity(intent);
            }
        });


        showNotification("new news", "you have new messages");


    }

    @Override
    public void onBackPressed() {
        if (isbackpresed == true)
            super.onBackPressed();
        else {
            isbackpresed = true;
            Toast.makeText( this,"press again",Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isbackpresed= false;

                }
            }, 2500);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.kebab_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.timeanddate.com/calendar/?country=27"));
                startActivity(intent);
                break;
            case R.id.second:
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("DO YOU LIKE APP?")
                   .setTitle("FEEDBACK")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this, "THANKS", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        )
              .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(MainActivity.this, "SORRY", Toast.LENGTH_SHORT).show();
                  }
              })
              .setNeutralButton("ASK ME LATER", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                  }
              }) .create();
                dialog.show();

        }

                return super.onOptionsItemSelected(item);
        }

    void showNotification(String title, String message) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("months",
                    "calender news",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DESCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "months")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle("news") // title for notification

                .setContentText(message)// message for notification
                .setAutoCancel(true); // clear notification after click

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());


    }



    }









