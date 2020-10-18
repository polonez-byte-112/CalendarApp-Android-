package com.example.calendarintosecondsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView myDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDate= (TextView) findViewById(R.id.textView);



    }

    public void onClickStart(View view){
        Intent calendar = new Intent(this, PopUpCalendar.class);
        startActivity(calendar);
    }




}