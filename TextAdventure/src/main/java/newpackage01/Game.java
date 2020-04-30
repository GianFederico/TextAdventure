package newpackage01;

import base.Command;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import newpackage01.Game.ChoiceHandler;
import newpackage01.Game.InventoryHandler;
import newpackage04.Item_Armatura;
import newpackage04.Item_Ciondolo;
import newpackage04.Item_ConsiglioLevaDestra;
import newpackage04.Item_Denaro;
import newpackage04.Item_Empty;
import newpackage04.Item_GemmaViverna;
import newpackage04.Item_Pozione;
import newpackage04.Item_PozioneMillecure;
import newpackage04.SuperItem;


public class Game {
    //varie istanziazioni
    ChoiceHandler cHandler= new ChoiceHandler();    
    UI ui= new UI();
    VisibilityManager vm= new VisibilityManager(ui);
    Story story= new Story(this, ui, vm);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    InventoryHandler invHandler= new InventoryHandler();
    List<Command> listacomandi = CommandsInit();
    
    SuperItem[] playerItem = new SuperItem[12];
        Item_Pozione pozione= new Item_Pozione();
        Item_GemmaViverna gemma= new Item_GemmaViverna();
        Item_Empty empty= new Item_Empty();
        Item_ConsiglioLevaDestra consiglio= new Item_ConsiglioLevaDestra();
        Item_Ciondolo ciondolo= new Item_Ciondolo();
        Item_Armatura armatura=new Item_Armatura();
        Item_PozioneMillecure millecure=new Item_PozioneMillecure();
        Item_Denaro denaro= new Item_Denaro(); 

    
    public static void main(String[] args){
        new Game();
    }
    
    
    
    public Game(){
        ui.createUI(cHandler, invHandler);  //accediamo ai metodi della classe UI = crea la finestra di dialogo
        vm.showTitleScreen();   //acceediamo ai metodi della classe VisibilityManager = mostra la schermata iniziale
        story.defaultSetup();   //accediamo ai metodi della classe Story = con i paramentri di default
    }


    
    public class ChoiceHandler implements ActionListener{ //gestore per le scelte che aspetta l'evento(cioè il click)
        @Override
        public void actionPerformed(ActionEvent event){
           String yourChoice= event.getActionCommand();
            
            switch(yourChoice){             //qui bisogna aggiungere tutti i possibili casi in cui il parser può sfociare
               case "start": 
                    vm.titleToGame(); story.storyBegins();  //transizione dallo schermo iniziale a storyBegins, non va cancellato 
                    break; 
                                        
                case "c1":
                    story.selectPosition(nextPosition1);
                    break;
                    
                case "c2":
                    story.selectPosition(nextPosition2);
                    break;
                    
                case "c3": 
                    story.selectPosition(nextPosition3);
                    break;
                    
                case "c4":
                    story.selectPosition(nextPosition4);
                    break;
            }
        }
    }
        
    
        public class InventoryHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event){
                String yourChoice=event.getActionCommand();
                
                switch(yourChoice){
                    case "inventoryButton":

                            if(story.inventoryStatus.equals("close")){
                                
                                vm.openInventory();
                           
                                ui.inv1.setText(playerItem[0].name+" "+playerItem[0].sellingValue); //solo per denaro
                                ui.inv2.setText(playerItem[1].name);
                                ui.inv3.setText(playerItem[2].name);
                                ui.inv4.setText(playerItem[3].name);
                                ui.inv5.setText(playerItem[4].name);
                                ui.inv6.setText(playerItem[5].name);
                                ui.inv7.setText(playerItem[6].name);
                                ui.inv8.setText(playerItem[7].name);
                                ui.inv9.setText(playerItem[8].name);
                                ui.inv10.setText(playerItem[9].name);
                                ui.inv11.setText(playerItem[10].name);
                                ui.inv12.setText(playerItem[11].name);

                                story.inventoryStatus= "open";                    
                            }
                            else if(story.inventoryStatus.equals("open")){
                                
                            vm.closeInventory();
                            story.inventoryStatus="close";
                            
                            }
                    break;
                        
                    }
                }
            }
        
        public List<Command> CommandsInit(){
            List<Command> comandi = new ArrayList<>();
            Command nord = new Command("nord");
            nord.setAka(new String[]{"n", "N", "Nord", "NORD"});
            comandi.add(nord);
            Command sud = new Command("sud");
            sud.setAka(new String[]{"s", "S", "Sud", "SUD"});
            comandi.add(sud);
            Command est = new Command("est");
            est.setAka(new String[]{"e", "E", "Est", "EST"});
            comandi.add(est);
            Command ovest = new Command("ovest");
            ovest.setAka(new String[]{"o", "O", "Ovest", "OVEST"});
            comandi.add(ovest);
            Command end = new Command("fine");
            end.setAka(new String[]{"end", "fine", "termina", "muori", "ammazzati", "ucciditi", "suicidati", "basta"});
            comandi.add(end);
            Command look = new Command("osserva");
            look.setAka(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
            comandi.add(look);
            Command pickup = new Command("raccogli");
            pickup.setAka(new String[]{"prendi"});
            comandi.add(pickup);
            Command push = new Command("premi");
            push.setAka(new String[]{"spingi","attiva","tira"});
            comandi.add(push);
            Command choose = new Command("scegli");
            choose.setAka(new String[]{});
            comandi.add(choose);
            Command fight = new Command("attacca");
            fight.setAka(new String[]{"combatti", "affronta"});
            comandi.add(fight);
            Command flee = new Command("fuggi");
            flee.setAka(new String[]{"scappa"});
            comandi.add(flee);
            Command climb = new Command("scala");
            climb.setAka(new String[]{"arrampica", "arrampicati"});
            comandi.add(climb);
            Command back = new Command("indietro");
            back.setAka(new String[]{"torna"});
            comandi.add(back);
            return comandi;
     }
        
        }
                
    


