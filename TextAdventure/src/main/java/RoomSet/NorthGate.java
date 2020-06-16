/**
 * Definizione della stanza di gioco
 */
package roomSet;

import base.Room;
import gameCore.Player;
import base.Stobj;

public class NorthGate extends Room {

    private boolean open = false;
    
    public NorthGate(){
        Stobj guard = new Stobj("Guardia", "Guardia del villaggio. Sorveglia il cancello principale.");
        guard.setAlias(new String[]{"soldato"});
        this.addObject(guard);
    }
    
    /**
     * Interazione di dialogo con la guardia. In caso di possesso di un oggetto Weapon nell'inventario del Player p, viene aperto il passaggio nord. In caso contrario viene negato l'accesso a nord
     * @param p
     * @param person 
     */
    @Override
    public void talkTo(Player p, Stobj person){
        if (person.getName().equals("Guardia")) {
            boolean a= false;
            boolean  c = false;
            for (Stobj inv : p.getInventory()) {
                if (inv.getName().equals("Spada") || inv.getName().equals("Coltello")) {
                    a = true;
                    if (inv.getName().equals("Coltello"))
                        c = true;
                    break;
                }
            }
            if (!this.open) {
                if (a) {
                    this.setMsg("La guardia ti consente di procedere.\n");
                    if (c)
                        this.setMsg(this.getMsg() + "Notando che porti con te solo un misero coltello, ti avvisa che potrebbe servire un'arma\nmigliore...");
                    this.setMsg(this.getMsg() + "\nIl cancello viene aperto. Buona fortuna!");
                    this.open = true;
                    this.setNorth(this.getNextNorth());
                    this.setDescription("Ti avvicini al cancello a nord del villaggio.\nDato che hai con te un'arma per difenderti, la guardia ti ha concesso di passare\naprendoti il cancello");
                } else {
                    this.setMsg("La guardia ti ferma e ti dice che per addentrarti nella foresta hai bisogno di\nun'arma per difenderti. Ti consiglia di andare dal fabbro del villaggio o almeno \ncercare qualcosa da usare a casa tua.");
                }
            } else if (a) {
                 this.setMsg("La guardia non ti risponde ma fa cenno con il capo in segno di saluto.");
            }
        }
    }
}
