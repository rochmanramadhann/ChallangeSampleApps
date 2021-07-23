package com.example.challangeanas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class gridAdapter extends RecyclerView.Adapter<gridAdapter.gridViewHolder> {
    private ArrayList<getData> data;
    Context context;

    gridAdapter(ArrayList<getData> list, Context ctx) {
        this.data = list;
        this.context = ctx;
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
        holder.gridLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detailNews.class);
                intent.putExtra("url", dt.getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class gridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView title;
        LinearLayout gridLy;

        gridViewHolder(View view) {
            super(view);

            imgNews = view.findViewById(R.id.imgNews);
            title = view.findViewById(R.id.TtlNews);
            gridLy = view.findViewById(R.id.gridLayout);
        }
    }
}
