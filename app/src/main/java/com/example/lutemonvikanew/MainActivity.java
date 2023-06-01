package com.example.lutemonvikanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;
        LutemonStorage.getInstance().loadLutemons(context);

    }


    //TextView moreLutemons = findViewById(R.id.moreLutemons);


    public void switchToCreateNewLutemon(View view) {
        Intent intent = new Intent(this, CreateNewLutemon.class);
        startActivity(intent);
    }//switching to creating a new lutemon if the btnCreateLutemon is choosed.
    public void switchToListLutemonsActivity(View view) {

        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    } //Switching to the listing of the created lutemons, should update the xp:s when needed.
    public void switchToTrainLutemon(View view) {

        Intent intent = new Intent(this, TrainLutemonsActivity.class);
        startActivity(intent);
    } //Switching to lutemon training ground where the player can train lutemons and raise their xp:s
    public void switchToFigthLutemons(View view) { // Switching to the battleground, here the lutemons can have duels
        TextView moreLutemons = findViewById(R.id.moreLutemons);
        lutemons = LutemonStorage.getInstance().getLutemons();
        if (lutemons.size()>=2) { //checks is there enough lutemons to fight
            Intent intent = new Intent(this, FigthLutemonsActivity.class);
            startActivity(intent);
        }
       else {
            moreLutemons.setText("Luo vähintään 2 lutemonia ennen taistelua.");
        }
    }

}