package com.example.challangeanas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class gridAdapter extends RecyclerView.Adapter<gridAdapter.gridViewHolder> {
    private ArrayList<getData> data;

    gridAdapter(ArrayList<getData> list) {
        this.data = list;
    }

    @NonNull
    @NotNull
    @Override
    public gridAdapter.gridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview, parent, false);
        return new gridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull gridAdapter.gridViewHolder holder, int position) {
        getData dt = data.get(position);

        Glide.with(holder.itemView.getContext())
                .load(dt.getImglink())
                .apply(new RequestOptions().override(250, 250))
                .into(holder.imgNews);

        holder.title.setText(dt.getJudul());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class gridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView title;
        gridViewHolder(View view) {
            super(view);

            imgNews = view.findViewById(R.id.imgNews);
            title = view.findViewById(R.id.TtlNews);
        }
    }
}
