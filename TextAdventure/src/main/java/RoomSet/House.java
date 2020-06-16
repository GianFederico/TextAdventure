/**
 * Definizione della casa come partenza e fine del gioco
 */
package roomSet;

import objectSet.Door;
import base.Stobj;
import objectSet.Weapon;
import gameCore.Player;

public class House extends RoomWDoor{
    

    public House(){
        Weapon knife = new Weapon();
        Stobj obj = new Stobj();
        Door door = new Door();
        Stobj mom = new Stobj("Mamma", "Tua madre. Giace nel letto");

        knife.setName("Coltello");
        knife.setAlias(new String[]{"arma", "lama"});
        knife.setDescription("Un semplice coltello. Potresti usarlo come arma, anche se potrebbe non essere troppo\nefficace");
        knife.setDamage(3);
        knife.setPickupable(true);
        this.addObject(knife);

        obj.setName("Ciondolo");
        obj.setDescription("Il ciondolo di tua madre. Risplende alla luce con la sua pietra preziosa.\nPensi possa valere qualcosa e che potrebbe tornarti utile");
        obj.setPickupable(true);
        this.addObject(obj);

        door.setName("Porta");
        door.setDescription("Porta di legno. Si affaccia proprio sulla piazza centrale del villaggio. \nSaperlo ti fa sentire importante. \nE' chiusa");
        door.setDirection("n");
        door.setOpen(false);
        this.addObject(door);

        this.addObject(mom);

        this.setMoney(2);
    }

    /**
     * Interazione di dalogo con la mamma. Interazione aggiuntiva e finale in caso di possesso dello Stobj con nome "Pozione Millecure"
     * @param p
     * @param person 
     */
    @Override
    public void talkTo(Player p, Stobj person){
        if (person.getName().equals("Mamma")){
            int pm = -1;
            for (int i = 0; i<p.getInventory().size(); i++)
                    if (p.getInventory().get(i).getName().equals("Pozione Millecure")) {
                        pm = i;
                    }
            if (pm > -1){
                p.removeFromInventory(pm);
               this.setMsg ("FINE");
            } else {
                this.setMsg("Tua madre è a letto, non riesci a parlarle e senti solo i suoi lamenti\nForse dovresti lasciarla riposare...");
            }
        }
    }
    
    /**
     * Interazione di cessione dello Stobj con nome "Pozione Millecure". In caso la pozione, indicata da obj, fosse presente nella lista Inventory del Player p, trigger dell dialogo finale del gioco
     * @param p
     * @param obj 
     */
    @Override
    public void give(Player p, Stobj obj){
        if (obj.getName().equals("Pozione") || obj.getName().equals("Pozione Millecure")){
        int pm = -1;
            for (int i = 0; i<p.getInventory().size(); i++)
                    if (p.getInventory().get(i).getName().equals("Pozione Millecure"))
                        pm = i;
            if (pm > -1){
                p.removeFromInventory(pm);
               this.setMsg ("FINE");
            } else {
                for (int i = 0; i<p.getInventory().size(); i++)
                    if (p.getInventory().get(i).getName().equals("Pozione"))
                        pm = i;
                 if (pm > -1)
                     this.setMsg("Nessun'altra pozione se non quella dello sciamano può curarla,\nnon ha senso consumarne inutilmente");
                 
            }
        } else {
             this.setMsg("Non succede niente");
        }
    }
}
