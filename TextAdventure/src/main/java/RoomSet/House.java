package RoomSet;
import ObjectSet.Door;
import ObjectSet.Stobj;
import ObjectSet.Weapon;
import newpackage01.Player;

public class House extends RoomWDoor{

    public House(){
        Stobj knife = new Weapon();
        Stobj obj = new Stobj();
        Stobj door = new Door();

        knife.setName("coltello");
        knife.setDescription("Un semplice coltello. Potresti usarlo come arma");
        //TODO dmg coltello
        knife.setPickupable(true);
        this.addObject(knife);

        obj.setName("ciondolo");
        obj.setDescription("Il ciondolo di tua madre. Risplende alla luce con la sua pietra preziosa. "
                + "Pensi possa valere qualcosa e che potrebbe tornarti utile");
        obj.setPickupable(true);
        this.addObject(obj);

        door.setName("porta");
        door.setDescription("Porta di legno. Si affaccia proprio sulla piazza centrale del villaggio. Saperlo ti fa sentire importante. E' chiusa");
        ((Door)door).setDirection("n");
        ((Door)door).setOpen(false);
        this.addObject(door);

        this.setMoney(2);
    }
    
    public void givePotion(Player player){
        boolean poz= false;
        
            for (Stobj inv : player.getInventory()){
                if (inv.getName().equals("pozione millecure")){
                    poz=true;
                    player.removeFromInventory(inv); 
                }
                    
                if(poz==true){
                    System.out.println("Dai la pozione dello sciamano a tua madre, gliela fai bere tutta d'un fiato e allo stremo delle forze si accascia sul letto in un sonno profondo.\n"
                            + "passano parecchie ore prima che si risvegli, ma la mattina del giorno dopo apre gli occhi ed è contenta di poterti riabbracciare.\nCe l'hai fatta, l'hai salvata.\nFine.");
                }
                else{
                    System.out.println("Controlli nel tuo zaino, ma non c'è nulla che tu possa darle, anche le pozioni dell'alchimista non hanno effetto.");
                }
        }
    }
}
