package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FishFoods extends AppCompatActivity {
    private CardView foodFeeds, foodJako, foodNoodles, foodSulib, foodWaffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_foods);

        foodFeeds = findViewById(R.id.foodFeeds);
        foodJako = findViewById(R.id.foodJako);
        foodNoodles = findViewById(R.id.foodNoodles);
        foodSulib = findViewById(R.id.foodSulib);
        foodWaffer = findViewById(R.id.foodWaffer);


        foodFeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishFoods.this, foodFeeds.class);
                FishFoods.this.startActivity(myIntent);
            }
        });
        foodJako.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishFoods.this, foodJako.class);
                FishFoods.this.startActivity(myIntent);
            }
        });
        foodNoodles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishFoods.this, foodNoodles.class);
                FishFoods.this.startActivity(myIntent);
            }
        });

        foodSulib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishFoods.this, foodSulib.class);
                FishFoods.this.startActivity(myIntent);
            }
        });
        foodWaffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishFoods.this, foodWaffer.class);
                FishFoods.this.startActivity(myIntent);
            }
        });

    }
}