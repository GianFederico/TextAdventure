package RoomSet;

import newpackage01.Player;
import newpackage03.SuperMonster;
import newpackage03.Monster_Lupo;


public class ForestClearing extends Room{
    
    private SuperMonster wolf = new Monster_Lupo();
    
    public ForestClearing(){
        this.setMonster(wolf);
    }
    
    /*public void fightSequence(Player p){
        
        //fightMonster(p, wolf)
        
    }*/
    
}
 