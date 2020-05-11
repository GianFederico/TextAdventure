package RoomSet;

import ObjectSet.*;
import newpackage01.Player;

public class BlackSmith extends Room{
    
    private Stobj lsword = new Weapon();
    private Stobj armor = new Armor();

    public BlackSmith(){
        this.lsword.setName("spada lunga");
        this.lsword.setDescription("Una spada lunga forgiata dal fabbro del villaggio. Servirà per affrontare i nemici sul tuo cammino. Costa 2 monete");
        this.lsword.setPickupable(true);
        this.lsword.setUsable(true);
        this.lsword.setAka(new String[]{"spada, arma"});
        //TODO damage di lsword
        this.armor.setName("armatura di cuoio");
        this.armor.setDescription("Una armatura di cuoio realizzata dal fabbro del villaggio. Servirà per difenderti dai nemici sul tuo cammino. Costa 2 monete");
        this.armor.setPickupable(true);
        this.armor.setUsable(true);
        this.armor.setAka(new String[]{"armatura, indumento, vestito, indumenti, vestiti"});
        //TODO defense di armor
        this.addObject(this.lsword);
        this.addObject(this.armor);
    }
    
    @Override
    public void buy(Player p, Stobj buy){
        //boolean aq = false;
        
        if (this.getObjects().contains(buy)){
            if (p.getMoney()<2){
                System.out.println("Non hai abbastanza denaro per concludere l'acquisto");
            } else {
                System.out.println("Hai ottenuto una" + buy.getName());
                //aq = true;
                buy.setDescription(buy.getDescription().substring(buy.getDescription().length()-15));
                p.addToInventory(buy);
                p.setMoney(p.getMoney()-2);
                this.getObjects().remove(buy);
            }
        } else {
            System.out.println("La " + buy.getName() + " non è più disponibile. Probabilmente l'hai già acquistata");
        }
        //return aq;
    }
}
