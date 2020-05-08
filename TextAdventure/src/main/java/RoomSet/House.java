package RoomSet;
import ObjectSet.Stobj;
import newpackage01.Player;

public class House extends RoomWDoor{ 
    
    public House(){
        
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
