package newpackage03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import newpackage01.Player;
import ObjectSet.*;
import java.io.Serializable;
import java.util.Random;
import newpackage01.UI;

public class SuperMonster  implements Serializable{  //TODO renderla un'interfaccia
    private String name;
    private String description;
    private Set<String> aka;
    private int hp;
    private int attack;
    private String attackMessage;
    private String dodgeMessage;
    private int hitRate;
    private int dodgeRate;
    
    public SuperMonster(){}

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }
    
    public Set<String> getAka() {
        return aka;
    }

    public final void setAka(Set<String> aka) {
        this.aka = aka;
    }
    
    public final void setAka(String[] sinonimi) {
        this.aka = new HashSet<>(Arrays.asList(sinonimi));
    }

    public int getHp() {
        return hp;
    }

    public final void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public final void setAttack(int attack) {
        this.attack = attack;
    }

    public String getAttackMessage() {
        return attackMessage;
    }

    public final void setAttackMessage(String attackMessage) {
        this.attackMessage = attackMessage;
    }

    public String getDodgeMessage() {
        return dodgeMessage;
    }

    public final void setDodgeMessage(String dodgeMessage) {
        this.dodgeMessage = dodgeMessage;
    }

    public int getHitRate() {
        return hitRate;
    }

    public final void setHitRate(int hitRate) {
        this.hitRate = hitRate;
    }

    public int getDodgeRate() {
        return dodgeRate;
    }

    public final void setDodgeRate(int dodgeRate) {
        this.dodgeRate = dodgeRate;
    }



    public boolean fightMonster(Player p, SuperMonster monster, UI ui){
    int pldmg = 0;
    int pldef = 0;
    String[] input = new String[2];
    boolean win = false;
    Random random = new Random(); //numero casuale = random.nextInt((max - min) +1) + min
    for (Stobj inv : p.getInventory()) {
            if (inv.getName().equals("spada") || inv.getName().equals("coltello")) {
                pldmg = ((Weapon)inv).getDamage();
            }
            if (inv.getName().equals("armatura")) {
                pldef = ((Armor)inv).getDefense();
            }
        }
    while (p.getCurrentHp() > 0 || monster.getHp() > 0 || input.equals("scappa")){
        //ad ogni turno viene chiesto cosa si vuole fare: combattere o scappare?
        while (!input[0].equals("combatti") || !input[0].equals("attacca") || !input[0].equals("scappa") || !input[0].equals("ritirati") ||!input[0].equals("usa") || !input[0].equals("bevi")){    //controllo sulla parola inserita->deve essere un verbo che indichi se continuare a combattere o scappare
            //se si decide di combattere
            //TODO acquisizione input
            if (input[0].equals("combatti") || input[0].equals("attacca")){

                //attacca sempre prima il mostro
                //con possibilità di colpire = monster.hitRate%
                    if(random.nextInt(100 - 1 + 1)+1 <= monster.getHitRate()){
                            ui.setText(monster.getAttackMessage());
                            p.setCurrentHp(p.getCurrentHp()-random.nextInt(((monster.getAttack()-pldef)-1)+1)+1); //max=monsterattack-pldef     min=1
                            //TODO se il danno che il mostro riesce a farti, si visualizza un messaggio del tipo "per fortuna è solo un graffio"
                    } else {
                            ui.setText("Hai schivato il colpo");
                    }

                //poi attacca il giocatore
                //con possibilità di colpire (100-monster.dodgeRate)
                    if(random.nextInt(100 - 1 + 1)+1 <= (100-monster.getDodgeRate())){
                        ui.setText("hai colpito");
                        monster.setHp(monster.getHp()-(random.nextInt((pldmg - (pldmg-5))+1)+(pldmg-5))); //max=pldmg    min=pldmg-5
                     }
                    else{
                            ui.setText(monster.getDodgeMessage());
                    }
                    if (monster.hp <= 0){
                        ui.setText(monster.getName() + " sconfitto");
                        win = true;
                    }
             }

            //se si decide di scappare
            if (input[0].equals("scappa") || input[0].equals("ritirati")){
                p.setCurrentRoom(p.getPreviousRoom());
            }
            
            //se si vuole usare una pozione
            if (input[0].equals("usa") || input[0].equals("bevi")){
                if (input[1].equals("pozione")){
                     int k = -1;
                    for (int i = 0; i < p.getInventory().size() || k==-1; i++) {
                        if (p.getInventory().get(i).getName().equals("Pozione")) {
                            k = i;
                        }
                    }
                    if (k>-1){
                        p.getInventory().get(k).use(p);
                        p.removeFromInventory(k);
                    } else {
                    int pot = 0;
                    for (Stobj inv : p.getInventory()) {
                        if (inv.getName().equals("Pozione")) {
                            pot++;
                        }
                    }
                    if (pot>0){
                        ui.setText("Hai ancora " + pot + "x Pozione che puoi usare");
                    } else {
                        ui.setText("Non hai più pozioni");
                    }
                }
            } else {
                    //In combattimento puoi usare solo le pozioni dal tuo inventario
                }
         }
    }
    }
    return win;
}
}