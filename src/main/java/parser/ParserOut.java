
package parser;

import base.Command;
import base.Stobj;

public class ParserOut {
    
    private Command command; //comando
    private Stobj object;    //oggetto interagibile
    private Stobj invobj;    //oggetto nell'inventario
    
    public ParserOut(Command command, Stobj object) {
        this.command = command;
        this.object = object;
    }
    
    public ParserOut(Command command, Stobj object, Stobj invobj) {
        this.command = command;
        this.object = object;
        this.invobj = invobj;
    }
    
    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Stobj getObject() {
        return object;
    }

    public void setObject(Stobj object) {
        this.object = object;
    }

    public Stobj getInvObject() {
        return invobj;
    }

    public void setInvObject(Stobj invobj) {
        this.invobj = invobj;
    }
    
}
