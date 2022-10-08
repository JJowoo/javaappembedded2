package com.example.javaappembedded;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CreateKey extends AppCompatActivity {

    TextView dateRentalText, timeRentalText, dateReturnText, timeReturnText;
    Calendar calendar;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_key);

        dateRentalText = findViewById(R.id.date_rental_text);
        timeRentalText = findViewById(R.id.time_rental_text);

        dateReturnText = findViewById(R.id.date_return_text);
        timeReturnText = findViewById(R.id.time_return_text);


        calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        Long today = MaterialDatePicker.todayInUtcMilliseconds();

        //대여 날짜 버튼
        Button button_rental_date = findViewById(R.id.button_rental_date);
        button_rental_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Date Picker")
                        .setSelection(today).build();   //오늘 날짜 셋팅
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");

                //확인버튼
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
                        Date date = new Date();
                        date.setTime(selection);
                        String dateString = simpleDateFormat.format(date);
                        dateRentalText.setText(dateString);

                    }
                });
            }
        });

        //대여 시각 버튼
        Button button_rental_time = findViewById(R.id.button_rental_time);
        button_rental_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(CreateKey.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar ,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "오전";
                        if(selectedHour >12){
                            selectedHour -= 12;
                            state = "오후";
                        }
                        timeRentalText.setText(state + " " + selectedHour + "시 " + selectedMinute + "분");
                    }
                }, hour, minute, false);
                mTimePicker.setTitle(("Select Time"));
                mTimePicker.show();
            }
        });

        //반납 날짜 버튼
        Button button_return_date = findViewById(R.id.button_return_date);
        button_return_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Date Picker")
                        .setSelection(today).build();   //오늘 날짜 셋팅
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");

                //확인버튼
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
                        Date date = new Date();
                        date.setTime(selection);

                        String dateString = simpleDateFormat.format(date);
                        result=result+dateString+"/";
                        dateReturnText.setText(dateString);
                    }
                });
            }
        });

        //반납 시각 버튼
        Button button_return_time = findViewById(R.id.button_return_time);
        button_return_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(CreateKey.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "오전";
                        if(selectedHour >12){
                            selectedHour -= 12;
                            state = "오후";
                        }
                        result= result+state + "/" + selectedHour + "/" + selectedMinute + "/";
                        timeReturnText.setText(state + " " + selectedHour + "시 " + selectedMinute + "분");
                    }
                }, hour, minute, false);
                mTimePicker.setTitle(("Select Time"));
                mTimePicker.show();
            }
        });



        Button button_create_key = findViewById(R.id.button_create_key);
        button_create_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });
    }
}