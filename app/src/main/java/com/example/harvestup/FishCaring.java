package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FishCaring extends AppCompatActivity {
    private CardView careBinhian, careKawagan, carePalakihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_caring);

        careBinhian = findViewById(R.id.careBinhian);
        carePalakihan = findViewById(R.id.carePalakihan);
        careKawagan = findViewById(R.id.careKawagan);


        careBinhian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishCaring.this, careBinhian.class);
                FishCaring.this.startActivity(myIntent);
            }
        });
        carePalakihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishCaring.this, carePalakihan.class);
                FishCaring.this.startActivity(myIntent);
            }
        });
        careKawagan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(FishCaring.this, careKawagan.class);
                FishCaring.this.startActivity(myIntent);
            }
        });

    }
}