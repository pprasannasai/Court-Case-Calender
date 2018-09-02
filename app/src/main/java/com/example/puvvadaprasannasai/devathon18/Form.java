package com.example.puvvadaprasannasai.devathon18;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.lang.*;
import java.util.Date;

public class Form extends AppCompatActivity {

    Database db;
    Date date;
    Button submit;
    Casedetails c;

    MaterialEditText ccNoEditText, courtEditText, dateFilingEditText,sectionEditText,hearingdateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        c=new Casedetails();



        submit=(Button) findViewById(R.id.Add_Witness);

        db=((DatabaseInstance)getApplication()).getDatabase();


        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

            public void onClick(View v) {

                ccNoEditText = findViewById(R.id.cc_no);
                courtEditText = findViewById(R.id.court);
                dateFilingEditText =findViewById(R.id.date_filing);
                sectionEditText=findViewById(R.id.section);
                hearingdateEditText=findViewById(R.id.date_hearing);
                c.cc_no = ccNoEditText.getText().toString();
                c.court = courtEditText.getText().toString();
                c.date_filing=dateFilingEditText.getText().toString();
                c.section=sectionEditText.getText().toString();


               // Toast.makeText(Form.this,c.cc_no, Toast.LENGTH_SHORT).show();
                long t=db.insert_case(c);

                if(t!=-1)
                    Toast.makeText(Form.this,"inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Form.this, "not inserted", Toast.LENGTH_SHORT).show();

                SQLiteDatabase db1=db.getWritableDatabase();
                Cursor c= db1.rawQuery("Select * from case_details",null);
                StringBuffer b=new StringBuffer();

                if (c.moveToFirst()) {
                    do {
                        String s=c.getString(0);

                        Toast.makeText(Form.this,s, Toast.LENGTH_SHORT).show();

                    } while (c.moveToNext());

                }
            }
        });

    }

}
