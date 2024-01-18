package com.backend.theWizardsBag.utils.Executors;


import com.backend.theWizardsBag.constants.enums.SpellDamageTypes;
import com.backend.theWizardsBag.models.Spell;
import com.backend.theWizardsBag.models.SpellDamage;
import com.backend.theWizardsBag.models.SpellTag;
import com.backend.theWizardsBag.utils.Executables.SpellDamagetypeJDBCExecutor;
import com.backend.theWizardsBag.utils.Executables.SpellTagJDBCExecutor;

import java.util.ArrayList;
import java.util.List;

public class Executor_test {
    public static void main(String[] args) {

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
