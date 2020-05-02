package newpackage03;

public class Monster_Hobgoblin extends SuperMonster{
   public Monster_Hobgoblin(){
        this.setName("hobgoblin");
        this.setDescription("Un vecchio Hobgoblin, probabilmente un servitore a difesa della dimora dello sciamano. Puzza come la peggiore delle latrine che riesci ad immaginare");
        this.setHp(30);
        this.setAttack(4);
        this.setAttackMessage("Ti ferisce con i suoi artigli!");
        this.setDodgeMessage("Riesce a spostarsi al momento giusto, e devia il tuo colpo");
        this.setHitRate(70);
        this.setDodgeRate(10);
        this.setAka(new String[]{"mostro"});
    }
}