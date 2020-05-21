package RoomSet;

import newpackage01.Player;
import newpackage03.SuperMonster;
import newpackage03.Monster_Lupo;
import ObjectSet.Stobj;


public class ForestClearing extends Room{
    
    private SuperMonster wolf = new Monster_Lupo();
    private boolean win = false;
    
    public ForestClearing(){
        this.setMonster(wolf);
    }

    @Override
    public void fightSequence(Player p){
        if (!this.win) {
            this.win = this.getMonster().fightMonster(p, this.getMonster());
            if (this.win) {
                this.setMonster(null);
                Stobj deadwolf = new Stobj("carcassa del lupo", "Il cadavere del lupo che hai sconfitto. La tua prima vittoria");
                deadwolf.setAka(new String[]{"cadavere", "carcassa", "lupo"});
                this.addObject(deadwolf);
            }
        }
    }
}
 