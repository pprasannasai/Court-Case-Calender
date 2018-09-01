package com.example.puvvadaprasannasai.devathon18;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;


public class Database extends SQLiteOpenHelper{


    public Database(Context context) {
        super(context, "Case.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table case_details(cc_no text, section text, court text, date_filing text, name text, address text, mob_no text)");
        db.execSQL("Create table witness_details(cc_no text, w_no text, w_mob text, w_name text, w_address text)");
        db.execSQL("Create table hearing(cc_no text, hearing_date text)");
        db.execSQL("Create table proceedings(cc_no text, case_proceeding text, next_hearing text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");
    }

    public void insert_case(Casedetails c){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no", c.cc_no);
        values.put("section", c.section);
        values.put("court",c.court);
        values.put("date_filing",c.date_filing);
        values.put("name",c.name);
        values.put("address",c.address);
        values.put("mob_no",c.mob_no);
        db.insert("case_details",null,values);
    }

    public void insert_witness(Witnessdetails w)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no",w.cc_no);
        values.put("w_no", w.cc_no);
        values.put("w_mob",w.w_mob);
        values.put("w_name",w.w_name);
        values.put("w_address",w.w_address);
        db.insert("witness_details",null,values);
    }

    public void insert_hearing(String cc_no,String hearing_date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no",cc_no);
        values.put("hearing_date",hearing_date);
        db.insert("hearing",null,values);
    }

    public void insert_proceedings(String cc_no, String case_proceeding, String next_hearing)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no",cc_no);
        values.put("next_hearing",next_hearing);
        values.put("case_proceeding",case_proceeding);
        db.insert("proceedings",null,values);
    }
}
