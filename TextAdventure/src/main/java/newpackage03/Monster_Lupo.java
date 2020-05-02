package newpackage03;

public class Monster_Lupo extends SuperMonster{
    
   public Monster_Lupo(){
        this.setName("lupo");
        this.setDescription("un lupo solitario, probabilmente in cerca di cibo....e tu sembri essere meglio di niente.");
        this.setHp(25);
        this.setAttack(5);
        this.setAttackMessage("ti azzanna con i suoi canini affilati!");
        this.setDodgeMessage("schiva con destrezza!");
        this.setHitRate(80);
        this.setDodgeRate(35);
        this.setAka(new String[]{"mostro", "animale"});
    }
}
