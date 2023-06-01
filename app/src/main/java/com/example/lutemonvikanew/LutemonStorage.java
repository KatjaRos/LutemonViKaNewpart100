package com.example.lutemonvikanew;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LutemonStorage {

    public ArrayList<Lutemon> lutemons = new ArrayList<>(); // list for created lutemons
    public ArrayList<Lutemon> types = new ArrayList<>(); // list for lutemon types for type_view


    private static LutemonStorage storage=null; //
    private LutemonStorage(){}

    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
    }
    public static LutemonStorage getInstance(){
        if(storage == null){
            storage = new LutemonStorage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getLutemons() {return lutemons;}

    public void listTheTypes(){
        if (types!=null){
            types.clear();
        }
        Lutemon type_mossMon = new MossMon();
        Lutemon type_bluMon = new BluMon();
        Lutemon type_rediMon = new RediMon();
        Lutemon type_oranMon = new OranMon();
        types.add(type_mossMon);
        types.add(type_bluMon);
        types.add(type_rediMon);
        types.add(type_oranMon);
    }
    public ArrayList<Lutemon> getTypes(){return types;}
    public void removeLutemon(Lutemon lutemon){
        int i = 0;
        for (Lutemon id : lutemons){
            if (id.equals(lutemon)){
                break;

            }
            i++;
        }
        lutemons.remove(i);
    }
    public void saveLutemons(Context context){ //saves lutemons to a file
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen epäonnistui");
        }
    }
    public void loadLutemons(Context context){ // retrieves lutemons from file
        try{
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
        } catch (IOException e) {
            System.out.println("Lutemonien lukeminen epäonnistui");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lukeminen2 epäonnistui");
            e.printStackTrace();
        }
    }

}


