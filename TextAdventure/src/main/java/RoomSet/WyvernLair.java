package RoomSet;

import ObjectSet.Stobj;
import newpackage01.Player;
import newpackage03.SuperMonster;
import newpackage03.Monster_Viverna;

public class WyvernLair extends Room{
    
    private SuperMonster wyvern = new Monster_Viverna();
    
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
    
    public void fightSequence(Player p){
        int d = 0;
        //fightMonster(p, this.hob);
        Stobj deadwyv = new Stobj("carcassa della viverna", "Il cadavere della viverna che hai sconfitto. Ha una gemma incastonata nella fronte che attira la tua attenzione");
        this.addObject(deadwyv);
        this.getObjects().get(0).setVisible(true);
    }
    
}
