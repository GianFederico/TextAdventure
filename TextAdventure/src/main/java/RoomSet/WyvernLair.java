package RoomSet;

import ObjectSet.Stobj;
import newpackage01.Player;
import newpackage01.UI;
import newpackage03.SuperMonster;
import newpackage03.Monster_Viverna;

public class WyvernLair extends Room{
    
    private SuperMonster wyvern = new Monster_Viverna();
    boolean win = false;
    
    public WyvernLair(){
        this.setMonster(wyvern);
        Stobj obj = new Stobj();
        obj.setName("Gemma viverna");
        obj.setAka(new String[]{"gemma","pietra"});
        obj.setDescription("Gemma rimossa dal cranio della viverna");
        obj.setPickupable(true);
        obj.setVisible(false);
        this.addObject(obj);
    }
    
    public void fightSequence(Player p, UI ui){
        if (!this.win) {
            this.win = this.getMonster().fightMonster(p, this.getMonster(), ui);
            if (this.win) {
                this.setMonster(null);
                Stobj deadwyv = new Stobj("Carcassa della viverna", "Il cadavere della viverna che hai sconfitto. Ha una gemma incastonata nella fronte che attira la tua attenzione");
                deadwyv.setAka(new String[]{"cadavere", "carcassa", "viverna"});
                this.addObject(deadwyv);
                this.getObjects().get(0).setVisible(true);
            }
        }
    }
}
