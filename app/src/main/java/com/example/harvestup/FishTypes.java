package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;

public class FishTypes extends AppCompatActivity {
    private CardView typeBangus, typePlapla, typeAgahap, typeTalangka, typeAlimango, typeSugpo, typeVannamei;
private ShapeableImageView imageBangus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_types);
        typeBangus = findViewById(R.id.typeBangus);
        typePlapla = findViewById(R.id.typePlapla);
        typeAgahap = findViewById(R.id.typeApahap);
        typeTalangka = findViewById(R.id.typeTalangka);
        typeAlimango = findViewById(R.id.typeAlimango);
        typeSugpo = findViewById(R.id.typeSugpo);
        typeVannamei = findViewById(R.id.typeVannamei);


        typeBangus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishTypes.this, bangusInfo.class);
                FishTypes.this.startActivity(myIntent);
            }
        });

        typePlapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishTypes.this, plaplaInfo.class);
                FishTypes.this.startActivity(myIntent);
            }
        });
        typeAgahap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishTypes.this, apahapInfo.class);
                FishTypes.this.startActivity(myIntent);
            }
        });
        typeTalangka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishTypes.this, talangkaInfo.class);
                FishTypes.this.startActivity(myIntent);
            }
        });  typeAlimango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishTypes.this, alimangoInfo.class);
                FishTypes.this.startActivity(myIntent);
            }
        });  typeSugpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishTypes.this, sugpoInfo.class);
                FishTypes.this.startActivity(myIntent);
            }
        });  typeVannamei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishTypes.this, vannameiInfo.class);
                FishTypes.this.startActivity(myIntent);
            }
        });
    }
}