package com.example.lutemonvikanew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListLutemonsActivity extends AppCompatActivity {

    private LutemonStorage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);
        storage = LutemonStorage.getInstance();
        recyclerView = findViewById(R.id.listOfLutemons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonViewAdapter(getApplicationContext(), storage.getLutemons()));
}}