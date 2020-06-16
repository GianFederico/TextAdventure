package base;

import java.io.Serializable;
import java.util.Random;

public class SuperMonster implements Serializable{
    private String name;
    private String description;
    private String image;
    private int hp;
    private int totHp;
    private int attack;
    private String[] attackMessage = new String[]{};
    private String[] dodgeMessage = new String[]{};;
    private int hitRate;
    private int dodgeRate;
    private String deadName;
    private String deadDescription;
    private Stobj loot = null;
    
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHp() {
        return hp;
    }

    public final void setHp(int hp) {
        this.hp = hp;
    }

    public int getTotHp() {
        return totHp;
    }

    public void setTotHp(int totHp) {
        this.totHp = totHp;
    }
    
    public int getAttack() {
        return attack;
    }

    public final void setAttack(int attack) {
        this.attack = attack;
    }

    public String getRndAttackMessage() {
        int rnd = new Random().nextInt(this.attackMessage.length);
        return this.attackMessage[rnd];
    }

    public void setAttackMessage(String[] attackMessage) {
        this.attackMessage = attackMessage;
    }

    public String getRndDodgeMessage() {
       int rnd = new Random().nextInt(this.dodgeMessage.length);
        return this.dodgeMessage[rnd];
    }

    public final void setDodgeMessage(String[] dodgeMessage) {
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

    public String getDeadName() {
        return deadName;
    }

    public void setDeadName(String deadName) {
        this.deadName = deadName;
    }

    public String getDeadDescription() {
        return deadDescription;
    }

    public void setDeadDescription(String deadDescription) {
        this.deadDescription = deadDescription;
    }

    public Stobj getLoot() {
        return loot;
    }

    public void setLoot(Stobj loot) {
        this.loot = loot;
        this.loot.setPickupable(true);
    }
}