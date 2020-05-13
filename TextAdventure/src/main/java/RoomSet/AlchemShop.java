package RoomSet;

import ObjectSet.Door;
import ObjectSet.Stobj;
import java.util.Iterator;
import java.util.Scanner;
import newpackage01.Player;

public class AlchemShop extends Room{
    
    private Stobj potion = new Stobj("pozione", "Una pozione creata dall'alchimista del villaggio. Ripristina un po' di salute. Costa 5 monete");
    
    public AlchemShop(){
        this.potion.setPickupable(true);
        this.potion.setUsable(true);
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
                                    this.potion.setDescription(this.potion.getDescription().substring(this.potion.getDescription().length()-15));
                                    p.addToInventory(this.potion);
                                    p.addToInventory(this.potion);
                                    this.getObjects().remove(this.potion);
                                    this.getObjects().remove(this.potion);
                                    p.getInventory().remove(p.getInventory().get(k));
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
                this.potion.setDescription(this.potion.getDescription().substring(this.potion.getDescription().length()-15));
                p.addToInventory(this.potion);
                this.getObjects().remove(this.potion);
                pot--;
                //aq = true;
            }
        } else {
            System.out.println("Purtroppo le pozioni acquistabili sono terminate");
        }
        //return aq;
    }
    
    
    
    
}
