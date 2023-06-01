package com.example.lutemonvikanew;

public class RediMon extends Lutemon{
    // health 13, attack = 13, defense = 11
    public RediMon(String name){
        super(name, "RediMon", 13,13,11);{
            image = R.drawable.redimon;
        }
    }
    public RediMon(){
        super("RediMon", 13, 13,11);{
            image = R.drawable.redimon;
        }

    }
}
