package RoomSet;

import ObjectSet.Stobj;
import ObjectSet.Weapon;
import newpackage01.Player;

public class WestLake extends Room{
    
   public WestLake(){}
   
   public void talkToNimph(Player p){
       int i=0;
       int k=0;
       Stobj adv = new Stobj("consiglio", "Un pezzo di carta sul quale hai appuntato il consiglio della ninfa del lago. Dice di tirare la leva destra");
       adv.setAka(new String[]{"appunto"});
       adv.setPickupable(true);
       adv.setUsable(true);
       for (Stobj inv : p.getInventory()){
           if (inv.getName().equals("spada lunga") || inv.getName().equals("coltello")){
                k=i;
            }
           i++;
       }
       ((Weapon) p.getInventory().get(k)).setDamage(((Weapon) p.getInventory().get(k)).getDamage()+5);
       p.addToInventory(adv);
   }
}
