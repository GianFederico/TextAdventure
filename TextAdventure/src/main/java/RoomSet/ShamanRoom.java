/**
 * Definizione della stanza di gioco
 */
package roomSet;

import objectSet.Door;
import base.Stobj;
import gameCore.Player;

public class ShamanRoom extends RoomWDoor{
    
    public ShamanRoom(){
        Door door = new Door();
        door.setName("Porta");
        door.setDescription("Una semplice porta di legno. E' aperta.");
        door.setOpen(true);
        door.setDirection("s");
        this.addObject(door);
        Stobj obj = new Stobj();
        obj.setName("Fessura");
        obj.setAlias(new String[]{"buco"});
        obj.setDescription("Un buco nel muro. Sembra avere la forma di una pietra preziosa.");
        this.addObject(obj);
        obj = new Stobj();
        obj.setName("Figura incappucciata");
        obj.setAlias(new String[]{"figura"});
        obj.setDescription("E' solo lo scheletro dello sciamano, ormai morto da molto tempo...");
        this.addObject(obj);
    }

    /**
     * Interazione per l'inserimento dello Stobj con nome "Gemma" se presente nella lista Inventory del Player p. Al momento dell'inserimento, viene aperto un passaggio
     * @param p 
     */
    @Override
    public void insert(Player p){
        boolean g = false;
        int k = -1;
        for (int i =0; i<p.getInventory().size(); i++){
            if (p.getInventory().get(i).getName().equals("Gemma")) {
                 g = true;
                 k = i;
            }
        }
        if (g){
              this.setMsg("Appena avvicini la gemma alla fessura nel muro, viene attirata per poi \nincastrarsi perfettamente. Sul muro appaiono parole e glifi a te incomprensibili." +
                "\nI glifi si illuminano e il muro scompare assieme ad essi. Ora puoi proseguire verso nord");
             p.removeFromInventory(k);
            this.getObjects().removeIf(obj -> obj.getName().equals("Fessura"));
            this.setNorth(this.getNextNorth());
        } else {
            this.setMsg("Non hai nulla da inserire ne nulla in cui inserire :(");
        }
        }
}

