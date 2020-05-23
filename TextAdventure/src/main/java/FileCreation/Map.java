package FileCreation;

import RoomSet.*;
import ObjectSet.Stobj;
import ObjectSet.Door;
import java.io.Serializable;
import newpackage01.UI;


public class Map implements Serializable{
    private Room house = new House();
    private Room square = new RoomWDoor();
    private Room alchemshop = new AlchemShop();
    private Room blksmith = new BlackSmith();
    private Room ngate = new NorthGate();
    private Room fclearing= new ForestClearing();
    private Room fcliff= new Room("dirupo foresta","Il vento si fa più forte, e anche più fresco, la vegetazione si "
                                                    + "dirada e davanti a te scorgi un grosso dirupo che ti offre un panorma"
                                                    + " mozzafiato ma, non puoi continuare da qui." );
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
        house.setName("Casa");
        house.setDescription("È mattino, sei vicino a tua madre che, dolorante, "
                                       + "giace nel letto...non ha chiuso occhio tutta la notte. "
                                       + "Le dai un infuso di erbe sperando che riesca a dormire.\n" 
                                       + "Tuo padre è morto anni fa. Solo tu puoi fare qualcosa per salvarla.\n" 
                                       +"\n" +"Che vuoi fare?");
        house.setNextNorth(square);
        //house.setUi(ui);
      
        //Piazza centrale
        square.setName("Piazza");
        square.setDescription("Ti trovi davanti la piazza centrale del villaggio dove sei nato e cresciuto. Quanti ricordi...\\n\"\n" +
                "                                                          + \"\\n\" +\"Che vuoi fare?");
        door.setName("Porta");
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
        alchemshop.setName("Alchimista");
        alchemshop.setDescription("Ti ritrovi nel negozio del vecchio alchimista del villaggio. Vende delle pozioni "
                                                                    + "che potrebbero tornare utili durante la tua avventura.\n" + "Ti accoglie la gentile apprendista"
                                                                    + "\n" + "Che vuoi fare?");
        alchemshop.setEast(square);
        
        //Fabbro
        blksmith.setName("Fabbro");
        blksmith.setDescription("Sei nella piccola forgia del villaggio. Hai davanti un omone pelato, peloso e muscoloso "
                                                            + "che ti chiede come può esserti utile");
        blksmith.setWest(square);
        
        //Cancello nord
        ngate.setName("Cancello nord");
        ngate.setDescription("Ti avvicini al cancello a nord del villaggio. Sai che oltre quel cancello inizia la foresta.\n"
                                                     + "Per aprirlo hai bisogno di parlare con la guardia");
        ngate.setNextNorth(fclearing);
        ngate.setSouth(square);

        //radura nella foresta
        fclearing.setName("Radura foresta");
        fclearing.setDescription("La radura si dirama in diverse direzioni davanti a te,\n" 
                                                           +"dove vuoi andare?");
        fclearing.setNorth(forestend);
        fclearing.setEast(fcliff);
        fclearing.setSouth(ngate);
        fclearing.setWest(tolake);

        //dirupo est //TODO da rivedere
        obj = new Stobj();
        obj.setName("Frutto");
        obj.setDescription("Un frutto selvatico. E' piccolo ma sembra molto nutriente. Può essere mangiato ma sei sicuro di voler mangiare qualcosa raccolta trovata per terra?");
        obj.setPickupable(false);
        obj.setUsable(true);
        fcliff.addObject(obj);
        fcliff.setWest(fclearing);
        
        //sentiero verso il lago
        tolake.setName("Sentiero verso il lago");
        tolake.setDescription("");
        tolake.setEast(fclearing);
        tolake.setWest(wlake);
        
        //lago ovest
        wlake.setName("Lago nella foresta");
        wlake.setDescription(""); //TODO descrizione
        wlake.setWest(tolake);
        
        //Piedi della montagna (fine foresta)
        forestend.setNorth(mountstart);
        forestend.setSouth(fclearing);
        
        //davanti alla porta segreta sulla montagna
        mountstart.setName("Base della montagna");
        mountstart.setDescription("Sei su un'area poco più grande che ti ricorda un pianerottolo di qualche casa, "
                                   + "ma oltre al vento e la viva roccia, ad una prima occhiata, non noti nulla di particolare.\nChe vuoi fare?");
        mountstart.setNextNorth(fork);
        mountstart.setSouth(forestend);
        
        //bivio all'interno della montagna
        fork.setName("Bivio");
        fork.setDescription("La strada si dirama verso Est ed Ovest.\nDove vuoi andare?");
        fork.setNextWest(wlair);
        fork.setNextEast(storage);
        fork.setSouth(mountstart);
        
        //tana della viverna
        wlair.setName("Tana della viverna");
        wlair.setDescription("Sei nella tana della viverna che giace immobile a terra, non hai mai visto una viverna vera, "
                                                    + "ma dalle illustrazioni che hai visto nella tua vita, sai che non hanno gemme sul corpo");
        wlair.setEast(fork);
        
        //magazzino est dopo il bivio
        storage.setName("Magazzino");
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
        door.setName("Porta");
        door.setDescription("Una semplice porta di legno. E' chiusa");
        ((Door)door).setOpen(false);
        ((Door)door).setDirection("n");
        storage.addObject(door);
        door = new Door();
        //door.setName("Porta");
        door.setDescription("Una semplice porta di legno. E' aperta");
        ((Door)door).setOpen(true);
        ((Door)door).setDirection("w");
        storage.addObject(door);
        storage.setNextNorth(shamanroom);
        storage.setWest(fork);
        storage.setNextWest(fork);
        
        //stanza sciamano
        shamanroom.setName("Stanza dello Sciamano");
        shamanroom.setDescription("Sulla  parete Ovest, c'è un'immensa libreria, piena di libri e di appunti. \\n\" +\n" +
                                    "\"La parete Nord è sgombra, ma noti un piccolo incavo al centro di essa.\\n\" +\n" +
                                    "\"La parete Est invece è occupata da un'enorme scrivania alla quale, una figura siede incappucciata, di spalle.\"\n" +
                                    "+ \"che vuoi fare?");
        shamanroom.setNextNorth(closet);
        shamanroom.setSouth(storage);
        shamanroom.setNextSouth(storage);
        
        //stanzino nascosto dello sciamano
        closet.setName("Stanzino nascosto");
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
    
    public void setMap(Map m){
       this.setHouse(m.getHouse());
       this.setSquare(m.getSquare());
       this.setAlchemshop(m.getAlchemshop());
       this.setBlksmith(m.getBlksmith());
       this.setNgate(m.getNgate());
       this.setFclearing(m.getFclearing());
       this.setFcliff(m.getFcliff());
       this.setTolake(m.getTolake());
       this.setWlake(m.getWlake());
       this.setForestend(m.getForestend());
       this.setMountstart(m.getMountstart());
       this.setFork(m.getFork());
       this.setWlair(m.getWlair());
       this.setStorage(m.getStorage());
       this.setShamanroom(m.getShamanroom());
       this.setCloset(m.getCloset());
       this.setCurrentRoom(m.getCurrentRoom());
       this.setPreviousRoom(m.getPreviousRoom());
      
    }

    public Room getHouse() {
        return house;
    }

    public void setHouse(Room house) {
        this.house = house;
    }

    public Room getSquare() {
        return square;
    }

    public void setSquare(Room square) {
        this.square = square;
    }

    public Room getAlchemshop() {
        return alchemshop;
    }

    public void setAlchemshop(Room alchemshop) {
        this.alchemshop = alchemshop;
    }

    public Room getBlksmith() {
        return blksmith;
    }

    public void setBlksmith(Room blksmith) {
        this.blksmith = blksmith;
    }

    public Room getNgate() {
        return ngate;
    }

    public void setNgate(Room ngate) {
        this.ngate = ngate;
    }

    public Room getFclearing() {
        return fclearing;
    }

    public void setFclearing(Room fclearing) {
        this.fclearing = fclearing;
    }

    public Room getFcliff() {
        return fcliff;
    }

    public void setFcliff(Room fcliff) {
        this.fcliff = fcliff;
    }

    public Room getTolake() {
        return tolake;
    }

    public void setTolake(Room tolake) {
        this.tolake = tolake;
    }

    public Room getWlake() {
        return wlake;
    }

    public void setWlake(Room wlake) {
        this.wlake = wlake;
    }

    public Room getForestend() {
        return forestend;
    }

    public void setForestend(Room forestend) {
        this.forestend = forestend;
    }

    public Room getMountstart() {
        return mountstart;
    }

    public void setMountstart(Room mountstart) {
        this.mountstart = mountstart;
    }

    public Room getFork() {
        return fork;
    }

    public void setFork(Room fork) {
        this.fork = fork;
    }

    public Room getWlair() {
        return wlair;
    }

    public void setWlair(Room wlair) {
        this.wlair = wlair;
    }

    public Room getStorage() {
        return storage;
    }

    public void setStorage(Room storage) {
        this.storage = storage;
    }

    public Room getShamanroom() {
        return shamanroom;
    }

    public void setShamanroom(Room shamanroom) {
        this.shamanroom = shamanroom;
    }

    public Room getCloset() {
        return closet;
    }

    public void setCloset(Room closet) {
        this.closet = closet;
    }
    
    
}
