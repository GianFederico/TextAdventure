package newpackage03;

public class Monster_Viverna extends SuperMonster{
   public Monster_Viverna(){
        this.setName("Viverna");
        this.setDescription("un po' piu' piccolo di un Drago, con due sole zampe, ma altrettanto temibile, ha una strana gemma incastonata sulla fronte. ");
        this.setHp(50);
        this.setAttack(8);
        this.setAttackMessage("Ti afferra con i suoi artigli e ti azzanna!");
        this.setDodgeMessage("Con un abile balzo all'indietro riesce a schivare il tuo colpo.");
        this.setHitRate(80);
        this.setDodgeRate(20);
        this.setAka(new String[]{"mostro"});
    }
}