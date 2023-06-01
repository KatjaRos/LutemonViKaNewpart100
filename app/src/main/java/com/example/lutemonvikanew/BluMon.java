package com.example.lutemonvikanew;

public class BluMon extends Lutemon{
    // health 12, attack = 8, defense = 16
    public BluMon(String name){
        super(name, "BluMon", 12,8,16);{
            image = R.drawable.blumon;
        }
    }
    public BluMon(){
        super("BluMon", 12, 20,8);{
            image = R.drawable.blumon;
        }

    }
}
