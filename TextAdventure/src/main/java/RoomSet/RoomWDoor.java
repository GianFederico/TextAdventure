package RoomSet;

import ObjectSet.Stobj;
import ObjectSet.Door;

public class RoomWDoor extends Room {
    
    public void openDoor(){
        int d = 0;
        Stobj e = new Stobj();
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("porta")) {
                d = i;
            }
        }
        if (this.getObjects().get(d).isOpen()){
            System.out.println("La porta è già aperta");
        } else {
        this.getObjects().get(d).setOpen(true);
        this.getObjects().get(d).setDescription(this.getObjects().get(3).getDescription().substring(this.getObjects().get(d).getDescription().length()-6) + "aperta");
        }
        switch (((Door) this.getObjects().get(d)).getDirection()){
            case "E":
                this.setEast(this.getNextEast());
                break;
            case "W":
                this.setWest(this.getNextWest());
                break;
            case "N":
                this.setNorth(this.getNextNorth());
                break;
        }
    }
    
    public void closeDoor(){
        int d = 0;
        Stobj e = new Stobj();
        for (int i = 0; i < this.getObjects().size(); i++) {
            if (this.getObjects().get(i).getName().equals("porta")) {
                d = i;
            }
        }
        if (this.getObjects().get(d).isOpen()){
            this.getObjects().get(d).setOpen(false);
             this.getObjects().get(d).setDescription(this.getObjects().get(3).getDescription().substring(this.getObjects().get(d).getDescription().length()-6) + "chiusa");
        } else {
            System.out.println("La porta è già chiusa");
        }
        switch (((Door) this.getObjects().get(d)).getDirection()){
            case "E":
                this.setNextEast(this.getEast());
                break;
            case "W":
                this.setNextWest(this.getWest());
                break;
            case "N":
                this.setNextNorth(this.getNorth());
                break;
        }
    }
    
}
