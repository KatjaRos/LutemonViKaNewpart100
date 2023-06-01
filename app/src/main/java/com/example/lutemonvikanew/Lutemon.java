package com.example.lutemonvikanew;

import java.io.Serializable;
import java.util.ArrayList;

public class Lutemon implements Serializable {
    protected String name;
    protected String type;
    protected int health;
    protected int attack;
    protected int defense;
    protected int image;




    public Lutemon (String name, String type, int health, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }
    public Lutemon(String type, int health, int attack, int defense){
        this.type=type;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public void jump(){ //TrainLutemonActivity calls this to train jumping, which improves legstrength and so improves both: defence and attack
        this.attack += 1;
        this.defense += 1;
    }
    public void attackTraining(){
        this.attack += 2;
    } //TrainLutemon calls this to train attacking
    public void defenceTraining(){
        this.defense +=2;
    }//TrainLutemon calls this to train defence

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name){this.name = name;}


    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
