package parser;

import base.Command;
import base.Stobj;

public class ParserOutput {
    
    private final Command command; //comando
    private final Stobj object;    //oggetto interagibile
    private String dir = "";      //direzione porta
    
    public ParserOutput(Command command, Stobj object) {
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Command command, Stobj object, String dir) {
        this.command = command;
        this.object = object;
        this.dir = dir;
    }
    
    public Command getCommand() {
        return command;
    }

    public Stobj getObject() {
        return object;
    }

    public String getDir() {
        return dir;
    }
}
