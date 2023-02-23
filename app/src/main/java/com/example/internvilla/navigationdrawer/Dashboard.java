package com.example.internvilla.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;

public class Dashboard extends AppCompatActivity {
SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        Window window = Dashboard.this.getWindow();
        //window.setStatusBarColor(ContextCompat.getColor(Dashboard.this,R.color.my_statusbar_color));
        searchView=findViewById(R.id.searchView);
        searchView.setQueryHint("What are you looking for?");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent j=new Intent(Dashboard.this,LoginPage.class);
                startActivity(j);
                finish();
            }
        },7000);
    }
}