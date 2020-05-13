package RoomSet;

import ObjectSet.Stobj;
import java.util.ArrayList;
import java.util.List;
import newpackage01.Player;
import newpackage03.SuperMonster;

public class Room {

    //private int id;
    private String name;
    private String description;
    private Room south = null;
    private Room north = null;
    private Room east = null;
    private Room west = null;
    private int money = 0;
    private List<Stobj> objects = new ArrayList<>();
    private SuperMonster monster = new SuperMonster();
    private Room nextNorth = null;
    private Room nextEast = null; 
    private Room nextWest = null;
    private Room nextSouth = null;
           
    public Room() {}

    /*public Room(int id) {
        this.id = id;
    }

    public Room(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }*/
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Room(String name, String description, List<Stobj> objects) {
        this.name = name;
        this.description = description;
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }*/

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public List<Stobj> getObjects() {
        return objects;
    }
    
    public void setObject(List<Stobj> objects){
        this.objects = objects;
    }
    
    public void addObject(Stobj object){
        this.objects.add(object);
    }
    
    public void setMoney(int money){
        this.money=money;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void setMonster(SuperMonster monster){
        this.monster = monster;
    }
    
    public SuperMonster getMonster(){
        return this.monster;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }*/

    
    public void setNextNorth(Room nextNorth){
        this.nextNorth = nextNorth;
    }
    
    public Room getNextNorth(){
        return this.nextNorth;
    }
    
    public void setNextWest(Room nextWest){
        this.nextWest = nextWest;
    }
    
    public Room getNextWest(){
        return this.nextWest;
    }
    
    public void setNextEast(Room nextEast){
        this.nextEast = nextEast;
    }
    
    public Room getNextEast(){
        return this.nextEast;
    }

    public void setNextSouth(Room nextEast){
        this.nextSouth = nextSouth;
    }

    public Room getNextSouth(){
        return this.nextSouth;
    }

    public void buy(Player p, Stobj buy) {
        System.out.println("Non c'è nulla da comprare");
    }

    public void openDoor(){};

    public void closeDoor(){};

    public void fightSequence(Player p){} //System.out.println("Non c'è nulla da combattere qui...");


    //DA RICORDARE: Se c'è un mostro nella stanza, non ci si può guardare intorno->Si restituisce un messaggio con scritto che il mostro blocca la visuale
    //Significa che Visible degli oggetti serve solo per il muro con l'enigma, la trappola/botola e la gemma della viverna
    
}
