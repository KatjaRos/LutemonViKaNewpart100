package com.example.lutemonvikanew;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TypeViewHolder extends RecyclerView.ViewHolder{
    TextView lut_type, attack_xp, defence_xp, health_xp;
    ImageView lut_image;
    public TypeViewHolder(@NonNull View itemView) {
        super(itemView);
        lut_type = itemView.findViewById(R.id.lut_type);
        attack_xp = itemView.findViewById(R.id.attack_xp);
        defence_xp = itemView.findViewById(R.id.defence_xp);
        health_xp = itemView.findViewById(R.id.health_xp);
        lut_image = itemView.findViewById(R.id.lut_image);
    }
}
