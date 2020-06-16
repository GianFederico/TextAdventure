package monsterSet;

import objectSet.Potion;
import base.SuperMonster;

public class Monster_Ciclope extends SuperMonster {
   public Monster_Ciclope(){
        this.setName("Ciclope");
        this.setDescription("un enorme ed orrendo ciclope, alto più di tre metri con una clava ed un piccolo\nstraccio per coprirsi le parti intime che lascia davvero poco\nspazio all'immaginazione..");
        this.setDeadName("Carcassa del ciclope");
        this.setDeadDescription("Il ciclope che hai sconfitto. E' stata una dura battaglia");
        this.setHp(50);
        this.setTotHp(50);
        this.setAttack(8);
        this.setLoot(new Potion());
        this.getLoot().setName("Pozione");
        this.getLoot().setDescription("Pozione caduta dallo straccio \"intimo\" del ciclope quando lo hai sconfitto.");
        this.setAttackMessage(new String[]{"La sua clava ti colpisce con forza","Ti colpisce con un pugno","Salta e produce un'onda d'urto"});
        this.setDodgeMessage(new String[]{"schiva, ti meravigli di te stesso, negativamente..."});
        this.setHitRate(50);
        this.setDodgeRate(5);
        this.setImage("           _......._\n" +
"       .-'.'.'.'.'.'.`-.\n" +
"    /.'.'               '.\\\n" +
"    \\    `._.-.....-._.'  /\n" +
"    |     _..- .-. -.._   |\n" +
" .-.'    `.   ((@))  .'   '.-.\n" +
"( ^ \\      `--.   .-'     / ^ )\n" +
" \\  /         .   .       \\  /\n" +
" /          .'     '.  .-    \\\n" +
"( _.\\    \\ (_`-._.-'_)    /._\\)\n" +
" `-' \\   ' .--.          / `-'\n" +
"     |  / /|_| `-._.'\\   |\n" +
"     |   |       |_| |   /-.._\n" +
" _..-\\   `.--.______.'  |\n" +
"      \\       .....     |\n" +
"       `.  .'      `.  /\n" +
"          `-..___..-`");
    }
}