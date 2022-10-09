package com.example.javaappembedded;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Home extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button_carpay = findViewById(R.id.button_carpay);
        Button button_position = findViewById(R.id.button_position);
        Button button_more = findViewById(R.id.button_more);
        Button button_createkey = findViewById(R.id.create_key);
        Button unlock = findViewById(R.id.unlock);

        //intent안의 uid값을 받아옴
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        final String[] unlock_status = {""};

        mDatabase.child("unlock").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                unlock_status[0] = snapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        unlock.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(unlock_status[0].equals("0")){
                    mDatabase.child("unlock").setValue("1");
                }
                else{
                    mDatabase.child("unlock").setValue("0");
                }

            }
        });


        button_carpay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Mainpage.class);
                intent.putExtra("uid",uid);
                startActivity(intent);
            }
        });
        button_position.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SeatAdjust.class);
                intent.putExtra("uid",uid);
                startActivity(intent);
            }
        });
        button_more.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                intent.putExtra("uid",uid);
                startActivity(intent);
            }
        });
        button_createkey.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),CreateKey.class);
                intent.putExtra("uid",uid);
                startActivity(intent);
            }
        });

    }
}