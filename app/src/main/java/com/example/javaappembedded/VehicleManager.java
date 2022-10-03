package com.example.javaappembedded;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class VehicleManager extends AppCompatActivity {
    private FirebaseAuth mAuth;     //
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_manager);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance(); //

        TextView car_num = (TextView) findViewById(R.id.car_num);
        TextView vehicle_type = (TextView) findViewById(R.id.vehicle_type);
        TextView max_num = (TextView) findViewById(R.id.max_num);

        //email값을 받아옴
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");

        mDatabase.child(uid).child("등록차량").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String carNum = dataSnapshot.getKey();
                    String vehicleType = dataSnapshot.child("차종").getValue(String.class);
                    String maxNum = dataSnapshot.child("최대승차인원").getValue(String.class);
                    Log.d("carNum", carNum);
                    Log.d("vehicleType", vehicleType);
                    Log.d("maxNum", maxNum);
                    car_num.setText(carNum);
                    vehicle_type.setText(vehicleType);
                    max_num.setText(maxNum);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}