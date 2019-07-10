package com.example.databasekaryawan.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.databasekaryawan.R;
import com.example.databasekaryawan.model.Karyawan;

import java.util.List;

import static com.example.databasekaryawan.AppController.db;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.KaryawanViewHolder> {
    private Context context;
    private List<Karyawan> karyawanList;

    public RecycleViewAdapter(Context context, List<Karyawan> karyawanList) {
        this.context = context;
        this.karyawanList = karyawanList;
    }

    @Override
    public KaryawanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(context)
                .inflate(R.layout.layout_list_karyawan, parent, false);

        return new KaryawanViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(KaryawanViewHolder holder, int position) {
        final Karyawan data = karyawanList.get(position);

        holder.nameKaryawan.setText(data.getNama_karyawan());
        holder.idKaryawan.setText(data.getId_karyawan());
        holder.divisiKaryawan.setText(data.getDivisi_karyawan());
        holder.gajiKaryawan.setText(data.getGaji_karyawan());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Edit... "+data.getNama_karyawan(), Toast.LENGTH_SHORT).show();
                Intent intenEdit = new Intent(context, UpdateActivity.class);
                intenEdit.putExtra("id", data.getId());
                context.startActivity(intenEdit);

            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Select your answer");

                builder.setMessage("Anda yakin ingin menghapus data ?");

                // Set click listener for alert dialog buttons
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case DialogInterface.BUTTON_POSITIVE:
                                // User clicked the Yes button
                                db.daoAccess().deleteUsers(data);
                                Intent intentdelete = new Intent(context, DetailActivity.class);
                                context.startActivity(intentdelete);
                                ((Activity)context).finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                // User clicked the No button
                                break;
                        }
                    }
                };

                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Yes", dialogClickListener);

                // Set the alert dialog no button click listener
                builder.setNegativeButton("No",dialogClickListener);

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
                //Toast.makeText(context,"Delete... "+data.getNama_karyawan(), Toast.LENGTH_SHORT).show();
/*                db.daoAccess().deleteUsers(data);
                Intent intentdelete = new Intent(context, DetailActivity.class);
                context.startActivity(intentdelete);
                ((Activity)context).finish();*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return karyawanList.size();
    }

    public class KaryawanViewHolder extends RecyclerView.ViewHolder{
        TextView nameKaryawan, idKaryawan, divisiKaryawan, gajiKaryawan;
        Button btnEdit, btnDelete;

        public KaryawanViewHolder(View itemView) {
            super(itemView);
            nameKaryawan = itemView.findViewById(R.id.valueNamaKaryawan);
            idKaryawan = itemView.findViewById(R.id.valueIdKaryawan);
            divisiKaryawan = itemView.findViewById(R.id.valueDivisiKaryawan);
            gajiKaryawan = itemView.findViewById(R.id.valueGajiKaryawan);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
