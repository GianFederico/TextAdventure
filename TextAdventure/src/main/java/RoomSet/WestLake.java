package RoomSet;

import ObjectSet.Stobj;
import ObjectSet.Weapon;
import newpackage01.Player;

public class WestLake extends Room{
    
   private boolean nym = true;
    
   public WestLake(){
       Stobj nymph = new Stobj("Ninfa", "La ninfa del lago"); //TODO migliorare descrizione e aggiungere aka
       this.addObject(nymph);
   }

   @Override
   public void talkTo(Player p, Stobj person){
       if (person.getName().equals("ninfa")) {
           if (this.nym) {
               int i = 0;
               int k = 0;
               Stobj adv = new Stobj("Consiglio", "Un pezzo di carta sul quale hai appuntato il consiglio della ninfa del lago. Dice di tirare la leva destra");
               adv.setAka(new String[]{"appunto"});
               for (Stobj inv : p.getInventory()) {
                   if (inv.getName().equals("spada") || inv.getName().equals("coltello")) {
                       k = i;
                   }
                   i++;
               }
               ((Weapon) p.getInventory().get(k)).setDamage(((Weapon) p.getInventory().get(k)).getDamage() + 5);
               System.out.println("Il consiglio della ninfa è stato aggiunto all'inventario");
               p.addToInventory(adv);
               System.out.println("La ninfa ti ringrazia un'ultima volta prima di sparire davanti ai tuoi occhi");
               this.nym = false;
               this.getObjects().get(0).setDescription(this.getObjects().get(0).getDescription() + "Purtroppo è svanita e non è più qui");
           } else {
               System.out.println("La ninfa non è più qui e non vedi tracce per capire dove sia andata o seguirla...");
           }
       }
   }
}
