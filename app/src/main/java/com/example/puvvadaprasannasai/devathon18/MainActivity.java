package com.example.puvvadaprasannasai.devathon18;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public Database db;

    private MyDynamicCalendar myDynamicCalendar;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main", "onCreate: ");

        //creating database object


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDynamicCalendar=findViewById(R.id.myCalendar);
        myDynamicCalendar.showMonthView();

        myDynamicCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onClick(Date date) {
                Log.d("date", String.valueOf(date));

                Intent intent=new Intent(MainActivity.this,Form.class);
                intent.putExtra("date",date);
                Bundle bundle=new Bundle();

                startActivity(intent);
            }

            @Override
            public void onLongClick(Date date) {
                Log.d("date", String.valueOf(date));

            }
        });
        myDynamicCalendar.setCalendarBackgroundColor("#008080"); //gray
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

        myDynamicCalendar.addEvent("5-10-2016", "8:00", "8:15", "Today Event 1");
        myDynamicCalendar.addEvent("05-10-2016", "8:15", "8:30", "Today Event 2");
        myDynamicCalendar.addEvent("05-10-2016", "8:30", "8:45", "Today Event 3");
        myDynamicCalendar.addEvent("05-10-2016", "8:45", "9:00", "Today Event 4");
        myDynamicCalendar.addEvent("8-10-2016", "8:00", "8:30", "Today Event 5");
        myDynamicCalendar.addEvent("08-10-2016", "9:00", "10:00", "Today Event 6");

        //SQLiteDatabase db=.getWritableDatabase();


        //myDynamicCalendar.addEvent();
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
            case R.id.action_week:
                showWeekView();
                return true;
            case R.id.action_day:
                showDayView();
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

    private void showDayView() {
        myDynamicCalendar.showDayView();

        myDynamicCalendar.setOnEventClickListener(new OnEventClickListener() {
            @Override
            public void onClick() {
                Log.e("showDayView", "from setOnEventClickListener onClick");

            }

            @Override
            public void onLongClick() {
                Log.e("showDayView", "from setOnEventClickListener onLongClick");

            }
        });

        myDynamicCalendar.setOnWeekDayViewClickListener(new OnWeekDayViewClickListener() {
            @Override
            public void onClick(String date, String time) {
                Log.d("showDayView", "from setOnWeekDayViewClickListener onClick");
                Log.d("tag", "date:-" + date + " time:-" + time);
            }

            @Override
            public void onLongClick(String date, String time) {
                Log.d("showDayView", "from setOnWeekDayViewClickListener onLongClick");
                Log.d("tag", "date:-" + date + " time:-" + time);
            }
        });
    }

    private void showWeekView() {
        myDynamicCalendar.showWeekView();

        myDynamicCalendar.setOnEventClickListener(new OnEventClickListener() {
            @Override
            public void onClick() {
                Log.d("showWeekView","from setOnEventClickListener onClick");
            }

            @Override
            public void onLongClick() {
                Log.d("showWeekView","from setOnEventClickListener onLongClick");

            }
        });
        myDynamicCalendar.setOnWeekDayViewClickListener(new OnWeekDayViewClickListener() {
            @Override
            public void onClick(String date, String time) {
                Log.d("showWeekView", "from setOnWeekDayViewClickListener onClick");
                Log.d("tag", "date:-" + date + " time:-" + time);

            }

            @Override
            public void onLongClick(String date, String time) {
                Log.d("showWeekView", "from setOnWeekDayViewClickListener onLongClick");
                Log.d("tag", "date:-" + date + " time:-" + time);

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

