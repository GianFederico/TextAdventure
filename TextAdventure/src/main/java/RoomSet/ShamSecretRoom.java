/**
 * Definizione della stanza di gioco
 */
package roomSet;

import base.Stobj;
import base.Room;

public class ShamSecretRoom extends Room {
    
    public ShamSecretRoom(){
        Stobj obj = new Stobj();
        obj.setName("Pozione Millecure");
        obj.setAlias(new String[]{"pozione di cura","pozione"});
        obj.setDescription("Leggendaria pozione Millecure, cura ogni male.");
        obj.setPickupable(true);
        this.addObject(obj);
    }

    /**
     * Interazione al momento della raccolta dell'oggetto Stobj con nome "Pozione Millecure". Con la raccolta viene aperto un passaggio verso nord.
     */
    @Override
    public void getPotion(){
        this.setMsg("Non appena raccogli la pozione, compare un piccolo portale che si affaccia prorio\nnella tua casa.\nChe punti proprio lì per tua volontà...o tua madre ti nasconde qualcosa..?");
        Stobj portal = new Stobj("Portale", "Un piccolo portale. Ti basta dirigerti a nord per attraversarlo\nDall'altra parte c'è proprio casa tua...\nNon riesci ad immaginarne il perchè...");
        this.addObject(portal);
        this.setNorth(this.getNextNorth());
    }
    
}
