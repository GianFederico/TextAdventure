package RoomSet;

import ObjectSet.Door;
import newpackage01.UI;

import java.util.Scanner;

public class RoomWDoor extends Room {

    @Override
    public void openDoor(UI ui){
        int[] d = {0, 0, 0, 0};
        int numd = 0;
        String[] dir = new String[4];
        String s = new String();
        boolean ins = false;
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("Porta")) {
                d[numd] = i;
                dir[numd] = ((Door)this.getObjects().get(i)).getDirection();
                numd++;
            }
        }
        if (numd>1){
            while (!ins || !s.equals("indietro")){
                ui.setText("Ci sono " + (numd+1) + " porte che si affacciano su queste direzioni:\n");
                for (int i = 0; i < numd+1; i++){
                    switch (dir[i]){
                        case "s":
                            ui.setText("Sud\n");
                            break;
                        case "n":
                            ui.setText("Nord\n");
                            break;
                        case "w":
                            ui.setText("Ovest\n");
                            break;
                        case "e":
                            ui.setText("Est\n");
                            break;
                    }
                }
                ui.setText("Quale porta vorresti aprire? [direzione o indietro]");
                //Scanner scanner = new Scanner(System.in);
                String input = ui.getCampotxt().trim();
                if (!input.equals("")){
                    s = input.toLowerCase();
                    if (s.startsWith("n") || s.startsWith("s") || s.startsWith("w") || s.startsWith("o") || s.startsWith("e")){
                        for (int i = 0; i < 4; i++) {
                            if (dir[i].equals(s.substring(0, 1))) {
                                ins = true;
                                if (((Door) this.getObjects().get(d[i])).isOpen()) {
                                    ui.setText("Questa porta è già aperta");
                                } else {
                                    ((Door) this.getObjects().get(d[i])).setOpen(true);
                                    this.getObjects().get(d[i]).setDescription(this.getObjects().get(d[i]).getDescription().substring(this.getObjects().get(d[i]).getDescription().length() - 6) + "aperta");
                                    switch (dir[i]) {
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
                                }
                            }
                        }
                        if (!ins){
                            ui.setText("Inserisci una delle direzioni disponibili");
                        }
                    } else {
                        ui.setText("Inserisci una direzione o torna indietro");
                    }
                }
            }
        } else {
            if (((Door)this.getObjects().get(d[0])).isOpen()) {
                ui.setText("La porta è già aperta");
            } else {
                ((Door)this.getObjects().get(d[0])).setOpen(true);
                this.getObjects().get(d[0]).setDescription(this.getObjects().get(d[0]).getDescription().substring(this.getObjects().get(d[0]).getDescription().length() - 6) + "aperta");
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
            }
        }
    }

    @Override
    public void closeDoor(UI ui) {
        int[] d = {0, 0, 0, 0};
        int numd = 0;
        String[] dir = new String[4];
        String s = new String();
        boolean ins = false;
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("Porta")) {
                d[numd] = i;
                dir[numd] = ((Door)this.getObjects().get(i)).getDirection();
                numd++;
            }
        }
        if (numd>1){
            while (!ins || !s.equals("indietro")){
                ui.setText("Ci sono " + (numd+1) + " porte che si affacciano su queste direzioni:\n");
                for (int i = 0; i < numd+1; i++){
                    switch (dir[i]){
                        case "s":
                            ui.setText("Sud\n");
                            break;
                        case "n":
                            ui.setText("Nord\n");
                            break;
                        case "w":
                            ui.setText("Ovest\n");
                            break;
                        case "e":
                            ui.setText("Est\n");
                            break;
                    }
                }
                ui.setText("Quale porta vorresti chiudere? [direzione o indietro]");
                //Scanner scanner = new Scanner(System.in);
                String input = ui.getCampotxt().trim();
                if (!input.equals("")) {
                    s = input.toLowerCase();
                    if (s.startsWith("n") || s.startsWith("s") || s.startsWith("w") || s.startsWith("o") || s.startsWith("e")) {
                        for (int i = 0; i < 4; i++) {
                            if (dir[i].equals(s.substring(0, 1))) {
                                ins = true;
                                if (!((Door)this.getObjects().get(d[i])).isOpen()) {
                                    ui.setText("Questa porta è già chiusa");
                                } else {
                                    ((Door)this.getObjects().get(d[i])).setOpen(false);
                                    this.getObjects().get(d[i]).setDescription(this.getObjects().get(d[i]).getDescription().substring(this.getObjects().get(d[i]).getDescription().length() - 6) + "aperta");
                                    switch (dir[i]) {
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
                                }
                            }
                        }
                        if (!ins){
                            ui.setText("Inserisci una delle direzioni disponibili");
                        }
                    } else {
                        ui.setText("Inserisci una direzione o torna indietro");
                    }
                }
            }
        } else {
            if (!((Door)this.getObjects().get(d[0])).isOpen()) {
                ui.setText("La porta è già chiusa");
            } else {
                ((Door)this.getObjects().get(d[0])).setOpen(false);
                this.getObjects().get(d[0]).setDescription(this.getObjects().get(d[0]).getDescription().substring(this.getObjects().get(d[0]).getDescription().length() - 6) + "aperta");
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
            }
        }
    }
}
