package RoomSet;

import ObjectSet.Stobj;
import newpackage03.SuperMonster;
import newpackage03.Monster_RagnoGigante;
import newpackage01.Player;
import newpackage01.UI;

public class MountStart extends RoomWDoor{

    private SuperMonster spider = new Monster_RagnoGigante();
    private boolean win = false;
    
    
    public MountStart(){
        Stobj dxlever = new Stobj("Leva destra", "Una semplice leva. Finchè non l'azioni non sai cosa attiva. Si trova alla tua destra");
        Stobj sxlever = new Stobj("Leva sinistra", "Una semplice leva. Finchè non l'azioni non sai cosa attiva. Si trova alla tua sinistra");
        Stobj trapdoor = new Stobj("Trappola", "Una trappola prima nascosta. Dopo aver tirato la leva sinistra risulta visibile");
        dxlever.setAka(new String[]{"destra"});
        dxlever.setUsable(true);
        sxlever.setAka(new String[]{"sinistra"});
        sxlever.setUsable(true);
        trapdoor.setVisible(false);
        this.addObject(dxlever);
        this.addObject(sxlever);
        this.addObject(trapdoor);
    }

    public void activate(Stobj lever, Player p){
        if (lever.equals(this.getObjects().get(0))){
            this.setNorth(this.getNextNorth());
            // TODO aggiungere descrizione evento
        }
        if (lever.equals(this.getObjects().get(1))){
            this.setMsg("Senti un cigolio, poi un rumore di ingranaggi per poi accorgerti di star cadendo nel vuoto. La leva sinistra era una trappola. Ti risvegli qualche ora dopo ai piedi della montagna. Hai perso 10 HP per la caduta");
            this.getObjects().get(2).setVisible(true);
            p.setCurrentHp(p.getCurrentHp()-10);
            p.setCurrentRoom(p.getPreviousRoom());
        }
    }

    @Override
    public void fightSequence(Player p, UI ui){
        if (!this.win) {
            this.win = this.getMonster().fightMonster(p, this.getMonster(), ui);
            if (this.win) {
                this.setMonster(null);
                Stobj deadspider = new Stobj("Carcassa del ragno", "Il cadavere del ragno che hai sconfitto");
                deadspider.setAka(new String[]{"cadavere", "carcassa", "ragno", "ragno gigante"});
                this.addObject(deadspider);
            }
        }
    }
}
