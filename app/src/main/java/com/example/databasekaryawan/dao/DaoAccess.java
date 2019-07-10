package com.example.databasekaryawan.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.databasekaryawan.model.Karyawan;

import java.util.List;

@Dao
public interface DaoAccess {

    @Query("SELECT * FROM karyawan")
    List<Karyawan> getAll();

    @Query("SELECT * FROM karyawan WHERE nama_karyawan LIKE :nama_karyawan")
    Karyawan findByName(String nama_karyawan);

    @Query("SELECT * FROM karyawan WHERE id LIKE :id")
    Karyawan findById(String id);

    @Insert
    void insertAll(Karyawan... karyawan);

    @Delete
    public void deleteUsers(Karyawan... users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateUsers(Karyawan karyawan);


}
