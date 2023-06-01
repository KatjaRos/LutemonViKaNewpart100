package com.example.lutemonvikanew;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder{
    TextView lut_name, lut_type, attack, defence, health, editText;
    ImageView lutemon_image, delete, editPen;
    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lut_name = itemView.findViewById(R.id.lut_name);
        lut_type = itemView.findViewById(R.id.type_lut);
        attack = itemView.findViewById(R.id.xp_attack);
        defence = itemView.findViewById(R.id.xp_defence);
        health = itemView.findViewById(R.id.health);
        lutemon_image = itemView.findViewById(R.id.lutemon_image);
        delete = itemView.findViewById(R.id.delete);
        editText = itemView.findViewById(R.id.textEdit);
        editPen = itemView.findViewById(R.id.penEdit);
    }
}
