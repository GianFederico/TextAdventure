package FileCreation;

import RoomSet.*;
import ObjectSet.Stobj;
import java.util.List;
import java.util.ArrayList;

public class Map {
    private List<Room> map = new ArrayList<>();
    
    public Map(){
        List<Stobj> roomobjects = new ArrayList<>();
        Stobj obj = new Stobj();
        
        //Creazione delle stanze. Le direzioni vengono aggiunte in seguito...
        
        //Casa
        Room house = new Room("casa", "È mattino, sei vicino a tua madre che, dolorante, "
                                       + "giace nel letto...non ha chiuso occhio tutta la notte. "
                                       + "Le dai un infuso di erbe sperando che riesca a dormire.\n" 
                                       + "Tuo padre è morto anni fa. Solo tu puoi fare qualcosa per salvarla.\n" 
                                       +"\n" +"Che vuoi fare?");
        obj.setName("coltello");
        obj.setDescription("Un semplice coltello. Potresti usarlo come arma");
        obj.setPickupable(true);
        roomobjects.add(obj);
        obj.setName("ciondolo");
        obj.setDescription("Il ciondolo di tua madre. Risplende alla luce con la sua pietra preziosa. "
                                            + "Pensi possa valere qualcosa e che potrebbe tornarti utile");
        roomobjects.add(obj);
        obj.setName("porta");
        obj.setDescription("Porta di legno. Si affaccia proprio sulla piazza centrale del villaggio. Saperlo ti fa sentire importante");
        obj.setPickupable(false);
        obj.setOpenable(true);
        house.setMoney(2);
        house.setObject(roomobjects);
        this.map.add(house);
        roomobjects.removeAll(roomobjects);
       
        
        
        
        //Piazza centrale
        Room square = new Room("piazza", "Ti trovi davanti la piazza centrale del villaggio dove sei nato e cresciuto. Quanti ricordi...\n"
                                                         + "\n" +"Che vuoi fare?");
        this.map.add(square);
        
        
        
        //Negozio dell'alchimista
        AlchemShop alchemshop = new AlchemShop();
        alchemshop.setName("alchimista");
        alchemshop.setDescription("Ti ritrovi nel negozio del vecchio alchimista del villaggio. Vende delle pozioni "
                                                                    + "che potrebbero tornare utili durante la tua avventura.\n" + "Ti accoglie la gentile apprendista"
                                                                    + "\n" + "Che vuoi fare?");
        this.map.add(alchemshop);
        
        
        
        //Fabbro
        BlackSmith blksmith = new BlackSmith();
        blksmith.setName("fabbro");
        blksmith.setDescription("Sei nella piccola forgia del villaggio. Hai davanti un omone pelato, peloso e muscoloso "
                                                            + "che ti chiede come può esserti utile");
        obj.setName("spada lunga");
        obj.setAka(new String[]{"spada, arma"});
        obj.setDescription("Una spada lunga. Sicuramente più utile del coltello in combattimento. Costa 2 monete");
        obj.setOpenable(false);
        roomobjects.add(obj);
        obj.setName("armatura di cuoio");
        obj.setAka(new String[]{"armatura, indumento, vestito, indumenti, vestiti"});
        obj.setDescription("Un'armatura di cuoio. Più resistente dei vestiti che indossi. Costa 2 monete");
        roomobjects.add(obj);
        blksmith.setObject(roomobjects);
        this.map.add(blksmith);
        roomobjects.removeAll(roomobjects);

        
        
        //Cancello nord
        Room ngate = new Room("cancello nord", "Ti avvicini al cancello a nord del villaggio. Sai che oltre quel cancello inizia la foresta.\n"
                                                     + "Ti ferma una guardia");
        this.map.add(ngate);
            
        
        
        //radura nella foresta
        Room fclearing= new Room("radura foresta","La radura si dirama in diverse direzioni davanti a te,\n" 
                                                           +"dove vuoi andare?");
        this.map.add(fclearing);
              
        
         //dirupo est
        Room fcliff= new Room("dirupo foresta","Il vento si fa più forte, e anche più fresco, la vegetazione si "
                                                    + "dirada e davanti a te scorgi un grosso dirupo che ti offre un panorma"
                                                    + " mozzafiato ma, non puoi continuare da qui.");
        this.map.add(fcliff);
        
        
        //lago ovest  [descrizione da fare]
        Room nlake= new Room("lago foresta","");
        obj.setName("consiglio ninfa"); //usable?
        obj.setAka(new String[]{"consiglio","appunto"});
        obj.setDescription("Il consiglio che la ninfa ti ha dato.\"tira la leva destra.\"");
        obj.setPickupable(true);
        roomobjects.add(obj);
        nlake.setObject(roomobjects);
        this.map.add(nlake);
        obj.setPickupable(true);
        roomobjects.removeAll(roomobjects);
        
        
        //davanti alla porta segreta sulla montagna
        Room sdoor = new Room("area rocciosa montagna","Sei su un'area poco più grande che ti ricorda un pianerottolo di qualche casa, "
                                                        + "ma oltre al vento e la viva roccia, ad una prima occhiata, non noti nulla di particolare.\nChe vuoi fare?");
        obj.setName("leva sinistra");
        obj.setDescription("leva alla tua sinistra");
        obj.setPushable(true);
        roomobjects.add(obj);
        obj.setName("leva destra");
        obj.setDescription("leva alla tua destra");
        roomobjects.add(obj); 
        this.map.add(sdoor);
        obj.setPushable(false);
        roomobjects.removeAll(roomobjects);
        
        
        //bivio all'interno della montagna
        Room fork= new Room("bivio","La strada si dirama verso Est ed Ovest.\nDove vuoi andare?");
        obj.setName("porta");
        obj.setDescription("porta in legno");
        obj.setOpenable(true);
        roomobjects.add(obj); 
        this.map.add(fork);
        obj.setOpenable(false);
        roomobjects.removeAll(roomobjects);
        
        
        //muro con indovinello
        Room rwall= new Room("indovinello sul muro","Pronuncia la soluzione, ed io mi aprirò. \n" 
                                                    +"Non è un'isola, ma è sempre in mezzo all'acqua\"\n" +"\n" +"Hai in mente una soluzione?");
        obj.setName("Muro con enigma");
        obj.setAka(new String[]{"muro","enigma","indovinello"});
        obj.setDescription("Il muro recita:\"Non è un'isola, ma è sempre in mezzo all'acqua\"");
        obj.setPushable(true);
        roomobjects.add(obj); 
        this.map.add(rwall);
        obj.setPushable(false);
        roomobjects.removeAll(roomobjects);
        
        //tana della viverna
        Room wlair=new Room("tana viverna","Sei nella tana della viverna che giace immobile a terra, non hai mai visto una viverna vera, "
                                                    + "ma dalle illustrazioni che hai visto nella tua vita, sai che non hanno gemme sul corpo");
        obj.setName("Gemma viverna");
        obj.setAka(new String[]{"gemma","pietra"});
        obj.setDescription("Gemma rimossa dal cranio della viverna");
        obj.setPickupable(true);
        roomobjects.add(obj); 
        this.map.add(wlair);
        obj.setPickupable(false);
        roomobjects.removeAll(roomobjects);
        
        
        //magazzino est dopo il bivio 
        Room storage=new Room("magazzino","La stanza in cui sei ha un'altra porta sulla parete nord, oltre a quella da cui sei entrato.\n" +
                                                    "Cosa vuoi fare?");
        obj.setName("Pozione curativa");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("pozione curativa");
        obj.setPickupable(true);
        roomobjects.add(obj);
        obj.setName("Pozione curativa");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("pozione curativa");
        obj.setPickupable(true);
        roomobjects.add(obj); 
        storage.setMoney(30);
        obj.setPickupable(false);
        obj.setName("porta");
        obj.setDescription("porta in legno dal bivio");
        obj.setOpenable(true);
        roomobjects.add(obj);
        obj.setName("porta");
        obj.setDescription("porta in legno verso nord");
        roomobjects.add(obj); 
        this.map.add(storage);
        roomobjects.removeAll(roomobjects);
        obj.setOpenable(false);
        
        
        //stanza sciamano
        Room shroom=new Room("stanza dello sciamano","Sulla  parete Ovest, c'è un'immensa libreria, piena di libri e di appunti. \n" +
                                                        "La parete Nord è sgombra, ma noti un piccolo incavo al centro di essa.\n" +
                                                        "La parete Est invece è occupata da un'enorme scrivania alla quale, una figura siede incappucciata, di spalle."
                                                        + "che vuoi fare?"); //deve fare "osserva parete nord\est\ovest"  invece "che vai a nord\est\ovest"
        this.map.add(shroom);

        
        
        //stanzino nascosto dello sciamano
        Room closet=new Room("stanzino nascosto","All'interno ci sono almeno una quindicina di mensole che partono dal basso, con ogni tipo di pozione meticolosamente conservate, "
                                                    + "che vanno da quelle d'amore a quelle velenose, ma i tuoi occhi si posano su una in particolare...");
        obj.setName("Pozione Millecure");
        obj.setAka(new String[]{"pozione di cura","pozione"});
        obj.setDescription("leggendaria pozione Millecure, cura ogni male.");
        obj.setPickupable(true);
        roomobjects.add(obj);
        this.map.add(closet);
        roomobjects.removeAll(roomobjects);
        obj.setPickupable(false);


        
 //collegamenti fra stanze:
        house.setNorth(square);

        square.setNorth(ngate);
        square.setEast(alchemshop);
        square.setSouth(blksmith);
        square.setWest(house);
        
        alchemshop.setEast(square);
        
        blksmith.setWest(square);
        
        ngate.setNorth(fclearing);
        ngate.setSouth(square);
        
        fclearing.setNorth(sdoor);
        fclearing.setEast(fcliff);
        fclearing.setSouth(ngate);//????
        fclearing.setWest(nlake);

        fcliff.setEast(fclearing);
        
        nlake.setWest(fclearing);
        
        sdoor.setNorth(square);
        sdoor.setSouth(fclearing);
        
        fork.setEast(rwall);
        fork.setWest(storage);   

        rwall.setEast(wlair);
        rwall.setWest(fork);  

        wlair.setWest(fork);  

        storage.setNorth(shroom);
        storage.setWest(fork);
        
        shroom.setNorth(square);
        shroom.setSouth(storage);

        closet.setSouth(shroom);

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
