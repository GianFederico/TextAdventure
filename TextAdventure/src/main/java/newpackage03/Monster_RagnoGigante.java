package newpackage03;

public class Monster_RagnoGigante extends SuperMonster{
   public Monster_RagnoGigante(){
        this.setName("Ragno gigante");
        this.setDescription("un ragno alto almeno un metro e con una peluria più folta del baffo del fabbro del villaggio.");
        this.setHp(40);
        this.setAttack(3);
        this.setAttackMessage("Ti morde!");
        this.setDodgeMessage("Con una velocità straordinaria schiva il tuo colpo facilmente");
        this.setHitRate(60);
        this.setDodgeRate(40);
        this.setAka(new String[]{"mostro", "ragno"});
    }
}