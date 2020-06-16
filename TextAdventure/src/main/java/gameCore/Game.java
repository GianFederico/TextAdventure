/**
 * Classe main. Definisce le basi del gioco. 
 */
package gameCore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import fileManager.FileHandler;
import gameInterface.*;
import parser.*;

public class Game {
    ChoiceHandler cHandler= new ChoiceHandler();
    UI ui= new UI();
    VisibilityManager vm= new VisibilityManager(ui);
    Story story= new Story();
    Player player= new Player();
    Map map = new Map();
    File mapfile = new File(".\\MapSaveFile.txt");
    File playerfile = new File(".\\PlayerSaveFile.txt");
    FileHandler fw = new FileHandler();
    Parser parser = new Parser();
    CommandList cl = new CommandList();
    String inventoryStatus = "";
    boolean combat = false;

    public static void main(String[] args){
        new Game();
    }
    
    public Game(){
        ui.createUI(cHandler);  //accediamo ai metodi della classe UI = crea la finestra di dialogo
        vm.showTitleScreen();   //accediamo ai metodi della classe VisibilityManager = mostra la schermata iniziale
    }
    
    /**
     * Inner Class della classe Game. Gestisce gli avvenimenti nel gioco basandosi sui comandi ottenuti in ingresso
     */
    public class ChoiceHandler implements ActionListener{ //gestore per le scelte che aspetta l'evento(cioè il click)
         @Override
         public void actionPerformed(ActionEvent event){
            String yourChoice= event.getActionCommand();
            Random random = new Random();  //numero casuale = random.nextInt((max - min) +1) + min
            String uitxt = "";  //Stringa che accumula il messaggio da visualizzare
            
            switch(yourChoice){
                  case "start": //Click su "Nuovo gioco"
                       vm.setMainTextPanelSize(50,100,650,420);
                       vm.hideExitConfirm();
                       vm.showMainGameScreen();
                       vm.setNormalFont(18);
                       vm.titleToInput();
                       story.start(vm);
                       break;

                  case "continua": //Click su "Carica"
                      vm.setMainTextPanelSize(50,100,650,300);
                      vm.hideExitConfirm();
                      vm.showMainGameScreen();
                      vm.setNormalFont(18);
                      vm.titleToGame();
                      try {
                          map.setMap(fw.loadMapDataFromFile(mapfile));
                          player.setPlayer(fw.loadPlayerDataFromFile(playerfile));
                          loadSetup();
                      } catch (NullPointerException | ClassNotFoundException | IOException e){
                          vm.backToMenu();
                          vm.writeOnExitScreen("                                 Caricamento fallito. Dati inesistenti o danneggiati :(");
                      }
                      break;

                  case "start1": //Click su "Avanti"
                      vm.setNormalFont(18);
                      vm.setMainTextPanelSize(50,100,650,300);
                      vm.hideSaved();
                      vm.titleToGame();
                      defaultSetup();
                      vm.setMoneyCount(player.getMoney());
                      break;

                  case "submit": //Click su "Submit " o pressione del tasto Invio (Enter)
                      vm.hideSaved();
                      ParserOutput par = parser.parse(vm.getCampoTxt(), cl.getCommands(), map.getCurrentRoom().getObjects(), player.getInventory());
                      
                      //Se viene inserito attacca e c'è un mostro inizia la combat phase
                      if (par.getCommand()!=null && par.getCommand().getName().equals("attacca") && map.getCurrentRoom().getMonster()!=null){
                          vm.showFightButtons();
                          player.setDef();
                          player.setDmg();
                          vm.setMainTextPanelSize(50,100,650,420);
                          vm.setFightFont(17);
                          combat = true;
                      }
                      
                      //Se viene inserito il comando fine o eventuali sinonimi, viene chiusa la finestra
                      if (par.getCommand()!=null && par.getCommand().getName().equals("fine"))
                          System.exit(0);

                      boolean end = story.nextMove(par, player, map, vm); //true se si è raggiunti l'ultima interazione, false altrimenti
                      vm.setHpLabel(player.getCurrentHp(),player.getTotHp());
                      vm.campoFocus();
                      vm.setMoneyCount(player.getMoney());
                      
                      //Se end == true viene visualizzata l'ultima interazione prima della schermata finale
                      if (end){
                          vm.backToMenu();
                          story.ending(player, map.getCurrentRoom(), vm);
                          }
                      break;


                  case "salva"://Click su "Salva"
                      vm.showSaved(fw.saveMapDataToFile(mapfile, map), fw.savePlayerDataToFile(playerfile, player));
                      vm.campoFocus();
                      break;

                  case "attacca"://Click su "attacca" in fase di combattimento, gestisce l'attacco del giocatore player e quello del nemico Monster
                      vm.hideSaved();
                      vm.setFightFont(17);
                      uitxt = (map.getCurrentRoom().getMonster().getImage());
                      
                      //attacca il mostro con possibilità di colpire = monster.hitRate%
                      if ((random.nextInt(99) + 1) <= map.getCurrentRoom().getMonster().getHitRate()) {
                          int dmg = random.nextInt(map.getCurrentRoom().getMonster().getAttack() - player.getDef()) + 1  ; //max=monster.attack-player.def     min=1
                          uitxt = (uitxt + "\n" + map.getCurrentRoom().getMonster().getRndAttackMessage() + " facendoti " + dmg + " dann");
                          if (dmg>1)
                              uitxt = (uitxt+"i");
                          else {
                              uitxt = (uitxt+"o");
                          }
                          player.setCurrentHp(player.getCurrentHp() - dmg);
                          if(player.getCurrentHp()<=0){ //Quando gli Hp di Player sono <= 0, si passa alla schermata di sconfitta conla possibilità di ricominciare 
                               vm.setNormalFont(35);
                               vm.writeOnScreen("                         Sei stato sconfitto.");
                               vm.defeatScreen();
                               combat = false;
                               break;
                          }
                      } else {
                          uitxt = (uitxt + "\nHai evitato l'attacco del nemico");
                      }

                       //attacca il giocatore con possibilità di colpire (100-monster.dodgeRate)
                       if ((random.nextInt(99) + 1) <= 100 - map.getCurrentRoom().getMonster().getDodgeRate()) {
                           int dmg = (random.nextInt(player.getDmg())+ 1); //max=pldmg    min=pldmg-5
                           uitxt = (uitxt + "\nIl tuo attacco è andato a segno! Il nemico ha subito  " + dmg + " danni");
                           map.getCurrentRoom().getMonster().setHp(map.getCurrentRoom().getMonster().getHp() - dmg);
                       } else {
                           uitxt = (uitxt + "\nIl nemico " + map.getCurrentRoom().getMonster().getRndDodgeMessage());
                       }
                       if (map.getCurrentRoom().getMonster().getHp() <= 0) { 
                           uitxt = (map.getCurrentRoom().getMonster().getName() + " sconfitto");
                           vm.setNormalFont(18);
                           vm.hideFightButtons();
                           map.getCurrentRoom().addObject(map.getCurrentRoom().getMonster().getDeadName(), map.getCurrentRoom().getMonster().getDeadDescription(), new String[]{"carcassa", "cadavere"});
                           if (map.getCurrentRoom().getMonster().getLoot()!=null) {
                               map.getCurrentRoom().addObject(map.getCurrentRoom().getMonster().getLoot());
                               uitxt = uitxt + "\nIl nemico lascia cadere: " + map.getCurrentRoom().getMonster().getLoot().getName();
                           }
                           vm.setMainTextPanelSize(50,100,650,300);
                           map.getCurrentRoom().setMonster(null);
                           combat = false;
                       }
                       vm.setHpLabel(player.getCurrentHp(),player.getTotHp());
                       vm.writeOnScreen(uitxt);
                       break;

                   case "scappa": //Click su "scappa" in fase di combattimento, scappa dal combattimento e torna alla stanza precendente specificandone il nome
                           vm.hideSaved();
                           vm.setNormalFont(18);
                           map.back();
                           vm.hideFightButtons();
                           vm.setMainTextPanelSize(50,100,650,300);
                           vm.writeOnScreen("Sei scappato dalla battaglia. Sei tornato qui: " + map.getCurrentRoom().getName());
                           combat = false;
                       break;


                   case "usa": //Click su "Usa Pozione" in fase di combattimento, se c'è o se gli hp non sono al massimo, usa una pozione in combattimento; Se non è presente nell'inventario, lo notifica; se gli hp sono al massimo, non consente l'utlizzo della pozione
                           vm.setFightFont(17);
                           uitxt = (map.getCurrentRoom().getMonster().getImage());
                           vm.hideSaved();
                           int k = -1;
                           for (int i = 0; i < player.getInventory().size() && k == -1; i++) {
                               if (player.getInventory().get(i).getName().equals("Pozione")) {
                                   k = i;
                               }
                           }
                           if (k > -1) {
                               if (player.getCurrentHp()<player.getTotHp()) {
                                   player.getInventory().get(k).use(player);
                                   player.removeFromInventory(k);
                                   uitxt = (uitxt + "\nHai usato una pozione che ti ha ripristinato la salute");
                               } else {
                                   uitxt = (uitxt + "\nLa tua salute è già al massimo, non hai bisogno di usare pozioni");
                               }
                           } else {
                               uitxt = (uitxt + "\nNon hai più pozioni");
                           }
                           vm.writeOnScreen(uitxt);
                           vm.setHpLabel(player.getCurrentHp(),player.getTotHp());
                   break;

                   case "osserva": //Click su "Osserva" in fase di combattimento, mostra a video i dettagli del mostro in base alla sua vita rimanente
                       vm.hideSaved();
                       vm.setFightFont(17);
                       uitxt = (map.getCurrentRoom().getMonster().getImage());
                       if (map.getCurrentRoom().getMonster() != null) {
                           int x = (100 * map.getCurrentRoom().getMonster().getHp()) / map.getCurrentRoom().getMonster().getTotHp();
                           if (x >= 75) {
                               vm.writeOnScreen(uitxt  + "\nIl nemico è in ottima forma");
                           }
                           if (x < 75 && x >= 50) {
                               vm.writeOnScreen(uitxt  + "\nI tuoi colpi stanno cominciando a farsi sentire");
                           }
                           if (x < 50 && x >= 25) {
                               vm.writeOnScreen(uitxt  + "\nIl nemico è visibilmente provato");
                           }
                           if (x < 25) {
                               vm.writeOnScreen(uitxt  + "\nManca poco, il nemico è alle pezze!");
                           }
                       }
                           break;

                   case "exitMenu": //Click su "Esci". Porta alla schermata di conferma dell'uscita
                       vm.hideSaved();
                       vm.exitConfirm();
                       vm.writeOnExitScreen("                                        Sei sicuro di voler abbandonare la partita?\n                                       Tutti i progressi non salvati andranno persi.");
                       break;

                   case "yes": //Click su "Sì" nella schermata di conferma dell'uscita. Esce dal gioco e torna al menù principale
                       vm.setMainTextPanelSize(50,100,650,300);
                       vm.showTitleScreen();
                       map = new Map();
                       player = new Player();
                       vm.hideExitConfirm();
                       combat = false;
                       break;

                   case "no": //Click su "No" nella schermata di conferma dell'uscita. Torna al gioco
                       vm.hideExitConfirm();
                       vm.showMainGameScreen();
                       if (combat)
                           vm.showFightButtons();
                       break;

                   case "exit": //Click su "Esci" nel menù principale. Chiude la finestra del gioco
                       System.exit(0);
                       break;  

                   case "BackToMenu": //Click su "Torna al menù principale" dalla schermata del caricamento fallito
                        vm.showTitleScreen();
                       break;

                   case "inventoryButton": //Click su "Zaino". Mostra il contenuto della lista Inventory del Player in un set di JLabel a scomparsa
                       vm.hideSaved();
                       if(inventoryStatus.equals("close")){
                           vm.openInventory();
                           vm.campoFocus();
                           if (!player.getInventory().isEmpty()){
                               for (int i = 0; i<player.getInventory().size(); i++ ){
                                   if (player.getInventory().get(i)!=null){
                                       vm.getInvLableComponent(i).setText(player.getInventory().get(i).getName());
                                   }
                               }
                           }
                           vm.getInvLableComponent(player.getInventory().size()).setText("");
                           inventoryStatus= "open";
                       } else if (inventoryStatus.equals("open")){
                           vm.closeInventory();
                           vm.campoFocus();
                           inventoryStatus="close";
                       }
                       break;
               }
           }
    }
        /**
         * Metodo per l'impostazione dei paramentri iniziali ad un nuovo inzio del gioco.
         */
         public void defaultSetup(){ 
            map = new Map();
            player = new Player();
            
            vm.setHpLabel(player.getCurrentHp(),player.getTotHp());
            vm.setMoneyCount(0);
            inventoryStatus="close";
            vm.writeOnScreen(map.getCurrentRoom().getName() + "\n================================================\n" + map.getCurrentRoom().getDescription());
            vm.campoFocus();
    }
        /**
         * Metodo per l'impostazione dei paramentri al caricamento di un salvataggio.
         */
        public void loadSetup(){
        String uitxt = "";
            vm.setHpLabel(player.getCurrentHp(),player.getTotHp());
            vm.setMoneyCount(player.getMoney());
            inventoryStatus="close";
            uitxt = (map.getCurrentRoom().getName() + "\n================================================\n" + map.getCurrentRoom().getDescription());
            if (map.getCurrentRoom().getMonster()!=null)
                uitxt = (uitxt + "\n\nUn " + map.getCurrentRoom().getMonster().getName() + " ti sbarra la strada.");
            vm.writeOnScreen(uitxt);
            vm.campoFocus();
    }
}
              
    


