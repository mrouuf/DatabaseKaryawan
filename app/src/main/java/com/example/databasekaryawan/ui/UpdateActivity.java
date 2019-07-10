package com.example.databasekaryawan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasekaryawan.R;
import com.example.databasekaryawan.model.Karyawan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.databasekaryawan.AppController.db;

public class UpdateActivity extends AppCompatActivity {
    @BindView(R.id.idNamaKaryawanEdit) EditText editNama;
    @BindView(R.id.idKaryawanEdit) EditText editId;
    @BindView(R.id.idDivisiKaryawanEdit) EditText editDivisi;
    @BindView(R.id.idGajiKaryawanEdit) EditText editGaji;
    Button btnEdit, btnCancel;
    Karyawan karyawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);

        getData();

    }

    private void getData() {
        Intent intent = getIntent();
        Integer ValueID = intent.getIntExtra("id",0);
        Log.d("Cekit",String.valueOf(ValueID));
        karyawan = db.daoAccess().findById(String.valueOf(ValueID));
        mapData(karyawan);
    }

    private void mapData(Karyawan karyawanNew) {
        editNama.setText(karyawanNew.getNama_karyawan());
        editId.setText(karyawanNew.getId_karyawan());
        editDivisi.setText(karyawanNew.getDivisi_karyawan());
        editGaji.setText(karyawanNew.getGaji_karyawan());
    }

    @OnClick(R.id.btn_Save)void EditKaryawan(){
        Karyawan karyawanupdate = new Karyawan();

        karyawanupdate.setId(karyawan.getId());
        karyawanupdate.setNama_karyawan(editNama.getText().toString());
        karyawanupdate.setId_karyawan(editId.getText().toString());
        karyawanupdate.setDivisi_karyawan(editDivisi.getText().toString());
        karyawanupdate.setGaji_karyawan(editGaji.getText().toString());

        db.daoAccess().updateUsers(karyawanupdate);
        startActivity(new Intent(this, DetailActivity.class));
        finish();
    }

    @OnClick(R.id.btn_Cancel)void CancelKaryawan(){
        startActivity(new Intent(this, DetailActivity.class));
        finish();
    }

}
