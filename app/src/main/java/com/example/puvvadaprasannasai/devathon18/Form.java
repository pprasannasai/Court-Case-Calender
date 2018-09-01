package com.example.puvvadaprasannasai.devathon18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.Date;

public class Form extends AppCompatActivity {

    EditText date_filing;
    Date date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        date_filing=findViewById(R.id.date_filing);

        Intent intent=getIntent();
        String date_recieved=intent.getStringExtra("date");
        Log.d("form","Date Recieved "+date_recieved);
        date_filing.setText(date_recieved);
        date_filing.setEnabled(false);



    }
}
