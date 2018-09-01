package com.example.puvvadaprasannasai.devathon18;

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

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private MyDynamicCalendar myDynamicCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDynamicCalendar=findViewById(R.id.myCalendar);
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
        myDynamicCalendar.setCalendarBackgroundColor("#eeeeee"); //gray
        myDynamicCalendar.setHeaderBackgroundColor("#454265");//black
        myDynamicCalendar.setHeaderTextColor("#ffffff");//white
        myDynamicCalendar.setNextPreviousIndicatorColor("#245675");//black
        myDynamicCalendar.setWeekDayLayoutBackgroundColor("#965471");
        myDynamicCalendar.setWeekDayLayoutTextColor("#246245");

        myDynamicCalendar.isSaturdayOff(true, "#ffffff", "#ff0000");
        myDynamicCalendar.isSaturdayOff(true, R.color.white, R.color.red);

        myDynamicCalendar.isSundayOff(true, "#658745", "#254632");
        myDynamicCalendar.isSundayOff(true, R.color.white, R.color.red);

        myDynamicCalendar.setExtraDatesOfMonthBackgroundColor("#324568");
        myDynamicCalendar.setExtraDatesOfMonthTextColor("#756325");

        myDynamicCalendar.setDatesOfMonthBackgroundColor("#145687");
        myDynamicCalendar.setDatesOfMonthTextColor("#745632");

        myDynamicCalendar.setCurrentDateTextColor("#00e600");
        myDynamicCalendar.setCurrentDateBackgroundColor("#123412");

        myDynamicCalendar.setEventCellBackgroundColor("#852365");
        myDynamicCalendar.setEventCellTextColor("#425684");

        myDynamicCalendar.addEvent("5-10-2016", "8:00", "8:15", "Today Event 1");
        myDynamicCalendar.addEvent("05-10-2016", "8:15", "8:30", "Today Event 2");
        myDynamicCalendar.addEvent("05-10-2016", "8:30", "8:45", "Today Event 3");
        myDynamicCalendar.addEvent("05-10-2016", "8:45", "9:00", "Today Event 4");
        myDynamicCalendar.addEvent("8-10-2016", "8:00", "8:30", "Today Event 5");
        myDynamicCalendar.addEvent("08-10-2016", "9:00", "10:00", "Today Event 6");


        myDynamicCalendar.getEventList(new GetEventListListener() {
            @Override
            public void eventList(ArrayList<EventModel> eventList) {

                Log.e("tag", "eventList.size():-" + eventList.size());
                for (int i = 0; i < eventList.size(); i++) {
                    Log.e("tag", "eventList.getStrName:-" + eventList.get(i).getStrName());
                }

            }
        });

        myDynamicCalendar.setBelowMonthEventTextColor("#425684");

        myDynamicCalendar.setBelowMonthEventDividerColor("#635478");

        myDynamicCalendar.setHolidayCellBackgroundColor("#654248");

        myDynamicCalendar.setHolidayCellTextColor("#d590bb");


        myDynamicCalendar.setHolidayCellClickable(false);
        myDynamicCalendar.addHoliday("2-11-2016");
        myDynamicCalendar.addHoliday("8-11-2016");
        myDynamicCalendar.addHoliday("12-11-2016");
        myDynamicCalendar.addHoliday("13-11-2016");
        myDynamicCalendar.addHoliday("8-10-2016");
        myDynamicCalendar.addHoliday("10-12-2016");






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    }

    private void showDayView() {
    }

    private void showWeekView() {
    }

    private void showMonthViewWithBelowEvents() {


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

