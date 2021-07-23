package com.example.challangeanas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //TextView title, Name, Desc, Total;
    String jdl, nm, desk, link, linkimg, tgl, cntnt;
    int jumlah;

    private RecyclerView rcView;
    private ArrayList<getData> DataNews = new ArrayList<>();
    //private ArrayList<String> data = new ArrayList<>();
    private ArrayList<getData> isiNews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcView = findViewById(R.id.rcview);
        rcView.setHasFixedSize(true);

        /*title = findViewById(R.id.judul);
        Name = findViewById(R.id.penulis);
        Desc = findViewById(R.id.deskripsi);
        Total = findViewById(R.id.total);*/

        NewsApiClient newsApiClient = new NewsApiClient("130a1cf11d6a4d5ab02dc85c2bc4fe77");

        // /v2/everything
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("tesla")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        jumlah = response.getTotalResults();

                        Toast.makeText(MainActivity.this, "berhasil"+jumlah, Toast.LENGTH_SHORT).show();
                        for (int i=0; i<15; i++) {
                            getData data = new getData();
                            data.setPenulis(response.getArticles().get(i).getAuthor());
                            data.setDeskripsi(response.getArticles().get(i).getDescription());
                            data.setJudul(response.getArticles().get(i).getTitle());
                            data.setLink(response.getArticles().get(i).getUrl());
                            data.setImglink(response.getArticles().get(i).getUrlToImage());
                            data.setTerbit(response.getArticles().get(i).getPublishedAt());
                            DataNews.add(data);
                        }

                        isiNews.addAll(DataNews);
                        showRcList();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        //System.out.println(throwable.getMessage());
                    }
                }
        );
    }

    //ArrayList<getData> dtNews
    private void showRcList() {
        rcView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        listAdapter listAdapt = new listAdapter(isiNews);
        rcView.setAdapter(listAdapt);
    }

    private void showRcGrid() {
        rcView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        gridAdapter gridAdapt = new gridAdapter(isiNews);
        rcView.setAdapter(gridAdapt);
    }

    public boolean onOptionsItemSelected(MenuItem menu) {
        setMenu(menu.getItemId());
        return super.onOptionsItemSelected(menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void setMenu(int mode) {
        switch (mode) {
            case R.id.action_list:
                showRcList();
                break;
            case R.id.action_grid:
                showRcGrid();
                break;
        }
    }
}