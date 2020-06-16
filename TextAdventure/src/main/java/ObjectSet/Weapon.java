/**
 *  Definizione degli oggetti di tipo Weapon
 */
package objectSet;

import base.Stobj;

public class Weapon extends Stobj {
    
    private int damage = 0;
    
    public void setDamage(int dmg){
        this.damage = dmg;
    }
    
    public int getDamage(){
        return this.damage;
    }
    
}
