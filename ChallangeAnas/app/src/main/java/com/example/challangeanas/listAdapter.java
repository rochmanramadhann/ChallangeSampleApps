package com.example.challangeanas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ListViewHolder> {
    private ArrayList<getData> listData;
    Context context;

    listAdapter(ArrayList<getData> list, Context ctx) {
        this.listData = list;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        getData data = listData.get(position);

        holder.itemTitle.setText(data.getJudul());
        holder.itemDesc.setText(data.getDeskripsi());

        holder.listLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detailNews.class);
                intent.putExtra("url", data.getLink());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        //ImageView imgPhoto;
        TextView itemTitle, itemDesc;
        LinearLayout listLy;

        ListViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.title_list);
            itemDesc = itemView.findViewById(R.id.desc_list);
            listLy = itemView.findViewById(R.id.listLayout);
        }
    }
}
