package com.example.harvestup;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harvestup.adapter.PondDBAdapter;
import com.example.harvestup.adapter.SectionAdapter;
import com.example.harvestup.database.DBHelper;
import com.google.android.material.snackbar.Snackbar;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ManagementViewPond extends AppCompatActivity {
    DBHelper dbHelper;
    String pondName, pondLayout, pondDate;
    Bundle bundle;
    String mPondName, mLayoutType;
    TextView textPondName, textPondLayout, textPondDate, sectionTitle;
    GridLayout gridLayout, espGridA;
    int columnCount;
    CheckBox pond1, pond2, pond3, pond4, pond5, pond6;
    CheckBox pondA1, pondA2, pondA3, pondA4, pondA5, pondA6;

    String dbPondSection, dbPonSecNum, dbSize, dbCare, dbFishType;
    int dbCapacity;

    RecyclerView recyclerView;
    private ArrayList pondSection, sectionNum, size, capacity, fishType, careType;
    SectionAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_view_pond);

        bundle = getIntent().getExtras();
        mPondName = bundle.getString("pondName");
        mLayoutType = bundle.getString("pondLayout");
        dbHelper = new DBHelper(this);
        textPondName = findViewById(R.id.textPondName);
        textPondLayout = findViewById(R.id.textPondLayout);
        textPondDate = findViewById(R.id.textPondDate);
        sectionTitle = findViewById(R.id.sectionTitle);
        espGridA = findViewById(R.id.espGridA);
        pond1 = findViewById(R.id.pond1);
        pond2 = findViewById(R.id.pond2);
        pond3 = findViewById(R.id.pond3);
        pond4 = findViewById(R.id.pond4);
        pond5 = findViewById(R.id.pond5);
        pond6 = findViewById(R.id.pond6);

        pondA1 = findViewById(R.id.pondA1);
        pondA2 = findViewById(R.id.pondA2);
        pondA3 = findViewById(R.id.pondA3);
        pondA4 = findViewById(R.id.pondA4);
        pondA5 = findViewById(R.id.pondA5);
        pondA6 = findViewById(R.id.pondA6);
        pondSection = new ArrayList<>();
        sectionNum = new ArrayList<>();
        size = new ArrayList<>();
        capacity = new ArrayList<>();
        fishType = new ArrayList<>();
        careType = new ArrayList<>();
        recyclerView = findViewById(R.id.recylerView);
        sectionAdapter = new SectionAdapter(this, pondSection, sectionNum, size, capacity, fishType, careType);
        recyclerView.setAdapter(sectionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData(mPondName);
        displayDataAll(mPondName);


        gridLayout = findViewById(R.id.pondLayout);
        Log.d(TAG, "onCreate: " + mLayoutType);
        switch (mLayoutType) {
            case "Layout 1":
                columnCount = 2;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.GONE);
                pond3.setVisibility(View.GONE);
                pond4.setVisibility(View.GONE);
                pond5.setVisibility(View.GONE);
                pond6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);

                break;
            case "Layout 2":
                columnCount = 2;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.VISIBLE);
                pond3.setVisibility(View.GONE);
                pond4.setVisibility(View.GONE);
                pond5.setVisibility(View.GONE);
                pond6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);

                break;
            case "Layout 3":
                columnCount = 2;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.VISIBLE);
                pond3.setVisibility(View.VISIBLE);
                pond4.setVisibility(View.GONE);
                pond5.setVisibility(View.GONE);
                pond6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);
                break;
            case "Layout 4":
                columnCount = 1;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.VISIBLE);
                pond3.setVisibility(View.GONE);
                pond4.setVisibility(View.GONE);
                pond5.setVisibility(View.GONE);
                pond6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);
                break;
            case "Layout 5":
                columnCount = 1;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.VISIBLE);
                pond3.setVisibility(View.VISIBLE);
                pond4.setVisibility(View.VISIBLE);
                pond5.setVisibility(View.GONE);
                pond6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);
                break;
            case "Layout 6":
                columnCount = 1;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.VISIBLE);
                pond3.setVisibility(View.VISIBLE);
                pond4.setVisibility(View.VISIBLE);
                pond5.setVisibility(View.VISIBLE);
                pond6.setVisibility(View.VISIBLE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);
                break;
            case "Layout 7":
                columnCount = 2;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.VISIBLE);
                pond3.setVisibility(View.VISIBLE);
                pond4.setVisibility(View.VISIBLE);
                pond5.setVisibility(View.GONE);
                pond6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);
                break;
            case "Layout 8":
                columnCount = 2;
                pond1.setVisibility(View.VISIBLE);
                pond2.setVisibility(View.VISIBLE);
                pond3.setVisibility(View.VISIBLE);
                pond4.setVisibility(View.VISIBLE);
                pond5.setVisibility(View.VISIBLE);
                pond6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.VISIBLE);
                espGridA.setVisibility(View.GONE);
                break;
            case "Layout 9":
                pondA6.setVisibility(View.GONE);
                gridLayout.setVisibility(View.GONE);
                espGridA.setVisibility(View.VISIBLE);

                break;
            case "Layout 10":
                gridLayout.setVisibility(View.GONE);
                espGridA.setVisibility(View.VISIBLE);
                pondA6.setVisibility(View.VISIBLE);
                break;
            default:
                // code block
        }
        final int viewsCount = gridLayout.getChildCount();
        for (int i = 0; i < viewsCount; i++) {
            View view = gridLayout.getChildAt(i);
            GridLayout.LayoutParams oldParams = (GridLayout.LayoutParams) view.getLayoutParams();
            GridLayout.LayoutParams newParams = new GridLayout.LayoutParams();
            newParams.width = oldParams.width;
            newParams.height = oldParams.height;
            newParams.setMargins(oldParams.leftMargin, oldParams.topMargin, oldParams.rightMargin, oldParams.bottomMargin);
            view.setLayoutParams(oldParams);
        }
        if (columnCount == 1) {
            gridLayout.setOrientation(GridLayout.HORIZONTAL);
            gridLayout.setColumnCount(2);
        } else {
            gridLayout.setOrientation(GridLayout.VERTICAL);
        }
    }


    private void displayData(String pondNam) {
        Cursor cursor = dbHelper.getPondDatabyID(pondNam);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Entry Exists!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                pondName = cursor.getString(0);
                pondLayout = cursor.getString(1);
                pondDate = cursor.getString(2);
            }
            textPondName.setText(pondName);
            textPondLayout.setText(pondLayout);
            textPondDate.setText(pondDate);
        }
    }

    private void displayDataAll(String pondName) {
        pond1.setChecked(false);
        pond2.setChecked(false);
        pond3.setChecked(false);
        pond4.setChecked(false);
        Cursor cursor = dbHelper.getPonSectionDatabyPond(pondName);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Fish pond section exists!", Toast.LENGTH_SHORT).show();
            sectionTitle.setText("No section exists!");
            return;
        } else {
            sectionTitle.setVisibility(View.VISIBLE);
            while (cursor.moveToNext()) {
                pondSection.add(cursor.getString(0));
                sectionNum.add(cursor.getString(1));
                size.add(cursor.getString(2));
                careType.add(cursor.getString(3));
                fishType.add(cursor.getString(4));
                capacity.add(cursor.getString(5));
                dbPonSecNum = cursor.getString(1);

                Log.d(TAG, "displayDataAll: " + dbPonSecNum);
                if (pondLayout.equals("Layout 9") || pondLayout.equals("Layout 10")) {
                    if (dbPonSecNum.equals("1")) {
                        pondA1.setChecked(true);
                    }
                    if (dbPonSecNum.equals("2")) {
                        pondA2.setChecked(true);
                    }
                    if (dbPonSecNum.equals("3")) {
                        pondA3.setChecked(true);
                    }
                    if (dbPonSecNum.equals("4")) {
                        pondA4.setChecked(true);
                    }
                    if (dbPonSecNum.equals("5")) {
                        pondA5.setChecked(true);
                    }
                    if (dbPonSecNum.equals("6")) {
                        pondA6.setChecked(true);
                    }
                } else {
                    if (dbPonSecNum.equals("1")) {
                        pond1.setChecked(true);
                    }
                    if (dbPonSecNum.equals("2")) {
                        pond2.setChecked(true);
                    }
                    if (dbPonSecNum.equals("3")) {
                        pond3.setChecked(true);
                    }
                    if (dbPonSecNum.equals("4")) {
                        pond4.setChecked(true);
                    }
                    if (dbPonSecNum.equals("5")) {
                        pond5.setChecked(true);
                    }
                    if (dbPonSecNum.equals("6")) {
                        pond6.setChecked(true);
                    }
                }
            }
        }
    }
}

