package com.example.calendarintosecondsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PopUpCalendar extends AppCompatActivity {

    CalendarView calendarView;
    String day;
    static String  date;
    static  Date c;
    static  int currentMonth, currentDay, currentYear;
    static  String currentMonthString, currentDayString , currentYearString;
    Button buttonn;

   static String[] allMonths = {"Styczen", "Luty", "Marzec", "Kwiecien", "Maj","Czerwiec", "Lipiec","Sierpien", "Wrzesien", "Pazdziernik", "Listopad","Grudzien"};

    static int years,months, dayofMonths;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

      c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        date = df.format(c);

        SimpleDateFormat sdf = new SimpleDateFormat("MM", Locale.getDefault());
        currentMonthString = sdf.format(c);
        currentMonth= Integer.parseInt(currentMonthString);

        SimpleDateFormat sdff = new SimpleDateFormat("dd", Locale.getDefault());
        currentDayString = sdff.format(c);
        currentDay= Integer.parseInt(currentDayString);

        SimpleDateFormat sdfff = new SimpleDateFormat("YYYY", Locale.getDefault());
        currentYearString = sdfff.format(c);
        currentYear= Integer.parseInt(currentYearString);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_calendar);

        calendarView= (CalendarView) findViewById(R.id.calendarView);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {




                month= month+1;

                years=year;
                months=month;
                dayofMonths=dayOfMonth;


                String displayedMonth="";




                if(dayOfMonth<10){
                    day="0"+(int)(dayOfMonth);
                }else{
                    day=""+(int)(dayOfMonth);
                }

                if(month<10){
                    displayedMonth="0"+month;
                }else{
                    displayedMonth=""+month;
                }



                date = day+"/"+ displayedMonth+"/"+year;



            }
        });

        buttonn= (Button) findViewById(R.id.button2);
        buttonn.setTransformationMethod(null);
    }

    public void onDateButton(View view){



        Toast.makeText(PopUpCalendar.this ,"Date: "+date, Toast.LENGTH_SHORT).show();

      //  date="";
        Intent results = new Intent(this, ResultActivity.class);
        startActivity(results);


    }
}