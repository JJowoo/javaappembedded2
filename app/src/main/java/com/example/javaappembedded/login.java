package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {

    EditText editText_email,editText_Password;
    Button button_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_email=findViewById(R.id.editText_email);
        editText_Password=findViewById(R.id.editText_Password);
        button_login=findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=editText_email.getText().toString();
                String password= editText_Password.getText().toString();

                Intent intent=new Intent(login.this, Mainpage.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
}