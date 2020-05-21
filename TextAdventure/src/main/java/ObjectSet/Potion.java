package ObjectSet;

import newpackage01.Player;

public class Potion extends Stobj{

    @Override
    public void use(Player p){
        p.setCurrentHp(p.getTotHp());
    }

}
