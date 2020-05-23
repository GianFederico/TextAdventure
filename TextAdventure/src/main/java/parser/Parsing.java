package parser;

import base.Command;
import ObjectSet.Stobj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parsing {
/*
    private Set<String> stopwords;

    public Parsing(){
        this.setStopword();
    }

    private void setStopword(){
        String[] stopw = {"di", "a", "da", "in", "con", "su", "per", "tra", "fra", "il", "lo", "la", "l'", "i", "gli", "le", "un", "uno", "una", "un''", "del", "della", "degli", "dello'", "delle", "dei", "dell'"};
        this.stopwords = new HashSet<>(Arrays.asList(stopw));
    }*/

    private int checkForCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getName().toLowerCase().equals(token) || commands.get(i).getAka().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int checkForObject(String token, List<Stobj> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().toLowerCase().equals(token) || objects.get(i).getAka().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    /*private boolean checkForStopwords(String token){
        boolean sw = false;
        if (this.stopwords.contains(token)){
            sw = true;
        }
        return sw;
    }*/

   public ParserOut parse(String command, List<Command> commands, List<Stobj> objects, List<Stobj> inventory) {
        String cmd = command.toLowerCase().trim();
        String[] tokens = cmd.split("\\s+");
        int i = 0;
        int io = -1,ic = -1, ioinv = -1;
        if (tokens.length > 0) {
            while (ic<0 && i<tokens.length){
                ic = checkForCommand(tokens[i], commands);
                i++;
            }

            i = 0; //riparte dalla prima parola al prossimo controllo

            if (ic > -1) {
                if (tokens.length > 1) {
                    while (io<0 && i<tokens.length){
                        io = checkForObject(tokens[i], objects);
                        i++;
                    }
                    i = 0;
                    if (io<0) {
                        while (ioinv<0 && i<tokens.length){
                            ioinv = checkForObject(tokens[i], inventory);
                            i++;
                        }
                    }
                    /*if (io > -1 && ioinv > -1) {
                        return new ParserOut(commands.get(ic), objects.get(io), inventory.get(ioinv));
                    } else*/
                    if (io > -1) {
                        return new ParserOut(commands.get(ic), objects.get(io));
                    } else if (ioinv > -1) {
                        return new ParserOut(commands.get(ic), inventory.get(ioinv));
                    } else {
                        return new ParserOut(commands.get(ic), null);//, null);
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
