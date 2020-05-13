package newpackage03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import newpackage01.Player;
import ObjectSet.*;
import java.util.Random;

public class SuperMonster {  //TODO renderla un'interfaccia
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



    public boolean fightMonster(Player p, SuperMonster monster){
    int pldmg = 0;
    int pldef = 0;
    String input = "";
    boolean win = false;
    Random random = new Random(); //numero casuale = random.nextInt((max - min) +1) + min
    for (Stobj inv : p.getInventory()) {
            if (inv.getName().equals("spada lunga") || inv.getName().equals("coltello")) {
                pldmg = ((Weapon)inv).getDamage();
            }
            if (inv.getName().equals("armatura")) {
                pldef = ((Armor)inv).getDefense();
            }
        }
    while (p.getHp() > 0 || monster.getHp() > 0 || input.equals("scappa")){
        //ad ogni turno viene chiesto cosa si vuole fare: combattere o scappare?
        while (!input.equals("combatti") || !input.equals("attacca") || !input.equals("scappa") || !input.equals("ritirati")){    //controllo sulla parola inserita->deve essere un verbo che indichi se continuare a combattere o scappare
            //se si decide di combattere
            //TODO acquisizione input
            if (input.equals("combatti") || input.equals("attacca")){

                //attacca sempre prima il mostro
                //con possibilità di colpire = monster.hitRate%
                    if(random.nextInt(100 - 99 + 1)+1 <= monster.getHitRate()){
                            System.out.println(monster.getAttackMessage());
                            //TODO se il danno che il mostro riesce a farti, si visualizza un messaggio del tipo "per fortuna è solo un graffio"
                            p.setHp(p.getHp()-random.nextInt(((monster.getAttack()-pldef)-1)+1)+1); //max=monsterattack-pldef     min=1
                    } else {
                            System.out.println("Hai schivato il colpo");
                    }

                //poi attacca il giocatore
                //con possibilità di colpire (100-monster.dodgeRate)
                    if(random.nextInt(100 - 99 + 1)+1 <= (100-monster.getDodgeRate())){
                        System.out.println("hai colpito");
                        monster.setHp(monster.getHp()-(random.nextInt((pldmg - (pldmg-5))+1)+(pldmg-5))); //max=pldmg    min=pldmg-5
                     }
                    else{
                            System.out.println(monster.getDodgeMessage());
                    }
                    if (monster.hp < 0){
                        System.out.println(monster.getName() + " sconfitto");
                        win = true;
                    }
             }

            //se si decide di scappare
            if (input.equals("scappa")){
                p.setCurrentRoom(p.getPreviousRoom());
            }
         }
    }
    return win;
}
}