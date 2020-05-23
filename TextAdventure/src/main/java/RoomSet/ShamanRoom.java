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
        Stobj obj = new Stobj();
        obj.setName("Fessura");
        obj.setDescription("Un buco nel muro");
    }

    public void gemInter(Player p){
        boolean g = false;
        int k = -1;
        for (int i =0; i<p.getInventory().size(); i++){
            if (p.getInventory().get(i).getName().equals("gemma")) {
                 g = true;
                 k = i;
            }
        }
        if (g){
              this.setMsg("Appena avvicini la gemma alla fessura nel muro, viene attirata per poi incastrarsi perfettamente. Sul muro appaiono parole e glifi a te incomprensibili." +
                "\nI glifi si illuminano e il muro scompare assieme ad essi. Ora puoi proseguire verso nord");
             p.removeFromInventory(k);
              for (Stobj obj : this.getObjects()) {
            if (obj.getName().equals("Fessura")) {
                this.getObjects().remove(obj);
            }
        }
        this.setNorth(this.getNextNorth());
        } else {
            //messaggio
        }
        }
}

