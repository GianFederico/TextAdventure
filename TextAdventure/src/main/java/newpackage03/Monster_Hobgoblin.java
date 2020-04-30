/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage03;

/**
 *
 * @author gianf
 */
public class Monster_Hobgoblin extends SuperMonster{
   public Monster_Hobgoblin(){
        name="Hobgoblin";
        description="Un vecchio Hobgoblin, probabilmente a difesa della dimora e servitore dello sciamano. Puzza come la peggiore delle latrine che riesci ad immaginare";
        hp=30;
        attack=4;
        attackMessage="Ti ferisce con i suoi artigli!";
        dodgeMessage="Riesce a spostarsi al momento giusto, e devia il tuo colpo";
        hitRate=70;
        dodgeRate=10;
    }
}