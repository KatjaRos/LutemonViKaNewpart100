package com.example.lutemonvikanew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TypeViewAdapter extends RecyclerView.Adapter<TypeViewHolder>{

    private Context context;
    private ArrayList<Lutemon>types = new ArrayList<>();
    public TypeViewAdapter(Context context, ArrayList<Lutemon> types){
        this.context = context;
        this.types = types;
    }
    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TypeViewHolder(LayoutInflater.from(context).inflate(R.layout.type_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        holder.lut_type.setText(types.get(position).getType());
        holder.attack_xp.setText(String.valueOf(types.get(position).getAttack())+"xp");
        holder.defence_xp.setText(String.valueOf(types.get(position).getDefense())+"xp");
        holder.health_xp.setText(String.valueOf(types.get(position).getHealth())+"xp");
        holder.lut_image.setImageResource(types.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
