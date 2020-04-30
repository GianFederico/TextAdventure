package FileCreation;

import base.Command;
import java.util.List;
import java.util.ArrayList;

public class CommandList {
    
    private List<Command> PresetCommands = new ArrayList<>();
    
    public CommandList(){
        Command nord = new Command("nord");
        nord.setAka(new String[]{"n", "N", "Nord", "NORD"});
        this.PresetCommands.add(nord);
        
        Command sud = new Command("sud");
        sud.setAka(new String[]{"s", "S", "Sud", "SUD"});
        this.PresetCommands.add(sud);
        
        Command est = new Command("est");
        est.setAka(new String[]{"e", "E", "Est", "EST"});
        this.PresetCommands.add(est);
        
        Command ovest = new Command("ovest");
        ovest.setAka(new String[]{"o", "O", "Ovest", "OVEST"});
        this.PresetCommands.add(ovest);
        
        Command end = new Command("fine");
        end.setAka(new String[]{"end", "fine", "termina", "muori", "ammazzati", "ucciditi", "suicidati", "basta"});
        this.PresetCommands.add(end);
        
        Command look = new Command("osserva");
        look.setAka(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        this.PresetCommands.add(look);
        
        Command pickup = new Command("raccogli");
        pickup.setAka(new String[]{"prendi, acquista"});
        this.PresetCommands.add(pickup);
        
        Command push = new Command("premi");
        push.setAka(new String[]{"spingi","attiva","tira"});
        this.PresetCommands.add(push);
        
        Command choose = new Command("scegli");
        choose.setAka(new String[]{});
        this.PresetCommands.add(choose);
        
        Command fight = new Command("attacca");
        fight.setAka(new String[]{"combatti", "affronta"});
        this.PresetCommands.add(fight);
        
        Command flee = new Command("fuggi");
        flee.setAka(new String[]{"scappa"});
        this.PresetCommands.add(flee);
        
        Command climb = new Command("scala");
        climb.setAka(new String[]{"arrampica", "arrampicati"});
        this.PresetCommands.add(climb);
        
        Command back = new Command("indietro");
        back.setAka(new String[]{"torna"});
        this.PresetCommands.add(back);
    }
    
}
