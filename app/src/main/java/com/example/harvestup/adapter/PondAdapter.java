package com.example.harvestup.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.harvestup.PondItem;
import com.example.harvestup.R;

import java.util.ArrayList;

public class PondAdapter extends ArrayAdapter<PondItem> {
    public PondAdapter(Context context, ArrayList<PondItem> pondList) {
        super(context, 0, pondList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.pond_spinner_layout, parent, false
            );
        }
        ImageView imageViewPond = convertView.findViewById(R.id.image_view_pond);
        TextView textViewName = convertView.findViewById(R.id.text_view_name);
        PondItem pondItem = getItem(position);
        if (pondItem != null) {
            imageViewPond.setImageResource(pondItem.getiPondImage());
            textViewName.setText(pondItem.getiPondLayout());
        }

        return convertView;
    }
}
