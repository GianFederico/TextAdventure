package RoomSet;

import newpackage01.Player;
import newpackage03.SuperMonster;
import newpackage03.Monster_Lupo;
import ObjectSet.Stobj;


public class ForestClearing extends Room{
    
    private SuperMonster wolf = new Monster_Lupo();
    
    public ForestClearing(){
        this.setMonster(wolf);
    }
    
    public void fightSequence(Player p){
        //fightMonster(p, this.wolf);
        Stobj deadwolf = new Stobj("carcassa del lupo", "Il cadavere del lupo che hai sconfitto. La tua prima vittoria");
        this.addObject(deadwolf);
    }
}
 