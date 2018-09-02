package com.example.puvvadaprasannasai.devathon18;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Database extends SQLiteOpenHelper{

    //Database db;

    public Database(Context context) {
        super(context, "Case1.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table case_details(cc_no text, section text, court text, date_filing text, address text, mob_no text)");
        db.execSQL("Create table witness_details(cc_no text, w_no text, w_mob text, w_name text, w_address text)");
        db.execSQL("Create table hearing(cc_no text, hearing_date text)");
        db.execSQL("Create table proceedings(cc_no text, case_proceeding text, next_hearing text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("delete from user");
    }

    public long insert_case(Casedetails c){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no", c.cc_no);
        //Toast.makeText(Form.thi, ""+c.cc_no, Toast.LENGTH_SHORT).show();
        //Toast.makeText(Database.this, c.cc_no, Toast.LENGTH_SHORT).show();
        Log.d("cc_no123",c.cc_no);
        values.put("section", c.section);
        values.put("court",c.court);
        values.put("date_filing",c.date_filing);
        //values.put("name",String.valueOf(c.name));
        //values.put("address",String.valueOf(c.address));
        //values.put("mob_no",String.valueOf(c.mob_no));
        long t;
        t=db.insert("case_details",null,values);
        return t;
    }

    public void insert_witness(Witnessdetails w)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no",w.cc_no);
        values.put("w_address",w.w_address);
        values.put("w_name",w.w_name);
        values.put("w_mob",w.w_mob);
        values.put("w_no",w.w_no);
        db.insert("witness_details",null,values);
    }

    public void insert_hearing(String cc_no,String hearing_date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no",cc_no);
        values.put("hearing_date",hearing_date);
        db.insert("witness_details",null,values);
    }

    public void insert_proceedings(String cc_no, String case_proceedings, String next_hearing)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("cc_no",cc_no);
        values.put("case_proceedings",case_proceedings);
        values.put("next_hearing",next_hearing);
        db.insert("proceedings",null,values);
    }

   /* public static Database getInstance(Context ctx)
    {
        if(db==null)
            db=new Database(ctx.getApplicationContext());

        return db;
    }*/

}
