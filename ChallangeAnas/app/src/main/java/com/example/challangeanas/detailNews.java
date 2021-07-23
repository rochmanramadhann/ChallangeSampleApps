package com.example.challangeanas;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class detailNews extends AppCompatActivity {
    WebView editWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailnews);

        editWeb = findViewById(R.id.web);
        editWeb.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        editWeb.loadUrl(url);
    }
}
