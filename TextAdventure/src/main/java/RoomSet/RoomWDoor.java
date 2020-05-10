package RoomSet;

import ObjectSet.Door;
import java.util.Scanner;

public class RoomWDoor extends Room {

    @Override
    public void openDoor(){
        int[] d = {0, 0, 0, 0};
        int numd = 0;
        String[] dir = new String[4];
        String s = new String();
        boolean ins = false;
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("porta")) {
                d[numd] = i;
                dir[numd] = ((Door)this.getObjects().get(i)).getDirection();
                numd++;
            }
        }
        if (numd>1){
            while (!ins || !s.equals("indietro")){
                System.out.println("Quale porta vorresti aprire? [direzione o indietro]");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()){
                    s = scanner.nextLine().toLowerCase();
                    if (s.startsWith("n") || s.startsWith("s") || s.startsWith("w") || s.startsWith("o") || s.startsWith("e")){
                        ins = true;
                        for (int i = 0; i < 4; i++){
                            if (dir[i].equals(s.substring(0,1))){
                                if (((Door)this.getObjects().get(d[i])).isOpen()) {
                                    System.out.println("Questa porta è già aperta");
                                } else {
                                    ((Door)this.getObjects().get(d[i])).setOpen(true);
                                    this.getObjects().get(d[i]).setDescription(this.getObjects().get(d[i]).getDescription().substring(this.getObjects().get(d[i]).getDescription().length()-6) + "aperta");
                                    switch (dir[i]){
                                        case "e":
                                            this.setEast(this.getNextEast());
                                            break;
                                        case "w": case "o":
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
                    } else {
                        System.out.println("Inserisci una direzione o torna indietro");
                    }
                }
            }
        } else {
            if (((Door)this.getObjects().get(d[0])).isOpen()) {
                System.out.println("La porta è già aperta");
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
    public void closeDoor() {
        int[] d = {0, 0, 0, 0};
        int numd = 0;
        String[] dir = new String[4];
        String s = new String();
        boolean ins = false;
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("porta")) {
                d[numd] = i;
                dir[numd] = ((Door) this.getObjects().get(i)).getDirection();
                numd++;
            }
        }
        if (numd > 1) {
            while (!ins || !s.equals("indietro")) {
                System.out.println("Quale porta vorresti chiudere? [direzione o indietro]");
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    s = scanner.nextLine().toLowerCase();
                    if (s.startsWith("n") || s.startsWith("s") || s.startsWith("w") || s.startsWith("o") || s.startsWith("e")) {
                        ins = true;
                        for (int i = 0; i < 4; i++) {
                            if (dir[i].equals(s.substring(0, 1))) {
                                if (!((Door)this.getObjects().get(d[i])).isOpen()) {
                                    System.out.println("Questa porta è già chiusa");
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
                    } else {
                        System.out.println("Inserisci una direzione o torna indietro");
                    }
                }
            }
        } else {
            if (!((Door)this.getObjects().get(d[0])).isOpen()) {
                System.out.println("La porta è già chiusa");
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
