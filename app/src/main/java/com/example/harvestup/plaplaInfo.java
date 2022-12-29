package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class plaplaInfo extends AppCompatActivity {
    CheckBox aSwitch;
    TextView textLang, textDesc;
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plapla_info);
        aSwitch = findViewById(R.id.langSwitch);
        textDesc = findViewById(R.id.textDesc);
        imageSlider = (ImageSlider) findViewById(R.id.imageSlider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.tilapia, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.plapla2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.plapla3, ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (aSwitch.isChecked()) {
                    aSwitch.setText(R.string.langFIL);
                    aSwitch.setTextColor(getResources().getColorStateList(R.color.white));
                    textDesc.setText(R.string.descPlaPlaTag);
                } else {
                    aSwitch.setText(R.string.langEN);
                    aSwitch.setTextColor(getResources().getColorStateList(R.color.black));
                    textDesc.setText(R.string.descPlaPlaEng);
                }
            }
        });
    }
}