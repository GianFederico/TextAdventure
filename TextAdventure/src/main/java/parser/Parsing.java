package parser;

import base.Command;
import ObjectSet.Stobj;
import java.util.List;

public class Parsing {
    
    private int checkForCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().equals(token) || commands.get(i).getAka().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int checkForObject(String token, List<Stobj> obejcts) {
        for (int i = 0; i < obejcts.size(); i++) {
            if (obejcts.get(i).getName().equals(token) || obejcts.get(i).getAka().contains(token)) {
                return i;
            }
        }
        return -1;
    }
    
    public ParserOut parse(String command, List<Command> commands, List<Stobj> objects, List<Stobj> inventory) {
        String cmd = command.toLowerCase().trim();
        String[] tokens = cmd.split("\\s+");
        if (tokens.length > 0) {
            int ic = checkForCommand(tokens[0], commands);
            if (ic > -1) {
                if (tokens.length > 1) {
                    int io = checkForObject(tokens[1], objects);
                    int ioinv = -1;
                    if (io < 0 && tokens.length > 2) {
                        io = checkForObject(tokens[2], objects);
                    }
                    if (io < 0) {
                        ioinv = checkForObject(tokens[1], inventory);
                        if (ioinv < 0 && tokens.length > 2) {
                            ioinv = checkForObject(tokens[2], inventory);
                        }
                    }
                    if (io > -1 && ioinv > -1) {
                        return new ParserOut(commands.get(ic), objects.get(io), inventory.get(ioinv));
                    } else if (io > -1) {
                        return new ParserOut(commands.get(ic), objects.get(io), null);
                    } else if (ioinv > -1) {
                        return new ParserOut(commands.get(ic), null, inventory.get(ioinv));
                    } else {
                        return new ParserOut(commands.get(ic), null, null);
                    }
                } else {
                    return new ParserOut(commands.get(ic), null);
                }
            } else {
                return new ParserOut(null, null);
            }
        } else {
            return null;
        }
    }
    
    
}
