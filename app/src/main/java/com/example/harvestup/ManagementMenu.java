package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harvestup.adapter.PondAdapter;
import com.example.harvestup.database.DBHelper;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ManagementMenu extends AppCompatActivity {
    DBHelper dbHelper;
    Button button;
    EditText textPondName;
    GridLayout gridLayout, espGridA;
    int columnCount, rowCount;

    CheckBox pond1, pond2, pond3, pond4, pond5, pond6;
    CheckBox pondA1, pondA2, pondA3, pondA4, pondA5, pondA6;

    private ArrayList<PondItem> iPondList;
    private PondAdapter iAdapter;
    Spinner spinnerPondLayout;


    private String pondName, pondLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_menu);
        initList();
        dbHelper = new DBHelper(this);
        button = findViewById(R.id.buttonSubmit);
        gridLayout = findViewById(R.id.pondLayout);
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
        spinnerPondLayout = findViewById(R.id.spinnerPondLayout);
        textPondName = findViewById(R.id.textPondName);
        iAdapter = new PondAdapter(this, iPondList);
        spinnerPondLayout.setAdapter(iAdapter);

        spinnerPondLayout.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PondItem clickedItem = (PondItem) parent.getItemAtPosition(position);
                String clickedPondLayout = clickedItem.getiPondLayout();
                pond1.setChecked(false);
                pond2.setChecked(false);
                pond3.setChecked(false);
                pond4.setChecked(false);
                switch (clickedPondLayout) {
                    case "Layout 1":
                        pondLayout = "Layout 1";
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
                        pondLayout = "Layout 2";
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
                        pondLayout = "Layout 3";
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
                        pondLayout = "Layout 4";
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
                        pondLayout = "Layout 5";
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
                        pondLayout = "Layout 6";
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
                        pondLayout = "Layout 7";
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
                        pondLayout = "Layout 8";
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
                        pondLayout = "Layout 9";
                        pondA6.setVisibility(View.GONE);
                        gridLayout.setVisibility(View.GONE);
                        espGridA.setVisibility(View.VISIBLE);

                        break;
                    case "Layout 10":
                        pondLayout = "Layout 10";
                        gridLayout.setVisibility(View.GONE);
                        espGridA.setVisibility(View.VISIBLE);
                        pondA6.setVisibility(View.VISIBLE);
                        break;
                    default:
                        // code block
                }


                final int viewsCount = gridLayout.getChildCount();
                for (int i = 0; i < viewsCount; i++) {
                    view = gridLayout.getChildAt(i);
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

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pondName = textPondName.getText().toString();
                if (!pondName.isEmpty()) {
                    if (pondName.length() < 5) {
                        textPondName.setError("Pond name should be 3 characters or more  ");
                    } else {
                        String currentDate = new SimpleDateFormat("MMMM dd,yyyy", Locale.getDefault()).format(new Date());
                        Boolean checkInsertData = dbHelper.insertPondDetails(pondName, pondLayout, currentDate);
                        if (checkInsertData == true) {
                            Toast.makeText(ManagementMenu.this, pondName + " has been created!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManagementMenu.this, ManagementCreatePondSection.class);
                            textPondName.setText("");
                            intent.putExtra("pondName", pondName);
                            intent.putExtra("pondLayout", pondLayout);
                            startActivity(intent);
                            finish();
                        } else {
                            textPondName.setError("Pond name error!");
                        }
                    }
                } else {
                    textPondName.setError("Pond name is required!");
                }
            }
        });
    }

    private void initList() {
        iPondList = new ArrayList<>();
        iPondList.add(new PondItem("Layout 1", R.drawable.pondwhole));
        iPondList.add(new PondItem("Layout 2", R.drawable.pondhalf1));
        iPondList.add(new PondItem("Layout 3", R.drawable.pondthird));
        iPondList.add(new PondItem("Layout 4", R.drawable.pondhalf));
        iPondList.add(new PondItem("Layout 5", R.drawable.pondquad));
        iPondList.add(new PondItem("Layout 6", R.drawable.pondsix));
        iPondList.add(new PondItem("Layout 7", R.drawable.pond4hor));
        iPondList.add(new PondItem("Layout 8", R.drawable.pond5hor));
        iPondList.add(new PondItem("Layout 9", R.drawable.esp_a));
        iPondList.add(new PondItem("Layout 10", R.drawable.esp_b));
    }
}