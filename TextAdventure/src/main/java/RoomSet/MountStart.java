package RoomSet;

import ObjectSet.Stobj;
import newpackage03.SuperMonster;
import newpackage03.Monster_RagnoGigante;
import newpackage01.Player;

public class MountStart extends Room{
    
    private Room nextNorth = null;
    private SuperMonster spider = new Monster_RagnoGigante();
    private Stobj rxlever = new Stobj("leva destra", "Una semplice leva. Finchè non l'azioni non sai cosa attiva. Si trova alla tua destra");
    private Stobj lxlever = new Stobj("leva sinistra", "Una semplice leva. Finchè non l'azioni non sai cosa attiva. Si trova alla tua sinistra");
    private Stobj trapdoor = new Stobj("trappola", "Una trappola prima nascosta. Dopo aver tirato la leva sinistra risulta visibile");
    
    
    public MountStart(){
        this.rxlever.setUsable(true);
        this.lxlever.setUsable(true);
        this.addObject(rxlever);
        this.addObject(lxlever);
        this.trapdoor.setVisible(false);
    }
    
    public void actRightLever(Room currentRoom){
        this.setNorth(this.nextNorth);
        // TODO aggiungere descrizione evento
    }
    
    public Room actLeftLever(Player p){
        System.out.println("Senti un cigolio, poi un rumore di ingranaggi per poi accorgerti di star cadendo nel vuoto. La leva sinistra era una trappola. Ti risvegli qualche ora dopo ai piedi della montagna. Hai perso 10 HP per la caduta");
        p.setHp(p.getHp()-10);
        
        return this.getSouth();
    }
    
    public void fightSequence(Player p){
        //Room fight = fightMonster(p, this.spider);
        Stobj deadspider = new Stobj("carcassa del ragno", "Il cadavere del ragno che hai sconfitto");
        this.addObject(deadspider);
        
    }
    
    public void setNextNorth(Room nextNorth){
        this.nextNorth = nextNorth;
    }
}
