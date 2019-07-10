package com.example.databasekaryawan.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.databasekaryawan.dao.DaoAccess;
import com.example.databasekaryawan.model.Karyawan;

@Database(entities = {Karyawan.class}, version = 1)
public abstract class KaryawanDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
