package RoomSet;

public class RoomWDoor extends Room {
    
    
    
    public void openDoor(){
        if (this.getObjects().get(3).isOpen()){
            System.out.println("La porta è già aperta");
        } else {
        this.getObjects().get(3).setOpen(true);
        this.getObjects().get(3).setDescription(this.getObjects().get(3).getDescription().substring(this.getObjects().get(3).getDescription().length()-6) + "aperta");
        }
    }
    
    public void closeDoor(){
        if (this.getObjects().get(3).isOpen()){
            this.getObjects().get(3).setOpen(false);
             this.getObjects().get(3).setDescription(this.getObjects().get(3).getDescription().substring(this.getObjects().get(3).getDescription().length()-6) + "chiusa");
        } else {
            System.out.println("La porta è già chiusa");
        }
    }
    
}
