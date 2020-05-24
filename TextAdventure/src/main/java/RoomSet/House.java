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
        Stobj mom = new Stobj("Mamma", "Tua madre. Giace nel letto");

        knife.setName("Coltello");
        knife.setAka(new String[]{"arma", "lama"});
        knife.setDescription("Un semplice coltello. Potresti usarlo come arma");
        //TODO dmg coltello
        knife.setPickupable(true);
        this.addObject(knife);

        obj.setName("Ciondolo");
        obj.setDescription("Il ciondolo di tua madre. Risplende alla luce con la sua pietra preziosa. "
                + "Pensi possa valere qualcosa e che potrebbe tornarti utile");
        obj.setPickupable(true);
        this.addObject(obj);

        door.setName("Porta");
        door.setDescription("Porta di legno. Si affaccia proprio sulla piazza centrale del villaggio. Saperlo ti fa sentire importante. E' chiusa");
        ((Door)door).setDirection("n");
        ((Door)door).setOpen(false);
        this.addObject(door);

        this.addObject(mom);

        this.setMoney(2);
    }

    @Override
    public void talkTo(Player p, Stobj person){
        if (person.getName().equals("Mamma")){
            boolean poz= false;
            for (Stobj inv : p.getInventory()){
                if (inv.getName().equals("Pozione millecure")){
                    poz=true;
                    p.removeFromInventory(inv);
                }
            }
            if(poz==true){
               this.setMsg ("Dai la pozione dello sciamano a tua madre, gliela fai bere tutta d'un fiato e allo stremo delle forze si accascia sul letto in un sonno profondo.\n"
                        + "passano parecchie ore prima che si risvegli, ma la mattina del giorno dopo apre gli occhi ed è contenta di poterti riabbracciare.\nCe l'hai fatta, l'hai salvata.\nFine.");
            } else {
                this.setMsg(""); //TODO conversazione con la madre senza pozione
            }
        }

    }
    
    
}
