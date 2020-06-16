/**
 * Definizione di base delle stanze con porte 
 */
package roomSet;

import objectSet.Door;
import base.Room;

public class RoomWDoor extends Room {

    /**
     * Interazione per l'apertura delle porte. In caso di presenza di una singola porta nella lista degli oggetti della stanza, ne avviene la semplice apertura quindi viene sbloccato il passaggio alla stanza su cui la porta affaccia.
     * In caso di presenza di più porte nella stanza e mancanza di una specifica direzione idir, restituisce come Msg l'elenco delle porte interagibili e il loro stato.
     * In caso di presenza di più porte e avendo specificato una direzione, quella specifica porta viene aperta.
     * Nel caso la porta a cui ci si riferisce è già aperta, restituisce un messaggio che lo notifica
     * @param idir 
     */
    @Override
    public void openDoor(String idir){
        int[] d = {0, 0, 0, 0};
        int numd = 0;
        String[] dir = {"", "", "", ""};
        StringBuilder uitxt;
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("Porta")) {
                d[numd] = i;
                dir[numd] = ((Door)this.getObjects().get(i)).getDirection();
                numd++;
            }
        }
        if (numd>1){
             if (idir.equals("")) {
                 uitxt = new StringBuilder(("Ci sono " + (numd) + " porte che si affacciano su queste direzioni:\n"));
                 for (int i = 0; i < numd + 1; i++) {
                     switch (dir[i]) {
                         case "s":
                             uitxt.append("- Sud\n");
                             break;
                         case "n":
                             uitxt.append("- Nord\n");
                             break;
                         case "w":
                             uitxt.append("- Ovest\n");
                             break;
                         case "e":
                             uitxt.append("- Est\n");
                             break;
                     }
                 }
                 uitxt.append("Specifica quale porta vorresti aprire.");
                 this.setMsg(uitxt.toString());
             } else {
                 for (int i = 0; i < 4; i++) {
                     if (dir[i].equals(idir)) {
                         if (((Door) this.getObjects().get(d[i])).isOpen()) {
                             this.setMsg("Questa porta è già aperta");
                         } else {
                             ((Door) this.getObjects().get(d[i])).setOpen(true);
                             this.getObjects().get(d[i]).setDescription(this.getObjects().get(d[i]).getDescription().substring(0, this.getObjects().get(d[i]).getDescription().length() - 6) + "aperta");
                             switch (idir) {
                                 case "n":
                                     this.setMsg("Hai aperto la porta verso nord");
                                     this.setNorth(this.getNextNorth());
                                     break;
                                 case "s":
                                     this.setMsg("Hai aperto la porta verso sud");
                                     this.setSouth(this.getNextSouth());
                                     break;
                                 case "e":
                                     this.setMsg("Hai aperto la porta verso est");
                                     this.setEast(this.getNextEast());
                                     break;
                                 case "w":
                                     this.setMsg("Hai aperto la porta verso ovest");
                                     this.setWest(this.getNextWest());
                                     break;
                             }
                         }
                     }
                 }
             }
        } else {
            if (((Door)this.getObjects().get(d[0])).isOpen()) {
                this.setMsg("La porta è già aperta");
            } else {
                ((Door)this.getObjects().get(d[0])).setOpen(true);
                this.getObjects().get(d[0]).setDescription(this.getObjects().get(d[0]).getDescription().substring(0, this.getObjects().get(d[0]).getDescription().length() - 6) + "aperta");
                switch (dir[0]) {
                    case "e":
                        this.setEast(this.getNextEast());
                        break;
                    case "w":
                    case "o":
                        this.setWest(this.getNextWest());
                        break;
                    case "n":
                        this.setNorth(this.getNextNorth());
                        break;
                    case "s":
                        this.setSouth(this.getNextSouth());
                        break;
                }
                this.setMsg("Hai aperto la porta");
            }
        }
    }

    /**
     * Interazione per la chiusura delle porte. In caso di presenza di una singola porta nella lista degli oggetti della stanza, ne avviene la semplice chiusura quindi viene bloccato il passaggio alla stanza su cui la porta affaccia.
     * In caso di presenza di più porte nella stanza e mancanza di una specifica direzione idir, restituisce come Msg l'elenco delle porte interagibili e il loro stato.
     * In caso di presenza di più porte e avendo specificato una direzione, quella specifica porta viene chiusa.
     * Nel caso la porta a cui ci si riferisce è già chiusa, restituisce un messaggio che lo notifica
     * @param idir 
     */
    @Override
    public void closeDoor(String idir){
        int[] d = {0, 0, 0, 0};
        int numd = 0;
        String[] dir = {"", "", "", ""};
        StringBuilder uitxt;
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("Porta")) {
                d[numd] = i;
                dir[numd] = ((Door)this.getObjects().get(i)).getDirection();
                numd++;
            }
        }
        if (numd>1){
            if (idir.equals("")) {
                uitxt = new StringBuilder(("Ci sono " + (numd) + " porte che si affacciano su queste direzioni:\n"));
                for (int i = 0; i < numd + 1; i++) {
                    switch (dir[i]) {
                        case "s":
                            uitxt.append("- Sud\n");
                            break;
                        case "n":
                            uitxt.append("- Nord\n");
                            break;
                        case "w":
                            uitxt.append("- Ovest\n");
                            break;
                        case "e":
                            uitxt.append("- Est\n");
                            break;
                    }
                }
                uitxt.append("Specifica quale porta vorresti chiudere.");
                this.setMsg(uitxt.toString());
            } else {
                for (int i = 0; i < 4; i++) {
                    if (dir[i].equals(idir)) {
                        if (!((Door) this.getObjects().get(d[i])).isOpen()) {
                            this.setMsg("Questa porta è già chiusa");
                        } else {
                            ((Door) this.getObjects().get(d[i])).setOpen(false);
                            this.getObjects().get(d[i]).setDescription(this.getObjects().get(d[i]).getDescription().substring(0, this.getObjects().get(d[i]).getDescription().length() - 6) + "chiusa");
                            switch (idir) {
                                case "n":
                                    this.setMsg("Hai chiuso la porta verso nord");
                                    this.setNorth(null);
                                    break;
                                case "s":
                                    this.setMsg("Hai chiuso la porta verso sud");
                                    this.setSouth(null);
                                    break;
                                case "e":
                                    this.setMsg("Hai chiuso la porta verso est");
                                    this.setEast(null);
                                    break;
                                case "w":
                                    this.setMsg("Hai chiuso la porta verso ovest");
                                    this.setWest(null);
                                    break;
                            }
                        }
                    }
                }
            }
        } else {
            if (!((Door)this.getObjects().get(d[0])).isOpen()) {
                this.setMsg("La porta è già chiusa");
            } else {
                ((Door)this.getObjects().get(d[0])).setOpen(false);
                this.getObjects().get(d[0]).setDescription(this.getObjects().get(d[0]).getDescription().substring(0, this.getObjects().get(d[0]).getDescription().length() - 6) + "chiusa");
                switch (dir[0]) {
                    case "e":
                        this.setEast(null);
                        break;
                    case "w":
                    case "o":
                        this.setWest(null);
                        break;
                    case "n":
                        this.setNorth(null);
                        break;
                    case "s":
                        this.setSouth(null);
                        break;
                }
                this.setMsg("Hai chiuso la porta");
            }
        }
    }



}
