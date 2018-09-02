package com.example.puvvadaprasannasai.devathon18;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class DatabaseInstance extends Application {

   public static Database db;
   public  static List<String> data;

    @SuppressLint("MissingSuperCall")
    public void onCreate() {
        super.onCreate();
        db=new Database(this);
        data=new ArrayList();
        //db.open();
    }

    @SuppressLint("MissingSuperCall")
    public void onTerminate()
    {
        super.onTerminate();
        db.close();
    }

    public Database getDatabase()
    {
        return db;
    }
    public  List<String> getList(){
        return data;
    }
}
