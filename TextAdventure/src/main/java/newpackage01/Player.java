package newpackage01;

import java.util.List;
import ObjectSet.Stobj;
import java.util.ArrayList;


public class Player {
    
    private int hp=20;
    private Stobj weapon;
    private int money=0;
    private List<Stobj> inventory = new ArrayList<>();;
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    public int getHp(){
        return this.hp;
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
}
