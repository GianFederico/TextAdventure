/**
 * Classe per la definizione delle stanze col negozio di pozioni
 */
package roomSet;

import objectSet.Potion;
import base.Stobj;
import base.Room;
import gameCore.Player;

public class AlchemShop extends Room {

    private int pot = 3;
    private boolean t = false;
    private boolean exc = false;
    
    public AlchemShop(){
        Stobj lady = new Stobj("Commessa", "Una gentile commessa. E' l'apprendista dell'alchimista del villaggio. \nLa sfrutta senza pagarla con la promessa di insegnarle le sue tecniche. \nFin'ora non ha imparato niente...");
        lady.setAlias(new String[]{"signorina", "apprendista", "commessa"});
        this.addObject(lady); 
        Stobj potion = new Potion();
        potion.setName("Pozione");
        potion.setDescription("Una pozione creata dall'alchimista del villaggio.\nRipristina un po' di salute. Costa 5 monete");
        potion.setUsable(true);
        this.addObject(potion);
        this.addObject(potion);
        this.addObject(potion);
    }
    
    /**
     * Acquisto e scambio di pozioni. Interazione basata sull'oggetto buy e aggiunta dell'acquisto nel'inventario del Player p. Interazione aggiuntiva nel caso di possesso lo Stobj con nome "Ciondolo"
     * @param p
     * @param buy 
     */
    @Override
    public void buy(Player p, Stobj buy){
         if (buy.equals(this.getObjects().get(0))){
            this.setMsg("Non varrebbe la spesa e non ti sarebbe d'aiuto dato che non sembra troppo...atletica");
        } else {
             int k = -1;
             if (this.pot > 0) {
                 if (p.getMoney() < 5) {
                     if (!this.exc && this.t) {
                         //Controllo se il ciondolo è nell'inventario e ne salvo la posizione
                         for (int i = 0; i < p.getInventory().size(); i++) {
                             if (p.getInventory().get(i).getName().equals("Ciondolo")) {
                                 k = i;
                             }
                         }
                         if (k>-1) {
                             p.setMoney(p.getMoney() + 5);
                             buy.setDescription(buy.getDescription().substring(0, buy.getDescription().length() - 15));
                             buy.setUsable(true);
                             p.addToInventory(buy);
                             p.addToInventory(buy);
                             this.getObjects().remove(buy);
                             this.getObjects().remove(buy);
                             this.pot-=2;
                             this.exc = true;
                             p.removeFromInventory(k);
                             this.setMsg("Hai ottenuto due pozioni e ben 5 monete! In cambio lasci il ciondolo alla commessa.\nAdesso è il suo...tesoro...");
                         } else {
                             this.setMsg("Non hai abbastanza soldi per acquistare pozioni. \nParla con la commessa, magari può offrirti uno sconto..."); 
                         }
                     } else {
                         this.setMsg("Non hai abbastanza soldi per acquistare pozioni. \nParla con la commessa, magari può offrirti uno sconto...");
                     }
                     } else {
                         this.setMsg("Con un sorriso, la commessa ti porge la pozione e si prende le tue monete.");
                         p.setMoney(p.getMoney() - 5);
                         this.getObjects().get(1).setUsable(true);
                         this.getObjects().get(1).setDescription(this.getObjects().get(1).getDescription().substring(this.getObjects().get(1).getDescription().length() - 15));
                         p.addToInventory(this.getObjects().get(1));
                         this.getObjects().remove(1);
                         this.pot--;
                     }

             } else {
                 this.setMsg("Purtroppo le pozioni acquistabili sono terminate.");
             }
             }
        }

    /**
     * Interazione di dialogo con la commessa del negozio. Interazione basata su Stobj person. Dialogo aggiuntivo nel caso di possesso lo Stobj con nome "Ciondolo" nell'inventario del Player p
     * @param p
     * @param person 
     */
    @Override
    public void talkTo(Player p, Stobj person){
        if (person.equals(this.getObjects().get(0))){
            if (!this.exc){
                boolean c = false;
                this.setMsg("Parlandole, capisci che questa commessa è molto materialista.\nSe avessi un gioiello da darle sicuramente riusciresti ad avere almeno una pozione in\ncambio...");
                for (int i = 0; i < p.getInventory().size(); i++) {
                    if (p.getInventory().get(i).getName().equals("Ciondolo")) {
                        c = true;
                        break;
                    }
                }
                if (c){
                    this.setMsg(this.getMsg() + "\nHai il ciondolo di tua madre nello zaino, potresti usarlo per lo scambio!");
                    this.t=true;
                }
            } else {
                this.setMsg("E' molto indaffarata e se non hai intenzione di fare acquisti, ti invita gentilmente ad uscire...");
            }
        }
    }
    
    /**
     * Interazione per lo scambio nel caso del possesso dello Stobj con nome "Ciondolo" nell'inventario del Player p. Vengono aggiunte due Pozione all'inventario in sostituizione del Ciondolo, oltre all'incremento di 5 a Money di Player
     * @param p
     * @param obj 
     */
    @Override
    public void give(Player p, Stobj obj){
        if (obj.getName().equals("Ciondolo")){
             if (!this.exc && this.t){
                 int k = -1;
                 for (int i = 0; i < p.getInventory().size(); i++) {
                             if (p.getInventory().get(i).getName().equals("Ciondolo")) {
                                 k = i;
                             }
                         }
                         if (k>-1) {
                             p.setMoney(p.getMoney() + 5);
                             this.getObjects().get(this.getObjects().size()-1).setDescription( this.getObjects().get(this.getObjects().size() -1).getDescription().substring(0,  this.getObjects().get(this.getObjects().size() -1).getDescription().length() - 15));
                             p.addToInventory( this.getObjects().get(this.getObjects().size() -1));
                             p.addToInventory( this.getObjects().get(this.getObjects().size() -1));
                             this.getObjects().remove(this.getObjects().size() -1);
                             this.getObjects().remove(this.getObjects().size() -1);
                             this.pot -= 2;
                             this.exc = true;
                             p.removeFromInventory(k);
                             this.setMsg("Hai ottenuto due pozioni e ben 5 monete! In cambio lasci il ciondolo alla commessa.\nAdesso è il suo...tesoro...");
                         } else {
                              this.setMsg("Non hai nulla che possa interessare alla commessa.");
                         }
            } else {
                this.setMsg("Non sai se potrebbe interessarle.");
            }
        } else {
             this.setMsg("Non credi che potrebbe interessarle.");
        }
    }
}
