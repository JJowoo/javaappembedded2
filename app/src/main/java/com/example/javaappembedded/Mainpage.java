package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Mainpage extends AppCompatActivity {

    TextView login_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        login_result=findViewById(R.id.login_result);

        Intent intent=getIntent();

        Bundle bundle=intent.getExtras();
        String email=bundle.getString("email");
        String password = bundle.getString("password");

        login_result.setText(email+"//"+password);
    }
}