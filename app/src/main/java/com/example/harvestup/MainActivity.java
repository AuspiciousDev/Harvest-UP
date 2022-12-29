package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CardView managementClick, infoClick, historyClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        managementClick = findViewById(R.id.home_Management);
        infoClick = findViewById(R.id.home_Information);
        historyClick = findViewById(R.id.home_History);

        managementClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ManagementMenu.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        infoClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, InformationMenu.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        historyClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, HistoryMenu.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }


}