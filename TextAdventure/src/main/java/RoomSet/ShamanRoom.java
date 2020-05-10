package RoomSet;

import ObjectSet.Door;
import ObjectSet.Stobj;

public class ShamanRoom extends RoomWDoor{

    public ShamanRoom(){
        Stobj door = new Door();
        door.setName("porta di legno");
        door.setDescription("Una semplice porta di legno. E' aperta");
        ((Door)door).setOpen(true);
        ((Door)door).setDirection("s");
        this.addObject(door);
    }

    public void gemInter(){
        System.out.println("Appena avvicini la gemma alla fessura nel muro, viene attirata per poi incastrarsi perfettamente. Sul muro appaiono parole e glifi a te incomprensibili." +
                "\nI glifi si illuminano e il muro scompare assieme ad essi. Ora puoi proseguire verso nord");
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("fessura")) {
                this.getObjects().remove(i);
            }
        }
        this.setNorth(this.getNextNorth());
    }

}
