package monsterSet;

import base.SuperMonster;

public class Monster_RagnoGigante extends SuperMonster {
   public Monster_RagnoGigante(){
        this.setName("Ragno gigante");
        this.setDescription("un ragno alto almeno un metro e con una peluria più folta del baffo del fabbro del villaggio.");
        this.setDeadName("Carcassa del ragno");
        this.setDeadDescription("Il cadavere del ragno che hai sconfitto");
        this.setHp(40);
        this.setTotHp(40);
        this.setAttack(7);
        this.setAttackMessage(new String[]{"Ti morde con i suoi innmerevoli denti", "Ti spara addosso getti di ragnatela", "Ti colpisce con le sue zampe appuntite"});
        this.setDodgeMessage(new String[]{"con una straordinaria velocità schiva il tuo colpo abilmente","evita il tuo colpo"});
        this.setHitRate(60);
        this.setDodgeRate(40);
        this.setImage("           ____\n" +
"          /---.'.__             ____//\n" +
"               '--.\\           /.---'\n" +
"        /.------.\\  \\|      .'/  ______\n" +
"       //  ___  \\ \\ ||/|\\  //  _/_----.\\__\n" +
"      |/  /.-.\\  \\ \\:|< >|// _/.'..\\   '--'\n" +
"         //   \\'. | \\'.|.'/ /_/ /  \\\\\n" +
"        //     \\ \\_\\/\" ' ~\\-'.-'    \\\\\n" +
"       //       '-._| :H: |'-.__     \\\\\n" +
"      //           (/'==='\\)'-._\\     ||\n" +
"      ||                        \\\\    \\|\n" +
"      ||                         \\\\    '\n" +
"      |/                          \\\\\n" +
"                                   ||\n" +
"                                   \\\\                       ");
    }
}