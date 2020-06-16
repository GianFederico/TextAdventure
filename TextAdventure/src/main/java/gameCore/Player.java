package gameCore;

import objectSet.Armor;
import java.util.List;
import base.Stobj;
import objectSet.Weapon;
import java.util.ArrayList;
import java.io.Serializable;

  
public class Player implements Serializable {

    private final int tothp = 40;
    private int currenthp = 40;
    private int money = 0;
    private List<Stobj> inventory = new ArrayList<>();
    private int dmg = 0;
    private int def = 0;

    public int getTotHp(){
        return this.tothp;
    }

    public void setCurrentHp(int hp){
        this.currenthp = hp;
    }

    public int getCurrentHp(){
        return this.currenthp;
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
    
    public void setPlayer(Player p){
       this.setCurrentHp(p.getCurrentHp());
       this.setInventory(p.getInventory());
       this.setMoney(p.getMoney());
    }

    public int getDmg() {
        return this.dmg;
    }

    public void setDmg() {
        for (Stobj inv : this.getInventory()) {
                    if (inv.getName().equals("Spada") || inv.getName().equals("Coltello")) {
                        this.dmg = ((Weapon)inv).getDamage();
                    }
        }
    }

    public int getDef() {
        return this.def;
    }

    public void setDef() {
         for (Stobj inv : this.getInventory()) {
             if (inv.getName().equals("Armatura")) {
                this.def = ((Armor)inv).getDefense();
            }
         }
    }    
}
