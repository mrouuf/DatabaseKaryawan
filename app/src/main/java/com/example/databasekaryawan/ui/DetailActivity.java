package com.example.databasekaryawan.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.databasekaryawan.R;
import com.example.databasekaryawan.db.KaryawanDatabase;
import com.example.databasekaryawan.model.Karyawan;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.databasekaryawan.AppController.db;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.rvKaryawan)
    RecyclerView recyclerView;
    List<Karyawan> karyawanList = new ArrayList<>();
    RecycleViewAdapter recycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        recyclerView = findViewById(R.id.rvKaryawan);
        fetchData();
        initRecycleView();
        setAdapter();

    }

    private void setAdapter() {
        recyclerView.setAdapter(recycleViewAdapter);
    }



    private void initRecycleView() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recycleViewAdapter = new RecycleViewAdapter(this, karyawanList);
        recyclerView.setHasFixedSize(true);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
    }

    private void fetchData() {
        db = Room.databaseBuilder(
                this,
                KaryawanDatabase.class,
                "karyawan"
        ).allowMainThreadQueries().build();
        karyawanList = db.daoAccess().getAll();

        for (int i = 0; i < karyawanList.size(); i++){
            Log.e("Cekit",karyawanList.get(i).getNama_karyawan()+i);
            Log.e("Cekit", karyawanList.get(i).getId_karyawan()+i);
            Log.e("Cekit", karyawanList.get(i).getDivisi_karyawan()+i);
            Log.e("Cekit", karyawanList.get(i).getGaji_karyawan()+i);
        };
    }

}
