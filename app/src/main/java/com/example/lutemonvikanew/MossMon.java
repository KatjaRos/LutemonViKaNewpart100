package com.example.lutemonvikanew;

public class MossMon extends Lutemon{


// lets give these : name from the user, type = MossMon, int health = 11 xp, attack xp =20,defense xp = 8, image = mossmon.png
   public MossMon(String name){
      super(name, "MossMon", 11, 20, 8);{
         image = R.drawable.mossmon;
      }

   }
   public MossMon(){
      super("MossMon", 11, 20,8);{
         image = R.drawable.mossmon;
      }

   }

}
