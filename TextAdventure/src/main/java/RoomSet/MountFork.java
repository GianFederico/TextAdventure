package RoomSet;

import newpackage01.Player;
import newpackage03.SuperMonster;
import newpackage03.Monster_Hobgoblin;
import ObjectSet.Stobj;


public class MountFork extends RoomWDoor{
    
    private SuperMonster hob = new Monster_Hobgoblin();
    
    public MountFork(){
        this.setMonster(hob);
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
                this.getObjects().get(i).setVisible(false);
            }
        }
    }
    
}
 