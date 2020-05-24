package newpackage01;

import FileCreation.CommandList;
import FileCreation.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import newpackage01.Game.ChoiceHandler;
import newpackage01.Game.InventoryHandler;
import FileCreation.FileWriter;
import parser.ParserOut;
import parser.Parsing;



public class Game {
    //varie istanziazioni
    ChoiceHandler cHandler= new ChoiceHandler();    
    UI ui= new UI();
    VisibilityManager vm= new VisibilityManager(ui);
    Story story= new Story();
    //String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    InventoryHandler invHandler= new InventoryHandler();
    Player player= new Player();
    Map map = new Map();
    File file = new File("..\\saveFile.txt");
    FileWriter fw = new FileWriter();
    Parsing parser = new Parsing();
    CommandList cl = new CommandList();
    String  inventoryStatus=null;
    
    
    public static void main(String[] args){
        new Game();
    }
    
    
    public Game(){
        ui.createUI(cHandler, invHandler);  //accediamo ai metodi della classe UI = crea la finestra di dialogo
        vm.showTitleScreen();   //acceediamo ai metodi della classe VisibilityManager = mostra la schermata iniziale
       // defaultSetup(player, ui);   //accediamo ai metodi della classe Story = con i paramentri di default
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
                    
               case "continua":
                   vm.titleToInput();
                    ui.inputDescription1();
               {
                   try {
                     fw. loadGameDataFromFile(file);
                   } catch (ClassNotFoundException | IOException ex) {
                       Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                   break;
                   
               case "start1":
                   vm.titleToGame();
                   defaultSetup(player, ui);
                   break;

               case "submit":
                   //System.out.println(ui.getCampotxt());
                   
                   ParserOut par = parser.parse(ui.getCampotxt(), cl.getCommands(), map.getCurrentRoom().getObjects(), player.getInventory());
                   System.out.println(par.getCommand().getName());
                   //System.out.println(par.getObject().getName());

                   //System.out.println(map.getCurrentRoom().getObjects().get(0).getName());
                  story.nextMove(par, player, map, ui);
                  ui.currentRoomNameLable.setText(map.getCurrentRoom().getName());
                   break;
            
                  
                case "salva":
                    fw.saveGameDataToFile(file);
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

                            if(inventoryStatus.equals("close")){
                                
                                vm.openInventory();
                                
                                if(player.getInventory().get(0)!=null){
                                    ui.inv1.setText(player.getInventory().get(0).getName()); 
                                }
                                else{
                                    ui.inv1.setText("");
                                }
                                if(player.getInventory().get(1)!=null){
                                    ui.inv2.setText(player.getInventory().get(1).getName()); 
                                }
                                else{
                                    ui.inv2.setText("");
                                }
                                if(player.getInventory().get(2)!=null){
                                    ui.inv3.setText(player.getInventory().get(2).getName()); 
                                }
                                else{
                                    ui.inv3.setText("");
                                }
                                if(player.getInventory().get(3)!=null){
                                    ui.inv4.setText(player.getInventory().get(3).getName()); 
                                }
                                else{
                                    ui.inv4.setText("");
                                }
                                if(player.getInventory().get(4)!=null){
                                    ui.inv5.setText(player.getInventory().get(4).getName()); 
                                }
                                else{
                                    ui.inv5.setText("");
                                }
                                if(player.getInventory().get(5)!=null){
                                    ui.inv6.setText(player.getInventory().get(5).getName()); 
                                }
                                else{
                                    ui.inv6.setText("");
                                }
                                if(player.getInventory().get(6)!=null){
                                    ui.inv7.setText(player.getInventory().get(6).getName()); 
                                }
                                else{
                                    ui.inv7.setText("");
                                }
                                if(player.getInventory().get(7)!=null){
                                    ui.inv8.setText(player.getInventory().get(7).getName()); 
                                }
                                else{
                                    ui.inv8.setText("");
                                }
                                if(player.getInventory().get(8)!=null){
                                    ui.inv9.setText(player.getInventory().get(8).getName()); 
                                }
                                else{
                                    ui.inv9.setText("");
                                }
                                if(player.getInventory().get(9)!=null){
                                    ui.inv10.setText(player.getInventory().get(9).getName()); 
                                }
                                else{
                                    ui.inv10.setText("");
                                }
                                if(player.getInventory().get(10)!=null){
                                    ui.inv11.setText(player.getInventory().get(10).getName()); 
                                }
                                else{
                                    ui.inv11.setText("");
                                }
                                if(player.getInventory().get(11)!=null){
                                    ui.inv12.setText(player.getInventory().get(11).getName()); 
                                }
                                else{
                                    ui.inv12.setText("");
                                }
                                inventoryStatus= "open";                    
                            }
                            else if(inventoryStatus.equals("open")){
                                
                            vm.closeInventory();
                            inventoryStatus="close";
                            
                            }
                    break;
                        
                    }
                }
            }
        
        public void defaultSetup(Player p, UI ui){
    //parametri iniziali prima di iniziare il gioco, o dopo che muori


        //game.player.setCurrentHp(10);
        ui.hpNumberLable.setText(""+p.getCurrentHp() + "/" + p.getTotHp());

        
       p.setWeapon(null);
        ui.weaponNameLabel.setText("");
        
        inventoryStatus="close";
 
        map.setCurrentRoom(map.getHouse());
        ui.currentRoomNameLable.setText(map.getCurrentRoom().getName());
        story.prepareText(ui);
        ui.setText(map.getCurrentRoom().getDescription());
    }
        
        }
                
    


