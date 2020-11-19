package com.example.nazanin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        TextView text = findViewById(R.id.tv);
        EditText edit = findViewById(R.id.ed);
        Button button = findViewById(R.id.btnsave);

      String name =  getSharedPreferences("Datas", MODE_PRIVATE).getString("name", "no name here" );
      text.setText(name);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String name = edit.getText().toString();
              getSharedPreferences("Data", MODE_PRIVATE )
                      .edit().putString("name" , name ). apply();
          }
      });
    }
}