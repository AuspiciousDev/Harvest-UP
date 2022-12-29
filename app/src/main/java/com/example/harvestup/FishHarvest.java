package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FishHarvest extends AppCompatActivity {
    private CardView harvestLambat, harvestDala, harvestBintol, harvestPaktang, harvestPanti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_harvest);


        harvestLambat = findViewById(R.id.harvestLambat);
        harvestDala = findViewById(R.id.harvestDala);
        harvestBintol = findViewById(R.id.harvestBintol);
        harvestPaktang = findViewById(R.id.harvestPaktang);
        harvestPanti = findViewById(R.id.harvestPanti);


        harvestLambat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishHarvest.this, harvestLambat.class);
                FishHarvest.this.startActivity(myIntent);
            }
        });
        harvestDala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishHarvest.this, harvestDala.class);
                FishHarvest.this.startActivity(myIntent);
            }
        });
        harvestBintol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishHarvest.this, harvestBintol.class);
                FishHarvest.this.startActivity(myIntent);
            }
        });  harvestPaktang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishHarvest.this, harvestPaktang.class);
                FishHarvest.this.startActivity(myIntent);
            }
        });  harvestPanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishHarvest.this, harvestPanti.class);
                FishHarvest.this.startActivity(myIntent);
            }
        });
    }
}