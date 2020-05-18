package FileCreation;

import RoomSet.*;
import ObjectSet.Stobj;
import ObjectSet.Door;
import java.io.Serializable;


public class Map implements Serializable{
    private Room house = new House();
    private Room square = new RoomWDoor();
    private Room alchemshop = new AlchemShop();
    private Room blksmith = new BlackSmith();
    private Room ngate = new NorthGate();
    private Room fclearing= new ForestClearing();
    private Room fcliff= new Room("dirupo foresta","Il vento si fa più forte, e anche più fresco, la vegetazione si "
                                                    + "dirada e davanti a te scorgi un grosso dirupo che ti offre un panorma"
                                                    + " mozzafiato ma, non puoi continuare da qui.");
    private Room tolake = new ToLake();
    private Room wlake = new WestLake();
    private Room forestend = new Room("piedi della montagna", ""); //TODO descrizione
    private Room mountstart = new MountStart();
    private Room fork = new MountFork();
    private Room wlair=new WyvernLair();
    private Room storage=new RoomWDoor();
    private Room shamanroom=new ShamanRoom();
    private Room closet=new ShamSecretRoom();

    private Room currentRoom = new Room();
    private Room previousRoom = new Room();
     
    public Map(){
        Stobj obj = new Stobj();
        Stobj door = new Door();
        //Creazione delle stanze e assegnazione degli oggetti interagibili
        
        //Casa
        house.setName("casa");
        house.setDescription("È mattino, sei vicino a tua madre che, dolorante, "
                                       + "giace nel letto...non ha chiuso occhio tutta la notte. "
                                       + "Le dai un infuso di erbe sperando che riesca a dormire.\n" 
                                       + "Tuo padre è morto anni fa. Solo tu puoi fare qualcosa per salvarla.\n" 
                                       +"\n" +"Che vuoi fare?");
        house.setNextNorth(square);
      
        //Piazza centrale
        square.setName("piazza");
        square.setDescription("Ti trovi davanti la piazza centrale del villaggio dove sei nato e cresciuto. Quanti ricordi...\\n\"\n" +
                "                                                          + \"\\n\" +\"Che vuoi fare?");
        door.setName("porta di legno");
        door.setDescription("E' la porta di casa tua. E' aperta");
        ((Door)door).setOpen(true);
        ((Door)door).setDirection("s");
        square.addObject(door);
        square.setNorth(ngate);
        square.setEast(blksmith);
        square.setSouth(house);
        square.setNextSouth(house);
        square.setWest(alchemshop);
        
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
        ngate.setNextNorth(fclearing);
        ngate.setSouth(square);

        //radura nella foresta
        fclearing.setName("radura foresta");
        fclearing.setDescription("La radura si dirama in diverse direzioni davanti a te,\n" 
                                                           +"dove vuoi andare?");
        fclearing.setNorth(forestend);
        fclearing.setEast(fcliff);
        fclearing.setSouth(ngate);
        fclearing.setWest(tolake);

        //dirupo est //TODO da rivedere
        obj = new Stobj();
        obj.setName("frutto");
        obj.setDescription("Un frutto selvatico. E' piccolo ma sembra molto nutriente. Può essere mangiato ma sei sicuro di voler mangiare qualcosa raccolta trovata per terra?");
        obj.setPickupable(false);
        obj.setUsable(true);
        fcliff.addObject(obj);
        fcliff.setWest(fclearing);
        
        //sentiero verso il lago
        tolake.setName("sentiero verso il lago");
        tolake.setDescription("");
        tolake.setEast(fclearing);
        tolake.setWest(wlake);
        
        //lago ovest
        wlake.setName("lago nella foresta");
        wlake.setDescription(""); //TODO descrizione
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
        fork.setNextWest(wlair);
        fork.setNextEast(storage);
        fork.setSouth(mountstart);
        
        //tana della viverna
        wlair.setName("tana della viverna");
        wlair.setDescription("Sei nella tana della viverna che giace immobile a terra, non hai mai visto una viverna vera, "
                                                    + "ma dalle illustrazioni che hai visto nella tua vita, sai che non hanno gemme sul corpo");
        wlair.setEast(fork);
        
        //magazzino est dopo il bivio
        storage.setName("magazzino");
        storage.setDescription("La stanza in cui sei ha un'altra porta sulla parete nord, oltre a quella da cui sei entrato.\\n\" +\n" +
                "                                                    \"Cosa vuoi fare?");
        obj = new Stobj();
        obj.setName("Pozione curativa");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("pozione curativa");
        obj.setPickupable(true);
        storage.addObject(obj);
        /*obj.setName("Pozione curativa");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("pozione curativa");
        obj.setPickupable(true);*/
        storage.addObject(obj); 
        storage.setMoney(30);
        door = new Door();
        door.setName("porta di legno");
        door.setDescription("Una semplice porta di legno. E' chiusa");
        ((Door)door).setOpen(false);
        ((Door)door).setDirection("n");
        storage.addObject(door);
        door = new Door();
        door.setName("porta di legno");
        door.setDescription("Una semplice porta di legno. E' aperta");
        ((Door)door).setOpen(true);
        ((Door)door).setDirection("w");
        storage.addObject(door);
        storage.setNextNorth(shamanroom);
        storage.setWest(fork);
        storage.setNextWest(fork);
        
        //stanza sciamano
        shamanroom.setName("stanza dello sciamano");
        shamanroom.setDescription("Sulla  parete Ovest, c'è un'immensa libreria, piena di libri e di appunti. \\n\" +\n" +
                                    "\"La parete Nord è sgombra, ma noti un piccolo incavo al centro di essa.\\n\" +\n" +
                                    "\"La parete Est invece è occupata da un'enorme scrivania alla quale, una figura siede incappucciata, di spalle.\"\n" +
                                    "+ \"che vuoi fare?");
        shamanroom.setNextNorth(closet);
        shamanroom.setSouth(storage);
        shamanroom.setNextSouth(storage);
        
        //stanzino nascosto dello sciamano
        closet.setName("stanzino nascosto");
        closet.setDescription("All'interno ci sono almeno una quindicina di mensole che partono dal basso, con ogni tipo di pozione meticolosamente conservate, "
                                                    + "che vanno da quelle d'amore a quelle velenose, ma i tuoi occhi si posano su una in particolare...");
        closet.setSouth(shamanroom);
        closet.setNextNorth(house);
    }

    public void setCurrentRoom(Room r){
        this.currentRoom = r;
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public void setPreviousRoom(Room r){
        this.previousRoom = r;
    }

    public Room getPreviousRoom(){
        return this.previousRoom;
    }
}
