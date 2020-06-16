/**
 * Definizione della stanza di gioco
 */
package roomSet;

import base.Stobj;
import monsterSet.Monster_RagnoGigante;
import gameCore.Player;

public class MountStart extends RoomWDoor{

    public MountStart(){
        Stobj dxlever = new Stobj("Leva destra", "Una semplice leva. Finchè non l'azioni non sai cosa attiva. Si trova alla tua destra.");
        Stobj sxlever = new Stobj("Leva sinistra", "Una semplice leva. Finchè non l'azioni non sai cosa attiva. Si trova alla tua sinistra.");
        Stobj trapdoor = new Stobj("Trappola", "Una trappola prima nascosta. Dopo aver tirato la leva sinistra risulta visibile.");
        dxlever.setAlias(new String[]{"destra"});
        dxlever.setUsable(true);
        sxlever.setAlias(new String[]{"sinistra"});
        sxlever.setUsable(true);
        trapdoor.setVisible(false);
        this.addObject(dxlever);
        this.addObject(sxlever);
        this.addObject(trapdoor);
        this.setMonster(new Monster_RagnoGigante());
    }

    /**
     * Interazione con la leva. Interazione basata su String lever nei due casi, "destra" e "sinistra". In caso di possesso dello Stobj con nome "Consiglio" nell'inventario di Player p, interazione "sinistra" inaccessibile. Se viene attivata la leva sinistra, decrementa di 10 gli Hp in Player essendo la leva sbagliata
     * @param lever
     * @param p 
     */
    public void activate(String lever, Player p){
        boolean adv = false;
        for (Stobj inv : p.getInventory()) {
            if (inv.getName().equals("Consiglio")) {
                adv = true;
                this.getObjects().get(1).setUsable(false);
                break;
            }
        }
        if (this.getObjects().get(0).getAlias().contains(lever)){
            this.setNorth(this.getNextNorth());
            this.setMsg("Sembra tu abbia attivato la leva corretta! La frana si disperde e le due leve si ritraggono");
            this.getObjects().remove(0);
            this.getObjects().remove(this.getObjects().get(1));
            this.setDescription("Sei su un'area rocciosa poco più grande di un pianerottolo di una casa.\nOra che la frana non c'è più puoi proseguire");
        } else
        if (this.getObjects().get(1).getAlias().contains(lever)){
            if (!adv) {
                this.getObjects().get(2).setVisible(true);
                p.setCurrentHp(p.getCurrentHp() - 10);
                this.getSouth().setMsg("Senti un cigolio, poi un rumore di ingranaggi per poi accorgerti di star cadendo nel vuoto." +
                        "\nLa leva sinistra era una trappola. Ti risvegli qualche ora dopo ai piedi della montagna." +
                        "\nHai perso 10 HP per la caduta\n\n" + "Sei tornato a: " + this.getSouth().getName());
            } else {
                this.setMsg("Grazie al consiglio che ti ha dato la ninfa del lago, sai che la leva giusta\nè quella destra. Molto probabilmente quella sinistra attiva solo una trappola...");
            }
        }
    }
}
