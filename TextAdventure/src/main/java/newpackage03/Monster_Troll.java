package newpackage03;

public class Monster_Troll extends SuperMonster{
   public Monster_Troll(){
        this.setName("Troll");
        this.setDescription("un enorme ed orrendo troll, alto più di due metri con una clava ed un piccolo straccio per coprirsi le parti intime che lascia davvero poco spazio all'immaginazione... ");
        this.setHp(50);
        this.setAttack(9);
        this.setAttackMessage("La sua clava ti colpisce con forza!");
        this.setDodgeMessage("Ti meravigli di essere riuscito a mancare un bersaglio così grosso...");
        this.setHitRate(50);
        this.setDodgeRate(5);
        this.setAka(new String[]{"mostro"});
    }
}