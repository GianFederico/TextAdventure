package FileCreation;

import RoomSet.*;
import ObjectSet.Stobj;
import ObjectSet.Weapon;
import ObjectSet.Door;


public class Map {
    public Room house = new House(); //va messo private
    private Room square = new Room("piazza", "Ti trovi davanti la piazza centrale del villaggio dove sei nato e cresciuto. Quanti ricordi...\n"
                                                          + "\n" +"Che vuoi fare?");
    private Room alchemshop = new AlchemShop();
    private Room blksmith = new BlackSmith();
    private Room ngate = new NorthGate();
    private Room fclearing= new ForestClearing();
    private Room fcliff= new Room("dirupo foresta","Il vento si fa più forte, e anche più fresco, la vegetazione si "
                                                    + "dirada e davanti a te scorgi un grosso dirupo che ti offre un panorma"
                                                    + " mozzafiato ma, non puoi continuare da qui.");
    private Room tolake = new ToLake();
    private Room wlake = new WestLake();
    private Room forestend = new Room("piedi della monstagna", "TODO");
    private Room mountstart = new MountStart();
    private Room fork = new MountFork();
    private Room wlair=new WyvernLair();
    private Room storage=new Room("magazzino","La stanza in cui sei ha un'altra porta sulla parete nord, oltre a quella da cui sei entrato.\n" +
                                                    "Cosa vuoi fare?");
    private Room shroom=new Room("stanza dello sciamano","Sulla  parete Ovest, c'è un'immensa libreria, piena di libri e di appunti. \n" +
                                                        "La parete Nord è sgombra, ma noti un piccolo incavo al centro di essa.\n" +
                                                        "La parete Est invece è occupata da un'enorme scrivania alla quale, una figura siede incappucciata, di spalle."
                                                        + "che vuoi fare?"); //deve fare "osserva parete nord\est\ovest"  invece "che vai a nord\est\ovest"
    private Room closet=new ShamSecretRoom();
     
    public Map(){
        Stobj obj = new Stobj();
        Stobj knife = new Weapon();
        Stobj door = new Door();
        //Creazione delle stanze e assegnazione degli oggetti interagibili
        
        //Casa
        house.setName("casa");
        house.setDescription("È mattino, sei vicino a tua madre che, dolorante, "
                                       + "giace nel letto...non ha chiuso occhio tutta la notte. "
                                       + "Le dai un infuso di erbe sperando che riesca a dormire.\n" 
                                       + "Tuo padre è morto anni fa. Solo tu puoi fare qualcosa per salvarla.\n" 
                                       +"\n" +"Che vuoi fare?");
        knife.setName("coltello");
        knife.setDescription("Un semplice coltello. Potresti usarlo come arma");
        knife.setPickupable(true);
        house.addObject(knife);
        obj.setName("ciondolo");
        obj.setDescription("Il ciondolo di tua madre. Risplende alla luce con la sua pietra preziosa. "
                                            + "Pensi possa valere qualcosa e che potrebbe tornarti utile");
        house.addObject(obj);
        door.setName("porta");
        door.setDescription("Porta di legno. Si affaccia proprio sulla piazza centrale del villaggio. Saperlo ti fa sentire importante. E' chiusa");
        ((Door)door).setDirection("N");
        door.setPickupable(false);
        door.setOpenable(true);
        house.setMoney(2);
        house.addObject(door);
        house.setNextNorth(square);
      
        //Piazza centrale
        square.setNorth(ngate);
        square.setEast(alchemshop);
        square.setSouth(blksmith);
        square.setWest(house);
        
        //Negozio dell'alchimista
        alchemshop.setName("alchimista");
        alchemshop.setDescription("Ti ritrovi nel negozio del vecchio alchimista del villaggio. Vende delle pozioni "
                                                                    + "che potrebbero tornare utili durante la tua avventura.\n" + "Ti accoglie la gentile apprendista"
                                                                    + "\n" + "Che vuoi fare?");
        alchemshop.setEast(square);
        
        //Fabbro
        blksmith.setName("fabbro");
        blksmith.setDescription("Sei nella piccola forgia del villaggio. Hai davanti un omone pelato, peloso e muscoloso "
                                                            + "che ti chiede come può esserti utile");
        blksmith.setWest(square);
        
        //Cancello nord
        ngate.setName("cancello nord");
        ngate.setDescription("Ti avvicini al cancello a nord del villaggio. Sai che oltre quel cancello inizia la foresta.\n"
                                                     + "Per aprirlo hai bisogno di parlare con la guardia");
        ngate.setNorth(fclearing);
        ngate.setSouth(square);

        //radura nella foresta
        fclearing.setName("radura foresta");
        fclearing.setDescription("La radura si dirama in diverse direzioni davanti a te,\n" 
                                                           +"dove vuoi andare?");
        fclearing.setNextNorth(forestend);
        fclearing.setNextEast(fcliff);
        fclearing.setSouth(ngate);
        fclearing.setNextWest(wlake);

        //dirupo est
        obj = new Stobj();
        obj.setName("frutto");
        obj.setDescription("Un frutto selvatico. E' piccolo ma sembra molto nutriente. Può essere mangiato ma sei sicuro di voler mangiare qualcosa raccolta trovata per terra?");
        obj.setPickupable(false);
        obj.setUsable(true);
        fcliff.addObject(obj);
        fcliff.setEast(fclearing);
        
        //sentiero verso il lago
        tolake.setName("sentiero verso il lago");
        tolake.setDescription("");
        tolake.setEast(fclearing);
        tolake.setNextWest(wlake);
        
        //lago ovest  [descrizione da fare]
        wlake.setName("lago nella foresta");
        wlake.setDescription("");
        wlake.setWest(tolake);
        
        //Piedi della montagna (fine foresta)
        forestend.setNorth(mountstart);
        forestend.setSouth(fclearing);
        
        //davanti alla porta segreta sulla montagna
        mountstart.setName("base della montagna");
        mountstart.setDescription("Sei su un'area poco più grande che ti ricorda un pianerottolo di qualche casa, "
                                   + "ma oltre al vento e la viva roccia, ad una prima occhiata, non noti nulla di particolare.\nChe vuoi fare?");
        mountstart.setNextNorth(fork);
        mountstart.setSouth(forestend);
        
        //bivio all'interno della montagna
        fork.setName("bivio");
        fork.setDescription("La strada si dirama verso Est ed Ovest.\nDove vuoi andare?");
        obj = new Stobj();
        obj.setName("Muro con enigma");
        obj.setAka(new String[]{"muro","enigma","indovinello"});
        obj.setDescription("Il muro ha una scritt a che recita:\"Non è un'isola, ma è sempre in mezzo all'acqua\". Sembra che voglia una risposta per aprirsi");
        obj.setPushable(true);
        door.setDescription("Porta di legno. E' chiusa");
        ((Door)door).setDirection("E");
        fork.addObject(door);
        fork.addObject(obj);
        fork.setNextWest(wlair);
        fork.setNextEast(storage);
        //fork.setWest(rwall);   
        fork.setSouth(mountstart);
        
        //tana della viverna
        wlair.setName("tana della viverna");
        wlair.setDescription("Sei nella tana della viverna che giace immobile a terra, non hai mai visto una viverna vera, "
                                                    + "ma dalle illustrazioni che hai visto nella tua vita, sai che non hanno gemme sul corpo");
        obj = new Stobj();
        obj.setName("Gemma viverna");
        obj.setAka(new String[]{"gemma","pietra"});
        obj.setDescription("Gemma rimossa dal cranio della viverna");
        obj.setPickupable(true);
        obj.setVisible(false);
        wlair.addObject(obj);
        wlair.setEast(fork);  
        
        //magazzino est dopo il bivio 
        obj = new Stobj();
        obj.setName("Pozione curativa");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("pozione curativa");
        obj.setPickupable(true);
        storage.addObject(obj);
        obj.setName("Pozione curativa");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("pozione curativa");
        obj.setPickupable(true);
        storage.addObject(obj); 
        storage.setMoney(30);
        obj.setPickupable(false);
        obj.setName("porta");
        obj.setDescription("porta in legno dal bivio");
        obj.setOpenable(true);
        storage.addObject(obj);
        obj.setName("porta");
        obj.setDescription("porta in legno verso nord");
        storage.addObject(obj); 
        obj.setOpenable(false);
        storage.setNorth(shroom);
        storage.setWest(fork);
        
        //stanza sciamano
        shroom.setNextNorth(closet);
        shroom.setSouth(storage);
        
        //stanzino nascosto dello sciamano
        closet.setName("stanzino nascosto");
        closet.setDescription("All'interno ci sono almeno una quindicina di mensole che partono dal basso, con ogni tipo di pozione meticolosamente conservate, "
                                                    + "che vanno da quelle d'amore a quelle velenose, ma i tuoi occhi si posano su una in particolare...");
        obj = new Stobj();
        obj.setName("Pozione Millecure");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("leggendaria pozione Millecure, cura ogni male.");
        obj.setPickupable(true);
        closet.addObject(obj);
        obj.setPickupable(false);
        closet.setSouth(shroom);
        closet.setEast(house);
    }
}
