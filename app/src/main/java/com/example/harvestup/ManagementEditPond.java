package com.example.harvestup;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harvestup.database.DBHelper;

public class ManagementEditPond extends AppCompatActivity {
    TextView textFishPondName, textSectionDetailsHeader;
    EditText textPondSize;
    Spinner spinnerCare, spinnerFishType;
    Button buttonSubmit, buttonDelete;
    CheckBox pond1, pond2, pond3, pond4, pond5, pond6;
    CheckBox pondA1, pondA2, pondA3, pondA4, pondA5, pondA6;

    DBHelper dbHelper;
    GridLayout gridLayout, espGridA;
    Bundle bundle;
    String mPondName, mLayoutType;
    int columnCount, pondSize, totalFishCapacity, dbCapacity;
    String[] setcaress = {"Binhian", "Kawagan", "Palakihan"};
    String[] setfishTypess = {"Bangus", "Pla-Pla", "Apahap", "Talangka", "Alimango", "Sugpo", "Vannamei"};
    String setFishType, setCareType, setSectionNum, strSize;
    String section = "Section [";
    String details = "] details";
    AlertDialog.Builder builder1;
    String dbPondSection, dbPonSecNum, dbSize, dbCare, dbFishType;

    ArrayAdapter aaFtype, aaCare;
    Boolean isNewSection = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_edit_pond);
        bundle = getIntent().getExtras();
        mPondName = bundle.getString("pondName");
        mLayoutType = bundle.getString("pondLayout");
        dbHelper = new DBHelper(this);
        textFishPondName = findViewById(R.id.textFishPondName);
        textSectionDetailsHeader = findViewById(R.id.textSectionDetailsHeader);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonDelete = findViewById(R.id.buttonDelete);
        gridLayout = findViewById(R.id.pondLayout);
        textPondSize = findViewById(R.id.textPondSize);
        spinnerCare = findViewById(R.id.spinnerCare);
        spinnerFishType = findViewById(R.id.spinnerFishType);
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
        displayDataAll(mPondName);

        textFishPondName.setText(mPondName);

        aaCare = new ArrayAdapter(this, R.layout.spinnerlistyle, setcaress);
        aaCare.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCare.setAdapter(aaCare);

        aaFtype = new ArrayAdapter(this, R.layout.spinnerlistyle, setfishTypess);
        aaFtype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
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
                    setSectionNum = "1";
                    displayData(mPondName, "1");
                    Log.d(TAG, "onCreate: " + dbSize);
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }

                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });

        pond2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond2.isChecked()) {
                    setSectionNum = "2";
                    displayData(mPondName, "2");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }

                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });


        pond3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond3.isChecked()) {
                    setSectionNum = "3";
                    displayData(mPondName, "3");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });
        pond4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond4.isChecked()) {
                    setSectionNum = "4";
                    displayData(mPondName, "4");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });
        pond5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond5.isChecked()) {
                    setSectionNum = "5";
                    displayData(mPondName, "5");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });
        pond6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pond6.isChecked()) {
                    setSectionNum = "6";
                    displayData(mPondName, "6");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });
        pondA1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA1.isChecked()) {
                    setSectionNum = "1";
                    displayData(mPondName, "1");
                    Log.d(TAG, "onCreate: " + dbSize);
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }

                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });

        pondA2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA2.isChecked()) {
                    setSectionNum = "2";
                    displayData(mPondName, "2");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }

                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });


        pondA3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA3.isChecked()) {
                    setSectionNum = "3";
                    displayData(mPondName, "3");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });
        pondA4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA4.isChecked()) {
                    setSectionNum = "4";
                    displayData(mPondName, "4");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });
        pondA5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA5.isChecked()) {
                    setSectionNum = "5";
                    displayData(mPondName, "5");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
                }
            }
        });
        pondA6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pondA6.isChecked()) {
                    setSectionNum = "6";
                    displayData(mPondName, "6");
                    textSectionDetailsHeader.setText(section + setSectionNum + details);
                    if (dbSize == null) {
                        textPondSize.setText("0");
                    } else {
                        textPondSize.setText(String.valueOf(dbSize));
                    }
                    if (dbFishType == null && dbCare == null) {
                        spinnerFishType.setSelection(0);
                        spinnerCare.setSelection(0);
                    } else {
                        int spinnerPosition = aaFtype.getPosition(dbFishType);
                        spinnerFishType.setSelection(spinnerPosition);
                        int spinnerPosition2 = aaCare.getPosition(dbCare);
                        spinnerCare.setSelection(spinnerPosition2);
                    }
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
                if (isNewSection) {
                    newSection();
                } else {
                    editSection();
                }
            }
        });

        buttonDelete.setOnClickListener(view -> {
            if (setSectionNum != null) {
                if (!setSectionNum.equals("0")) {
                    deleteSection(mPondName, setSectionNum);
                } else {
                    Toast.makeText(ManagementEditPond.this, "Select Pond Section!!", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(ManagementEditPond.this, "Select Pond Section!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void editSection() {
        try {
            strSize = textPondSize.getText().toString();
            pondSize = Integer.parseInt(strSize);
            if (!setFishType.isEmpty() && !setCareType.isEmpty() && !setSectionNum.isEmpty() && pondSize != 0) {
                totalFishCapacity = getTotalFish(pondSize, setFishType, setCareType);
                Boolean checkInsertData = dbHelper.updateSectionDetails(mPondName + setSectionNum, pondSize, setCareType, setFishType, totalFishCapacity);
                if (checkInsertData == true) {
                    textPondSize.setText("");
                    setSectionNum = "";
                    spinnerFishType.setSelection(0);
                    spinnerCare.setSelection(0);
                    Toast.makeText(ManagementEditPond.this, "Pond section updated!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ManagementEditPond.this, "Unable to add Pond Section!", Toast.LENGTH_SHORT).show();
                }
            } else {
                textPondSize.setError("Insert a fishpond size!");
                Toast.makeText(ManagementEditPond.this, "Incomplete Fields!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(ManagementEditPond.this, "Error:" + e, Toast.LENGTH_SHORT).show();
        }
    }

    private void newSection() {
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
                    builder1 = new AlertDialog.Builder(ManagementEditPond.this);
                    builder1.setMessage(
                            "Fish pond size  :" + pondSize +
                                    "\n" + "Fish Care           :" + setCareType +
                                    "\n" + "Fish Type           :" + setFishType +
                                    "\n" + "Fish Capacity    :" + totalFishCapacity
                    ).setTitle(mPondName + "Fish pond section " + setSectionNum);
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Boolean checkInsertData = dbHelper.insertSectionDetails(mPondName + setSectionNum, mPondName, setSectionNum, pondSize, setCareType, setFishType, totalFishCapacity);
                                    if (checkInsertData == true) {
                                        Toast.makeText(ManagementEditPond.this, "Fish pond section " + setSectionNum + " added!", Toast.LENGTH_SHORT).show();
                                        textPondSize.setText("");
                                        setSectionNum = "";
                                        strSize = "";
                                        spinnerCare.setSelection(0);
                                        spinnerFishType.setSelection(0);
                                    } else {
                                        Toast.makeText(ManagementEditPond.this, "Fish Pond Section Exists!", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(ManagementEditPond.this, "Select Fish pond section!", Toast.LENGTH_SHORT).show();
                }
            } else {
                textPondSize.setError("Fish pond size is empty!");
            }
        } catch (Exception e) {
            Toast.makeText(ManagementEditPond.this, "Error : " + e, Toast.LENGTH_SHORT).show();
        }
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

    private void displayData(String pondName, String setSectionNum) {
        clearFields();
        Cursor cursor = dbHelper.getPonSectionDatabyID(pondName + setSectionNum);
        if (cursor.getCount() == 0) {
            isNewSection = true;
            buttonSubmit.setText("Submit");
            Toast.makeText(this, "No Entry Exists!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            isNewSection = false;
            buttonSubmit.setText("Update");
            while (cursor.moveToNext()) {
                dbPondSection = cursor.getString(0);
                dbPonSecNum = cursor.getString(1);
                dbSize = cursor.getString(2);
                dbCare = cursor.getString(3);
                dbFishType = cursor.getString(4);
                dbCapacity = cursor.getInt(5);
            }
        }
    }

    private void displayDataAll(String pondName) {
        Cursor cursor = dbHelper.getPonSectionDatabyPond(pondName);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Entry Exists!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                dbPonSecNum = cursor.getString(1);
                dbSize = cursor.getString(2);
                if (mLayoutType.equals("Layout 9") || mLayoutType.equals("Layout 10")) {
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

    private void deleteSection(String pondName, String setSectionNum) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(ManagementEditPond.this);
        builder1.setTitle("Delete record");
        builder1.setMessage("Are you sure to delete " + pondName + " Section [" + setSectionNum + "] ? ");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String name = String.valueOf(pondName);
                        Boolean checkDelete = dbHelper.deleteSectionDetails(name + setSectionNum);
                        if (checkDelete == true) {
                            Toast.makeText(ManagementEditPond.this, "Pond section " + name + " " + setSectionNum + " has been deleted!", Toast.LENGTH_SHORT).show();
                            removeCheck(setSectionNum);
                            clearFields();

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
    }

    private void removeCheck(String sectionNum) {
        switch (sectionNum) {
            case "1":
                pond1.setChecked(false);
                pondA1.setChecked(false);
                break;
            case "2":
                pond2.setChecked(false);
                pondA2.setChecked(false);
                break;
            case "3":
                pond3.setChecked(false);
                pondA3.setChecked(false);
                break;
            case "4":
                pond4.setChecked(false);
                pondA4.setChecked(false);
                break;
            case "5":
                pond5.setChecked(false);
                pondA5.setChecked(false);
                break;
            case "6":
                pond6.setChecked(false);
                pondA6.setChecked(false);
                break;
            default:
                break;
        }


    }

    private void clearFields() {
        textPondSize.setText("");
        spinnerCare.setSelection(0);
        spinnerFishType.setSelection(0);
        dbPondSection = "";
        dbPonSecNum = "";
        dbSize = "";
        dbCare = "";
        dbFishType = "";
        dbCapacity = 0;
    }

}