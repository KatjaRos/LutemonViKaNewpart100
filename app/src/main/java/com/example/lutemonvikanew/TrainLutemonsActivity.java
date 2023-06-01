package com.example.lutemonvikanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainLutemonsActivity extends AppCompatActivity {

    private Context context;

    // in this activity Lutemons that the user has created can be trained
    // there are three possibilities for the training:
    // jumpTraining gives the lutemon +1 defense AND attack xp
    // attack training gives +2 attack xp
    // defence training gives +2 defence xp
    // the training also is shown as a textView in the activity view.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_lutemons);
        makeRadioButtons();
    }

    public void makeRadioButtons(){ // creates radiobuttons for lutemons so that the
        RadioGroup whichLutemon = findViewById(R.id.whichLutemon); //user can choose which Lutemon will be training
        ArrayList<Lutemon> lutemons = LutemonStorage.getInstance().getLutemons();
        RadioButton rb;
        int i = 0;
        for (Lutemon l : lutemons){
            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i++);
            whichLutemon.addView(rb);
        }

    }

    public void jumpTraining(View view){ // connects to the traininground Jump training
        RadioGroup whichLutemon = findViewById(R.id.whichLutemon);
        TextView showJump = findViewById(R.id.showJump);
        Lutemon lutemonToJump = LutemonStorage.getInstance().getLutemons().get(whichLutemon.getCheckedRadioButtonId());
        lutemonToJump.jump();
        showJump.setText(lutemonToJump.getName() +" hyppäsi!");
    }

    public void attackTraining(View view){
        RadioGroup whichLutemon = findViewById(R.id.whichLutemon);
        TextView showAttack = findViewById(R.id.showAttack);
        Lutemon lutemonToAttack = LutemonStorage.getInstance().getLutemons().get(whichLutemon.getCheckedRadioButtonId());
        lutemonToAttack.attackTraining();
        showAttack.setText(lutemonToAttack.getName() +" hyökkäsi hienosti!");

    }
    public void defenceTraining(View view){
        RadioGroup whichLutemon = findViewById(R.id.whichLutemon);
        TextView showDefence = findViewById(R.id.showDefence);
        Lutemon lutemonToAttack = LutemonStorage.getInstance().getLutemons().get(whichLutemon.getCheckedRadioButtonId());
        lutemonToAttack.defenceTraining();
        showDefence.setText(lutemonToAttack.getName() +" treenasi suojatumista!");

    }
    public void stopTraining(View view){
        context = this;
        LutemonStorage.getInstance().saveLutemons(context);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}