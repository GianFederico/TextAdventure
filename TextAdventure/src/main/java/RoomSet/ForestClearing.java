package RoomSet;

import newpackage01.Player;
import newpackage03.SuperMonster;
import newpackage03.Monster_Lupo;
import ObjectSet.Stobj;


public class ForestClearing extends Room{
    
    private SuperMonster wolf = new Monster_Lupo();
    private Room nextNorth = new Room();
    private Room nextEast = new Room();
    private Room nextWest = new Room();
    
    public ForestClearing(){
        this.setMonster(wolf);
    }
    
    public void fightSequence(Player p){
        //fightMonster(p, this.wolf);
        Stobj deadwolf = new Stobj("carcassa del lupo", "Il cadavere del lupo che hai sconfitto. La tua prima vittoria");
        this.addObject(deadwolf);
        this.setNorth(nextNorth);
        this.setEast(nextEast);
        this.setWest(nextWest);
    }
    
    public void setNextNorth(Room nextNorth){
        this.nextNorth = nextNorth;
    }
    
    public void setNextEast(Room nextEast){
        this.nextEast = nextEast;
    }
    
    public void setNextWest(Room nextWest){
        this.nextWest = nextWest;
    }
}
 