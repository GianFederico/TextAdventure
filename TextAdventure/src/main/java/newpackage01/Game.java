package newpackage01;

import ObjectSet.Stobj;
import RoomSet.Room;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Player player= new Player();
    File file = new File("c:\\users\\gianf\\Desktop\\saveFile.txt");
    
    
    public static void main(String[] args){
        new Game();
    }
    
    
    public Game(){
        ui.createUI(cHandler, invHandler);  //accediamo ai metodi della classe UI = crea la finestra di dialogo
        vm.showTitleScreen();   //acceediamo ai metodi della classe VisibilityManager = mostra la schermata iniziale
        story.defaultSetup();   //accediamo ai metodi della classe Story = con i paramentri di default
    }
    
    
     public void saveGameDataToFile(File file) {   
       
    try {   
        FileOutputStream fileStream = new FileOutputStream(file);   
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   

        objectStream.writeObject(player.getCurrentHp());
        objectStream.writeObject(player.getWeapon());   //??
        objectStream.writeObject(player.getMoney());   
        objectStream.writeObject(player.getInventory());   
        objectStream.writeObject(player.getCurrentRoom());  //??    

        objectStream.close();   
        fileStream.close();   

            System.out.println("Save game state successfully."); 
            
    } catch (IOException e) {   
          System.out.println("Failed to save"); 
        }   
    }
    
     
    public void loadGameDataFromFile(File file) throws ClassNotFoundException, FileNotFoundException, IOException{   

    FileInputStream fileStream = new FileInputStream(file);   
    ObjectInputStream objectStream = new ObjectInputStream(fileStream);   

    player.setCurrentHp( (int) objectStream.readObject());
    player.setWeapon((Stobj) objectStream.readObject());     
    player.setMoney((int) objectStream.readObject());   
    player.setInventory((List<Stobj>) objectStream.readObject());   
    player.setCurrentRoom((Room) objectStream.readObject()); 
    
    objectStream.close();
    System.out.println("load game successefully"); 
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
                       loadGameDataFromFile(file);
                   } catch (ClassNotFoundException | IOException ex) {
                       Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
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
                  
                case "salva":
                    saveGameDataToFile(file);
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
                                    ui.inv12.setText("nada");
                                }
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
                
    


