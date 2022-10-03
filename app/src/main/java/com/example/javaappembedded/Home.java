package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button_carpay = findViewById(R.id.button_carpay);
        Button button_position = findViewById(R.id.button_position);
        Button button_more = findViewById(R.id.button_more);
        //intent안의 email값을 받아옴
        //Intent intent = getIntent();
       // String email = intent.getStringExtra("email");



        button_carpay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Mainpage.class);
                startActivity(intent);
            }
        });
        button_position.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SeatAdjust.class);
                startActivity(intent);
            }
        });
        button_more.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}