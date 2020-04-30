package newpackage01;

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
        
        }
                
    


