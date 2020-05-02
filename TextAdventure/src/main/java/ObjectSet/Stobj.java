
package ObjectSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Stobj {
    
    private String name;
    private String description;
    private Set<String> aka;
    private boolean visible = true;
    private boolean openable = false;
    private boolean pickupable = false;
    private boolean usable = false;
    private boolean open = false;
    private boolean push = false;
    private boolean pushable=false;
    
    public Stobj(){}
    
    public Stobj(String name){
        this.name=name;
    }
    
    public Stobj(String name, String description){
        this.name=name;
        this.description=description;
    }
    
    public Stobj(String name, String description, Set<String> aka){
        this.name=name;
        this.description=description;
        this.aka=aka;
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
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean isPickupable() {
        return pickupable;
    }

    public void setPickupable(boolean pickupable) {
        this.pickupable = pickupable;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }
    
     public boolean isPushable() {
        return pushable;
    }
    
     public void setPushable(boolean push) {
        this.pushable = pushable;
    }
    
    public Set<String> getAka() {
        return aka;
    }

    public void setAka(Set<String> aka) {
        this.aka = aka;
    }
    
    public void setAka(String[] sinonimi) {
        this.aka = new HashSet<>(Arrays.asList(sinonimi));
    }
    
    public boolean equals(Object other) {
        boolean e=true;
        if (this == other) {
            e=true;
        }
        if (other == null) {
            e=false;
        }
        if (getClass() != other.getClass()) {
            e=false;
        }
        return e;
    }
    
}
