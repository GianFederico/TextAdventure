/*
 * classe che definisce tutta l'interfaccia utente
 * tramite l'utilizzo di JavaSwing
 */
package newpackage01;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import newpackage01.Game.ChoiceHandler;
import newpackage01.Game.InventoryHandler;

public class UI {
    JFrame window;                                                                                                                                                                                                                                                                   //FINESTRA GENERALE
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inventoryPanel;                                                                                               //pannelli vari all'interno della finestra
    JLabel titleNameLabel, hpLabel, hpNumberLable, weaponLabel, weaponNameLabel, inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8, inv9, inv10, inv11, inv12;                 //parti dei pannelli
    JButton startButton, submit, inventoryButton;                                                                                                                                                                                                                 //pulsanti
    JTextField campo;
    JTextArea mainTextArea;                                                                                                                                                                                                                                                       //area del testo in game
    Font titleFont= new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont= new Font("Times New Roman", Font.PLAIN, 20);
    Font invFont=new Font("Times New Roman", Font.PLAIN, 15);
    Timer timer;
        String text; //serve in timer 
        int i=0;//serve in timer
    
    
    public void createUI(ChoiceHandler cHandler, InventoryHandler invHandler){
        
        //window
        window= new JFrame();
        window.setSize(920,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        //title screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("AVVENTURA");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        
        startButtonPanel= new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);
        
        window.add(titleNamePanel);
        window.add(startButtonPanel);
        
        //GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50,100,650,300);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);
        
        mainTextArea= new JTextArea("");
        mainTextArea.setBounds(50,50,650,300);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

                            timer = new Timer(30, new ActionListener(){   //timer serve per mostrare un carattere alla volta
                            @Override
                            public void actionPerformed(ActionEvent e){                              
                                char character[]= text.toCharArray();              //mette il testo in un array di char lettera per lettera
                                int arrayNumber = character.length;             //prendiamo la dimensione

                                String addedChar="";
                                String blank="";

                                addedChar=blank+character[i];                     //creo la stringa perchè append non funziona con i char
                                mainTextArea.append(addedChar);             //mostro a schermo lettera dopo lettera
                                i++;

                                    if(i==arrayNumber){                                    //se i= numero di char nell'array vuol dire che ho finito di mostrare i caratteri per quella schermata
                                        i=0;
                                        timer.stop();
                                    }
                            }
                        });
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(200,350,400,100);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2,1));
        window.add(choiceButtonPanel);

        inventoryPanel=new JPanel();
        inventoryPanel.setBounds(720, 65, 180, 230);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(10,1));
        window.add(inventoryPanel);
        
        
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.white);  //non so perchè me l'abbia fatto fare così, era l'unico modo per metterci i bordi
        inv1=new JLabel();
        inv1.setBackground(Color.black);
        inv1.setForeground(Color.white);
        inv1.setFont(invFont);
        inv1.setBorder(border);
  
        inv2=new JLabel();
        inv2.setBackground(Color.black);
        inv2.setForeground(Color.white);
        inv2.setFont(invFont);
        inv2.setBorder(border);

        inv3=new JLabel();
        inv3.setBackground(Color.black);
        inv3.setForeground(Color.white);
        inv3.setFont(invFont);
        inv3.setBorder(border);

        inv4=new JLabel();
        inv4.setBackground(Color.black);
        inv4.setForeground(Color.white);
        inv4.setFont(invFont);
        inv4.setBorder(border);

        inv5=new JLabel();
        inv5.setBackground(Color.black);
        inv5.setForeground(Color.white);
        inv5.setFont(invFont);
        inv5.setBorder(border);

        inv6=new JLabel();
        inv6.setBackground(Color.black);
        inv6.setForeground(Color.white);
        inv6.setFont(invFont);
        inv6.setBorder(border);

        inv7=new JLabel();
        inv7.setBackground(Color.black);
        inv7.setForeground(Color.white);
        inv7.setFont(invFont);
        inv7.setBorder(border);

        inv8=new JLabel();
        inv8.setBackground(Color.black);
        inv8.setForeground(Color.white);
        inv8.setFont(invFont);
        inv8.setBorder(border);

        inv9=new JLabel();
        inv9.setBackground(Color.black);
        inv9.setForeground(Color.white);
        inv9.setFont(invFont);
        inv9.setBorder(border);

        inv10=new JLabel();
        inv10.setBackground(Color.black);
        inv10.setForeground(Color.white);
        inv10.setFont(invFont);
        inv10.setBorder(border);

        inv11=new JLabel();
        inv11.setBackground(Color.black);
        inv11.setForeground(Color.white);
        inv11.setFont(invFont);
        inv11.setBorder(border);

        inv12=new JLabel();
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


        campo= new JTextField ("");           
        campo.setBackground(Color.black);         
        campo.setForeground(Color.white);
        campo.setFont(normalFont);
        campo.addActionListener(cHandler);
        choiceButtonPanel.add(campo);
        
                            campo.addActionListener(new ActionListener(){
                                                    @Override
                                                    public void actionPerformed(ActionEvent e){
                                                           String campotxt=campo.getText();

                                                           campo.setText("");
                                                    }
                                                });
        
        submit= new JButton ("Submit");
        submit.setBackground(Color.black);        
        submit.setForeground(Color.white);
        submit.setFont(normalFont);
        submit.setFocusPainted(false);
        submit.addActionListener(cHandler);
        choiceButtonPanel.add(submit);
        
                            submit.addMouseListener(new MouseAdapter(){
                                @Override
                                public void mousePressed(MouseEvent evt) {
                                        String campotxt = campo.getText();
                                        submit.setActionCommand(campotxt);
                                        
                                        campo.setText("");
                                }
                            });
     
       
        playerPanel = new JPanel();                     //pannello in alto con HP e ARMA e INVENTARIO
        playerPanel.setBounds(120,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout( new GridLayout(1,4));
        window.add(playerPanel);
        
        hpLabel= new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpNumberLable= new JLabel();
        hpNumberLable.setForeground(Color.white);
        hpNumberLable.setFont(normalFont);
        playerPanel.add(hpNumberLable);
        weaponLabel= new JLabel("ARMA:");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);
        weaponNameLabel= new JLabel();
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setFont(normalFont);
        playerPanel.add(weaponNameLabel); 
        
        inventoryButton = new JButton("Inventario");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(invHandler);
        inventoryButton.setActionCommand("inventoryButton");
        playerPanel.add(inventoryButton);

        window.setVisible(true);
    }
}
