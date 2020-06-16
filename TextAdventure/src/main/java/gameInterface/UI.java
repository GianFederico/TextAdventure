/*
 * Definizione dell'interfaccia utente
 * tramite l'utilizzo di JavaSwing
 */
package gameInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import gameCore.Game.ChoiceHandler;

public class UI{
    private JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inventoryPanel, fightPanel, savePanel, ynPanel;
    private JLabel hpNumberLable;
    private JLabel moneyCountLabel;
    private JLabel saveConfirm;
    private JButton startButton;
    private JButton submit;
    private JButton startButton1;
    private JButton continueButton;
    private JButton attackButton;
    private JButton exitButton1;
    private JButton exitButton2;
    private JButton yesButton;
    private JButton noButton;
    private JButton returnToMenu;
    private JTextField campo;
    private JTextArea mainTextArea, mainTextAreaExit;
    private final Font normalFont= new Font("Times New Roman", Font.PLAIN, 18);
    private final Font invFont=new Font("Times New Roman", Font.PLAIN, 14);
    private String campotxt = "";
    private boolean pressed = false;

    /**
     * Creazione dell'interfaccia.
     * @param cHandler 
     */
    public void createUI(ChoiceHandler cHandler){//}, InventoryHandler invHandler){
        
        //window. Finestra dell'interfaccia
        JFrame window = new JFrame();
        window.setSize(840,650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        //title screen. Schermata del titolo 
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,300);
        titleNamePanel.setBackground(Color.black);
        JLabel titleNameLabel = new JLabel("TextAdventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 85));
        titleNamePanel.add(titleNameLabel);
        
        //Pannello del menù principale
        startButtonPanel= new JPanel();
        startButtonPanel.setBounds(310,400,200,100);
        startButtonPanel.setBackground(Color.black);
        startButtonPanel.setLayout(new GridLayout(4,1));
        
        //Pulsante del nuovo gioco
        startButton = new JButton("NUOVO GIOCO");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButton.setBorder(null);
        startButtonPanel.add(startButton);
        
        //Pulsante del caricamento da file
        continueButton = new JButton("CARICA");
        continueButton.setVisible(true);
        continueButton.setBackground(Color.black);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(cHandler);
        continueButton.setActionCommand("continua");
        continueButton.setBorder(null);
        startButtonPanel.add(continueButton);
        
        //Pulsante esci per chiudere il gioco dal menù principale
        exitButton1 = new JButton("ESCI");
        exitButton1.setBackground(Color.black);
        exitButton1.setForeground(Color.white);
        exitButton1.setFont(normalFont);
        exitButton1.setFocusPainted(false);
        exitButton1.addActionListener(cHandler);
        exitButton1.setActionCommand("exit");
        exitButton1.setBorder(null);
        startButtonPanel.add(exitButton1);

        //Pulsante avanti a seguito del nuovo gioco
        startButton1 = new JButton("Avanti");
        startButton1.setBackground(Color.black);
        startButton1.setForeground(Color.white);
        startButton1.setFont(normalFont);
        startButton1.setFocusPainted(false);
        startButton1.addActionListener(cHandler);
        startButton1.setActionCommand("start1");
        startButtonPanel.add(startButton1);
        
        //Pannello di conferma dell'uscita
        ynPanel= new JPanel();
        ynPanel.setBounds(310,400,200,100);
        ynPanel.setBackground(Color.black);
        ynPanel.setLayout(new GridLayout(4,1));
        ynPanel.setVisible(false);
        
        //Pulsante Sì per la conferma del ritorno al menù principale
        yesButton = new JButton("Sì");
        yesButton.setBackground(Color.black);
        yesButton.setForeground(Color.white);
        yesButton.setFont(normalFont);
        yesButton.setFocusPainted(false);
        yesButton.addActionListener(cHandler);
        yesButton.setActionCommand("yes");
        yesButton.setBorder(null);
        ynPanel.add(yesButton);
        
        //Pulsante No per tornare al gioco dopo aver premuto il pulsante Esci (in game)
        noButton = new JButton("No");
        noButton.setBackground(Color.black);
        noButton.setForeground(Color.white);
        noButton.setFont(normalFont);
        noButton.setFocusPainted(false);
        noButton.addActionListener(cHandler);
        noButton.setActionCommand("no");
        noButton.setBorder(null);
        ynPanel.add(noButton);
        
        //Pulsante Torna al menù principale in caso di caricamento fallito o morte
        returnToMenu = new JButton("Torna al menu principale");
        returnToMenu.setBackground(Color.black);
        returnToMenu.setForeground(Color.white);
        returnToMenu.setFont(normalFont);
        returnToMenu.setFocusPainted(false);
        returnToMenu.addActionListener(cHandler);
        returnToMenu.setActionCommand("BackToMenu");
        returnToMenu.setBorder(null);
        ynPanel.add(returnToMenu);
        
        window.add(titleNamePanel);
        window.add(startButtonPanel);
        window.add(ynPanel);
        
        //Pannello a scomparsa per la visualizzazione dell'inventario
        inventoryPanel=new JPanel();
        inventoryPanel.setBounds(547, 65, 130, 230);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(12,1));
        window.add(inventoryPanel);

        //Pannello per l'area di testo principale
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50,100,650,315);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        //Area di testo principale
        mainTextArea= new JTextArea("");
        mainTextArea.setBounds(50,50,650,600);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
        
        //Area di testo per l'uscita dal gioco
        mainTextAreaExit= new JTextArea("");
        mainTextAreaExit.setBounds(50,50,650,400);
        mainTextAreaExit.setBackground(Color.black);
        mainTextAreaExit.setForeground(Color.white);
        mainTextAreaExit.setFont(normalFont);
        mainTextAreaExit.setLineWrap(true);
        mainTextAreaExit.setEditable(false);
        mainTextAreaExit.setVisible(false);
        mainTextPanel.add(mainTextAreaExit);
        
        //Pannello per contenere il campo per l'inserimento dei comandi e il tasto Submit
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(230,430,400,100);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2,1));
        window.add(choiceButtonPanel);
        
        //Set di Label per l'inventario
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.white);
        JLabel inv1 = new JLabel();
        inv1.setBackground(Color.black);
        inv1.setForeground(Color.white);
        inv1.setFont(invFont);
        inv1.setBorder(border);

        JLabel inv2 = new JLabel();
        inv2.setBackground(Color.black);
        inv2.setForeground(Color.white);
        inv2.setFont(invFont);
        inv2.setBorder(border);

        JLabel inv3 = new JLabel();
        inv3.setBackground(Color.black);
        inv3.setForeground(Color.white);
        inv3.setFont(invFont);
        inv3.setBorder(border);

        JLabel inv4 = new JLabel();
        inv4.setBackground(Color.black);
        inv4.setForeground(Color.white);
        inv4.setFont(invFont);
        inv4.setBorder(border);

        JLabel inv5 = new JLabel();
        inv5.setBackground(Color.black);
        inv5.setForeground(Color.white);
        inv5.setFont(invFont);
        inv5.setBorder(border);

        JLabel inv6 = new JLabel();
        inv6.setBackground(Color.black);
        inv6.setForeground(Color.white);
        inv6.setFont(invFont);
        inv6.setBorder(border);

        JLabel inv7 = new JLabel();
        inv7.setBackground(Color.black);
        inv7.setForeground(Color.white);
        inv7.setFont(invFont);
        inv7.setBorder(border);

        JLabel inv8 = new JLabel();
        inv8.setBackground(Color.black);
        inv8.setForeground(Color.white);
        inv8.setFont(invFont);
        inv8.setBorder(border);

        JLabel inv9 = new JLabel();
        inv9.setBackground(Color.black);
        inv9.setForeground(Color.white);
        inv9.setFont(invFont);
        inv9.setBorder(border);

        JLabel inv10 = new JLabel();
        inv10.setBackground(Color.black);
        inv10.setForeground(Color.white);
        inv10.setFont(invFont);
        inv10.setBorder(border);

        JLabel inv11 = new JLabel();
        inv11.setBackground(Color.black);
        inv11.setForeground(Color.white);
        inv11.setFont(invFont);
        inv11.setBorder(border);

        JLabel inv12 = new JLabel();
        inv12.setBackground(Color.black);
        inv12.setForeground(Color.white);
        inv12.setFont(invFont);
        inv12.setBorder(border);
        
        inventoryPanel.add(inv1);
        inventoryPanel.add(inv2);
        inventoryPanel.add(inv3);
        inventoryPanel.add(inv4);
        inventoryPanel.add(inv5);
        inventoryPanel.add(inv6);
        inventoryPanel.add(inv7);
        inventoryPanel.add(inv8);
        inventoryPanel.add(inv9);
        inventoryPanel.add(inv10);
        inventoryPanel.add(inv11);
        inventoryPanel.add(inv12);
        
        //Campo per l'inserimento dei comandi
        campo= new JTextField ("");           
        campo.setBackground(Color.black);         
        campo.setForeground(Color.DARK_GRAY);
        campo.setFont(normalFont);
        campo.addActionListener(cHandler);
        campo.setActionCommand("submit");
        campo.setText("                            Cosa devo fare?");

        //Al click del mouse su campo, la scritta "Cosa devo fare?" scompare
        campo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                campo.setText("");
                campo.setForeground(Color.white);
            }
        });

        //Alla pressione di un qualsiasi tasto, la scritta "Cosa devo fare?" scompare
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed (java.awt.event.KeyEvent evt){
                if (!pressed) {
                    campo.setForeground(Color.white);
                    campo.setText("");
                    pressed = true;
                }
            }
        });

        //Alla pressione dell tasto invio, ricompare la scritta "Cosa devo fare?" e il testo digitato viene salvato in campotxt
        campo.addActionListener((ActionEvent e) -> {
                 campotxt = campo.getText();
                 campo.setForeground(Color.DARK_GRAY);
                 campo.setText("                           Cosa devo fare?");
                 pressed = false;
         });
        choiceButtonPanel.add(campo);

        //Pulsante per l'ottenimento dei comandi dal campo
        submit= new JButton ("Submit");
        submit.setBackground(Color.black);        
        submit.setForeground(Color.white);
        submit.setFont(normalFont);
        submit.setFocusPainted(false);
        submit.addActionListener(cHandler);
        choiceButtonPanel.add(submit);

        //Alla pressione del JButton "Submit", ricompare la scritta "Cosa devo fare?" e il testo digitato viene salvato in campotxt
        submit.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt) {
                    campotxt = campo.getText();
                    submit.setActionCommand("submit");
                    campo.setForeground(Color.DARK_GRAY);
                    campo.setText("                           Cosa devo fare?");
                    pressed = false;
            }
        });
     
        //Pannello per le statistiche base del giocatore e tasti Salva, Zaino ed Esci
        playerPanel = new JPanel();                     
        playerPanel.setBounds(120,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout( new GridLayout(1,4));
        window.add(playerPanel);
        
        //Pannello per il messaggio di salvataggio avvenuto
        savePanel= new JPanel();
        savePanel.setBounds(720,20,60,50);
        savePanel.setBackground(Color.black);
        window.add(savePanel);
        savePanel.setVisible(false);
        
        //Pannello per la gestione della fase di combattimento
        fightPanel = new JPanel();
        fightPanel.setBounds(230,530,400,50);
        fightPanel.setBackground(Color.black);
        fightPanel.setLayout( new GridLayout(1,4));
        window.add(fightPanel);
        fightPanel.setVisible(false);
        
        //Pulsante Attacca in combattimento
        attackButton= new JButton ("Attacca");
        attackButton.setBackground(Color.black);        
        attackButton.setForeground(Color.white);
        attackButton.setFont(normalFont);
        attackButton.setFocusPainted(false);
        attackButton.addActionListener(cHandler);
        attackButton.setActionCommand("attacca");
        fightPanel.add(attackButton);
        
        //Pulsante Usa pozione in combattimento
        JButton useButton = new JButton("Usa pozione");
        useButton.setBackground(Color.black);        
        useButton.setForeground(Color.white);
        useButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        useButton.setFocusPainted(false);
        useButton.addActionListener(cHandler);
        useButton.setActionCommand("usa");
        fightPanel.add(useButton);
        
        //Pulsante Scappa in combattimento
        JButton runButton = new JButton("Scappa");
        runButton.setBackground(Color.black);        
        runButton.setForeground(Color.white);
        runButton.setFont(normalFont);
        runButton.setFocusPainted(false);
        runButton.addActionListener(cHandler);
        runButton.setActionCommand("scappa");
        fightPanel.add(runButton);
        
        //Pulsante Osserva in combattimento
        JButton lookButton = new JButton("Osserva");
        lookButton.setBackground(Color.black);        
        lookButton.setForeground(Color.white);
        lookButton.setFont(normalFont);
        lookButton.setFocusPainted(false);
        lookButton.addActionListener(cHandler);
        lookButton.setActionCommand("osserva");
        fightPanel.add(lookButton);
        
        //Label per gli HP del giocatore 
        JLabel hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        
        //Label per il numero effettivo degli HP del giocatore (Correnti/Totali)
        hpNumberLable= new JLabel();
        hpNumberLable.setForeground(Color.white);
        hpNumberLable.setFont(normalFont);
        playerPanel.add(hpNumberLable);
        
        //Label per le Monete del giocatore
        JLabel moneyLabel = new JLabel("MONETE:");
        moneyLabel.setForeground(Color.white);
        moneyLabel.setFont(normalFont);
        playerPanel.add(moneyLabel);
        
        //Label per il numero effettivo di monete del giocatore 
        moneyCountLabel= new JLabel();
        moneyCountLabel.setForeground(Color.white);
        moneyCountLabel.setFont(normalFont);
        playerPanel.add(moneyCountLabel); 

        //Pulsante Zaino per l'apertura e chiusura dell'inventario
        JButton inventoryButton = new JButton("Zaino");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(cHandler);
        inventoryButton.setActionCommand("inventoryButton");
        playerPanel.add(inventoryButton);
        
        //Pulsante Salva
        JButton saveButton = new JButton("Salva");
        saveButton.setBackground(Color.black);
        saveButton.setForeground(Color.white);
        saveButton.setFont(normalFont);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(cHandler);
        saveButton.setActionCommand("salva");
        playerPanel.add(saveButton);
        
        //Pulsante Esci sulla schermata di gioco (in game)
        exitButton2 = new JButton("Esci");
        exitButton2.setBackground(Color.black);
        exitButton2.setForeground(Color.white);
        exitButton2.setFont(normalFont);
        exitButton2.setFocusPainted(false);
        exitButton2.addActionListener(cHandler);
        exitButton2.setActionCommand("exitMenu");
        playerPanel.add(exitButton2);

        //Label per la conferma del salvataggio avvenuto
        saveConfirm= new JLabel("");
        saveConfirm.setForeground(Color.white);
        saveConfirm.setFont(normalFont);
        savePanel.add(saveConfirm);
        
        window.setVisible(true);
    }
      
    public String getCampotxt() {
        return campotxt;
    }

    public JTextArea getMainTextArea() {
        return mainTextArea;
    }

    public JTextArea getMainTextAreaExit() {
        return mainTextAreaExit;
    }

    public JTextField getCampo() {
        return campo;
    }

    public JPanel getTitleNamePanel() {
        return titleNamePanel;
    }

    public JPanel getStartButtonPanel() {
        return startButtonPanel;
    }

    public JPanel getMainTextPanel() {
        return mainTextPanel;
    }

    public JPanel getChoiceButtonPanel() {
        return choiceButtonPanel;
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

    public JPanel getFightPanel() {
        return fightPanel;
    }

    public JPanel getSavePanel() {
        return savePanel;
    }

    public JPanel getYnPanel() {
        return ynPanel;
    }

    public JLabel getHpNumberLable() {
        return hpNumberLable;
    }

    public JLabel getMoneyCountLabel() {
        return moneyCountLabel;
    }

    public JLabel getSaveConfirm() {
        return saveConfirm;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStartButton1() {
        return startButton1;
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public JButton getExitButton1() {
        return exitButton1;
    }

    public JButton getYesButton() {
        return yesButton;
    }

    public JButton getNoButton() {
        return noButton;
    }

    public JButton getReturnToMenu() {
        return returnToMenu;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
    
    
}

