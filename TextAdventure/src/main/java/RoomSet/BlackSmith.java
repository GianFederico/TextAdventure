package RoomSet;

import ObjectSet.*;
import newpackage01.Player;

public class BlackSmith extends Room{

    public BlackSmith(){
        Stobj lsword = new Weapon();
        Stobj armor = new Armor();
        Stobj blksm = new Stobj("Fabbro", "Il fabbro del villaggio. Ha un forte odore di...vero uomo"); //TODO aggiungere aka
        this.addObject(blksm);
        lsword.setName("Spada");
        lsword.setDescription("Una spada lunga forgiata dal fabbro del villaggio. Servirà per affrontare i nemici sul tuo cammino. Costa 2 monete");
        lsword.setPickupable(true);
        lsword.setUsable(true);
        lsword.setAka(new String[]{"arma"});
        //TODO damage di lsword
        armor.setName("Armatura di cuoio");
        armor.setDescription("Una armatura di cuoio realizzata dal fabbro del villaggio. Servirà per difenderti dai nemici sul tuo cammino. Costa 2 monete");
        armor.setPickupable(true);
        armor.setUsable(true);
        armor.setAka(new String[]{"armatura, indumento, vestito, indumenti, vestiti"});
        //TODO defense di armor
        this.addObject(lsword);
        this.addObject(armor);
    }
    
    @Override
    public void buy(Player p, Stobj buy){
        if (buy.getName().equals("fabbro")){
            System.out.println("Sarebbe comodo poterlo portare insieme durante la tua avventura ma purtroppo non puoi. Ha una famiglia da mantenere e deve tornare a lavoro");
        }
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
                if (buy.getName().equals("spada")){
                    for (int i = 0; i < p.getInventory().size(); i++) {
                        if (p.getInventory().get(i).getName().equals("coltello")) {
                            p.removeFromInventory(i);
                        }
                    }
                }
            }
        } else {
            System.out.println("La " + buy.getName() + " non è più disponibile. Probabilmente l'hai già acquistata");
        }
        //return aq;
    }

    @Override
    public void talkTo(Player p, Stobj person){
        if (person.getName().equals("fabbro")){
            //TODO parla col fabbro
        }

    }
}
