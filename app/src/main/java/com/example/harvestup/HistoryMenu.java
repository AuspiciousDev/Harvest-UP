package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.harvestup.adapter.PondDBAdapter;
import com.example.harvestup.database.DBHelper;

import java.util.ArrayList;

public class HistoryMenu extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> pondName, pondLayout, pondDate;
    DBHelper dbHelper;
    PondDBAdapter pondDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_menu);

        dbHelper = new DBHelper(this);
        pondName = new ArrayList<>();
        pondLayout = new ArrayList<>();
        pondDate = new ArrayList<>();
        recyclerView = findViewById(R.id.recylerView);
        pondDBAdapter = new PondDBAdapter(this, pondName, pondLayout, pondDate);
        recyclerView.setAdapter(pondDBAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData() {
        Cursor cursor = dbHelper.getData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Entry Exists!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                pondName.add(cursor.getString(0));
                pondLayout.add(cursor.getString(1));
                pondDate.add(cursor.getString(2));
            }

        }
    }
}