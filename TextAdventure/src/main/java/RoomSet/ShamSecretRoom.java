package RoomSet;

import ObjectSet.Stobj;

public class ShamSecretRoom extends Room{ //TODO aggiungere interazione con la pozione. Solo se raccolta, si apre il portale per tornare alla piazza centrale
    
    public ShamSecretRoom(){
        Stobj obj = new Stobj();
        obj.setName("Pozione Millecure");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("leggendaria pozione Millecure, cura ogni male.");
        obj.setPickupable(true);
        this.addObject(obj);
    }

    public void getPotion(){
        System.out.println("");
        Stobj portal = new Stobj("Portale", "Descrizione portale");
        this.addObject(portal);
        this.setNorth(this.getNextNorth());
    }
    
}
