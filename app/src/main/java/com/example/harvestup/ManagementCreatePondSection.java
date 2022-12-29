package com.example.harvestup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harvestup.database.DBHelper;
import com.google.android.material.snackbar.Snackbar;

public class ManagementCreatePondSection extends AppCompatActivity {
    TextView textFishPondName, textSectionDetailsHeader;
    EditText textPondSize;
    Spinner spinnerCare, spinnerFishType;
    Button buttonSubmit, buttonExit;
    CheckBox pond1, pond2, pond3, pond4, pond5, pond6;
    CheckBox pondA1, pondA2, pondA3, pondA4, pondA5, pondA6;

    DBHelper dbHelper;
    GridLayout gridLayout, espGridA;
    Bundle bundle;
    String mPondName, mLayoutType;
    int columnCount, rowCount;
    String[] care = {"Binhian", "Kawagan", "Palakihan"};
    String[] fishType = {"Bangus", "Pla-Pla", "Apahap", "Talangka", "Alimango", "Sugpo", "Vannamei"};
    String setFishType, setCareType, setSectionNum, strSize;
    int totalFishCapacity;
    int pondSize;
    RadioGroup radioGroup;
    AlertDialog.Builder builder1;
    ArrayAdapter aaCare, aaFtype;
    String section = "Section [";
    String details = "] details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_create_pond_section);
        bundle = getIntent().getExtras();
        mPondName = bundle.getString("pondName");
        mLayoutType = bundle.getString("pondLayout");
        dbHelper = new DBHelper(this);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonExit = findViewById(R.id.buttonExit);
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
        textFishPondName = findViewById(R.id.textFishPondName);
        textSectionDetailsHeader = findViewById(R.id.textSectionDetailsHeader);
        textPondSize = findViewById(R.id.textPondSize);
        spinnerCare = findViewById(R.id.spinnerCare);
        spinnerFishType = findViewById(R.id.spinnerFishType);

        textFishPondName.setText(mPondName);

        builder1 = new AlertDialog.Builder(this);
        builder1.setCancelable(true);
        builder1.setTitle(mPondName + " Fish pond");
        builder1.setMessage("Add Fish pond sections.");
        builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert11 = builder1.create();
        alert11.show();

        aaCare = new ArrayAdapter(this, R.layout.spinnerlistyle, care);
        aaCare.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCare.setAdapter(aaCare);

        aaFtype = new ArrayAdapter(this, R.layout.spinnerlistyle, fishType);
        aaFtype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFishType.setAdapter(aaFtype);

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


        pond1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond1.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 1", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "1";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pond2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond2.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 2", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "2";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pond3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond3.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 3", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "3";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pond4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond4.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 4", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "4";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pond5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond5.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 5", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "5";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pond6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond6.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 6", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "6";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pondA1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA1.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 1", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "1";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pondA2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA2.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 2", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "2";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pondA3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA3.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 3", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "3";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pondA4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA4.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 4", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "4";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pondA5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA5.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 5", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "5";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });
        pondA6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA6.isChecked()) {
                    Snackbar.make(findViewById(android.R.id.content), "Section 6", Snackbar.LENGTH_LONG).show();
                    setSectionNum = "6";
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    clearFields();
                } else {
                    clearSelectedSection();
                }
            }
        });


        spinnerCare.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setCareType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerFishType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setFishType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!pond1.isChecked() && !pond2.isChecked() && !pond3.isChecked() && !pond4.isChecked() && !pond5.isChecked() && !pond6.isChecked() && !pondA1.isChecked() && !pondA2.isChecked() && !pondA3.isChecked() && !pondA4.isChecked() && !pondA5.isChecked() && !pondA6.isChecked()) {
                        setSectionNum = "0";
                    }
                    strSize = textPondSize.getText().toString();
                    if (!strSize.equals("0") && !strSize.isEmpty()) {
                        if (!setSectionNum.equals("0")) {
                            pondSize = Integer.parseInt(strSize);
                            totalFishCapacity = getTotalFish(pondSize, setFishType, setCareType);
                            //Uncomment the below code to Set the message and title from the strings.xml file
                            builder1 = new AlertDialog.Builder(ManagementCreatePondSection.this);
                            builder1.setMessage(
                                    "Fish pond size  : " + pondSize +
                                            "\n" + "Fish Care           : " + setCareType +
                                            "\n" + "Fish Type           : " + setFishType +
                                            "\n" + "Fish Capacity    : " + totalFishCapacity
                            ).setTitle(mPondName + "Fish pond section " + setSectionNum);
                            builder1.setCancelable(true);
                            builder1.setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Boolean checkInsertData = dbHelper.insertSectionDetails(mPondName + setSectionNum, mPondName, setSectionNum, pondSize, setCareType, setFishType, totalFishCapacity);
                                            if (checkInsertData == true) {
                                                Toast.makeText(ManagementCreatePondSection.this, "Fish pond section " + setSectionNum + " added!", Toast.LENGTH_SHORT).show();
                                                textPondSize.setText("");
                                                setSectionNum = "";
                                                strSize = "";
                                                spinnerCare.setSelection(0);
                                                spinnerFishType.setSelection(0);
                                            } else {
                                                Toast.makeText(ManagementCreatePondSection.this, "Fish Pond Section Exists!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                            builder1.setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        } else {
                            Toast.makeText(ManagementCreatePondSection.this, "Select Fish pond section!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        textPondSize.setError("Fish pond size is empty!");
                    }
                } catch (Exception e) {
                    Toast.makeText(ManagementCreatePondSection.this, "Error : " + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonExit.setOnClickListener(view ->

        {
            Intent intent = new Intent(ManagementCreatePondSection.this, ManagementViewPond.class);
            intent.putExtra("pondName", mPondName);
            intent.putExtra("pondLayout", mLayoutType);
            startActivity(intent);
            finish();
        });
    }

    private int getTotalFish(int size, String type, String care) {
        int totalFishCapacity = 0;
        switch (care) {
            case "Binhian": {
                if (type.equals("Bangus")) {
                    totalFishCapacity = size * 300000;
                }
                if (type.equals("Pla-Pla")) {
                    totalFishCapacity = size * 2500000;
                }
                if (type.equals("Apahap")) {
                    totalFishCapacity = size * 500000;
                }
                if (type.equals("Talangka")) {
                    totalFishCapacity = size * 5000000;
                }
                if (type.equals("Alimango")) {
                    totalFishCapacity = size * 300000;
                }
                if (type.equals("Sugpo")) {
                    totalFishCapacity = size * 2500000;
                }
                if (type.equals("Vannamei")) {
                    totalFishCapacity = size * 2500000;
                }
            }
            break;
            case "Kawagan": {
                if (type.equals("Bangus")) {
                    totalFishCapacity = size * 480000;
                }
                if (type.equals("Pla-Pla")) {
                    totalFishCapacity = size * 4000000;
                }
                if (type.equals("Apahap")) {
                    totalFishCapacity = size * 800000;
                }
                if (type.equals("Talangka")) {
                    totalFishCapacity = size * 8000000;
                }
                if (type.equals("Alimango")) {
                    totalFishCapacity = size * 480000;
                }
                if (type.equals("Sugpo")) {
                    totalFishCapacity = size * 4000000;
                }
                if (type.equals("Vannamei")) {
                    totalFishCapacity = size * 4000000;
                }

            }
            break;
            case "Palakihan": {
                if (type.equals("Bangus")) {
                    totalFishCapacity = size * 6000;
                }
                if (type.equals("Pla-Pla")) {
                    totalFishCapacity = size * 50000;
                }
                if (type.equals("Apahap")) {
                    totalFishCapacity = size * 10000;
                }
                if (type.equals("Talangka")) {
                    totalFishCapacity = size * 100000;
                }
                if (type.equals("Alimango")) {
                    totalFishCapacity = size * 2500000;
                }
                if (type.equals("Sugpo")) {
                    totalFishCapacity = size * 50000;
                }
                if (type.equals("Vannamei")) {
                    totalFishCapacity = size * 10000;
                }

            }
            break;
            default:
                break;

        }

        return totalFishCapacity;

    }

    private void clearFields() {
        textPondSize.setText("");
        spinnerFishType.setSelection(0);
        spinnerCare.setSelection(0);
    }

    private void clearSelectedSection() {
        if (!pond1.isChecked() && !pond2.isChecked() && !pond3.isChecked() && !pond4.isChecked() && !pond5.isChecked() && !pond6.isChecked() && !pondA1.isChecked() && !pondA2.isChecked() && !pondA3.isChecked() && !pondA4.isChecked() && !pondA5.isChecked() && !pondA6.isChecked()) {
            textSectionDetailsHeader.setText(section + details);
            textPondSize.setText("");
            spinnerFishType.setSelection(0);
            spinnerCare.setSelection(0);
        }
    }
}