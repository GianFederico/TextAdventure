package RoomSet;

import newpackage01.Player;
import ObjectSet.Stobj;

public class NorthGate extends Room{
    
    public NorthGate(){
        Stobj guard = new Stobj("Guardia", "Guardia del villaggio. Sorveglia il cancello principale"); //TODO aggiungere aka
        this.addObject(guard);
    }
    
    //TODO Va aggiustato
    @Override
    public void talkTo(Player p, Stobj person){
        if (person.getName().equals("guardia")) {
            boolean a = false;
            boolean open = false;
            for (Stobj inv : p.getInventory()) {
                if (inv.getName().equals("spada lunga") || inv.getName().equals("coltello")) {
                    a = true;
                }
            }
            if (a && !open) {
                 this.setMsg("La guardia ti consente di procedere e ti augura buona fortuna. Il cancello viene aperto");
                open = true;
                this.setNorth(this.getNextNorth());
            } else if (!a && !open) {
                 this.setMsg("La guardia ti ferma e ti dice che per addentrarti nella foresta hai bisogno di un'arma per difenderti."
                        + " Ti consiglia di andare dal fabbro del villaggio o almeno cercare qualcosa da usare a casa tua");
            } else if (a && open) {
                 this.setMsg("La guardia non ti risponde ma fa cenno con il capo in segno di saluto");
            }
        }
    }
    
}
