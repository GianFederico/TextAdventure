package RoomSet;

import ObjectSet.Door;
import ObjectSet.Stobj;
import newpackage01.Player;

public class ShamanRoom extends RoomWDoor{

    public ShamanRoom(){
        Stobj door = new Door();
        door.setName("Porta");
        door.setDescription("Una semplice porta di legno. E' aperta");
        ((Door)door).setOpen(true);
        ((Door)door).setDirection("s");
        this.addObject(door);
    }

    public void gemInter(Player p){
        System.out.println("Appena avvicini la gemma alla fessura nel muro, viene attirata per poi incastrarsi perfettamente. Sul muro appaiono parole e glifi a te incomprensibili." +
                "\nI glifi si illuminano e il muro scompare assieme ad essi. Ora puoi proseguire verso nord");

        for (Stobj inv : p.getInventory()) {
            if (inv.getName().equals("gemma")) {
                p.removeFromInventory(inv);
            }
        }

        for (Stobj inv : this.getObjects()) {
            if (inv.getName().equals("fessura")) {
                this.getObjects().remove(inv);
            }
        }
        this.setNorth(this.getNextNorth());
    }
}

