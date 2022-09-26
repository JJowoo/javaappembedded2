package com.example.javaappembedded;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;     //

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //
        super.onCreate(savedInstanceState); //
        setContentView(R.layout.activity_sign_up);  //
        mAuth = FirebaseAuth.getInstance(); //
        findViewById(R.id.btn_signup).setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_signup:
                    signUp();
                    break;
            }
        }
    };


    private void signUp(){
        String name=((EditText)findViewById(R.id.editText_name)).getText().toString();
        String email=((EditText)findViewById(R.id.editText_email)).getText().toString();
        String password=((EditText)findViewById(R.id.editText_password)).getText().toString();
        String password_confirm=((EditText)findViewById(R.id.editText_password_confirm)).getText().toString();

        if(email.length()>0 && password.length()>0 && password_confirm.length()>0){
            if(password.equals(password_confirm)){
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUp.this, "회원가입에 성공했습니다." ,Toast.LENGTH_SHORT).show();
                                } else {
                                    if(task.getException().toString() !=null){
                                        Toast.makeText(SignUp.this, "회원가입에 실패했습니다." ,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }
            else{
                Toast.makeText(SignUp.this, "비밀번호가 일치하지 않습니다." ,Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(SignUp.this, "아아디와 비밀번호를 확인해주세요." ,Toast.LENGTH_SHORT).show();
        }
    }
}