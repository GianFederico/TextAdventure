package RoomSet;

import newpackage01.Player;
import newpackage03.SuperMonster;
import newpackage03.Monster_Hobgoblin;
import ObjectSet.Stobj;
import ObjectSet.Door;


public class MountFork extends RoomWDoor{
    
    private SuperMonster hob = new Monster_Hobgoblin();
    
    public MountFork(){
        this.setMonster(hob);
        Stobj obj = new Stobj();
        Stobj door = new Door();
        obj.setName("Muro con enigma");
        obj.setAka(new String[]{"muro","enigma","indovinello"});
        obj.setDescription("Il muro ha una scritta che recita:\"Non è un'isola, ma è sempre in mezzo all'acqua\". Sembra che voglia una risposta per aprirsi");
        //obj.setPushable(true);
        this.addObject(obj);
        door.setName("porta di legno");
        door.setDescription("Porta di legno. E' chiusa");
        ((Door)door).setOpen(false);
        ((Door)door).setDirection("e");
        this.addObject(door);
    }
    
    public void fightSequence(Player p){
        int d = 0;
        //fightMonster(p, this.hob);
        Stobj deadhob = new Stobj("carcassa del goblin", "Il cadavere dell'hobgoblin che hai sconfitto. Riesce ad emanare un odore peggiore di quando era in vita...per quanto possibile...");
        this.addObject(deadhob);
    }
    public void riddle(){
        //TODO apertura muro con indovinello
        this.setWest(this.getNextWest());
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("Muro con enigma")) {
                this.getObjects().remove(i);
            }
        }
    }
    
}
 