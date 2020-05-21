package RoomSet;

import ObjectSet.Door;
import ObjectSet.Potion;
import ObjectSet.Stobj;
import java.util.Iterator;
import java.util.Scanner;
import newpackage01.Player;

public class AlchemShop extends Room{

    
    public AlchemShop(){
        Stobj lady = new Stobj("commessa", "Una gentile commessa. E' l'apprendista dell'alchimista del villaggio. La sfrutta senza pagarla con la promessa di insegnarle le sue tecniche. Fin'ora non ha imparato niente...");
        this.addObject(lady); //TODO aggiungere aka
        Stobj potion = new Potion();
        potion.setName("Pozione");
        potion.setDescription("Una pozione creata dall'alchimista del villaggio. Ripristina un po' di salute. Costa 5 monete");
        this.addObject(potion);
        this.addObject(potion);
        this.addObject(potion);
    }
    
    @Override
    public void buy(Player p, Stobj buy){
        boolean nl = false;
        int pot = 3;
        int k = 0;
        //boolean aq = false;
        boolean c = false;
        Stobj e = new Stobj();
        if (pot > 0){
            if (p.getMoney() < 5){
                //Controllo se il ciondolo è nell'inventario e ne salvo la posizione
                for (int i = 0; i < p.getInventory().size(); i++) {
                    if (p.getInventory().get(i).getName().equals("ciondolo")) {
                        k = i;
                        nl = true;
                    }
                }
                if (nl){
                    while (!c){
                        System.out.println("Non hai abbastanza soldi per permettertene una ma, "
                                + "notando il tuo ciondolo, la commessa ti propone uno scambio:"
                                + "\n" + "Il gioiello in cambio di 2 pozioni e 5 monete."
                                + "\n" + "Che ne dici? [ok/no]");
                        Scanner scanner = new Scanner(System.in);
                        if (scanner.hasNextLine()){
                            String s = scanner.nextLine();
                            s.toLowerCase();
                            switch (s){
                                case "ok":
                                    System.out.println("Scambio accettato");
                                    p.setMoney(p.getMoney()+5);
                                    this.getObjects().get(2).setDescription(this.getObjects().get(2).getDescription().substring(this.getObjects().get(2).getDescription().length()-15));
                                    this.getObjects().get(2).setUsable(true);
                                    p.addToInventory(this.getObjects().get(2));
                                    this.getObjects().get(1).setDescription(this.getObjects().get(1).getDescription().substring(this.getObjects().get(1).getDescription().length()-15));
                                    this.getObjects().get(1).setUsable(true);
                                    p.addToInventory(this.getObjects().get(1));
                                    this.getObjects().remove(2);
                                    this.getObjects().remove(1);
                                    p.getInventory().remove(k);
                                    pot--;
                                    pot--;
                                    c = true;
                                    break;
                                case "no":
                                    System.out.println("Peccato");
                                    c = true;
                                    break;
                                default: 
                                    System.out.println("Inserisci una scelta valida");
                                    break;
                            }
                        }
                    }   
                } else {
                        System.out.println("Non hai abbastanza soldi per concludere l'acquisto");
                }
            } else {
                System.out.println("Con un sorriso, la commessa ti porge la pozione e si prende le tue monete.");
                p.setMoney(p.getMoney()-5);
                this.getObjects().get(0).setUsable(true);
                this.getObjects().get(0).setDescription(this.getObjects().get(0).getDescription().substring(this.getObjects().get(0).getDescription().length()-15));
                p.addToInventory(this.getObjects().get(0));
                this.getObjects().remove(0);
                pot--;
                //aq = true;
            }
        } else {
            System.out.println("Purtroppo le pozioni acquistabili sono terminate");
        }
        //return aq;
    }
    
    @Override
    public void talkTo(Player p, Stobj person){
        if (person.getName().equals("commessa")){
            //TODO parla con la commessa dell'alchimista
        }

    }
    
    
}
