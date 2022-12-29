package com.example.harvestup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class foodFeeds extends AppCompatActivity {
    CheckBox aSwitch;
    TextView textLang, textDesc;
    ImageSlider imageSlider;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_feeds);
        aSwitch = findViewById(R.id.langSwitch);
        textDesc = findViewById(R.id.textDesc);
        button = findViewById(R.id.playButton);
        imageSlider = (ImageSlider) findViewById(R.id.imageSlider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.feeds, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.feeds2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.feed3, ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (aSwitch.isChecked()) {
                    aSwitch.setText(R.string.langFIL);
                    aSwitch.setTextColor(getResources().getColorStateList(R.color.white));
                    textDesc.setText(R.string.descFeedsTag);
                } else {
                    aSwitch.setText(R.string.langEN);
                    aSwitch.setTextColor(getResources().getColorStateList(R.color.black));
                    textDesc.setText(R.string.descFeedsEng);
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(foodFeeds.this, watchFeed.class);
                foodFeeds.this.startActivity(myIntent);
            }
        });
    }
}