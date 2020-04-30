package RoomSet;

import ObjectSet.Stobj;
import newpackage01.Player;

public class BlackSmith extends Room{
    
    private Stobj lsword = new Stobj("spada lunga", "Una spada lunga forgiata dal fabbro del villaggio. Servirà per affrontare i nemici sul tuo cammino. Costa 2 monete");
    private Stobj armor = new Stobj("armatura di cuoio", "Una armatura di cuoio realizzata dal fabbro del villaggio. Servirà per difenderti dai nemici sul tuo cammino. Costa 2 monete");

    public BlackSmith(){
        this.lsword.setPickupable(true);
        this.lsword.setUsable(true);
        this.armor.setPickupable(true);
        this.armor.setUsable(true);
        this.getObjects().add(this.lsword);
        this.getObjects().add(this.armor);
    }
    
    
    public boolean interaction(Player p, Stobj buy){
        boolean aq = false;
        
        if (this.getObjects().contains(buy)){
            if (p.getMoney()<2){
                System.out.println("Non hai abbastanza denaro per concludere l'acquisto");
            } else {
                System.out.println("Hai ottenuto una" + buy.getName());
                aq = true;
                buy.setDescription(buy.getDescription().substring(buy.getDescription().length()-15));
                p.addToInventory(buy);
                p.setMoney(p.getMoney()-2);
                this.getObjects().remove(buy);
            }
        } else {
            System.out.println("La " + buy.getName() + " non è più disponibile. Probabilmente l'hai già acquistata");
        }
        return aq;
    }
}
