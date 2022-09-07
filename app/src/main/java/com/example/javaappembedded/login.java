package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {

    EditText editText_email,editText_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_email=findViewById(R.id.editText_email);
        editText_Password=findViewById(R.id.editText_Password);


    }
}