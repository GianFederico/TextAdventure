package newpackage01;

import FileCreation.Map;
import newpackage03.SuperMonster;

public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player= new Player();
    SuperMonster monster;
    String  inventoryStatus=null;
    Map map= new Map();
    
    int silverRing;         //oggetto, ma va implementato un inventario magari, è solo per far vedere la diversa scelta nel metodo parlaGuardia()
    
    public Story(Game g, UI userInterface, VisibilityManager vManager){
        game=g;
        ui=userInterface;
        vm=vManager;
    }
    
    public void defaultSetup(){
    //parametri iniziali prima di iniziare il gioco, o dopo che muori

        player.setHp(10);
        ui.hpNumberLable.setText(""+ player.getHp());
        
        player.setWeapon(null);
        ui.weaponNameLabel.setText("");
        
        inventoryStatus="close";
 
    }
    
    
    public void selectPosition(String nextPosition){           //questi saranno tutti i possibili case
        switch(nextPosition){
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
    
    
    public void storyBegins(){
       prepareText();  
       ui.text=map.house.getDescription();
              
        /*
        ui.choice1.setText("Parla con qualcuno");               //questi vanno tutti rimossi e lasciato solo un panel che aspetta la stringa input dell'utente
        ui.choice2.setText("Va via");
        ui.choice3.setText("Dormi per terra");
        ui.choice4.setText("Guarda il cielo");
        */
        
        game.nextPosition1 = "parlaGuardia";                    //questi sono parametri per ogni pulsante, anche questi vanno rimossi
        game.nextPosition2 = "vaiVia";                          //quandoo vengono cliccati i pulsanti, restituiscono quel valore che poi va nello switch
        game.nextPosition3 = "dormi";
        game.nextPosition4 = "guardaCielo";
    }
    
    
    
    
    public void parlaGuardia(){
        prepareText();   
       if (silverRing==0){
       ui.text="Ciao, io sono Dio,\nmi dispiace ma questo non e' il tuo posto, devo rimandarti indietro"; 
       
        
       /* ui.choice1.setText("indietro");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
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
        */ 
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
        */ 
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
        */ 
        game.nextPosition1 = "storyBegins";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
        
    }
    
    public void toTitle(){
        prepareText();//?   
        defaultSetup();
        vm.showTitleScreen();
        
    }

 //==============================================================ACTUAL STORY============================================================================     
    public void prepareText(){
        ui.i=0;                                               //setta i=0 per il timer
        ui.mainTextArea.setText("");       //cancella il testo precedente
        ui.timer.start();                              //fa partire il timer
    }
    
  public void house(){
      prepareText();
      ui.text=map.house.getDescription();
    }
   
   public void centralSquare(){
       prepareText();      
       ui.text=map.square.getDescription();
    }   
  
   public void alchemistShop(){
       prepareText();      
       ui.text=map.alchemshop.getDescription();
    }

public void blacksmithShop(){
    prepareText();
       ui.text=map.blksmith.getDescription();
    }     

  public void northGate(){
      prepareText();    
      ui.text=map.ngate.getDescription();
    }     

//forestIntro?
  
public void forestClearing(){
    prepareText();
        ui.text=map.fclearing.getDescription();
    }      

public void forestCliff(){
    prepareText();
    ui.text=map.fcliff.getDescription();
    }      


public void forestToLake(){
    prepareText();
    ui.text=map.tolake.getDescription();
    }      

public void lakeNynph(){
    prepareText();
        ui.text=map.wlake.getDescription();
    }      

public void forestEnd(){
    prepareText();
        ui.text=map.forestend.getDescription();
    }


public void mounainBegins(){
    prepareText();
       ui.text=map.mountstart.getDescription();
    }


public void MountainFork(){
    prepareText();
        ui.text=map.fork.getDescription();
    }


public void riddleWall(){
    prepareText();
    }


public void wyvernLair(){
    prepareText();
    ui.text=map.wlair.getDescription();
    }


public void tunnelStorage(){
    prepareText();
    ui.text=map.storage.getDescription();
    }


public void shamanRoom(){
    prepareText();
    ui.text=map.shroom.getDescription();
    }


public void shamanCloset(){
    prepareText();
    ui.text=map.closet.getDescription();
    }


public void ending(){
    prepareText();
    }

}