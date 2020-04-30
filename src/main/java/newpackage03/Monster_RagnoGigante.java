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
public class Monster_RagnoGigante extends SuperMonster{
   public Monster_RagnoGigante(){
        name="Ragno gigante";
        description="un ragno alto almeno un metro e con una peluria più folta del baffi del fabbro al villaggio.";
        hp=40;
        attack=3;
        attackMessage="Ti morde!";
        dodgeMessage="Con una velocità straordinaria schiva il tuo colpo facilmente";
        hitRate=60;
        dodgeRate=40;
    }
}