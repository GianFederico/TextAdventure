package newpackage03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SuperMonster {
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
    
}


/*
while player.hp>0{
    attacca sempre prima il mostro
    con possibilità di colpire = monster.hitRate%
        if(random(1,100) <= hitrate){
                print attackMessage
                palyer.hp-random(1,monster.attack)
        }
        else{
                print "hai schivato il colpo"
                }

    poi attacca il player
    con possibilità di colpire i= (100-monster.dodgeRate)
        if(random(1,100)<= i){
            print "hai colpito"
            monster.hp-random(1,weapon.dmg)
         }
        else{
                print monster.dodgeMessage
                }
          
          if (monster.hp<0){
            print mostro sconfitto
            }
}
*/