package com.backend.theWizardsBag.utils.Executors;


import com.backend.theWizardsBag.constants.enums.SpellDamageTypes;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.models.SpellCondition;
import com.backend.theWizardsBag.models.SpellDamage;
import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.utils.Executables.SpellConditionJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellDamagetypeJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellTagJDBCExecutor;

import java.util.ArrayList;
import java.util.List;

public class Executor_test {
    public static void main(String[] args) {

        // TEST SPELLS
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();



        // Get all the tags for a spell
        Spell spell = spellJDBCExecutor.getById(10);
        System.out.println(spell.getConditionList());



        // -------------------------------------------------------------------------------

        // Get All...
        /*
        List<Spell> spells1 = spellJDBCExecutor.getAll();
        for (Spell spell : spells1) {
            System.out.println(spell.getName());
        }
         */

        // Get by Id...
        /*
        Spell spell2 = spellJDBCExecutor.getById(55);
        System.out.println(spell2);
         */

        // TEST SPELL CONDITIONS
        SpellConditionJDBCExecutor spellConditionJDBCExecutor = new SpellConditionJDBCExecutor();

        // Get All...
        /*
        List<SpellCondition> spellConditions1 = spellConditionJDBCExecutor.getAll();
        for (SpellCondition spellCondition : spellConditions1) {
            System.out.println(spellCondition);
        }
         */

        // Get by ID...
        /*
        SpellCondition spellCondition1 = spellConditionJDBCExecutor.getById(5);
        System.out.println(spellCondition1);
        */

        // Get All by Spell ID...
        /*
        List<SpellCondition> spellConditions1 = spellConditionJDBCExecutor.getAllBySpellId(44);
        for (SpellCondition spellCondition : spellConditions1) {
            System.out.println(spellCondition);
        }
        */

        // TEST DAMAGETYPES
        SpellDamagetypeJDBCExecutor spellDamagetypeJDBCExecutor = new SpellDamagetypeJDBCExecutor();

        // Get All...
        /*
        List<SpellDamage> spellDamages = spellDamagetypeJDBCExecutor.getAll();
        for (SpellDamage spellDamage : spellDamages) {
            System.out.println(spellDamage);
        }
        */

        // Get by Id...
        /*
        SpellDamage spellDamage1 = spellDamagetypeJDBCExecutor.getById(7);
        System.out.println(spellDamage1);
         */

        // Get All by Spell ID...
        /*
        List<SpellDamage> spellDamages2 = spellDamagetypeJDBCExecutor.getAllBySpellId(55);
        for (SpellDamage spellDamage : spellDamages2) {
            System.out.println(spellDamage);
        }
        */

        // TEST TAG
        SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();

        // Get All...
        /*
        List<SpellTag> spellTags1 = spellTagJDBCExecutor.getAll();
        for (SpellTag spellTag : spellTags1) {
            System.out.println(spellTag);
        }
         */

        // Get by ID...
        /*
        SpellTag spellTag1 = spellTagJDBCExecutor.getByID(7);
        System.out.println(spellTag1);
         */

        // Get All by Spell ID...
        /*
        List<SpellTag> spellTags2 = spellTagJDBCExecutor.getAllBySpellId(17);

        for (SpellTag spellTag : spellTags2) {
            System.out.println(spellTag);
        }
         */


    }
}
