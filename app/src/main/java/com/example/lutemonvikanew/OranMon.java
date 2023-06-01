package com.example.lutemonvikanew;

public class OranMon extends Lutemon{

     // health 10, attack = 10, defense = 12
    public OranMon(String name){
        super(name, "OranMon", 10,10,12);{
            image = R.drawable.oranmon;
        }
    }

    public OranMon(){
        super("OranMon", 10, 10,12);{
            image = R.drawable.oranmon;
        }

    }
}
