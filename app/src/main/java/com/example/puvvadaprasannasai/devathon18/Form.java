package com.example.puvvadaprasannasai.devathon18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.Date;

public class Form extends AppCompatActivity {

    Date date;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Bundle getData=getIntent().getExtras();
        Intent intent=getIntent();
       // date=new Date(getIntent().get("d1ate", -1));
        Log.d("form","Date Recieved "+date);

    }
}
