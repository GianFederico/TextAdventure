
package base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Command {
    
    /*private enum CommandType {
       END, INVENTORY, NORD, SOUTH, EAST, WEST, OPEN, CLOSE, PUSH, PULL, WALK_TO, PICK_UP, TALK_TO, GIVE, USE, LOOK_AT, TURN_ON, TURN_OFF
    }*/
    
    //private final CommandType Type;     
    private final String name;
    private Set<String> aka;
 
    public Command(String name){
        this.name=name;
    }
    
    public Command(String name, Set<String> aka){
        this.name=name;
        this.aka=aka;
    }
    
    /*public Command(CommandType type, String name){
        this.type=type;
        this.name=name;
    }
    
    public Command(CommandType type, String name, Set<String> aka){
        this.type=type;
        this.name=name;
        this.aka=aka;
    }*/
    
    public String getName() {
        return name;
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
    
    /*public CommandType getType() {
        return type;
    }*/   
    
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
