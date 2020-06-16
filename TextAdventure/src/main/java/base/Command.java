/**
 * Definizione base dei comandi di gioco.
 */
package base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Command {
    
    private final String name;
    private Set<String> alias;
 
    public Command(String name){
        this.name=name;
    }
    
    public Command(String name, Set<String> alias){
        this.name=name;
        this.alias=alias;
    }
    
    public String getName() {
        return name;
    }

    public Set<String> getAlias() {
        return alias;
    }

    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
    
    public void setAlias(String[] sinonimi) {
        this.alias = new HashSet<>(Arrays.asList(sinonimi));
    }
}
