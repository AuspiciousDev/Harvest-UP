package com.example.harvestup.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvestup.ManagementCreatePondSection;
import com.example.harvestup.ManagementEditPond;
import com.example.harvestup.ManagementMenu;
import com.example.harvestup.ManagementViewPond;
import com.example.harvestup.PondItem;
import com.example.harvestup.R;
import com.example.harvestup.database.DBHelper;

import java.util.ArrayList;

public class PondDBAdapter extends RecyclerView.Adapter<PondDBAdapter.PondDBViewHolder> {

    private Context context;
    private ArrayList pondName, pondLayout, pondDate;
    private DBHelper dbHelper;

    public PondDBAdapter(Context context, ArrayList pondName, ArrayList pondLayout, ArrayList pondDate) {
        this.context = context;
        this.pondName = pondName;
        this.pondLayout = pondLayout;
        this.pondDate = pondDate;
    }

    @NonNull
    @Override
    public PondDBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pondentry, parent, false);
        return new PondDBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PondDBViewHolder holder, int position) {
        holder.pondName.setText(String.valueOf(pondName.get(position)));
        holder.pondLayout.setText(String.valueOf(pondLayout.get(position)));
        holder.pondDate.setText(String.valueOf(pondDate.get(position)));

        if (String.valueOf(pondLayout.get(position)).equals("Layout 1")) holder.imgLayout.setImageResource(R.drawable.pondwhole);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 2")) holder.imgLayout.setImageResource(R.drawable.pondhalf1);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 3")) holder.imgLayout.setImageResource(R.drawable.pondthird);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 4")) holder.imgLayout.setImageResource(R.drawable.pondhalf);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 5")) holder.imgLayout.setImageResource(R.drawable.pondquad);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 6")) holder.imgLayout.setImageResource(R.drawable.pondsix);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 7")) holder.imgLayout.setImageResource(R.drawable.pond4hor);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 8")) holder.imgLayout.setImageResource(R.drawable.pond5hor);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 9")) holder.imgLayout.setImageResource(R.drawable.esp_a);
        if (String.valueOf(pondLayout.get(position)).equals("Layout 10")) holder.imgLayout.setImageResource(R.drawable.esp_b);

        dbHelper = new DBHelper(context);

        holder.img_menu.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.img_menu);
            popupMenu.getMenuInflater().inflate(R.menu.record_options, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getTitle().equals("Edit")) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setTitle("Edit record");
                        builder1.setMessage("Are you sure to edit " + pondName.get(position) + "?");
                        builder1.setCancelable(true);
                        builder1.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(context, ManagementEditPond.class);
                                        intent.putExtra("pondName", String.valueOf(pondName.get(position)));
                                        intent.putExtra("pondLayout", String.valueOf(pondLayout.get(position)));
                                        context.startActivity(intent);
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
                    if (item.getTitle().equals("Delete")) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setTitle("Delete record");
                        builder1.setMessage("Are you sure to delete " + pondName.get(position) + " ? ");
                        builder1.setCancelable(true);
                        builder1.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String name = String.valueOf(pondName.get(position));
                                        Boolean checkDelete = dbHelper.deletePondDetails(name);
                                        if (checkDelete == true) {
                                            Toast.makeText(context, "Pond has been deleted!", Toast.LENGTH_SHORT).show();
                                            pondName.remove(position);
                                            notifyItemRemoved(position);
                                            notifyItemRangeChanged(position, pondName.size());
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
                    return true;
                }
            });
            popupMenu.show();
        });

        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ManagementViewPond.class);
            intent.putExtra("pondName", String.valueOf(pondName.get(position)));
            intent.putExtra("pondLayout", String.valueOf(pondLayout.get(position)));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pondName.size();
    }

    public class PondDBViewHolder extends RecyclerView.ViewHolder {
        TextView pondName, pondLayout, pondDate;
        ImageView img_menu, imgLayout;
        CardView cardView;

        public PondDBViewHolder(@NonNull View itemView) {
            super(itemView);
            pondName = itemView.findViewById(R.id.textName);
            pondLayout = itemView.findViewById(R.id.textLayout);
            pondDate = itemView.findViewById(R.id.textDate);
            img_menu = itemView.findViewById(R.id.img_menu);
            imgLayout = itemView.findViewById(R.id.imgLayout);
            cardView = itemView.findViewById(R.id.cvProfile);

        }
    }
}
