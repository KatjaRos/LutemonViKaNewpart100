package com.example.lutemonvikanew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonViewAdapter extends RecyclerView.Adapter<LutemonViewHolder>{
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();


    public LutemonViewAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;

    }
    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view,parent,false ));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lut_name.setText(lutemons.get(position).getName());
        holder.lut_type.setText(lutemons.get(position).getType());
        holder.attack.setText(String.valueOf("Attack " + lutemons.get(position).getAttack()) + "xp");
        holder.defence.setText(String.valueOf("Defence " + lutemons.get(position).getDefense())+"xp");
        holder.health.setText(String.valueOf("Health " + lutemons.get(position).getHealth())+"xp");
        holder.lutemon_image.setImageResource(lutemons.get(position).getImage());

        holder.delete.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            LutemonStorage.getInstance().removeLutemon(lutemons.get(pos));
            LutemonStorage.getInstance().saveLutemons(context);
            notifyItemRemoved(pos);


        });


        holder.editPen.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();

            if (holder.editText.getVisibility() == View.VISIBLE){
                Lutemon lutemon = LutemonStorage.getInstance().getLutemons().get(pos);
                lutemon.setName(holder.editText.getText().toString());
                holder.editText.setVisibility(View.GONE);
                LutemonStorage.getInstance().saveLutemons(context);
                notifyDataSetChanged();
            }

            else{
                holder.editText.setVisibility(View.VISIBLE);
            }});

    }



    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}


