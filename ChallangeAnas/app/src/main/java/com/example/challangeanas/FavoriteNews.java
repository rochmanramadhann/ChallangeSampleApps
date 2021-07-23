package com.example.challangeanas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class FavoriteNews extends AppCompatActivity {
    private ArrayList<getData> favList = new ArrayList<>();
    private RecyclerView rcFavNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_news);

        rcFavNews = findViewById(R.id.rcfav_news);
        rcFavNews.setHasFixedSize(true);

        Intent getIntnt = getIntent();
        //ArrayList<getData> dataIntent = getIntent().getSerializableExtra("data");

        ArrayList<getData> data = new ArrayList<getData>();
        data = (ArrayList<getData>) getIntnt.getSerializableExtra("data");

        ArrayList<getData> newData = new ArrayList<>();
        for (int i=0; i<15; i++) {
            getData item = new getData();
            if (data.get(i).getFavorit()) {
                //newData.addAll(i, data);
                item.setFavorit(true);
                item.setDeskripsi(data.get(i).getDeskripsi());
                item.setImglink(data.get(i).getImglink());
                item.setJudul(data.get(i).getJudul());
                item.setLink(data.get(i).getLink());
                item.setPenulis(data.get(i).getPenulis());
                item.setTerbit(data.get(i).getTerbit());
                newData.add(item);
            }
        }
        favList.addAll(newData);

        rcFavNews.setLayoutManager(new GridLayoutManager(FavoriteNews.this, 2));
        gridAdapter gridAdapt = new gridAdapter(favList, FavoriteNews.this, true);
        rcFavNews.setAdapter(gridAdapt);

    }
}