package newpackage01;

import java.util.List;
import ObjectSet.Stobj;
import java.util.ArrayList;
import RoomSet.Room;
import java.io.Serializable;
import java.util.Arrays;

  
public class Player implements Serializable {

    private final int tothp=40;
    private int currenthp=40;
    private Stobj weapon;
    private int money=0;
    private List<Stobj> inventory = new ArrayList<>();
    private Room currentRoom = new Room();
    private Room previousRoom = new Room();

    public int getTotHp(){
        return this.tothp;
    }

    public void setCurrentHp(int hp){
        this.currenthp = hp;
    }

    public int getCurrentHp(){
        return this.currenthp;
    }

    public void setWeapon(Stobj weapon){
        this.weapon = weapon;
    }

    public Stobj getWeapon(){
        return this.weapon;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return this.money;
    }

    public void setInventory(List<Stobj> inventory){
        this.inventory = inventory;
    }

    public List<Stobj> getInventory(){
        return this.inventory;
    }

    public void addToInventory(Stobj obj) {
        this.inventory.add(obj);
    }

    public void removeFromInventory(Stobj obj) {
        this.inventory.remove(obj);
    }

    public void removeFromInventory(int i){this.inventory.remove(i);}

    public void setCurrentRoom(Room current){
        this.currentRoom = current;
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public void setPreviousRoom(Room previous){
        this.previousRoom = previous;
    }

    public Room getPreviousRoom(){
        return this.previousRoom;
    }
}
