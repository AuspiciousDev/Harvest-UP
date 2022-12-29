package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InformationMenu extends AppCompatActivity {
    private CardView card_fTypes, card_fFoods,card_fCare,card_fHarvest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_menu);

        card_fTypes = findViewById(R.id.card_fTypes);
        card_fFoods = findViewById(R.id.card_fFoods);
        card_fCare = findViewById(R.id.card_fCare);
        card_fHarvest = findViewById(R.id.card_fHarvest);

        card_fTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InformationMenu.this, FishTypes.class);
                InformationMenu.this.startActivity(myIntent);
            }
        });
        card_fTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InformationMenu.this, FishTypes.class);
                InformationMenu.this.startActivity(myIntent);
            }
        });
        card_fFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InformationMenu.this, FishFoods.class);
                InformationMenu.this.startActivity(myIntent);
            }
        }); card_fCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InformationMenu.this, FishCaring.class);
                InformationMenu.this.startActivity(myIntent);
            }
        }); card_fHarvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InformationMenu.this, FishHarvest.class);
                InformationMenu.this.startActivity(myIntent);
            }
        });
    }
}