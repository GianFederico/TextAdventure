/**
 * Definizione degli oggetti di tipo Potion
 */
package objectSet;

import base.Stobj;
import gameCore.Player;

public class Potion extends Stobj {

    /**
     * Metodo per l'utilizzo delle pozioni. 
     * Porta il valore degli hp del Player p al massimo (totHp)
     * @param p
     * @return String x come numero degli hp recuperati
     */
    @Override
    public String use(Player p){
        String x = Integer.toString(p.getTotHp()-p.getCurrentHp());
        p.setCurrentHp(p.getTotHp());
        return x;
    }

}
