package monsterSet;

import base.Stobj;
import base.SuperMonster;

public class Monster_Viverna extends SuperMonster {
   public Monster_Viverna(){
        this.setName("Viverna");
        this.setDescription("una Viverna. E' un lucertolone alato un po' piu' piccolo di un drago,\ncon due sole zampe, ma altrettanto temibile.");
        this.setDeadName("Carcassa della viverna");
        this.setDeadDescription("Il cadavere della viverna che hai sconfitto.");
        this.setHp(50);
        this.setTotHp(50);
        this.setAttack(9);
        this.setAttackMessage(new String[]{"Ti lacera con i suoi artigli","Ruggisce producendo una grossa fiammata e","Ti azzanna con i suoi denti incandescenti"});
        this.setDodgeMessage(new String[]{"con un abile balzo all'indietro riesce a schivare il tuo colpo","evita il tuo colpo"});
        this.setHitRate(80);
        this.setDodgeRate(20);
        this.setLoot(new Stobj("Gemma", "La gemma della viverna. L'hai estratta dallo stomaco del suo cadavere.\nPerchè squartare cadaveri ogni tanto ripaga della fatica."));
        this.getLoot().setPickupable(true);
        this.setImage("<>=======() \n" +
"(/\\___   /|\\\\          ()==========<>_\n" +
"      \\_/ | \\\\        //|\\   ______/ \\)\n" +
"        \\_|  \\\\      // | \\_/\n" +
"          \\|\\/|\\_   //  /\\/\n" +
"           (oo)\\ \\_//  /\n" +
"          //_/\\_\\/ /  |\n" +
"         @@/  |=\\  \\  |\n" +
"              \\_=\\_ \\ |\n" +
"                \\==\\ \\|\\_ \n" +
"             __(\\===\\(  )\\\n" +
"            (((~) __(_/   |\n" +
"                 (((~) \\  /\n" +
"                 ______/ /\n" +
"                 '------'");
    }
}