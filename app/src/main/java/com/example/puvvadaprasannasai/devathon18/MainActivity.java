package com.example.puvvadaprasannasai.devathon18;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.desai.vatsal.mydynamiccalendar.EventModel;
import com.desai.vatsal.mydynamiccalendar.GetEventListListener;
import com.desai.vatsal.mydynamiccalendar.MyDynamicCalendar;
import com.desai.vatsal.mydynamiccalendar.OnDateClickListener;
import com.desai.vatsal.mydynamiccalendar.OnEventClickListener;
import com.desai.vatsal.mydynamiccalendar.OnWeekDayViewClickListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private MyDynamicCalendar myDynamicCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main", "onCreate: ");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDynamicCalendar=findViewById(R.id.myCalendar);
        myDynamicCalendar.showMonthView();
        myDynamicCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onClick(Date date) {
                Log.d("date", String.valueOf(date));
                DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
                String strDate = dateFormat.format(date);
                Intent intent=new Intent(MainActivity.this,Form.class);
                intent.putExtra("date",strDate);
                startActivity(intent);
            }

            @Override
            public void onLongClick(Date date) {
                Log.d("date", String.valueOf(date));

            }
        });
        myDynamicCalendar.setCalendarBackgroundColor("#fff9f9"); //gray
        myDynamicCalendar.setHeaderBackgroundColor("#454265");//black
        myDynamicCalendar.setHeaderTextColor("#FFFF33");//white
        myDynamicCalendar.setNextPreviousIndicatorColor("#245675");//black
        myDynamicCalendar.setWeekDayLayoutBackgroundColor("#8743e8");
        myDynamicCalendar.setWeekDayLayoutTextColor("#FFFF33");

        myDynamicCalendar.isSaturdayOff(true, "#ffffff", "#ff0000");
        myDynamicCalendar.isSaturdayOff(true, R.color.white, R.color.red);

        myDynamicCalendar.isSundayOff(true, "#658745", "#254632");
        myDynamicCalendar.isSundayOff(true, R.color.white, R.color.red);

        myDynamicCalendar.setExtraDatesOfMonthBackgroundColor("#e0d870");
        myDynamicCalendar.setExtraDatesOfMonthTextColor("#756325");

        myDynamicCalendar.setDatesOfMonthBackgroundColor("#edaaaa");
        myDynamicCalendar.setDatesOfMonthTextColor("#745632");

        myDynamicCalendar.setCurrentDateTextColor("#000500");
        myDynamicCalendar.setCurrentDateBackgroundColor("#870202");

        myDynamicCalendar.setEventCellBackgroundColor("#852365");
        myDynamicCalendar.setEventCellTextColor("#425684");

        myDynamicCalendar.setBelowMonthEventDividerColor("#0f0f0f");

        myDynamicCalendar.addEvent("18-09-2018", "9:00", "10:00", "CaseNumber :CC023 The Culprit is Punishable");
        myDynamicCalendar.addEvent("18-09-2018", "9:00", "10:00", "CaseNumber :CC024 Koi nahi aaya!!!!!!!");
        myDynamicCalendar.addEvent("18-09-2018", "9:00", "10:00", "CaseNumber :CC025 Judge toh mota hai");
        myDynamicCalendar.addEvent("18-09-2018", "9:00", "10:00", "CaseNumber :CC026 Kya app 5 pachvi paas se tej ho");
        myDynamicCalendar.addEvent("18-09-2018", "9:00", "10:00", "CaseNumber :CC027 The Culprit is Punishable");
        myDynamicCalendar.addEvent("18-09-2018", "9:00", "10:00", "CaseNumber :CC028 Hum honge kamyaab");
        myDynamicCalendar.addEvent("18-09-2018", "9:00", "10:00", "CaseNumber :CC029 The Culprit is Punishable");
        myDynamicCalendar.addEvent("26-09-2018", "9:00", "10:00", "Case Detail Event 2");
        myDynamicCalendar.addEvent("03-09-2018", "9:00", "10:00", "Case Detail Event 3");
        myDynamicCalendar.addEvent("03-09-2018", "9:00", "10:00", "Case Detail Event 4");
        myDynamicCalendar.addEvent("02-09-2018", "9:00", "10:00", "Case Detail Event 5");
        myDynamicCalendar.addEvent("08-09-2018", "9:00", "10:00", "Case Detail Event 6");



        myDynamicCalendar.getEventList(new GetEventListListener() {
            @Override
            public void eventList(ArrayList<EventModel> eventList) {

                    Log.d("tag", "eventList.size():-" + eventList.size());
                    for (int i = 0; i < eventList.size(); i++) {
                        Log.d("tag", "eventList.getStrName:-" + eventList.get(i).getStrName());

                    }


            }
        });

        myDynamicCalendar.setBelowMonthEventTextColor("#425684");

        myDynamicCalendar.setBelowMonthEventDividerColor("#635478");

        myDynamicCalendar.setHolidayCellBackgroundColor("#21ea02");

        myDynamicCalendar.setHolidayCellTextColor("#d590bb");


        myDynamicCalendar.setHolidayCellClickable(false);
        myDynamicCalendar.addHoliday("2-11-2016");
        myDynamicCalendar.addHoliday("8-11-2016");
        myDynamicCalendar.addHoliday("12-11-2016");
        myDynamicCalendar.addHoliday("13-11-2016");
        myDynamicCalendar.addHoliday("8-10-2016");
        myDynamicCalendar.addHoliday("10-12-2016");
        myDynamicCalendar.addHoliday("5-09-2018");







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            //noinspection SimplifiableIfStatement
            case R.id.action_month:
                showMonthView();
                return true;
            case R.id.action_month_with_below_events:
                showMonthViewWithBelowEvents();
                return true;
            case R.id.action_agenda:
                showAgendaView();
                return true;
            case R.id.action_today:
                myDynamicCalendar.goToCurrentDate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void showAgendaView() {
        myDynamicCalendar.showAgendaView();

        myDynamicCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onClick(Date date) {
                Log.e("date", String.valueOf(date));
            }

            @Override
            public void onLongClick(Date date) {
                Log.e("date", String.valueOf(date));
            }
        });
    }





    private void showMonthViewWithBelowEvents() {
        myDynamicCalendar.showMonthViewWithBelowEvents();

        myDynamicCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onClick(Date date) {
                Log.d("date", String.valueOf(date));
            }

            @Override
            public void onLongClick(Date date) {
                Log.d("date", String.valueOf(date));
            }
        });


    }

    private void showMonthView() {
        myDynamicCalendar.showMonthView();
        myDynamicCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onClick(Date date) {
                Log.d("date", String.valueOf(date));

            }

            @Override
            public void onLongClick(Date date) {
                Log.d("date", String.valueOf(date));

            }
        });

    }
}

