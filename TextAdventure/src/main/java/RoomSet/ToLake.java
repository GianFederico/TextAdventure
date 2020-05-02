package RoomSet;

import newpackage01.Player;
import ObjectSet.Weapon;
import newpackage03.SuperMonster;
import newpackage03.Monster_Troll;


public class ToLake extends Room{
    
    private SuperMonster troll = new Monster_Troll();
    
    public ToLake(){
        this.setMonster(troll);
    }
    
    /*public void fightSequence(Player p){
        
        //fightMonster(p, troll)
        
    }*/
    
}
