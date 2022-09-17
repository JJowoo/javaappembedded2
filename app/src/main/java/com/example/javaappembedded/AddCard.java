package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class AddCard extends AppCompatActivity  {
    EditText owner_name,card_num, exp_date, cvd_num;
    TextView card_num_view,card_exp_date_view, card_name_view,card_cvd_view;
    EditText owner_name_out,card_num_out, exp_date_out, cvd_num_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        card_num_view =findViewById(R.id.card_num_view);
        card_exp_date_view =findViewById(R.id.card_exp_date_view);
        card_name_view =findViewById(R.id.card_name_view);
        card_cvd_view =findViewById(R.id.card_cvd_view);

        owner_name=findViewById(R.id.owner_name);
        card_num=findViewById(R.id.card_num);
        exp_date=findViewById(R.id.exp_date);
        cvd_num=findViewById(R.id.cvd_num);

        owner_name_out=(EditText) findViewById(R.id.owner_name);
        card_num_out=(EditText) findViewById(R.id.card_num);
        exp_date_out=(EditText) findViewById(R.id.exp_date);
        cvd_num_out=(EditText) findViewById(R.id.cvd_num);

        owner_name_out.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                card_name_view.setText(s.toString());

            }
        });
        card_num_out.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                card_num_view.setText(s.toString());

            }
        });
        exp_date_out.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                card_exp_date_view.setText(s.toString());

            }
        });
        cvd_num_out.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                card_cvd_view.setText(s.toString());

            }
        });

    }



}