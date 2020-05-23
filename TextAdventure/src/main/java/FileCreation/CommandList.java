package FileCreation;

import base.Command;
import java.util.List;
import java.util.ArrayList;

public class CommandList {
    
    private List<Command> commands = new ArrayList<>();
    
    public CommandList(){
        Command nord = new Command("nord");
        nord.setAka(new String[]{"n", "N", "Nord", "NORD"});
        this.commands.add(nord);
        
        Command sud = new Command("sud");
        sud.setAka(new String[]{"s", "S", "Sud", "SUD"});
        this.commands.add(sud);
        
        Command est = new Command("est");
        est.setAka(new String[]{"e", "E", "Est", "EST"});
        this.commands.add(est);
        
        Command ovest = new Command("ovest");
        ovest.setAka(new String[]{"o", "O", "Ovest", "OVEST"});
        this.commands.add(ovest);
        
        Command end = new Command("fine");
        end.setAka(new String[]{"end", "fine", "termina", "muori", "ammazzati", "ucciditi", "suicidati", "basta"});
        this.commands.add(end);
        
        Command look = new Command("osserva");
        look.setAka(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        this.commands.add(look);
        
        Command pickup = new Command("raccogli");
        pickup.setAka(new String[]{"prendi", "ottieni"});
        this.commands.add(pickup);
        
        Command push = new Command("premi");
        push.setAka(new String[]{"spingi","attiva","tira"});
        this.commands.add(push);
        
        /*Command choose = new Command("scegli");
        choose.setAka(new String[]{});
        this.commands.add(choose);*/
        
        Command fight = new Command("attacca");
        fight.setAka(new String[]{"combatti", "affronta"});
        this.commands.add(fight);
        
        /*Command flee = new Command("fuggi");
        flee.setAka(new String[]{"scappa"});
        this.commands.add(flee);*/
        
        /*Command climb = new Command("scala");
        climb.setAka(new String[]{"arrampica", "arrampicati"});
        this.commands.add(climb);*/
        
        Command back = new Command("indietro");
        back.setAka(new String[]{"torna"});
        this.commands.add(back);
        
        Command open = new Command("apri");
        open.setAka(new String[]{"spalanca"});
        this.commands.add(open);

        Command close = new Command("chiudi");
        open.setAka(new String[]{"richiudi", "serra"});
        this.commands.add(close);
        
        Command buy = new Command("compra");
        buy.setAka(new String[]{"acquista"});
        this.commands.add(buy);

        Command talk = new Command("parla");
        //open.setAka(new String[]{""}); //TODO
        this.commands.add(talk);

        Command eat = new Command("mangia");
        open.setAka(new String[]{"addenta"});
        this.commands.add(eat);

        Command use = new Command("usa");
        open.setAka(new String[]{"utilizza"});
        this.commands.add(use);

        Command drink = new Command("bevi");
        //open.setAka(new String[]{""});
        this.commands.add(drink);

        Command read = new Command("leggi");
        //open.setAka(new String[]{""});
        this.commands.add(read);

        Command q = new Command("Q");
        //open.setAka(new String[]{""});
        this.commands.add(q);
    }

    public List<Command> getCommands() {
        return commands;
    }
    
}
