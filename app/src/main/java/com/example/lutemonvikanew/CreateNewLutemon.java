package com.example.lutemonvikanew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class CreateNewLutemon extends AppCompatActivity {
    private Context context;
    private LutemonStorage storage;
    private RecyclerView lutemonTypes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_lutemon);
        context = this;
        storage = LutemonStorage.getInstance();
        storage.listTheTypes();
        lutemonTypes = findViewById(R.id.lutemonTypes);
        lutemonTypes.setLayoutManager(new LinearLayoutManager(this));
        lutemonTypes.setAdapter(new TypeViewAdapter(getApplicationContext(), storage.getTypes()));

    }


    public void addLutemon(View view){

        RadioGroup lut_type = findViewById(R.id.lutemon_type);
        EditText nameLutemon = findViewById(R.id.lutemonName);
        String name = nameLutemon.getText().toString();


        switch (lut_type.getCheckedRadioButtonId()) {
            case R.id.btnMossMon:
                LutemonStorage.getInstance().addLutemon(new MossMon(name));
                break;
            case R.id.btnBluMon:
                LutemonStorage.getInstance().addLutemon(new BluMon(name));
                break;
            case R.id.btnRediMon:
                LutemonStorage.getInstance().addLutemon(new RediMon(name));
                break;
            case R.id.btnOranMon:
                LutemonStorage.getInstance().addLutemon(new OranMon(name));
                break;
        }
        LutemonStorage.getInstance().saveLutemons(context);


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}