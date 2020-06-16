/**
 * Definizione degli oggetti di tipo Door
 */
package objectSet;

import base.Stobj;

public class Door extends Stobj {
    
    private String direction;
    private boolean open;
    
    public void setDirection(String d){
        this.direction = d;
    }
    
    public String getDirection(){
        return this.direction;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
