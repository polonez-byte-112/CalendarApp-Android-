package com.example.calendarintosecondsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Calendar;

public class ResultActivity extends AppCompatActivity {


    TextView resultView;

    int seconds= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultView=  (TextView) findViewById(R.id.textView6);
        calculateDateIntoSec();



    }

    public void calculateDateIntoSec(){



        int minutesInMonths=0;
        int minutesInDay=24*60;




        int diffrentInMonths=0;
        if(PopUpCalendar.months>=PopUpCalendar.currentMonth){ diffrentInMonths= PopUpCalendar.months - PopUpCalendar.currentMonth;}

        if(PopUpCalendar.months<PopUpCalendar.currentMonth){
            diffrentInMonths=(int)Math.abs(PopUpCalendar.months) +  (12 -PopUpCalendar.currentMonth);

            System.out.println("Month is "+PopUpCalendar.months+"\n How much to new Year : "+ (12 -PopUpCalendar.currentMonth) );
        }

        int lastMonths = PopUpCalendar.months;



            //dni
            int displayedDays=0;

            if(PopUpCalendar.currentDay == PopUpCalendar.dayofMonths && PopUpCalendar.currentMonth == PopUpCalendar.months && PopUpCalendar.currentYear == PopUpCalendar.years){
                displayedDays=0;
            }

            if(PopUpCalendar.currentDay != PopUpCalendar.dayofMonths && PopUpCalendar.currentMonth == PopUpCalendar.months){
            displayedDays = ((PopUpCalendar.dayofMonths- PopUpCalendar.currentDay)*minutesInDay);}

            if(PopUpCalendar.currentDay != PopUpCalendar.dayofMonths && PopUpCalendar.currentMonth != PopUpCalendar.months){
            displayedDays = (PopUpCalendar.dayofMonths*minutesInDay);}




            // miesiace


        //liczenie pozostalych dni do konca obecnego mies
        int extraDaysFromCurrentMonth=0;



        if(diffrentInMonths>0) {
            switch (PopUpCalendar.currentMonth) {
                case 1:
                    extraDaysFromCurrentMonth = 31 - PopUpCalendar.currentDay;
                    break;
                case 2:
                    extraDaysFromCurrentMonth = 28 - PopUpCalendar.currentDay;
                    break;

                case 3:
                    extraDaysFromCurrentMonth = 31 - PopUpCalendar.currentDay;
                    break;
                case 4:
                    extraDaysFromCurrentMonth = 30 - PopUpCalendar.currentDay;
                    break;


                case 5:
                    extraDaysFromCurrentMonth = 31 - PopUpCalendar.currentDay;
                    break;
                case 6:
                    extraDaysFromCurrentMonth = 30 - PopUpCalendar.currentDay;
                    break;


                case 7:
                    extraDaysFromCurrentMonth = 31 - PopUpCalendar.currentDay;
                    break;
                case 8:
                    extraDaysFromCurrentMonth = 31 - PopUpCalendar.currentDay;
                    break;


                case 9:
                    extraDaysFromCurrentMonth = 30 - PopUpCalendar.currentDay;
                    break;
                case 10:
                    extraDaysFromCurrentMonth = 31 - PopUpCalendar.currentDay;
                    break;

                case 11:
                    extraDaysFromCurrentMonth = 30 - PopUpCalendar.currentDay;
                    break;
                case 12:
                    extraDaysFromCurrentMonth = 31 - PopUpCalendar.currentDay;
                    break;
                default:
                    break;
            }
        }


// extra dni dobrze zrobione



        int fullMonthMinutes=0;

        int even=0;
        int odd=0;

        //tutaj liczymy pełne miesiace
        if(diffrentInMonths>1){
            for (int i = 0; i < diffrentInMonths-1; i++) {
                if(Math.random()>50){
                    even++;
                }else{
                    odd++;
                }
            }

            fullMonthMinutes= (31*odd+30*even)*minutesInDay;
            odd=0;
            even=0;
        }


         int extraDayFromFutureMonth=0;

        if(diffrentInMonths>0 && lastMonths== PopUpCalendar.months){

            extraDayFromFutureMonth= PopUpCalendar.dayofMonths-1;
        }

        if(diffrentInMonths==0) {
            minutesInMonths = 0;
            seconds= displayedDays;
        }


        if(diffrentInMonths>1) {
            minutesInMonths = fullMonthMinutes + (extraDaysFromCurrentMonth+ extraDayFromFutureMonth)*minutesInDay;
            seconds=    minutesInMonths;
        }
//displayedDays+


        if(diffrentInMonths==1) {
            minutesInMonths = (extraDaysFromCurrentMonth+ extraDayFromFutureMonth+1)*minutesInDay;
            seconds=  minutesInMonths;
        }
//

      //  seconds= ((PopUpCalendar.years-PopUpCalendar.currentYear)*365*minutesInDay)  +displayedDays+ minutesInMonths;


              if(seconds<=0){
                  seconds=0;
              }


        resultView.setText(seconds+"");


        System.out.println("Last Days of Month: "+extraDaysFromCurrentMonth+"\nExtra days "+extraDayFromFutureMonth);


    }

    public void goStartAgain(View view){
        seconds=0;
        PopUpCalendar.dayofMonths=0;
        PopUpCalendar.years=0;
        PopUpCalendar.months=0;
        PopUpCalendar.c = Calendar.getInstance().getTime();
        Intent reset = new Intent(this, MainActivity.class);
        startActivity(reset);
    }
}