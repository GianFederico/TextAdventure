/*
 * classe che serve per gestire le trasizioni fra le varie schermata di gioco
 * come quella del titolo, e del gioco vero e proprio, o inventario (da implementare)
 * combat, o altri menu
 */
package newpackage01;

public class VisibilityManager {
    UI ui;
    
    public VisibilityManager(UI userInterface){
        
        ui=userInterface;
    }

    public void showTitleScreen(){
       //mostra schermata del titolo 
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        
        //nasconde schermata di gioco e inventario
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.inventoryPanel.setVisible(false);
    }
    
    public void openInventory(){
    
        ui.inventoryPanel.setVisible(true);
       //mostra schermata dell'inventario 

    }
    
    public void closeInventory(){
       //chiude schermata dell'inventario 
        ui.inventoryPanel.setVisible(false);

    }
    
    public void titleToGame(){
        //nasconde schermata del titolo e inventario
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.inventoryPanel.setVisible(false);
        
        //mostra schermata di gioco
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
