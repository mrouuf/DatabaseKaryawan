package com.example.databasekaryawan.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Karyawan {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "nama_karyawan")
    String nama_karyawan;
    @ColumnInfo(name = "id_karyawan")
    String id_karyawan;
    @ColumnInfo(name = "divisi_karyawan")
    String divisi_karyawan;
    @ColumnInfo(name = "gaji_karyawan")
    String gaji_karyawan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getDivisi_karyawan() {
        return divisi_karyawan;
    }

    public void setDivisi_karyawan(String divisi_karyawan) {
        this.divisi_karyawan = divisi_karyawan;
    }

    public String getGaji_karyawan() {
        return gaji_karyawan;
    }

    public void setGaji_karyawan(String gaji_karyawan) {
        this.gaji_karyawan = gaji_karyawan;
    }
}
