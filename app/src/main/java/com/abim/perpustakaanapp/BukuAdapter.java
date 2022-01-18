package com.abim.perpustakaanapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.ViewHolder> {
    Context ctx;
    List<Buku> bukus;

    public BukuAdapter(Context ctx, List<Buku> bukus) {
        this.ctx = ctx;
        this.bukus = bukus;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bukus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
