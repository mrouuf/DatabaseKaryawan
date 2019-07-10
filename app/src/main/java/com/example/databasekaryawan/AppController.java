package com.example.databasekaryawan;

import android.app.Application;

import androidx.room.Room;

import com.example.databasekaryawan.db.KaryawanDatabase;

public class AppController extends Application {
    public static KaryawanDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(
                getApplicationContext(),
                KaryawanDatabase.class,
                "karyawan"
        ).allowMainThreadQueries().build();
    }
}
