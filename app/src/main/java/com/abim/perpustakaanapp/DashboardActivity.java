package com.abim.perpustakaanapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ctx = this;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id){
            case R.id.card_buku:
                intent = new Intent(DashboardActivity.this, BukuActivity.class);
                startActivity(intent);
                break;
            case R.id.card_history:
                intent = new Intent(DashboardActivity.this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.card_info:
                intent = new Intent(DashboardActivity.this, InfoActivity.class);
                startActivity(intent);
                break;
            case R.id.card_keluar:
                AlertDialog dialog = new AlertDialog.Builder(ctx).create();
                dialog.setTitle("Konfirmasi");
                dialog.setMessage("Apakah anda yakin ingin keluar?");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(DashboardActivity.this, HomeActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();
                    }
                });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
    }
}