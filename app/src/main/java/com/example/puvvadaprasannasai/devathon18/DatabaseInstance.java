package com.example.puvvadaprasannasai.devathon18;

import android.annotation.SuppressLint;
import android.app.Application;

public class DatabaseInstance extends Application {

   public static Database db;

    @SuppressLint("MissingSuperCall")
    public void onCreate() {
        super.onCreate();
        db=new Database(this);
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
}
