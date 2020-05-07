package RoomSet;

import newpackage01.Player;
import ObjectSet.Stobj;

public class NorthGate extends Room{
    
    //TODO Va aggiustato
    
    public void talkToGuard(Player p){
        boolean a = false;
        boolean open = false;
        for (Stobj inv : p.getInventory()){
            if (inv.getName().equals("spada lunga") || inv.getName().equals("coltello")){
                a = true;
            }
        }
        if (a && !open){
            System.out.println("La guardia ti consente di procedere e ti augura buona fortuna. Il cancello viene aperto");
        } else if (!a && !open){
            System.out.println("La guardia ti ferma e ti dice che per addentrarti nella foresta hai bisogno di un'arma per difenderti."
                    + " Ti consiglia di andare dal fabbro del villaggio o almeno cercare qualcosa da usare a casa tua");
        } else if (a && open) {
            System.out.println("La guardia non ti risponde ma fa cenno con il capo in segno di saluto");
        }
    }
    
}
