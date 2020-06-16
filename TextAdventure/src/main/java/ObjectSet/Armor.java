/**
 * Definizione degli oggetti di tipo Armor
 */
package objectSet;

import base.Stobj;

public class Armor extends Stobj {
    
    private int defense = 0;
    
    public void setDefense(int defense){
        this.defense = defense;
    }
    
    public int getDefense(){
        return this.defense;
    }
    
}
