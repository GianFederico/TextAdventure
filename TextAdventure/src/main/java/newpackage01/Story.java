package newpackage01;

import FileCreation.Map;
import ObjectSet.Stobj;
import RoomSet.Room;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import newpackage03.SuperMonster;
import parser.ParserOut;

public class Story {
    VisibilityManager vm;

   
    public Story(){
       
    }
    
     public void defaultSetup(Player p, UI ui, String inventoryStatus ){
    //parametri iniziali prima di iniziare il gioco, o dopo che muori
        //game.player.setCurrentHp(10);
        ui.hpNumberLable.setText(""+p.getCurrentHp() + "/" + p.getTotHp());
        p.setWeapon(null);
        ui.weaponNameLabel.setText(""); 
        inventoryStatus="close";
        
        
 
    }
    
   /* public void selectPosition [-->nextMove] (String nextPosition --> ParserOut par){           //questi saranno tutti i possibili case
        switch(nextPosition --> par.getCommand()){
            case "storyBegins": storyBegins();
            break;
            
            case "parlaGuardia": parlaGuardia();
            break;
            
            case "vaiVia": vaiVia();
            break;
            
            case "dormi": dormi();
            break;
            
            case "guardaCielo": guardaCielo();
            break;
            
        }
    }
    

   /* public void storyBegins(){
       prepareText();  
       ui.text=map.house.getDescription();

        /*
        ui.choice1.setText("Parla con qualcuno");               //questi vanno tutti rimossi e lasciato solo un panel che aspetta la stringa input dell'utente
        ui.choice2.setText("Va via");
        ui.choice3.setText("Dormi per terra");
        ui.choice4.setText("Guarda il cielo");

    
        
        game.nextPosition1 = "parlaGuardia";                    //questi sono parametri per ogni pulsante, anche questi vanno rimossi
        game.nextPosition2 = "vaiVia";                          //quandoo vengono cliccati i pulsanti, restituiscono quel valore che poi va nello switch
        game.nextPosition3 = "dormi";
        game.nextPosition4 = "guardaCielo";
    }

    
    
    
    public void parlaGuardia(){
        prepareText();   
       if (silverRing==0){
       ui.text="Ciao, io sono Dio,\nmi dispiace ma questo non e' il tuo posto, devo rimandarti indietro"; 
       */
        
       /* ui.choice1.setText("indietro");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

    
        game.nextPosition1 = "storyBegins";               
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
        else if(silverRing>0){
           ending();
        }
    }
    public void vaiVia(){
        prepareText();   ui.text="Dove vorresti andare?"; 

        
       /* ui.choice1.setText("nord");               
        ui.choice2.setText("est");
        ui.choice3.setText("rimani a sud");
        ui.choice4.setText("ovest");

    
        game.nextPosition1 = "nord";                    
        game.nextPosition2 = "est";
        game.nextPosition3 = "storyBegins";
        game.nextPosition4 = "ovest";    
    }
    
    public void dormi(){
        prepareText();   
        ui.text="Proprio mentre stai per addormentarti, senti puzza di bruciato\n è la tua veste! dei bambini poco raccomandabili gli hanno dato fuoco,"
                + " per spegnarla ricevi 2danni!"; 
        player.setHp(player.getHp()-2);
        ui.hpNumberLable.setText(""+ player.getHp());
        
       /* ui.choice1.setText("indietro");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

    
        game.nextPosition1 = "storyBegins";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
        
    }
    public void guardaCielo(){
        prepareText();   
        ui.text="Il cielo è sgombro da nuvole, e le ore del tramonto gli danno un perfetto color salmone.\n ti senti rincuorato"
                 + "e questo panorama ti rinvigorisce, guadagni 1hp"; 
        player.setHp(player.getHp()+1);
        ui.hpNumberLable.setText(""+ player.getHp());
        
        /*ui.choice1.setText("indietro");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

    
        game.nextPosition1 = "storyBegins";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
        
    }
    
    public void toTitle(){
        prepareText();//?   
        defaultSetup();
        vm.showTitleScreen();
        
    }*/

 //==============================================================ACTUAL STORY============================================================================     
    public void prepareText(UI ui ){
        ui.i=0;                                               //setta i=0 per il timer
        ui.mainTextArea.setText("");       //cancella il testo precedente
        ui.timer.start();                              //fa partire il timer
    }


    public void nextMove(ParserOut par, Player p, Map map, UI ui){
        if (par.getCommand() == null) {
            prepareText(ui);
            ui.setText("Comando non riconosciuto");
        } else {
            boolean noroom = false;
            boolean move = false;
            //Se non è presente un mostro le azioni sono effettuabili, altrimenti è necessario prima sconfiggerlo
            if (map.getCurrentRoom().getMonster()!=null) {

                //Inserimento "nord" (o simili)
                if (par.getCommand().getName().equals("nord")) {
                    if (map.getCurrentRoom().getNorth() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getNorth());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "sud" (o simili)
                if (par.getCommand().getName().equals("sud")) {
                    if (map.getCurrentRoom().getSouth() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getSouth());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "est" (o simili)
                if (par.getCommand().getName().equals("est")) {
                    if (map.getCurrentRoom().getEast() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getEast());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "ovest" (o simili)
                if (par.getCommand().getName().equals("ovest")) {
                    if (map.getCurrentRoom().getWest() != null) {
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(map.getCurrentRoom().getWest());
                        move = true;
                    } else {
                        noroom = true;
                    }
                }

                //Inserimento "osserva" o simili
                if (par.getCommand().getName().equals("osserva")) {
                    if (par.getObject() == null) {
                        prepareText(ui);
                        ui.setText(map.getCurrentRoom().getDescription());
                        if (map.getCurrentRoom().getObjects().size() > 0) {
                            int i = 0;
                            ui.setText("Cio' con cui puoi interagire in questo luogo: ");
                            for (Stobj robj : map.getCurrentRoom().getObjects()) {
                                if (robj.isVisible()) {
                                    ui.setText(i++ + robj.getName());
                                }
                            }
                        }
                        if (map.getCurrentRoom().getMoney() > 0) {
                            ui.setText("Ci sono" + map.getCurrentRoom().getMoney() + "monete. Le raccogli istintivamente. Sarà cleptomania?");
                            p.setMoney(p.getMoney() + map.getCurrentRoom().getMoney());
                            map.getCurrentRoom().setMoney(0);
                        }
                    } else if (par.getObject() != null && par.getObject().isVisible()) {
                        int k = -1;
                        for (int i = 0; i < map.getCurrentRoom().getObjects().size() || k==-1; i++) {
                            if (map.getCurrentRoom().getObjects().get(i).getName().equals(par.getObject().getName())) {
                                k = i;
                            }
                        }
                        if (k>-1){
                            prepareText(ui);
                            ui.setText(map.getCurrentRoom().getObjects().get(k).getDescription());
                        } else {
                            for (int i = 0; i < p.getInventory().size() || k==-1; i++) {
                                if (p.getInventory().get(i).getName().equals(par.getObject().getName())) {
                                    k = i;
                                }
                            }
                            prepareText(ui);
                            ui.setText(map.getCurrentRoom().getObjects().get(k).getDescription());
                        }
                    }
                }

                //Inserimento "raccogli" o simili
                if (par.getCommand().getName().equals("raccogli")) {
                    if (par.getObject() == null) {
                        prepareText(ui);
                        ui.setText("Non ho capito cosa vorresti raccogliere. Specifica cosa raccogliere");
                    } else {
                        //boolean po = false;
                        for (Stobj robj : map.getCurrentRoom().getObjects()) {
                            if (robj.getName().equals(par.getObject().getName())) {
                                //po = true;
                                if (robj.isPickupable()) {
                                    p.addToInventory(robj);
                                    prepareText(ui);
                                    ui.setText(robj.getName() + " aggiunto al tuo inventario");
                                    map.getCurrentRoom().getObjects().remove(robj);
                                } else {
                                    prepareText(ui);
                                    ui.setText("Non puoi raccogliere questo oggetto");
                                }
                            }
                            //if (!po){
                            //    ui.setText("L'oggetto inserito non esiste in questo luogo");
                            //}
                        }
                    }
                }

                //Inserimento "premi" o simili SOLO per l'attivazione delle leve
                if (par.getCommand().getName().equals("premi")) {
                    if (par.getObject() != null) {
                        if (par.getObject().getName().equals("Leva destra") || par.getObject().getName().equals("Leva sinistra")){
                            map.getCurrentRoom().activate(par.getObject(), p);
                            if (!map.getCurrentRoom().equals(p.getCurrentRoom())) {
                                map.setPreviousRoom(map.getCurrentRoom());
                                map.setCurrentRoom(p.getCurrentRoom());
                                move = true;
                            }
                        }
                    } else {
                        prepareText(ui);
                        ui.setText("Specifica con cosa vorresti interagire");
                    }
                }

                //Inserimento "apri" o simili (vale solo per le porte)
                if (par.getCommand().getName().equals("apri")) {
                    if (par.getObject() != null) {
                        if (par.getObject().getName().equals("Porta")) {
                            map.getCurrentRoom().openDoor(ui);
                        }
                    } else {
                        prepareText(ui);
                        ui.setText("L'oggetto a cui ti riferisci non esiste, non è apribile o lo hai scritto in modo incorretto");
                    }
                }

                //Inserimento "chiudi" o simili (vale solo per le porte)
                if (par.getCommand().getName().equals("chiudi")) {
                    if (par.getObject() != null) {
                        if (par.getObject().getName().equals("Porta")) {
                            map.getCurrentRoom().closeDoor(ui);
                        }
                    } else {
                        prepareText(ui);
                        ui.setText("L'oggetto a cui ti riferisci non esiste, non è richiudibile o lo hai scritto in modo incorretto");
                    }
                }

            }
            else
                {
                prepareText(ui);
                ui.setText("Non puoi compiere questa azione, la presenza del mostro te lo impedisce");
            }
            //Inserimento "attacca" o simili
            if (par.getCommand().getName().equals("attacca")) {
                if (map.getCurrentRoom().getMonster() != null) {
                    map.getCurrentRoom().fightSequence(p, ui);
                    if (!map.getCurrentRoom().equals(p.getCurrentRoom())){
                        map.setPreviousRoom(map.getCurrentRoom());
                        map.setCurrentRoom(p.getCurrentRoom());
                        move = true;
                    }
                } else {
                    prepareText(ui);
                    ui.setText("Non c'è nulla da combattere qui...");
                }
            }

            //Inserimento "indietro" o simili
            if (par.getCommand().getName().equals("indietro")) {
                Room temp = map.getPreviousRoom();
                map.setPreviousRoom(map.getCurrentRoom());
                map.setCurrentRoom(temp);
                move = true;
            }

            //Inserimento "compra" o simili (vale solo in blksmith o alchemshop
            if (par.getCommand().getName().equals("compra")) {
                if (par.getObject() != null){
                    map.getCurrentRoom().buy(p, par.getObject(), ui);
                } else {
                    prepareText(ui);
                    ui.setText("Devi specificare cosa vuoi comprare, nessuno può capire i tuoi bisogni meglio di te");
                }
            }

            //Inserimento "parla"
            if (par.getCommand().getName().equals("parla")) {
                if (par.getObject()!=null){
                    map.getCurrentRoom().talkTo(p, par.getObject());
                } else {
                    prepareText(ui);
                    ui.setText("Con chi vorresti parlare?");
                }
            }

            //Inserimento "usa" o simili (vale solo per le pozioni e per il consiglio)
            if (par.getCommand().getName().equals("usa")) {
                if (par.getObject() != null) {
                    if (par.getObject().getName().equals("Pozione")) {
                        int k = -1;
                        for (int i = 0; i < p.getInventory().size() || k == -1; i++) {
                            if (p.getInventory().get(i).getName().equals("Pozione")) {
                                k = i;
                            }
                        }
                        if (k > -1) {
                            p.getInventory().get(k).use(p);
                            p.removeFromInventory(k);
                        }
                    } else if (par.getObject().getName().equals("Consiglio")) {
                        for (Stobj inv : p.getInventory()) {
                            if (inv.getName().equals("Consiglio")) {
                                prepareText(ui);
                                ui.setText(inv.getDescription());
                            }
                        }
                    }
                } else {
                    prepareText(ui);
                    ui.setText("Specifica cosa vorresti usare");
                }
            }

            //Inserimento "bevi" (vale solo per le pozioni)
            if (par.getCommand().getName().equals("bevi")) {
                if (par.getObject() != null) {
                    if (par.getObject().getName().equals("Pozione")) {
                        int k = -1;
                        for (int i = 0; i < p.getInventory().size() || k == -1; i++) {
                            if (p.getInventory().get(i).getName().equals("Pozione")) {
                                k = i;
                            }
                        }
                        if (k > -1) {
                            p.getInventory().get(k).use(p);
                            p.removeFromInventory(k);
                        }
                    }
                } else {
                    int pot = 0;
                    for (Stobj inv : p.getInventory()) {
                        if (inv.getName().equals("Pozione")) {
                            pot++;
                        }
                    }
                    if (pot>0){
                        prepareText(ui);
                        ui.setText("Hai ancora " + pot + "x Pozione che puoi bere");
                    } else {
                        prepareText(ui);
                        ui.setText("Non hai nulla da bere");
                    }
                    prepareText(ui);
                    ui.setText("Specifica cosa vorresti bere");
                }
            }

            //Inserimento "leggi" (vale solo per il consiglio della ninfa)
            if (par.getCommand().getName().equals("leggi")) {
                if (par.getObject() != null) {
                    if (par.getObject().getName().equals("Consiglio")) {
                        for (Stobj inv : p.getInventory()) {
                            if (inv.getName().equals("Consiglio")) {
                                ui.setText(inv.getDescription());
                            }
                        }
                    }
                } else {
                    boolean adv = false;
                    for (Stobj inv : p.getInventory()) {
                        if (inv.getName().equals("Consiglio")) {
                            adv = true;
                        }
                    }
                    if (adv){
                        prepareText(ui);
                        ui.setText("L'unica cosa che hai da leggere è il consiglio che ti ha dato la ninfa");
                    } else {
                        prepareText(ui);
                        ui.setText("Non c'è nulla dal leggere");
                    }
                }
            }

            //Inserimento "mangia" (vale solo per il frutto)
            if (par.getCommand().getName().equals("mangia")) {
                if (par.getObject() != null) {
                    if (par.getObject().getName().equals("Frutto")) {
                        for (Stobj inv : p.getInventory()) {
                            if (inv.getName().equals("Frutto")) {
                                int x = p.getCurrentHp() + 20 - p.getTotHp();
                                if (x > 0) {
                                    p.setCurrentHp(p.getTotHp());
                                } else {
                                    p.setCurrentHp(p.getCurrentHp() + 20);
                                }
                            }
                        }
                    }
                }else {
                    boolean f = false;
                    for (Stobj inv : p.getInventory()) {
                        if (inv.getName().equals("Frutto")) {
                            f = true;
                        }
                    }
                    if (f){
                        prepareText(ui);
                        ui.setText("L'unica cosa che hai da mangiare è il frutto che hai raccolto");
                    } else {
                        prepareText(ui);
                        ui.setText("Non hai nulla da mangiare");
                    }
                }
            }

            //Inserimento "Q" per risoluzione di riddle
            if (par.getCommand().getName().equals("q")) {
                map.getCurrentRoom().riddle();
            }
            
            prepareText(ui);
            ui.setText(map.getCurrentRoom().getMsg());

            if (noroom) {
                prepareText(ui);
                ui.setText("Non puoi proseguire in quella direzione");
            }/* else if (move) {
                prepareText(ui);
                ui.setText(map.getCurrentRoom().getName());
                ui.setText("================================================");
                ui.setText(map.getCurrentRoom().getDescription());
            }*/





        }
    }
}