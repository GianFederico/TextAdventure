/**
 * Definizione della stanza di gioco
 */
package roomSet;

import base.Stobj;
import objectSet.Weapon;
import base.Room;
import gameCore.Player;

public class WestLake extends Room {
    
   public WestLake(){
       Stobj nymph = new Stobj("Ninfa", "La ninfa del lago.\nCome raccontano le leggende, è davvero bellissima e\nti è difficile non fissarla come un ebete.");
       this.addObject(nymph);
   }

   /**
    * Interazione di dialogo con la ninfa del lago. Interazione basata sul nome di Stobj person. Nell'interazione con la ninfa, all'arma contenuta nella lista Inventory del Player p viene incrementato il Dmg di 5. Inoltre viene aggiunto uno Stobj con nome "Consiglio" all'inventario. Al termine dell'interazione la ninfa viene rimossa dalla  lista degli interagibili della stanza
    * @param p
    * @param person 
    */
   @Override
   public void talkTo(Player p, Stobj person){
       if (person != null) {
               int k = -1;
               Stobj adv = new Stobj("Consiglio", "Un pezzo di carta sul quale hai appuntato il consiglio della ninfa del lago.\nDice di tirare la leva destra.");
               adv.setVisible(true);
               adv.setAlias(new String[]{"appunto"});
               for (int i = 0; i < p.getInventory().size() && k < 0; i++)
                   if (p.getInventory().get(i).getName().equals("Spada") || p.getInventory().get(i).getName().equals("Coltello"))
                       k = i;
               ((Weapon) p.getInventory().get(k)).setDamage(((Weapon) p.getInventory().get(k)).getDamage() + 2);
               p.getInventory().get(k).setDescription(p.getInventory().get(k).getDescription() + "\nL'arma è stata incantata dalla ninfa, rendendola più affilata e\nmagicamente più potente. Il fabbro ne sarebbe fiero...");
               this.setMsg("La Ninfa ti ringrazia per averla liberata dal Ciclope e, recitando una strana formula\nmagica, incanta la tua arma aumentandone l'efficacia (danno +2)." +
                       "\nPurtroppo non può far molto altro per aiutarti nella tua avventura, ma ti racconta\nche una volta ha visto lo sciamano entrare nella montagna tirando la leva alla sua destra"
                       + "\n\nAppunti il consiglio della ninfa su un foglietto che riponi nel tuo zaino.\n\nLa ninfa ti ringrazia un'ultima volta prima di sparire davanti ai tuoi occhi.");
               p.addToInventory(adv);
               this.getObjects().remove(0);
       } else {
           this.setMsg("La ninfa non è più qui e non vedi tracce per capire dove sia andata o seguirla...");
       }
   }
}
