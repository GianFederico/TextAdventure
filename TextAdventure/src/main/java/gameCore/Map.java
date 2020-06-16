/**
 * Classe utile alla definizione della mappa di gioco
 */
package gameCore;

import objectSet.Potion;
import roomSet.*;
import base.Stobj;
import objectSet.Door;
import java.io.Serializable;
import base.Room;
import monsterSet.*;


public class Map implements Serializable{
    private Room house = new House();
    private Room square = new RoomWDoor();
    private Room alchemshop = new AlchemShop();
    private Room blksmith = new BlackSmith();
    private Room ngate = new NorthGate();
    private Room fclearing= new Room();
    private Room fcliff= new Room();
    private Room tolake = new Room();
    private Room wlake = new WestLake();
    private Room mountbase = new Room();
    private Room mountstart = new MountStart();
    private Room fork = new MountFork();
    private Room wlair=new Room();
    private Room storage=new RoomWDoor();
    private Room shamanroom=new ShamanRoom();
    private Room closet=new ShamSecretRoom();

    private Room currentRoom = new Room();
    private Room previousRoom = null;
     
    /**
     * Costruzione della mappa di gioco
     */
    public Map(){
        Stobj obj = new Stobj();
        Door door = new Door();
        //Creazione delle stanze e assegnazione degli oggetti interagibili
        
        //Casa
        house.setName("Casa");
        house.setDescription("Sei nella casa dove sei cresciuto. E' molto umile ma è la casa tenuta meglio nell'intero\nvillaggio. C'è silenzio a parte per i lamenti smorzati di tua mamma.");
        house.setNextNorth(square);
      
        //Piazza centrale
        square.setName("Piazza");
        square.setDescription("Ti trovi nella piazza centrale del villaggio dove sei nato e cresciuto. Quanti ricordi...\n");
        door.setName("Porta");
        door.setDescription("E' la porta di casa tua. E' aperta");
        door.setOpen(true);
        door.setDirection("s");
        square.addObject(door);
        square.setNorth(ngate);
        square.setEast(blksmith);
        square.setSouth(house);
        square.setNextSouth(house);
        square.setWest(alchemshop);
        
        //Negozio dell'alchimista
        alchemshop.setName("Alchimista");
        alchemshop.setDescription("Ti ritrovi nel negozio del vecchio alchimista del villaggio.\nVende delle pozioni che potrebbero tornare utili durante la tua avventura.\nTi accoglie la gentile apprendista.");
        alchemshop.setEast(square);
        
        //Fabbro
        blksmith.setName("Fabbro");
        blksmith.setDescription("Sei nella piccola forgia del villaggio. Hai davanti un omone pelato, peloso e muscoloso\nche ti chiede come può esserti utile.");

        blksmith.setWest(square);
        
        //Cancello nord
        ngate.setName("Cancello nord");
        ngate.setDescription("Ti avvicini al cancello a nord del villaggio.\nSai che oltre quel cancello inizia la foresta.\nPer aprirlo hai bisogno di parlare con la guardia.");

        ngate.setNextNorth(fclearing);
        ngate.setSouth(square);

        //radura nella foresta
        fclearing.setName("Radura nella foresta");
        fclearing.setDescription("La radura si dirama in diverse direzioni davanti a te.");
        fclearing.setMonster(new Monster_Lupo());
        fclearing.setNorth(mountbase);
        fclearing.setEast(fcliff);
        fclearing.setSouth(ngate);
        fclearing.setWest(tolake);

        //dirupo est
        obj.setName("Frutto");
        obj.setDescription("Un frutto selvatico. E' piccolo ma sembra molto nutriente.\nPuò essere mangiato. Sei sicuro di voler mangiare qualcosa raccolta trovata per terra?");
        obj.setPickupable(true);
        obj.setUsable(true);
        fcliff.setName("Dirupo nella foresta");
        fcliff.setDescription("Il vento si fa più forte e più fresco e la vegetazione si dirada." +
                                "\nDavanti a te scorgi un grosso dirupo che ti offre un panorama mozzafiato" +
                                "\nma non puoi continuare da qui.");
        fcliff.setMoney(2);
        fcliff.addObject(obj);
        fcliff.setWest(fclearing);
        
        //sentiero verso il lago
        tolake.setName("Sentiero verso il lago");
        tolake.setDescription("Sai che proseguendo in questa direzione raggiungerai il lago.\nVoci dicono che sia la dimora di una ninfa. Potrebbe aiutarti...?");
        tolake.setMonster(new Monster_Ciclope());
        tolake.setEast(fclearing);
        tolake.setWest(wlake);
        
        //lago ovest
        wlake.setName("Lago nella foresta");
        wlake.setDescription("Davanti a te si estende un modesto laghetto che ti infonde serenità.\nL'acqua è limpida e resti sorpreso dagli ammalianti colori della vegetazione.");
        wlake.setEast(tolake);
        
        //Piedi della montagna (fine foresta)
        mountbase.setName("Base della montagna");
        mountbase.setDescription("Vedi la foresta diradarsi per lasciare spazio ad un enorme montagna.");
        mountbase.setNorth(mountstart);
        mountbase.setSouth(fclearing);
        
        //davanti alla porta segreta sulla montagna
        mountstart.setName("Sentiero sul fianco della montagna");
        mountstart.setDescription("Proseguendo, ti ritrovi su un'area rocciosa poco più grande di un pianerottolo di una casa."
                                   + "\nIl sentiero è bloccato da una frana e davanti a te vedi due strane leve sospette.");
        mountstart.setNextNorth(fork);
        mountstart.setSouth(mountbase);
        
        //bivio all'interno della montagna
        fork.setName("Entrata nella montagna");
        fork.setDescription("Sei all'entrata di una strana caverna nella montagna.\nCapisci che è stata abitata ma adesso sembra abbandonata. La strada prosegue verso est.\nAd ovest c'è solo un muro...");
        fork.setNextWest(wlair);
        fork.setNextEast(storage);
        fork.setSouth(mountstart);
        
        //tana della viverna
        wlair.setName("Tana della viverna");
        wlair.setDescription("Sei nella tana dove la viverna era in letargo. Una caverna spaziosa e ben riscaldata!");
        wlair.setMonster(new Monster_Viverna());
        wlair.setEast(fork);
        
        //magazzino est dopo il bivio
        storage.setName("Magazzino");
        storage.setDescription("Sei in una stanza che sembra essere dove lo sciamano conserva le sue cianfrusaglie.");
        Stobj potion = new Potion();
        potion.setName("Pozione");
        potion.setAlias(new String[]{"cura"});
        potion.setDescription("Pozione curativa. Apparteneva allo sciamano. Sei un ladro...");
        potion.setPickupable(true);
        potion.setUsable(true);
        storage.addObject(potion);
        storage.addObject(potion);
        storage.setMoney(21);
        door = new Door();
        door.setName("Porta");
        door.setDescription("Una semplice porta di legno. E' chiusa");
        door.setOpen(false);
        door.setDirection("n");
        storage.addObject(door);
        door = new Door();
        door.setName("Porta");
        door.setDescription("Una semplice porta di legno. E' aperta");
        door.setOpen(true);
        door.setDirection("w");
        storage.addObject(door);
        storage.setNextNorth(shamanroom);
        storage.setWest(fork);
        storage.setNextWest(fork);
        
        //stanza sciamano
        shamanroom.setName("Stanza dello Sciamano");
        shamanroom.setDescription("Sei nella stanza in cui viveva lo sciamano in completo isolamento.\nSulla  parete sinistra, c'è un'immensa libreria, piena di libri e di appunti.\n" +
                                    "La parete davanti a te è sgombra, ma noti un piccolo incavo al centro di essa.\n" +
                                    "La parete destra invece è occupata da un'enorme scrivania alla quale è seduta\nuna figura incappucciata che ti porge le spalle.");
        shamanroom.setNextNorth(closet);
        shamanroom.setSouth(storage);
        shamanroom.setNextSouth(storage);
        
        //stanzino nascosto dello sciamano
        closet.setName("Stanzino nascosto");
        closet.setDescription("Sei nello stanzino segreto dello sciamano.\nChissà quali cose losche avvenivano qui dentro...\n" +
                                "All'interno ci sono almeno una quindicina di mensole che partono dal basso,\ncon ogni tipo di pozione meticolosamente conservate.\n"
                                + "Leggi etichette che vanno da \"amore\" a \"veleno\",\nma il tuo interesse cade su una in particolare:\n" +
                                "\"Pozione millecure\", è proprio quel che cercavi!");
        closet.setSouth(shamanroom);
        closet.setNextNorth(house);

        this.setCurrentRoom(house);
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
    
    /**
     * Riempimento della mappa a partire da una mappa esistente
     * @param m 
     */
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
       this.setMountbase(m.getMountbase());
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

    public Room getMountbase() {
        return mountbase;
    }

    public void setMountbase(Room forestend) {
        this.mountbase = forestend;
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

    /**
     * Spostamento alla stanza precedente
     */
    public void back(){
        Room tmp = this.getCurrentRoom();
        this.setCurrentRoom(this.getPreviousRoom());
        this.setPreviousRoom(tmp);
    }
    
}
