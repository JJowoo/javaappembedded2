package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    Button button_carpay,button_home,button_position,btn_logout,btn_cardSetting,btn_Vsetting,btn_postionreset, button_more;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        button_carpay = findViewById(R.id.button_carpay);
        button_home = findViewById(R.id.button_home);
        button_position = findViewById(R.id.button_position);

        btn_logout = findViewById(R.id.button_logout);
        btn_cardSetting = findViewById(R.id.button_carpay);
        btn_Vsetting = findViewById(R.id.button_carsetting);

        //uid값을 받아옴
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");

        //btn_logout to go login page with "logout" message
        btn_logout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),login.class);
                intent.putExtra("logout","로그아웃 되었습니다.");
                startActivity(intent);
            }
        });

        /*
        //btn_cardSetting to go card setting page
        btn_cardSetting.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),CardSetting.class);
                startActivity(intent);
            }
        });*/

        //btn_Vsetting to go vehicle setting page
        btn_Vsetting.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),VehicleManager.class);
                //email값을 넘겨줌
                intent.putExtra("uid",uid);
                startActivity(intent);
            }
        });





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
                Intent intent = new Intent(getApplicationContext(), SeatAdjust.class);
                startActivity(intent);
            }
        });
    }
}