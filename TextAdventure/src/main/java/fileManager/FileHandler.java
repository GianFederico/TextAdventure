/**
 * Classe utile alla scrittura e lettura dei file di salvataggio
 */
package fileManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gameCore.Map;
import gameCore.Player;

public class FileHandler {

     /**
      * Salvataggio dell'oggetto Map su file
      * @param file
      * @param map
      * @return boolean savemap true se il salvataggio è avvenuto con successo, false altrimenti
      */
     public boolean saveMapDataToFile(File file, Map map) {
         boolean savemap = false;
         
         try {
            FileOutputStream fileStream = new FileOutputStream(file);   
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   

            objectStream.writeObject(map);

            objectStream.close();   
            fileStream.close();   

            System.out.println("Save map state successfully.");
            savemap = true;
         } catch (IOException e) {
            System.out.println("Failed to save");
            e.printStackTrace();
         }
         return savemap;
    }
     
     /**
      * Salvataggio dell'oggetto Player su file
      * @param file
      * @param player
      * @return boolean savepl true se il salvataggio è avvenuto con successo, false altrimenti
      */
     public boolean savePlayerDataToFile(File file, Player player) {
         boolean savepl = false;

         try {
            FileOutputStream fileStream = new FileOutputStream(file);   
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   


            objectStream.writeObject(player);

            objectStream.close();   
            fileStream.close();   

            System.out.println("Save player state successfully.");
            savepl = true;


         } catch (IOException e) {
            System.out.println("Failed to save"); 
            e.printStackTrace();
         }
         return savepl;
    }
    
    /**
     * Caricamento dei dati da file sull'oggetto Map
     * @param file
     * @return Oggetto Map caricato da file
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException 
     */ 
    public Map loadMapDataFromFile(File file) throws ClassNotFoundException, FileNotFoundException, IOException{  
        
        Map filemap = new Map();
        
        FileInputStream fileStream = new FileInputStream(file);   
        
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);   

        filemap.setMap((Map)objectStream.readObject());

        objectStream.close();
        
        System.out.println("Map loaded successefully");

        return filemap; 
     }
    
    /**
     * Caricamento dei dati da file sull'oggetto Player
     * @param file
     * @return Oggetto Player caricato da file
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException 
     */ 
    public Player loadPlayerDataFromFile(File file) throws ClassNotFoundException, FileNotFoundException, IOException{   

        Player fileplayer = new Player();

        FileInputStream fileStream = new FileInputStream(file);   

        ObjectInputStream objectStream = new ObjectInputStream(fileStream);   

         fileplayer.setPlayer((Player)objectStream.readObject());

        objectStream.close();

         System.out.println("Player loaded successefully");

         return fileplayer;
    }
}
