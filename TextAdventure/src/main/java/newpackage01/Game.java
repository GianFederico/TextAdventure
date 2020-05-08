package newpackage01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import newpackage01.Game.ChoiceHandler;
import newpackage01.Game.InventoryHandler;



public class Game {
    //varie istanziazioni
    ChoiceHandler cHandler= new ChoiceHandler();    
    UI ui= new UI();
    VisibilityManager vm= new VisibilityManager(ui);
    Story story= new Story(this, ui, vm);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    InventoryHandler invHandler= new InventoryHandler();
    
    
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
            
            switch(yourChoice){             
               case "start": 
                    vm.titleToInput();
                    ui.inputDescription1();
                    break; 
                    
                case "start1": 
                   vm.titleToGame();
                   story.storyBegins();
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
                           
                                ui.inv1.setText(""); 
                                ui.inv2.setText("");
                                ui.inv3.setText("");
                                ui.inv4.setText("");
                                ui.inv5.setText("");
                                ui.inv6.setText("");
                                ui.inv7.setText("");
                                ui.inv8.setText("");
                                ui.inv9.setText("");
                                ui.inv10.setText("");
                                ui.inv11.setText("");
                                ui.inv12.setText("");

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
                
    


