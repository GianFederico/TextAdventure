/*
 * Classe per la gestione delle transizioni UI fra le varie schermata di gioco
 * (schermata del titolo, schermata di gioco principale, inventario, schermata di combattimento, salvataggio e caricamento)
 */
package gameInterface;

import javax.swing.*;
import java.awt.*;

public class VisibilityManager {
     UI ui;
    
     public VisibilityManager(UI userInterface){
        ui=userInterface;
    }

     /**
     * Mostra la schermata del titolo con i tasti "Nuovo gioco", "Carica" ed "Esci"
     */
     public void showTitleScreen(){
        ui.getTitleNamePanel().setVisible(true);
        ui.getStartButtonPanel().setVisible(true);
        ui.getStartButton().setVisible(true);
        ui.getContinueButton().setVisible(true);
        ui.getExitButton1().setVisible(true);
         
        ui.getMainTextArea().setVisible(false);
        ui.getChoiceButtonPanel().setVisible(false);
        ui.getPlayerPanel().setVisible(false);
        ui.getInventoryPanel().setVisible(false);
        ui.getStartButton1().setVisible(false);
        ui.getYnPanel().setVisible(false);
        ui.getReturnToMenu().setVisible(false);
        ui.getMainTextAreaExit().setVisible(false);
    }

     /**
     * Apre l'inventario quando si preme il tasto "Zaino" mostrando il pannello con vari lables
     */
     public void openInventory(){
        ui.getInventoryPanel().setVisible(true);
    }
    
     /**
     * Chiude l'inventario
     */
     public void closeInventory(){
        ui.getInventoryPanel().setVisible(false);
    }
    
     /**
     * Passa dalla schermata del titolo a quella della descrizione iniziale con il tasto "Avanti" nascondendo tutto il resto (nuovo gioco)
     */
     public void titleToInput(){
        ui.getMainTextPanel().setVisible(true);
        ui.getStartButtonPanel().setVisible(true);
        ui.getStartButton1().setVisible(true);
        ui.getMainTextArea().setVisible(true);
        
        ui.getTitleNamePanel().setVisible(false);
        ui.getInventoryPanel().setVisible(false);
        ui.getChoiceButtonPanel().setVisible(false);
        ui.getPlayerPanel().setVisible(false);
        ui.getStartButton().setVisible(false);
        ui.getContinueButton().setVisible(false);
        ui.getFightPanel().setVisible(false);
        ui.getExitButton1().setVisible(false);
        ui.getYnPanel().setVisible(false);
        ui.getReturnToMenu().setVisible(false);
        ui.getMainTextAreaExit().setVisible(false);
    }
    
     /**
     * Mostra tutti i tasti utili alla fase di combattimento e nasconde "Submit" e il campo di inserimento input
     */
     public void showFightButtons(){
        ui.getFightPanel().setVisible(true);
        ui.getChoiceButtonPanel().setVisible(false);
        ui.getYnPanel().setVisible(false);
        ui.getReturnToMenu().setVisible(false);
    }
    
     /**
     * Mostra "Submit" e il campo di inserimento input e nasconde tutti i tasti della fase di combattimento
     */
     public void hideFightButtons(){
        ui.getFightPanel().setVisible(false);
        ui.getChoiceButtonPanel().setVisible(true);
    }
    
     /**
     * Se il salvataggio del player p e della mappa m vanno a buon fine, mostra il lable "Salvato!", altrimenti mostra il lable "Save error"
     * @param m
     * @param p 
     */
     public void showSaved(boolean m, boolean p) {
        ui.getSaveConfirm().setVisible((true));
        if (m && p) {
            ui.getSaveConfirm().setText("Salvato!");
        }
        else {
            ui.getSaveConfirm().setText("Save error");
        }
     }
    
     /**
     * Nasconde il lable della conferma di salvataggio (o errore nel salvataggio)
     */
        public void hideSaved(){
        ui.getSaveConfirm().setVisible(false);
    }
    
     /**
     * Nasconde il titolo e i tasti del menù principale e mostra la schermata di gioco (carica)
     */
     public void titleToGame(){
        ui.getTitleNamePanel().setVisible(false);
        ui.getStartButtonPanel().setVisible(false);
        ui.getInventoryPanel().setVisible(false);
        ui.getFightPanel().setVisible(false);
        ui.getYnPanel().setVisible(false);
        ui.getReturnToMenu().setVisible(false);
        ui.getMainTextAreaExit().setVisible(false);

        ui.getMainTextArea().setVisible(true);
        ui.getMainTextPanel().setVisible(true);
        ui.getChoiceButtonPanel().setVisible(true);
        ui.getCampo().setVisible(true);
        ui.getPlayerPanel().setVisible(true);

        ui.getCampo().setForeground(Color.DARK_GRAY);
        ui.getCampo().setText("                            Cosa devo fare?");
        ui.getCampo().grabFocus();
        ui.setPressed(false);
    }
     
     /**
      * Nasconde tutto tranne l'area di testo e il tasto "Torna al menù princiaple" (sconfitta)
      */
     public void defeatScreen(){
         ui.getStartButtonPanel().setVisible(true);
         ui.getMainTextArea().setVisible(true);
         ui.getYnPanel().setVisible(true);
         ui.getReturnToMenu().setVisible(true);
         
         ui.getPlayerPanel().setVisible(false);
         ui.getInventoryPanel().setVisible(false);
         ui.getChoiceButtonPanel().setVisible(false);
         ui.getFightPanel().setVisible(false);
         ui.getMainTextAreaExit().setVisible(false);
         ui.getStartButton1().setVisible(false);
         ui.getYesButton().setVisible(false);
         ui.getNoButton().setVisible(false);
         ui.getStartButtonPanel().setVisible(false);
     }
     
     /**
     * Mostra la schermata per la conferma di uscita dal gioco con i relativi pulsanti "Sì" e "No". Nasconde tutto il resto
     */
     public void exitConfirm(){
         ui.getPlayerPanel().setVisible(false);
         ui.getInventoryPanel().setVisible(false);
         ui.getChoiceButtonPanel().setVisible(false);
         ui.getFightPanel().setVisible(false);
         ui.getMainTextArea().setVisible(false);
         
         ui.getMainTextAreaExit().setVisible(true);
         ui.getYnPanel().setVisible(true);
         ui.getReturnToMenu().setVisible(false);
         ui.getYesButton().setVisible(true);
         ui.getNoButton().setVisible(true);
    }
     
     /**
      * Nasconde la schemrata per la conferma di uscita dal gioco e i relativi tasti "Sì" e "No"
      */
     public void hideExitConfirm(){
         ui.getYnPanel().setVisible(false);
         ui.getReturnToMenu().setVisible(false);
         ui.getMainTextAreaExit().setVisible(false);
     }
     
     /**
      * Mostra la schermata di notifica di caricamento fallito con il singolo tasto "Torna al menù principale"
      */
     public void backToMenu(){
         ui.getPlayerPanel().setVisible(false);
         ui.getInventoryPanel().setVisible(false);
         ui.getChoiceButtonPanel().setVisible(false);
         ui.getFightPanel().setVisible(false);
         ui.getMainTextArea().setVisible(false);
         ui.getYesButton().setVisible(false);
         ui.getNoButton().setVisible(false);
         
         ui.getMainTextAreaExit().setVisible(true);
         ui.getYnPanel().setVisible(true);
         ui.getReturnToMenu().setVisible(true);
     }

     /**
      * Mostra la schemrata principale del gioco
      */
     public void showMainGameScreen(){
         ui.getPlayerPanel().setVisible(true);
         ui.getMainTextArea().setVisible(true);
         ui.getChoiceButtonPanel().setVisible(true);
         ui.getSavePanel().setVisible(true);
     }
     
     /**
      * Imposta il font base di gioco tramite la dimensione (size)
      * @param size 
      */
     public void setNormalFont(int size){
        Font f= new Font("Times New Roman", Font.PLAIN, size);
        ui.getMainTextArea().setFont(f);
     }

     /**
      * imposta il font per la fase di combattimento ricevendo in input la grandezza desiderata
      * @param size 
      */
     public void setFightFont(int size){
        Font f= new Font("Consolas", Font.PLAIN, size);
        ui.getMainTextArea().setFont(f);
     }
   
     /**
     * Visualizza sull'interfaccia, nell'area di testo principale, il testo text
     * @param text 
     */
     public void writeOnScreen(String text){
         ui.getMainTextArea().setText(text);
     }

     /**
      * Visualizza sull'interfaccia, nell'area di testo dedicata a quando si clicca il tasto "Esci" oppure si viene sconfitti, il testo text
      * @param text 
      */
     public void writeOnExitScreen(String text){
        ui.getMainTextAreaExit().setText(text);
    }

     /**
     * Imposta il lable per il conteggio delle monete m che vengono raccolte
     * @param m 
     */
     public void setMoneyCount(int m){
         ui.getMoneyCountLabel().setText(Integer.toString(m));
     }

     /**
      * Imposta tutte le dimensioni per il pannello dell'area di testo x ed y identificano il punto di partenza, width e height invece larghezza e altezza
      * @param x
      * @param y
      * @param width
      * @param height 
      */
     public void setMainTextPanelSize(int x, int y, int width, int height){
         ui.getMainTextPanel().setBounds(x, y, width, height);
     }

     /**
     * Imposta il lable per il conteggio degli hp del player (correnti/totali)
     * @param cur
     * @param tot
     */     
     public void setHpLabel(int cur, int tot){
         ui.getHpNumberLable().setText(""+ cur + "/" + tot);
     }

     /**
      * Restituisce il focus al campo per l'inserimento dell'input
      */
     public void campoFocus(){
         if (ui.getCampo().isVisible())
             ui.getCampo().grabFocus();
     }

     /**
     * Restituisce il componente i-esimo dei lable facenti parte dell'inventare
     * @param i
     * @return
     */
     public JLabel getInvLableComponent(int i){
        return ((JLabel)ui.getInventoryPanel().getComponent(i));
     }

     /**
     * Restituisce il contenuto di campoTxt, ovvero la stringa in ingresso scritta dall'utente
     * @return
     */
     public String getCampoTxt(){
        return ui.getCampotxt();
    }
}
