/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileCreation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import newpackage01.Player;


/**
 *
 * @author gianl
 */
public class FileWriter {
    
    private Player player = new Player();
    private Map map = new Map();

     public void saveGameDataToFile(File file) {   
       
    try {   
        FileOutputStream fileStream = new FileOutputStream(file);   
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   

       
        objectStream.writeObject((Player)player);
        objectStream.writeObject((Map) map);

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

      player.setPlayer((Player)objectStream.readObject());
      map.setMap((Map)objectStream.readObject());

    objectStream.close();
    System.out.println("load game successefully"); 
    
    }
}
