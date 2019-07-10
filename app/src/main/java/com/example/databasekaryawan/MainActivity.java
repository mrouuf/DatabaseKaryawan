package com.example.databasekaryawan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasekaryawan.model.Karyawan;
import com.example.databasekaryawan.ui.DetailActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.databasekaryawan.AppController.db;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.idNamaKaryawan) EditText inputNama;
    @BindView(R.id.idKaryawan) EditText inputID;
    @BindView(R.id.idDivisiKaryawan) EditText inputDivisi;
    @BindView(R.id.idGajiKaryawan) EditText inputGaji;

    Karyawan karyawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_Daftar)void daftarKaryawan(){
        if (!inputNama.getText().toString().isEmpty()&&
                !inputID.getText().toString().isEmpty()&&
                !inputDivisi.getText().toString().isEmpty()&&
                !inputGaji.getText().toString().isEmpty()){

            karyawan = new Karyawan();
            karyawan.setNama_karyawan(inputNama.getText().toString());
            karyawan.setId_karyawan(inputID.getText().toString());
            karyawan.setDivisi_karyawan(inputDivisi.getText().toString());
            karyawan.setGaji_karyawan(inputGaji.getText().toString());

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            db.daoAccess().insertAll(karyawan);
            //Toast.makeText(this,"Berhasil mendaftarkan karyawan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, DetailActivity.class));
        }else {
            Toast.makeText(this, "Harap lengkapi field yang masih kosong", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_LihatDaftar)void lihatDaftarKaryawan(){
        startActivity(new Intent(MainActivity.this, DetailActivity.class));

    }
}
