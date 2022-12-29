package com.example.harvestup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvestup.R;
import com.example.harvestup.database.DBHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {

    private Context context;
    private ArrayList pondSection, sectionNum, size, capacity, fishType, careType;
    private DBHelper dbHelper;

    public SectionAdapter(Context context, ArrayList pondSection, ArrayList sectionNum, ArrayList size, ArrayList capacity, ArrayList fishType, ArrayList careType) {
        this.context = context;
        this.pondSection = pondSection;
        this.sectionNum = sectionNum;
        this.size = size;
        this.capacity = capacity;
        this.fishType = fishType;
        this.careType = careType;
    }

    @NonNull
    @Override
    public SectionAdapter.SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.section_details, parent, false);
        return new SectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionAdapter.SectionViewHolder holder, int position) {
        holder.textPondSection.setText(String.valueOf(sectionNum.get(position)));
        holder.textSize.setText(String.valueOf(size.get(position)));
        holder.textCapacity.setText(String.valueOf(capacity.get(position)));
        holder.textFish.setText(String.valueOf(fishType.get(position)));
        holder.textCare.setText(String.valueOf(careType.get(position)));
    }

    @Override
    public int getItemCount() {
        return pondSection.size();
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder {
        TextView textPondSection, textSize, textCapacity, textFish, textCare;
        CardView cvProfile;

        public SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            cvProfile = itemView.findViewById(R.id.cvProfile);
            textPondSection = itemView.findViewById(R.id.textPondSection);
            textSize = itemView.findViewById(R.id.textSize);
            textCapacity = itemView.findViewById(R.id.textCapacity);
            textFish = itemView.findViewById(R.id.textFish);
            textCare = itemView.findViewById(R.id.textCare);
        }
    }
}
