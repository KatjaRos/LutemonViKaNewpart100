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

public class FigthLutemonsActivity extends AppCompatActivity {

    private Context context;
    private LutemonStorage storage;
    public ArrayList<Lutemon> figthers = new ArrayList<>();
    String fight =""; // empty String for the fighting outputs
    int health2, newAttack;
    // This is the battleground for the lutemons. If lutemons health xp goes to 0, the lutemon dies and is deleted.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figth_lutemons);
        storage = LutemonStorage.getInstance();
        makeRadioButtons1(); makeRadioButtons2();
        context = this;
    }
    public void makeRadioButtons1(){ //creates radiobuttons of the created lutemons so that the user
        RadioGroup lutemonToFigth1 = findViewById(R.id.lutemonToFigth1);  //can choose the first lutemon to fight
        ArrayList<Lutemon> lutemons = LutemonStorage.getInstance().getLutemons();
        RadioButton rb;
        int i = 0;
        for (Lutemon l : lutemons){
            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i++);
            lutemonToFigth1.addView(rb);
        }

    }
    public void makeRadioButtons2(){
        RadioGroup lutemonToFigth2 = findViewById(R.id.lutemonToFigth2);
        ArrayList<Lutemon> lutemons = LutemonStorage.getInstance().getLutemons();
        RadioButton rb;
        int i = 0;
        for (Lutemon l : lutemons){
            rb = new RadioButton(this);
            rb.setText(l.getName());
            rb.setId(i++);
            lutemonToFigth2.addView(rb);
        }

    }
    public void addFigther1 (View view){
        if (figthers != null){
            figthers.clear();
        }
        RadioGroup lutemon1 = findViewById(R.id.lutemonToFigth1);
        Lutemon lutemonToFigth1 = LutemonStorage.getInstance().getLutemons().get(lutemon1.getCheckedRadioButtonId());
        figthers.add(lutemonToFigth1);

    }

    public void addFigther2 (View view){
        RadioGroup lutemon2 = findViewById(R.id.lutemonToFigth2);
        Lutemon lutemonToFigth2 = LutemonStorage.getInstance().getLutemons().get(lutemon2.getCheckedRadioButtonId());
        figthers.add(lutemonToFigth2);
    }

    public void startTheFigth (View view) {
        ArrayList<Lutemon> lutemons = LutemonStorage.getInstance().getLutemons();
        TextView showTheFigth = findViewById(R.id.showTheFigth);
        fight += "Aloitetaan taistelu\n";
        showTheFigth.setText(fight);
        int damage1, health1, attackDam;

        while(figthers.get(0).getHealth()>0 && figthers.get(1).getHealth()>0) {

            if (figthers.get(0).getAttack() > figthers.get(1).getAttack()) {  //if the figther ones attack x is bigger than fighter twos,
                fight += figthers.get(0).getName() + " hyökkää\n";
                showTheFigth.setText(fight); // figther one attacks first
                if (figthers.get(0).getAttack() >= figthers.get(1).getDefense()) {  // and if the figther ones attack xp is greater than the figther twos defence
                    damage1 = figthers.get(0).getAttack() - figthers.get(1).getDefense(); // then the figther two receives damage
                    health1 = figthers.get(1).getHealth() - damage1; // health1 gives the amount how much damage the health xp gets
                    figthers.get(1).setHealth(health1); // set's the new health for fighter two
                    fight += figthers.get(1).getName() + " menetti " + damage1 + " verran health xp:tä\n";
                    showTheFigth.setText(fight);


                } else if (figthers.get(0).getAttack() < figthers.get(1).getDefense()) { // but if the attack xp of fighter one is smaller
                      // than the figther twos defence, then fighter two can repell the attack
                    damage1 = 2; //while still losing a little healht, but the attacker also loses  two attack xp
                    attackDam = figthers.get(0).getAttack() - damage1;
                    health1 = figthers.get(1).getHealth() - damage1;
                    figthers.get(0).setAttack(attackDam);
                    figthers.get(1).setHealth(health1);
                    fight+= figthers.get(1).getName() + " torjui hyökkäyksen(-2health xp)\n" + figthers.get(0).getName() + " menettää 2 attack xp:tä\n";
                    showTheFigth.setText(fight);

                }


            } else if (figthers.get(0).getAttack() <= figthers.get(1).getAttack()){ //and if the figther twos attack is bigger
                fight += figthers.get(1).getName() + " hyökkää\n"; //figther two starts the attack, and so on
                showTheFigth.setText(fight);
                if (figthers.get(1).getAttack() >= figthers.get(0).getDefense()) {
                    damage1 = figthers.get(1).getAttack() - figthers.get(0).getDefense();
                    health1 = figthers.get(0).getHealth() - damage1;
                    figthers.get(0).setHealth(health1);
                    fight = figthers.get(0).getName() + " menetti " + damage1 + " verran health xp:tä\n";
                    showTheFigth.setText(fight);


                } else if (figthers.get(1).getAttack() < figthers.get(0).getDefense()) {
                    damage1 = 2;
                    attackDam = figthers.get(1).getAttack() - damage1;
                    health1 = figthers.get(0).getHealth() - damage1;
                    figthers.get(1).setAttack(attackDam);
                    figthers.get(0).setHealth(health1);
                    fight += figthers.get(0).getName() + " torjui hyökkäyksen(-2health xp)\n" + figthers.get(1).getName() + " menettää 2 attack xp:tä\n";
                    showTheFigth.setText(fight);
                }
            }
        } // fight is over and then it is time to check who dies
        if (figthers.get(0).getHealth()<=0 && figthers.get(1).getHealth()>0){
            fight += figthers.get(1).getName() + " voittaa taistelun.\n";
            showTheFigth.setText(fight);
            storage.removeLutemon(figthers.get(0));
            LutemonStorage.getInstance().saveLutemons(context);
            newAttack = figthers.get(1).getAttack();
            health2 = figthers.get(1).getHealth();
            int i = 0;
            for (Lutemon id:lutemons){
                if (id.equals(figthers.get(1))){
                break;
                }i++;

            }
            Lutemon lutemon = LutemonStorage.getInstance().getLutemons().get(i);
            lutemon.setAttack(newAttack);
            lutemon.setHealth(health2);
        }else if (figthers.get(1).getHealth()<=0 && figthers.get(0).getHealth()>0){
            fight += figthers.get(0).getName() + " voittaa taistelun.\n";
            showTheFigth.setText(fight);
            storage.removeLutemon(figthers.get(1));
            LutemonStorage.getInstance().saveLutemons(context);
            newAttack = figthers.get(0).getAttack();
            health2 = figthers.get(0).getHealth();
            int i = 0;
            for (Lutemon id:lutemons){
                if (id.equals(figthers.get(0))){
                    break;
                }i++;
            }
            Lutemon lutemon = LutemonStorage.getInstance().getLutemons().get(i);
            lutemon.setAttack(newAttack);
            lutemon.setHealth(health2);
        }else{
            fight += "Molemmat kuolivat.";
            showTheFigth.setText(fight);
            storage.removeLutemon(figthers.get(1));
            storage.removeLutemon(figthers.get(0));
            LutemonStorage.getInstance().saveLutemons(context);
        }
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent); //after the fight is finished the user is returned to main activity

    }
}
