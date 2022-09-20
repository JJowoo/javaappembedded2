package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SettingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button button_carpay = findViewById(R.id.button_carpay);
        Button button_home = findViewById(R.id.button_home);
        Button button_position = findViewById(R.id.button_position);


        button_carpay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Mainpage.class);
                startActivity(intent);
            }
        });
        button_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }
        });
        button_position.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),SheetAdjust.class);
                startActivity(intent);
            }
        });
    }
}