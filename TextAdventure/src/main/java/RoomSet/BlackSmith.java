/**
 * Classe per la definizione delle stanze col negozio di spade e armature
 */
package roomSet;

import objectSet.*;
import base.Room;
import base.Stobj;
import gameCore.Player;

public class BlackSmith extends Room {

    private boolean f = false;
    private boolean exc = false;

    public BlackSmith(){
        Weapon lsword = new Weapon();
        Armor armor = new Armor();
        Stobj blksm = new Stobj("Fabbro", "Il fabbro del villaggio. Ha un forte odore di...vero uomo");
        lsword.setName("Spada");
        lsword.setDescription("Una spada lunga forgiata dal fabbro del villaggio.\nServirà per affrontare i nemici sul tuo cammino. Costa 8 monete");
        lsword.setPickupable(false);
        lsword.setAlias(new String[]{"arma", "lama"});
        lsword.setDamage(8);
        armor.setName("Armatura");
        armor.setDescription("Una armatura di cuoio realizzata dal fabbro del villaggio.\nServirà per difenderti dai nemici sul tuo cammino. Costa 2 monete");
        armor.setPickupable(false);
        armor.setAlias(new String[]{"armatura, indumento, vestito, indumenti, vestiti"});
        armor.setDefense(3);
        this.addObject(blksm);
        this.addObject(lsword);
        this.addObject(armor);
    }
    
     /**
     * Acquisto e scambio di equipaggiamenti. Interazione basata sull'oggetto buy e aggiunta dell'acquisto nel'inventario del Player p. Interazione aggiuntiva nel caso di possesso lo Stobj con nome "Coltello"
     * @param p
     * @param buy 
     */
    @Override
    public void buy(Player p, Stobj buy){
        boolean c = false;
        int k = 0;
        if (buy.getName().equals("Fabbro")){
            this.setMsg("Sarebbe comodo poterlo portare insieme durante la tua avventura ma purtroppo non puoi. Ha una famiglia da mantenere e deve tornare a lavoro");
        } else
        //boolean aq = false;
        if (this.getObjects().contains(buy)){
            if (p.getMoney()<2){
                  this.setMsg("Non hai abbastanza denaro per concludere l'acquisto");
            } else {
                if (buy.getName().equals("Spada")){
                    if (!this.exc && this.f) {
                        for (int i = 0; i < p.getInventory().size(); i++) {
                            if (p.getInventory().get(i).getName().equals("Coltello")){
                                c = true;
                                k = i;
                            }
                        }
                        if (c) {
                            p.removeFromInventory(k);
                            this.setMsg("Hai ottenuto una spada lunga. Lasci il coltello e 2 monete al fabbro");
                            buy.setDescription(buy.getDescription().substring(0, buy.getDescription().length() - 15));
                            p.addToInventory(buy);
                            p.setMoney(p.getMoney() - 2);
                            this.getObjects().remove(buy);
                            this.exc = true;
                        } else {
                            this.setMsg("Non hai abbastanza monete per acquistare la spada. \nProva a parlare col fabbro, magari può offrirti uno scambio");
                        }
                    } else {
                        this.setMsg("Non hai abbastanza monete per acquistare la spada. \nProva a parlare col fabbro, magari può offrirti uno scambio");
                    }
                } else {
                    this.setMsg("Hai ottenuto una " + buy.getName());
                    buy.setDescription(buy.getDescription().substring(0, buy.getDescription().length()-15));
                    p.addToInventory(buy);
                    p.setMoney(p.getMoney()-2);
                    this.getObjects().remove(buy);
                }
            }
        } else {
              this.setMsg("La " + buy.getName() + " non è più disponibile. Probabilmente l'hai già acquistata");
        }
    }

    /**
     * Interazione di dialogo conil fabbro. Interazione basata su Stobj person. Dialogo aggiuntivo nel caso di possesso lo Stobj con nome "Coltello" nell'inventario del Player p
     * @param p
     * @param person 
     */
    @Override
    public void talkTo(Player p, Stobj person){
        if (person.getName().equals("Fabbro")){
            if (!this.exc){
                boolean c = false;
                this.setMsg("Dato che non hai abbastanza monete per acquistare la spada, il fabbro \nti propone un affare: otterresti la spada in cambio di sole 2 monete se riuscissi a \ndargli un'altra arma in cambio...");
                for (int i = 0; i < p.getInventory().size(); i++) {
                    if (p.getInventory().get(i).getName().equals("Coltello")) {
                        c = true;
                        break;
                    }
                }
                if (c){
                    this.setMsg(this.getMsg() + "\nHai un coltello nello zaino, potresti usarlo per lo scambio!");
                    this.f=true;
                }
            } else {
                this.setMsg("Ti da consigli su come maneggiare e fare manutenzione alla spada\nma il suo martellare sul metallo rovente è tanto fastidioso da costringerti ad allontanarti");
            }
        }
    }
    
      /**
     * Interazione per lo scambio nel caso del possesso dello Stobj con nome "Coltello" nell'inventario del Player p. Viene aggiunta "Spada" all'inventario in sostituzione di Coltello, oltre alla riduzione di 2 di Money in Player
     * @param p
     * @param obj 
     */
    @Override
    public void give(Player p, Stobj obj){
            if (obj.getName().equals("Coltello")){
                 if (!this.exc && this.f){
                     if (p.getMoney()>=2){
                     int k = -1;
                     for (int i = 0; i < p.getInventory().size(); i++) {
                                 if (p.getInventory().get(i).getName().equals("Coltello")) {
                                     k = i;
                                 }
                             }
                             if (k>-1) {
                                p.removeFromInventory(k);
                                this.setMsg("Hai ottenuto una spada lunga. Lasci il coltello e 2 monete al fabbro");
                                 this.getObjects().get(1).setDescription( this.getObjects().get(1).getDescription().substring(0,  this.getObjects().get(1).getDescription().length() - 15));
                                 p.addToInventory( this.getObjects().get(1));
                                 this.getObjects().remove(1);
                                 p.setMoney(p.getMoney() - 2);
                                 this.exc = true;
                             } else {
                                  this.setMsg("Non hai nulla da scambiare.");
                             }
                 } else {
                          this.setMsg("Non hai abbastanza monete per completare lo scambio.");
                     }
                } else {
                    this.setMsg("Non sai se potrebbe interessargli.");
                }
            } else {
                 this.setMsg("Non credi che potrebbe interessargli.");
            }
    }
}
