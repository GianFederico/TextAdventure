/**
 * Definizione della stanza di gioco
 */
package roomSet;

import monsterSet.Monster_Hobgoblin;
import base.Stobj;
import objectSet.Door;


public class MountFork extends RoomWDoor{

    public MountFork(){
        this.setMonster(new Monster_Hobgoblin());
        Stobj obj = new Stobj();
        Door door = new Door();
        obj.setName("Muro con enigma");
        obj.setAlias(new String[]{"muro","enigma","indovinello"});
        obj.setDescription("Il muro ha una scritta che recita:\n\n\"Non è un'isola, ma è sempre in mezzo all'acqua\"\n\nSembra che voglia una risposta per aprirsi...");
        this.addObject(obj);
        door.setName("Porta");
        door.setDescription("Porta di legno. E' chiusa");
        door.setOpen(false);
        door.setDirection("e");
        this.addObject(door);
    }

    /**
     * Interazione per la risoluzione dell'enigma
     */
    public void riddle(){
        this.setMsg("Nel momento in cui pronunci la risposta, il muro svanisce come se fosse sempre stato \nun'illusione!\nOra puoi proseguire verso ovest.");
        this.setWest(this.getNextWest());
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("Muro con enigma")) {
                this.getObjects().remove(i);
                break;
            }
        }
        this.setDescription("Sei all'entrata di una strana caverna nella montagna.\nCapisci che è stata abitata ma adesso sembra abbandonata.\nDopo aver risolto l'indovinello il muro è scomparso e puoi proseguire verso ovest");
    }
    
}
 