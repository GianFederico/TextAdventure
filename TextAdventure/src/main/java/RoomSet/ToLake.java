package RoomSet;

import newpackage01.Player;
import ObjectSet.Stobj;
import newpackage01.UI;
import newpackage03.SuperMonster;
import newpackage03.Monster_Troll;


public class ToLake extends Room{
    
    private SuperMonster troll = new Monster_Troll();
    private boolean win = false;
    
    public ToLake(){
        this.setMonster(troll);
    }
    
    public void fightSequence(Player p, UI ui){
        if (!this.win) {
            this.win = this.getMonster().fightMonster(p, this.getMonster(), ui);
            if (this.win) {
                this.setMonster(null);
                Stobj deadtroll = new Stobj("carcassa del troll", "Il trollo che hai sconfitto. E' stata una dura battaglia");
                deadtroll.setAka(new String[]{"cadavere", "carcassa", "troll"});
                this.addObject(deadtroll);
            }
        }
    }
}
