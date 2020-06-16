package monsterSet;

import base.SuperMonster;

public class Monster_Hobgoblin extends SuperMonster {
   public Monster_Hobgoblin(){
        this.setName("Hobgoblin");
        this.setDescription("un vecchio Hobgoblin, probabilmente un \nservitore a difesa della dimora dello sciamano. \nPuzza come la peggiore delle latrine che riesci ad immaginare...");
        this.setDeadName("Carcassa del goblin");
        this.setDeadDescription("Il cadavere dell'hobgoblin che hai sconfitto. \nRiesce ad emanare un odore peggiore di quando era in vita...per quanto possibile...");
        this.setHp(30);
        this.setTotHp(30);
        this.setAttack(6);
        this.setAttackMessage(new String[]{"Ti ferisce con i suoi artigli", "Si attacca alla tua caviglia con un morso"});
        this.setDodgeMessage(new String[]{"riesce a spostarsi al momento giusto e a deviare il tuo colpo","evita il tuo colpo"});
        this.setHitRate(70);
        this.setDodgeRate(10);
        this.setImage("         .';:;'.\n" +
"        /_' _' /\\   __\n" +
"        ;a/ e= J/-'\"  '.\n" +
"        \\ ~_   (  -'  ( ;_ ,.\n" +
"         L~\"'_.    -.  \\ ./  )\n" +
"         ,'-' '-._  _;  )'   (\n" +
"       .' .'   _.'\")  \\  \\(  |\n" +
"      /  (  .-'   __\\{`', \\  |\n" +
"     / .'  /  _.-'   \"  ; /  |\n" +
"    / /    '-._'-,     / / \\ (\n" +
" __/ (_    ,;' .-'    / /  /_'-._\n" +
"`\"-'` ~`  ccc.'   __.','     \\j\\L\\\n" +
"                 .='/|\\7      \n" +
"                  ' `");
    }
}