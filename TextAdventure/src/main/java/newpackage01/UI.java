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

public class UI  {
    JFrame window;                                                                                                                                                                                                                                                                   //FINESTRA GENERALE
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inventoryPanel, inventoryDescPanel;                                                                                               //pannelli vari all'interno della finestra
    JLabel titleNameLabel, hpLabel, hpNumberLable, weaponLabel, weaponNameLabel, currentRoomLable,currentRoomNameLable, inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8, inv9, inv10, inv11, inv12;                 //parti dei pannelli
    JButton startButton, submit, inventoryButton, startButton1, saveButton, continueButton;                                                                                                                                     //pulsanti
    private JTextField campo;
    JTextArea mainTextArea,invInfoArea;                                                                                                                                                                                                                                                       //area del testo in game
    Font titleFont= new Font("Times New Roman", Font.PLAIN, 85);
    Font normalFont= new Font("Times New Roman", Font.PLAIN, 18);
    Font invFont=new Font("Times New Roman", Font.PLAIN, 14);
    Timer timer;
        private String text; //serve in timer 
        int i=0;//serve in timer
        String desc=""; //descrizione degli oggetti nell'inventario    
    
        Game game;
        
        private String campotxt = new String();

    public void createUI(ChoiceHandler cHandler, InventoryHandler invHandler){
        
        //window
        window= new JFrame();
        window.setSize(900,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        //title screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(130,100,600,300);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("AVVENTURA");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        
        startButtonPanel= new JPanel();
        startButtonPanel.setBounds(330,400,200,100);
        startButtonPanel.setBackground(Color.black);
        startButtonPanel.setLayout(new GridLayout(3,2));
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButton.setBorder(null);
        startButtonPanel.add(startButton);
        
        continueButton = new JButton("CONTINUA");
        continueButton.setVisible(true);
        continueButton.setBackground(Color.black);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(cHandler);
        continueButton.setActionCommand("continua");
        continueButton.setBorder(null);
        startButtonPanel.add(continueButton);

        startButton1 = new JButton("Avanti");
        startButton1.setBackground(Color.black);
        startButton1.setForeground(Color.white);
        startButton1.setFont(normalFont);
        startButton1.setFocusPainted(false);
        startButton1.addActionListener(cHandler);
        startButton1.setActionCommand("start1");
        startButtonPanel.add(startButton1);
        
        window.add(titleNamePanel);
        window.add(startButtonPanel);
        
        //GAME SCREEN
        inventoryPanel=new JPanel();
        inventoryPanel.setBounds(620, 65, 180, 300);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(10,1));
        window.add(inventoryPanel);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50,100,650,300);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea= new JTextArea("");
        mainTextArea.setBounds(50,50,650,350);
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
        choiceButtonPanel.setBounds(230,400,400,100);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2,1));
        window.add(choiceButtonPanel);
        

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
        
        inventoryDescPanel=new JPanel();
        inventoryDescPanel.setBounds(548, 245, 350, 100);/////////////////////////////////
        inventoryDescPanel.setBackground(Color.black);
        window.add(inventoryDescPanel);
        inventoryDescPanel.setVisible(false);
        
        invInfoArea=new JTextArea();
        invInfoArea.setBackground(Color.black);
        invInfoArea.setForeground(Color.white);
        invInfoArea.setFont(invFont);
        inventoryDescPanel.add(invInfoArea);
        invInfoArea.setVisible(false);
        
                                    inv1.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                        if(game.player.getInventory().get(0)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc= game.player.getInventory().get(0).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                        }
                                                        else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv2.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(1)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(1).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv3.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(2)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(2).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv4.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(3)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(3).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv5.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(4)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(4).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv6.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(5)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(5).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv7.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(6)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(6).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv8.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(7)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(7).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv9.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(8)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(8).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv10.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(9)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(9).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv11.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(10)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(10).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });
                                    
                                    inv12.addMouseListener(new MouseAdapter(){
                                                    @Override
                                                    public void mouseEntered(MouseEvent e){
                                                         if(game.player.getInventory().get(11)!= null){
                                                            inventoryDescPanel.setVisible(true);
                                                            invInfoArea.setVisible(true);
                                                            desc=game.player.getInventory().get(11).getDescription() ;
                                                            invInfoArea.setText(desc); //descrizione oggetto
                                                         }
                                                          else{
                                                            desc="" ;
                                                        }
                                                            System.out.println("mouse sopra");
                                                    }
                                                    @Override
                                                    public void mouseExited(MouseEvent e){
                                                            invInfoArea.setVisible(false);
                                                             System.out.println("mouse uscito");
                                                    }
                                                    
                                                });


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
        campo.setActionCommand("submit"); //questo doveva stare fuori dall'action listener
        choiceButtonPanel.add(campo);
        
                   campo.addActionListener((ActionEvent e) -> {
                            campotxt = campo.getText();     
                            campo.setText("");
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
                                        campotxt = campo.getText();
                                        submit.setActionCommand("submit");
                                        
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
        
        currentRoomLable= new JLabel("STANZA:");
        currentRoomLable.setForeground(Color.white);
        currentRoomLable.setFont(normalFont);
        playerPanel.add(currentRoomLable);
        currentRoomNameLable= new JLabel();
        currentRoomNameLable.setForeground(Color.white);
        currentRoomNameLable.setFont(normalFont);
        playerPanel.add(currentRoomNameLable); 
        
        inventoryButton = new JButton("Zaino");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(invHandler);
        inventoryButton.setActionCommand("inventoryButton");
        playerPanel.add(inventoryButton);
        
        saveButton = new JButton("Salva");
        saveButton.setBackground(Color.black);
        saveButton.setForeground(Color.white);
        saveButton.setFont(normalFont);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(cHandler);
        saveButton.setActionCommand("salva");
        playerPanel.add(saveButton);
        

        window.setVisible(true);
    }
      
        public void prepareText(){
        i=0;                                               //setta i=0 per il timer
        mainTextArea.setText("");       //cancella il testo precedente
        timer.start();                              //fa partire il timer
    }

       public void inputDescription1(){
       prepareText();  
       text="In questo gioco "; /*impersonerai un giovanissimo avventuriero, in un ambiente fantasy, che si ritrova a dover lottare contro la malattia di sua madre, "
                                                        + "alla quale, neanche i chierici del villaggio in cui vivi, hanno saputo dare risposta...\n\n"
               + "L'unica maniera per salvarla, è cercare l'ex sciamano del villaggio, esiliato dagli altri abitanti perchè ritenuto pericoloso, che vive ormai da molti anni "
                                                        + "in solitudine sulla montagna a Nord, oltre la foresta...\n\n"
               + "DESCRIZIONE COMANDI\n */
    }

    public String getCampotxt() {
        return campotxt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JTextField getCampo() {
        return campo;
    }
    
    
}

