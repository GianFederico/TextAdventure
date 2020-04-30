package newpackage01;

import newpackage02.Weapon_Coltello;
import newpackage02.Weapon_SpadaLunga;
import newpackage03.Monster_Troll;
import newpackage03.Monster_Lupo;
import newpackage03.SuperMonster;

public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player= new Player();
    SuperMonster monster;
    String  inventoryStatus=null;
    
    int silverRing;         //oggetto, ma va implementato un inventario magari, è solo per far vedere la diversa scelta nel metodo parlaGuardia()
    
    public Story(Game g, UI userInterface, VisibilityManager vManager){
        game=g;
        ui=userInterface;
        vm=vManager;
    }
    
    public void defaultSetup(){
    //parametri iniziali prima di iniziare il gioco, o dopo che muori
        
        
        player.hp= 10;
        ui.hpNumberLable.setText(""+ player.hp);
        
        player.currentWeapon= new Weapon_Coltello();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        
        inventoryStatus="close";
        
        game.playerItem[0]=game.denaro;
        game.playerItem[1]=game.empty;
        game.playerItem[2]=game.empty;
        game.playerItem[3]=game.empty;
        game.playerItem[4]=game.empty;
        game.playerItem[5]=game.empty;
        game.playerItem[6]=game.empty;
        game.playerItem[7]=game.empty;
        game.playerItem[8]=game.empty;
        game.playerItem[9]=game.empty;
        game.playerItem[10]=game.empty;
        game.playerItem[11]=game.empty;
        
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
            
            case "nord": nord();
            break;
            
            case "est": est();
            break;
                
            case "ovest": ovest();
            break;
            
            case "fight": fight();
            break;
            
            case "playerAttack": playerAttack();
            break;
            
            case "monsterAttack": monsterAttack();
            break;
            
            case "win": win();
            break;
            
            case "lose": lose();
            break;
            
            case "toTitle": toTitle();
            break;
        }
    }
    
    
    public void storyBegins(){
       prepareText();  
       ui.text="Ciao blablablaba\n\nChe vuoi fare?";
              
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
        player.hp=(player.hp-2);
        ui.hpNumberLable.setText(""+ player.hp);
        
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
        player.hp= (player.hp+1);
        ui.hpNumberLable.setText(""+ player.hp);
        
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
    
    public void nord(){
        prepareText();   
        ui.text=""; 
       
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
    
    public void est(){
        prepareText();   
        ui.text="ti addentri in una foresta e trovi appoggiata ad un alber una Spada Lunga!"; 
        player.currentWeapon=new Weapon_SpadaLunga();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        game.playerItem[2]=game.ciondolo;
        
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
    
    public void ovest(){
        prepareText();   
        int i = new java.util.Random().nextInt(100)+1;
        
        if(i<10){
           monster= new Monster_Troll(); 
        }
        else{
            monster= new Monster_Lupo();
        }
        
        ui.text="Ti avvicini ad un ruscello e quando provi a rinfrescarti bagnandoti la faccia, ti attacca un "+ monster.name +" nascosto nei cespugli!"
                + "prendi 3danni!";
        player.hp=(player.hp-3);
        ui.hpNumberLable.setText("" + player.hp);
        
       /* ui.choice1.setText("combatti");               
        ui.choice2.setText("scappa");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        game.nextPosition1 = "fight";                    
        game.nextPosition2 = "storyBegins";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
        
    }
    
    public void fight(){
        prepareText();   
        ui.text=monster.getName() + ": "+monster.getHp()+ "\n\nche vuoi fare?"; 
        
       /* ui.choice1.setText("attacca");               
        ui.choice2.setText("scappa");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        game.nextPosition1 = "playerAttack";                    
        game.nextPosition2 = "storyBegins";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void playerAttack(){
        prepareText();   
        int playerDamage= new java.util.Random().nextInt(player.currentWeapon.damage); //danno uguale ad un numero a caso tra 0 e danno dell'arma
        
        ui.text="Hai attaccato il " +monster.getName()+ "ed hai fatto "+playerDamage+"danni!";
        monster.setHp(monster.getHp()-playerDamage);
        
       /* ui.choice1.setText(">");               
        ui.choice2.setText("scappa");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        if(monster.hp>0){
            game.nextPosition1 = "monsterAttack";                    
            game.nextPosition2 = "storyBegins";
            game.nextPosition3 = "";
            game.nextPosition4 = "";            
        }
        else if(monster.hp<1){
        game.nextPosition1 = "win";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
        
    }
    
    public void monsterAttack(){
        prepareText();        
        int monsterDamage= new java.util.Random().nextInt(monster.attack);
        ui.text=monster.attackMessage + "ricevi " +monsterDamage+"danni!";
        
        player.hp=(player.hp-monsterDamage);
        ui.hpNumberLable.setText(""+ player.hp);
        
        if(player.hp>0){
            game.nextPosition1 = "fight";                    
            game.nextPosition2 = "storyBegins";
            game.nextPosition3 = "";
            game.nextPosition4 = "";            
        }
        else if(player.hp<1){
            game.nextPosition1 = "lose";                    
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
    }
        
    }
    
    public void win(){
        prepareText();        
        ui.text="hai battuto il "+monster.name+"!\nIl mostro ha lasciato cadere un Anello d'Argento! \n(hai ottenuto: Anello d'Argento)";
        silverRing=1;
        
       /* ui.choice1.setText("Torna indietro");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        game.nextPosition1 = "storyBegins";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void lose(){
        prepareText();        
        ui.text="Sei morto. \n\nGAME OVER";
        silverRing=1;
        
       /* ui.choice1.setText("Alla schermata principale");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        game.nextPosition1 = "toTitle";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
        
    }
    
    public void ending(){
        prepareText();        
         ui.text="una guardia ti si avvicina e inizia a parlarti:\n''hai ucciso il mostro?! sei un EROE!\n benvenuto nella nostra citta'''\nFINE";
         
        /* ui.choice1.setVisible(false);
         ui.choice2.setVisible(false);
         ui.choice3.setVisible(false);
         ui.choice4.setVisible(false);
           */      
    }
    
    public void toTitle(){
        prepareText();//?   
        defaultSetup();
        vm.showTitleScreen();
        
    }
    
    
 //======================================================================================================================================================
 //====================================================================================================================================================== 
 //==============================================================ACTUAL STORY============================================================================     
  
   //DA FARE:   COMBAT - MORTE - ENDING - ATTACCA
    
  /* TEMPLATE 
    public void NOME(){
    prepareText();    
        //COME FA AD ARRIVARE QUI
    
        ui.text="TESTO SU DISPLAY"; 
        
        //DOVE PUO' ANDARE
    }    */
    
    public void prepareText(){
        ui.i=0;                                               //setta i=0 per il timer
        ui.mainTextArea.setText("");       //cancella il testo precedente
        ui.timer.start();                              //fa partire il timer
    }
    
    
     public void inputDescription(){
         prepareText();   
         ui.text="no idea"; 
        
        //avanti---intro1    
    }
    
     public void intro1(){
         prepareText();
        ui.text="In questo gioco impersonerai un giovanissimo avventuriero, in un ambiente fantasy, che si ritrova a dover lottare contro la malattia di sua madre, "
                                                        + "alla quale, neanche i chierici del villaggio in cui vivi, hanno saputo dare risposta..."; 
        
        //avanti---intro2    
    }    
     
         public void intro2(){
             prepareText();    
        ui.text="L'unica maniera per salvarla, è cercare l'ex sciamano del villaggio, esiliato dagli altri abitanti perchè ritenuto pericoloso, che vive ormai da molti anni "
                                                        + "in solitudine sulla montagna a Nord, oltre la foresta..."; 
        
        //avanti---house1    
    }     
         
  public void house1(){
      prepareText();    
        ui.text="È mattino, sei vicino a tua madre che dolorante, nel letto, non ha chiuso occhio tutta la notte, e le dai un infuso di erbe sperando che riesca a dormire.\n" 
                                                       + "Tuo padre è morto anni fa, e solo tu puoi fare qualcosa.\n" +"\n" +"che vuoi fare?"; 
        
        //cerca---house2  esci---centralSquare   
    }
  
   public void house2(){
       prepareText();      
       //house2---cerca
        ui.text="In giro per casa riesci a trovare un Coltello, puoi usarlo come arma.\n" 
                                                       +"Racimoli 2gold ed inoltre noti un ciondolo di tua madre, con una pietra preziosa, pensi possa valere quaclosa e forse può ritornarti utile, decidi allora di prenderlo."; 
        
        //indietro---house2 (+ 2gold +coltello +ciondolo)   
    } 
   
   public void centralSquare(){
       prepareText();      
       //house2---esci
        ui.text="L'aria mattutina è ancora fresca, sembra essere una bella giornata di sole ed in città inizia ad esserci movimento.\n" +
                                                        "Sei proprio davanti alla piazzetta centrale del villaggio.\n" +"\n" +"che vuoi fare?"; 
        
        //nord---northGate  ovest---alchemistWay  est---blacksmithWay
    }   
  
   public void alchemistWay(){
       prepareText();      
       //centralSqaure---ovest
        ui.text="Inbocchi la strada che porta al negozio dell'alchimista, credi che delle pozioni curative potrebbero tornarti utili e decidi di dare un'occhiata."; 
        
        //avanti---alchemistTalk
    }
   
   public void alchemistTalk(){
       prepareText();      
       //centralSqaure---ovest
        ui.text="Ti accoglie una gentile ragazza, apprendista del vecchio alchimista, che ti rivolge il buongiorno.\n" +
                                                        "Le chiedi delle pozioni curative e ti risponde che costano 5gold ognuna."; 
        
                                    /*SE NON HAI ABBASTANZA SOLDI:
                                                    Purtroppo non hai abbastanza soldi per permettertele, e decidi di tornare 
                                                    //indietro---centralSqaure
        
                                       SE NON HAI ABBASTANZA SOLDI MA HAI IL CIONDOLO:
                                                    Ti propone uno scambio: 2pozioni e 5gold per il gioiello di tua madre.

                                                    -CIONDOLO
                                                    + 2 POZIONI
                                                    + 5gold

                                                    Affare fatto allora! è stato un piacere, grazie e buona giornata.
                                                    //indietro--centralSquare

                                       SE HAI ABBASTANZA SOLDI
                                                    Puoi comprarne una.

                                                    - SOLDI
                                                    + POZIONE

                                                    Affare fatto allora! è stato un piacere, grazie e buona giornata.
                                                    //indietro---centralSquare
                                   */
    }
    

public void blacksmithWay(){
    prepareText();
       //centralSqaure---est
        ui.text="Prendi la strada del mercato, alcune bancarelle stanno aprendo ora ed altre invece sono già allestite.\n" +
                                                        "Da quello che vedi, le uniche cose che potrebbero aiutarti sono una Spada Lunga ed un'Armatura dal fabbro, ti dirigi lì."; 
        
        //avanti---blacksmithTalk
    }     
    

public void blacksmithTalk(){
    prepareText();
    
        ui.text="Ti ritrovi davanti ad un omone pelato e muscoloso, con grossi baffi neri che ti chiede come ti può essere utile,\n" +
                                                        "e ti informa che la Spada Lunga e l'Armatura di cuoio fanno 2gold ciascuno"; 
        
                                    /*SE HAI I SOLDI PER ENTRAMBI
                                                    Un ottimo affare! decidi di tornare indietro.

                                                    + ARMATURA (-5 qualsiasi danno)
                                                    + SPADA LUNGA
                                                    - 4gold
                                                    //indietro---centralSquare

                                      SE HAI SOLDI SOLO PER 1
                                                    Non hai abbastanza soldi per entrambi, scegli cosa comprare
                                                            SE "SPADA"
                                                                    + SPADA LUNGA
                                                                     - 2gold
                                                            SE "ARMATURA"
                                                                    + ARMATURA
                                                                     - 2gold
                                                    Un ottimo affare! decidi di tornare indietro
                                                    //indietro---centralSquare

                                       SE NON HAI ABBASTANZA SOLDI
                                                    Il fabbro ti dice che gli dispiace e di tornare quando avrai qualche spicciolo.
                                                    decidi di tornare indietro 
                                                    //indietro---centralSquare
                                   */
    }     
  

  public void northGate(){
      prepareText();    
      //centralSquare---nord
        ui.text="Ti avvivini al cancello nord del villaggio. Sai che oltre quel cancello c'è la foresta che dovrai affrontare per arrivare alla montagna dello sciamano. \n" +
                                                        "Ai suoi piedi c'è una guardia che ti ferma."; 
        
                                    /*SE NON HAI ARMI CON TE
                                                    Ti intima di allontanarti, non può farti uscire senza neanche un'arma con te. 
                                                    Oltre quel cancello ci sono creature pericolose.
                                                    Decidi di tornare indietro.
                                                    //indietro---centralSquare

                                        SE HAI UN'ARMA CON TE
                                                    Ti dice di star attento lì fuori, ci sono creature molto pericolose, ti augura buona fortuna e ti apre il cancello.
                                                    //avanti---confirmVillageToForest
                                   */
    }     
  
  
  public void confirmVillageToForest(){
      prepareText();    
      //centralSquare---nord
        ui.text="Sicuro di essere pronto per partire?"; 
        
                                    /*SE SI   
                                                    //si---introForest
                                        SE NO
                                                   decidi di tornare indietro.
                                                  //no---centralSquare  
                                   */
    }     
  
  
public void introForest(){
    prepareText();
    //confirmVillageToForest---si
        ui.text="Ti allonani dal tuo villaggio, lasciandotelo alle spalle, dopo poche ore sei costretto ad abbandonare anche il sentiero per inoltrarti in una rigogliosa foresta,"
                                                    + " la quale ti porterà direttamente ai piedi della montagna se manterrai la direzione Nord."; 
        
        //avanti--COMBAT---forestClearing   
    }    
  

public void forestClearing(){
    prepareText();
        ui.text="Sono passate ormai parecchie ore da quando hai lasciato il villaggio, ed inizia a far buio, davanti a te si apre una piccola radura e credi che possa essere un"
                                                    + " buon punto per passare la notte e rimetterti in forze mangiando qualcosa"; 
        
                                                    //+ fullHP  SOLO 1 VOLTA
        //avanti---Clearing
    }      
  

public void clearing(){
    prepareText();
        ui.text="La radura si dirama in diverse direzioni davanti a te,\n" +"\n" +"dove vuoi andare?"; 
        
        //ovest---forestLake  est---forestCliff  nord---forestAfterClearing
    }      


public void forestCliff(){
    prepareText();
    //forestClearing---est
        ui.text="Proseguendo verso Est, noti che il vento si fa più forte, e anche più fresco, la vegetazione si diradai e davanti a te scorgi un grosso dirupo che ti offre un panorma"
                                                    + " mozzafiato ma, non puoi continuare da qui, e decidi di tornare indietro"; 
        
        //avanti---forestClearing
    }      


public void forestLake(){
    prepareText();
    //forestClearing---ovest
        ui.text="Proseguendo verso Ovest, oltre gli alberi riesci a scorgere un incantevole laghetto, ma prima che tu possa arrivarci,  ti si para davanti un Troll, "
                                                    + "hai invaso il suo territorio e ti attacca!"; 
        
        //avanti---COMBAT---lakeNynph1
    }      

public void lakeNynph1(){
    prepareText();
        ui.text="Oltrepassi il corpo del Troll, e ti ritrovi in un posto incantevole, con un ruscello, fiori profumati e i raggi del sole che ti riscaldano oltre le foglie degli alberi."
                                                      + " Non appena ti avvicini al lago noti che una figura riemerge dalle acque..."; 
        
        //avanti---lakeNynph2
    }      

public void lakeNynph2(){
    prepareText();
        ui.text="La figura con la pella squamosa ma di aspetto umanoide è di una bellezza senza eguali, è una Ninfa.\n" +
                                                     "La ninfa porge lo sguardo prima sul corpo del Troll, e poi su di te, e dalla riva del lago si incammina nella tua direzione."; 
        
        //avanti---lakeNynph3
    }      


public void lakeNynph3(){
    prepareText();
        ui.text="Si ferma davanti a te, e ti confida di averla salvata dal Troll che la teneva prigioniera. Le dici del tuo viaggio e lei, come ricompensa, "
                                                    + "incanta la tua arma (+5danni) e ti dice che una volta ha visto lo sciamano tirare la leva destra sulla montagna."; 
        
                                                    //+5 danni arma
        //avanti---lakeNynph4
    }   


public void lakeNynph4(){
    prepareText();
        ui.text="Grato dell'incantamento e del consiglio della Ninfa che decidi di appuntarti per non rischiare di dimenticarlo, ritorni sui tuoi passi e "
                                                    + "decidi che forse è il momento di preseguire verso la montagna."; 
        
                                                    //+cosniglio scritto
        //avanti---forestClearing
    }


public void forestAfterClearing(){
    prepareText();
        //forestClearing---nord
        ui.text="Dopo qualche ora di cammino noti che il paesaggio davanti a te inizia a cambiare, la vegetazione è sempre meno, e le formazioni rocciose invece sempre di più.\n" +
                                                      "Sai di starti avvicinando alla montagna dello sciamano. Sicuro di voler continuare?"; 
        
        //si---COMBAT---mountainBegins no---"torni indietro"Clearing
    }


public void mounainBegins(){
    prepareText();
        ui.text="Dopo ancora qualche miglio, arrivi finalmente ai piedi della montagna, sai che dovrai provare a scalarla, ma prima che tu possa iniziare a pensare come,"
                                                    + " un Ragno Gigante ti blocca la strada e ti attacca!"; 
        
        //avanti---introMountain
    }


public void introMounain(){
    prepareText();
        ui.text="Davanti a te si presenta una enorme montagna interamente in roccia, e metro dopo mentro, inizi a scalarla con non poca difficoltà, fino ad arrivare su "
                                                    + "una formazione rocciosa che sembra essere quasi un sentiero che la risale dalle pareti."; 
        
        //avanti---secretDoor
    }


public void secretDoor(){
    prepareText();
        ui.text="Segui per un po' il sentiero e scopri che finisce con un area poco più grande che ti ricorda un pianerottolo di qualche casa, ma oltre al vento e la viva roccia, "
                                                    + "ad una prima occhiata, non noti nulla di particolare.\n"+ "Che vuoi fare?"; 
   
        //scala indietro cerca---leversFound
                                    /*
                                        SE SCRIVE "SCALA"
                                                    Non sapresti davvero dove appigliarti ora, non ti sembra possibile scalarla ancora

                                        SE SCRIVE "TORNA INDIETRO"
                                                    Sai di non poter arrenderti adesso, Ci deve essere quacosa che ti sfugge
                                    */
    }


public void leversFound(){
    prepareText();
    //secretDoor---cerca
        ui.text="In effetti noti che verso l'interno della montagna ci sono due stalagmiti che sembrano sospette, ti avvicini, e noti che fanno sicuramente aprte di un meccanismo. \n" +
                                                    "Sono leve! Quale vuoi tirare?"; 
        
        //destra---rightLever sinistra---leftLever
    }


public void leftLever(){
    prepareText();
    //leversFound---sinistra
        ui.text="La parete davanti a te si apre, ma non appena ti avvicini per guardare meglio, un'incredibile folata di vento ti spinge all'indietro e ti fa perdere l'equilibrio facendoti "
                                                    + "inevitabilmente precipitare giù dalla montagna."; 
        
                                    
                                    //- X hp
        
                                    /*
                                        SE hp>0
                                          Hai fatto un bel volo, ma per miracolo sei ancora tutto intero ai piedi della montagna 
                                                avanti---introMountain        

                                        SE hp<0
                                                   avanti---death
                                    */
    }


public void rightLever(){
    prepareText();
    //leversFound---destra
    
                                    /*
                                    SE HA CONSIGLIO NINFA:
                                                Ti ricordi del consiglio della Ninfa, e 
                                    */
    
        ui.text="tiri la leva destra, che apre davanti a te, una parete verso l'interno della montagna che conduce in un cunicolo buio.\n" +
                                                    "Ci entri, sicuramente è la dimora dello sciamano."; 
        
        //avanti---firstTunnel
    }


public void firstTunnel(){
    prepareText();
    //secretDoor---cerca
        ui.text="La parete dietro di te si chiude, e una volta chiusa noti che due file di torce sulle pareti accendersi magicamente, "
                                                    + "illuminando un cunicolo stretto, ma ben rifinito che porta verso nord."; 
        
        //avanti---COMBAT (prima di fork: Sembra che il cunicolo finisca con un bivio, puoi andare ad Est o ad Ovest, ma prima che ti possa decidere appare davanti a te un ___??___ e ti attacca! )---fork
    }


public void fork(){
    prepareText();
        ui.text="Sei al bivio. \n" +
"Dove vuoi andare?\n"; 
        
        //ovest---riddleWall1  est---tunnelStorage1
    }


public void riddleWall1(){
    prepareText();
    //fork---ovest
        ui.text="Inbocchi un corridoio che porta verso ovest e che si interrompe bruscamente su una parete. Avvicinandoti, "
                                                    + "noti che sulla parete ci sono incise alcune parole che recitano:"; 
        
       //avanti---rilleWall2
    }


public void riddleWall2(){
    prepareText();
        ui.text="\"Pronuncia la soluzione, ed io mi aprirò. \n" +"Non è un'isola, ma è sempre in mezzo all'acqua\"\n" +"\n" +"Hai in mente una soluzione?"; 
        
       //q---tunnelAfterRiddle1  indietro---fork
    }


public void tunnelAfterFork1(){
    prepareText();
    //fork---q
        ui.text="Quando pronunci la laettera \"Q\" la parete davanti a te sembra sbloccarsi meccanicamente e scorre all'interno della roccia, "
                                                     + "concedendoti il passaggio per un cunicolo verso Ovest che non ti sembra nulla di buono... "; 
        
       //avanti---tunnelAfterFork2
    }


public void tunnelAfterFork2(){
    prepareText();
        ui.text="La via davanti a te è disseminata di cadaveri e scheletri di ogni tipo da piccoli animali ad umanoidi, il tanfo è insopportabile, "
                                                    + "ma decidi di proseguire curvando verso nord, ed arrivando a quella che è inequivocabilmente la tana di un grosso animale. "; 
        
            //avanti---tunnelAfterFork3
    }


public void tunnelAfterFork3(){
    prepareText();
        ui.text="Decidi di prenderne una delle torce per fare luce più avanti nella stanza, ma non appena la tocchi, un ruggito ti immobilizza dalla paura, "
                                                     + "pochi secondi dopo, dalle tenebre appare una Viverna con una strana pietra incastonata in fronte che ti attacca!"; 
        
            //avanti---COMBAT---wyvernLair
    }


public void wyvernLair(){
    prepareText();
        ui.text="La Viverna giace immobile a terra, non hai mai visto una viverna vera, ma dalle illustrazioni che hai visto nella tua vita, "
                                                     + "sai che non hanno gemme sul corpo, decidi allora di rimuoverla e prenderla, pensi che possa tornare utile."; 
         
        //+gemmaViverna
        
            //indietro---fork
    }


public void tunnelStorage1(){
    prepareText();
    //fork---est
        ui.text="Prosegui verso Est, la via davanti a te è retta ma si interrompe su una porta, decidi di aprirla piano.\n" +
                                                    "All'interno rivela quello che sembra essere un Magazzino, c'è dell' oro (30g), delle razioni, degli armamenti logori e due pozioni curative."; 
        
        // +30gold  +2pozioni curative
        
        //avanti---tunnelStorage2
    }


public void tunnelStorage2(){
    prepareText();
        ui.text="La stanza in cui sei ha un'altra porta sulla parete nord, oltre a quella da cui sei entrato.\n" +
                                                    "Cosa vuoi fare?"; 
        
        // +30gold  +2pozioni curative
        
        //nord---shamanLair1  indietro---fork
    }


public void shamanLair1(){
    prepareText();
        ui.text="Apri cautamente la porta e davanti a te ritrovi un'ampia stanza. "; 
        
       //avanti---shamanLair2
    }


public void shamanLair2(){
    prepareText();
        ui.text="Sulla  parete Ovest, c'è un'immensa libreria, piena di libri e di appunti. \n" +
                                                    "La parete Nord è sgombra, ma noti un piccolo incavo al centro di essa.\n" +
                                                    "La parete Est invece è occupata da un'enorme scrivania alla quale, una figura siede incappucciata, di spalle."
                                                    + "che vuoi fare? "; 
        
       //ovest---shamanLibrary  nord---shamanWall1  est---shamanDesk1  indietro---fork
    }


public void shamanLibrary(){
    prepareText();
    //shamanLair---ovest
        ui.text="hai davanti a te una gigantesca libreria, con libri di ogni tipo e in ogni lingua, appunti e fogli sbicano in mezzo ai libri, "
                                                    + "sicuramente lo sciamano deve aver passato molto tempo qui, e questi libri gli avranno tuuto compagnia. "; 
        
       // indietro---shamanLair2
    }


public void shamanDesk1(){
    prepareText();
    //shamanLair---est
        ui.text="ti schiarisci la gola per farti sentire, è sicuramente la persona che cercavi, ma non ottieni nessuna risposta, ti avvicini e gli tocchi una spalla, "
                                                    + "ma non appena lo sfiori, la sua tunica rivela solo uno scheletro che al tuo tocco cade a pezzi per terra..."; 
        
       // avanti---shamanDesk2
    }


public void shamanDesk2(){
    prepareText();
        ui.text="Con tuo profondo rammarico, scopri che dello sciamano che cercavi, ormai non rimane nient'altro che un mucchio di ossa... \n" +
                                                    "Fatichi a non farti prendere dallo sconforto, ma ti concentri e pensi razionalmente, ci deve essere qualcosa che ancora puoi fare!"; 
        
       //indietro---shamanLair2
    }


public void shamanWall1(){
    prepareText();
    //shamanLair2---nord
        ui.text="la parete è stranamente pulita, al centro di essa c'è uno strano buco incavato poco più piccolo di una mano. "
                                                    + "Pensi possa esserci qualcosa da metterci all'interno."; 
        
        //avanti---shamanWall2
    }


public void shamanWall2(){
    prepareText();

        ui.text=""; 
        
                                            /*
                                              SE HA LA GEMMA DELLA VIVERNA
                                                        "la gemma della Viverna ci calza a pennello! non appena la appoggi, la parete scorre verso destra e apre
                                                        l'entrata su un piccolo stanzino ricolmo di oggetti."
	
                                                        entra---shamanCloset1  indietro---shamanLair2



                                            SE NON HA LA GEMMA DELAL VIVERNA
                                                        "Non sai proprio cosa possa entrarci lì dentro, e non hai la minima idea di a cosa potrebbe servire
                                                        un buco del genere..."

                                                        indietro---shamanLair2
                                            */
         
    }


public void shamanCloset1(){
    prepareText();
    //shamanWall2---entra
        ui.text="All'interno ci sono almeno una quindicina di mensole che partono dal basso, con ogni tipo di pozione meticolosamente conservate, "
                                                    + "che vanno da quelle d'amore a quelle velenose, ma i tuoi occhi si posano su una in particolare..."; 
        
        //avanti---shamanCloset2
    }


public void shamanCloset2(){
    prepareText();
        ui.text="L'etichetta su di essa riporta \"Millecure\", non credi ai tuoi occhi, è la leggendaria pozione Millecure, "
                                                    + "in grado di guarire qualsiasi malattia! Non credevi potesse esistere davvero, ma è proprio nelle tue mani."; 
       
        //+ pozioneMillecure
        //avanti---ending1
    }


public void ending1(){
    prepareText();
        ui.text="Ora sai di poter tornare a casa, e lasciare questo posto, quindi, fiero di te stesso, ti rimietti in cammino sui tuoi passi, "
                                                    + "ripensando a come sei arrivato fin qui, ai mostri che hai sconfitto, all'avventura che hai vissuto, e a tua madre."; 
        
        //avanti---ending2
    }


public void ending2(){
    prepareText();
        ui.text="Arrivi al cancello del villaggio, affamato e stanco, ma soddisfatto, la guardia ti vede da lontano, e ti apre il cancello da lontano facendoti un cenno con la mano. "
                                                    + "Sei a casa ormai, entri nel villaggio e la gente ti guarda con rispetto."; 
        
        //avanti---ending3
    }


public void ending3(){
    prepareText();
        ui.text="Sei finalmente a casa,"; 
                                        /*Sei finalmente a casa,

                                            FINALE BUONO
                                                        tua madre è ancora a letto, respira a  fatica, ma è viva, le dai immediatamente la pozione che hai preso, sai che starà meglio.
                                                        Passata una notte di riposo è infatti prorpio lei a svegliarti, con un caloroso abbraccio tra le lacrime di gioia.


                                            FINALE BAD(?)
                                                        ma non sei solo, c'è anche altra gente, sono i chierici del villaggio che ti guardano dispiaciuti...
                                                        I tuoi sforzi sono stati vani, la malattia è stata più veloce di te e tua madre non ce l'ha fatta.
        
                                        */
       
        //avanti---end
    }

//______________________________________________________________________________________________________________________________________________________________rimuovere 1 dal nome del metodo, li ho messi sotto solo per ricordare quali servono in actual story

    public void fight1(){
        prepareText();   
        ui.text=monster.name + ": "+monster.hp+ "\n\nche vuoi fare?"; 
        
       /* ui.choice1.setText("attacca");               
        ui.choice2.setText("scappa");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        game.nextPosition1 = "playerAttack";                    
        game.nextPosition2 = "storyBegins";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void playerAttack1(){
        prepareText();   
        int playerDamage= new java.util.Random().nextInt(player.currentWeapon.damage); //danno uguale ad un numero a caso tra 0 e danno dell'arma
        
        ui.text="Hai attaccato il " +monster.name+ "ed hai fatto "+playerDamage+"danni!";
        monster.hp= (monster.hp-playerDamage);
        
       /* ui.choice1.setText(">");               
        ui.choice2.setText("scappa");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        if(monster.hp>0){
            game.nextPosition1 = "monsterAttack";                    
            game.nextPosition2 = "storyBegins";
            game.nextPosition3 = "";
            game.nextPosition4 = "";            
        }
        else if(monster.hp<1){
        game.nextPosition1 = "win";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
        
    }
    
    public void monsterAttack1(){
        prepareText();        
        int monsterDamage= new java.util.Random().nextInt(monster.attack);
        ui.text=monster.attackMessage + "ricevi " +monsterDamage+"danni!";
        
        player.hp=(player.hp-monsterDamage);
        ui.hpNumberLable.setText(""+ player.hp);
        
        if(player.hp>0){
            game.nextPosition1 = "fight";                    
            game.nextPosition2 = "storyBegins";
            game.nextPosition3 = "";
            game.nextPosition4 = "";            
        }
        else if(player.hp<1){
            game.nextPosition1 = "lose";                    
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = ""; 
    }
        
    }
    
    public void win1(){
        prepareText();        
        ui.text="hai battuto il "+monster.name+"!\nIl mostro ha lasciato cadere un Anello d'Argento! \n(hai ottenuto: Anello d'Argento)";
        silverRing=1;
        
       /* ui.choice1.setText("Torna indietro");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        game.nextPosition1 = "storyBegins";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
    }
    
    public void lose1(){
        prepareText();        
        ui.text="Sei morto. \n\nGAME OVER";
        silverRing=1;
        
       /* ui.choice1.setText("Alla schermata principale");               
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        */ 
        game.nextPosition1 = "toTitle";                    
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = ""; 
        
    }

    public void toTitle1(){
        prepareText();//?   
        defaultSetup();
        vm.showTitleScreen();
    }
}






