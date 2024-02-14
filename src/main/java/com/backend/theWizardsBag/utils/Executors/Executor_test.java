package com.backend.theWizardsBag.utils.Executors;


import com.backend.theWizardsBag.models.*;
import com.backend.theWizardsBag.utils.Executables.*;

import java.util.ArrayList;
import java.util.List;

public class Executor_test {
    public static void main(String[] args) {

        // -------------------------------------------------------------------------------
        // TEST Condition     <- Completed
        ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();



        // -------------------------------------------------------------------------------
        // TEST Damagetype
        DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();

        // create
        /*
        System.out.println(damagetypeJDBCExecutor.create("Calvin Damage"));
        */

        // find by id
        /*
        System.out.println(damagetypeJDBCExecutor.getById(39));
        */

        // find all
        /*
        List<Damagetype> damagetypes = damagetypeJDBCExecutor.getAll();
        for (Damagetype damagetype : damagetypes) {
            System.out.println(damagetype);
        }
         */

        // find by name
        /*
        System.out.println(damagetypeJDBCExecutor.getByName("acid"));
        */

        // update
        /*
        Damagetype damagetypeWithNewData = new Damagetype(39, "Mocha Damage");
        damagetypeJDBCExecutor.update(damagetypeWithNewData);
        */

        // delete
        /*
        damagetypeJDBCExecutor.delete(39);
        */


        // -------------------------------------------------------------------------------
        // TEST Effect
        EffectJDBCExecutor effectJDBCExecutor = new EffectJDBCExecutor();

        // create
        /*
        System.out.println(effectJDBCExecutor.create("Calvin Name", "Mocha sub"));
        */

        // find by id
        /*
        System.out.println(effectJDBCExecutor.getById(2657));
        */

        // find all
        /*
        List<Effect> effects = effectJDBCExecutor.getAll();
        for (Effect effect: effects) {
            System.out.println(effect);
        }
         */

        // find all by name
        /*
        List<Effect> effects = effectJDBCExecutor.getAllByName("Size");
        for (Effect effect : effects) {
            System.out.println(effect);
        }
         */

        // find by name and sub
        /*
        System.out.println(effectJDBCExecutor.getByNameAndSub("Size", "Tiny"));
        */

        // update
        /*
        Effect effectWithNewData = new Effect(2657, "Mocha Name", "Mocha sub name");
        System.out.println(effectJDBCExecutor.update(effectWithNewData));
        */

        // delete
        /*
        effectJDBCExecutor.delete(2657);
        */


        // -------------------------------------------------------------------------------
        // TEST Note



        // -------------------------------------------------------------------------------
        // TEST RpgClass



        // -------------------------------------------------------------------------------
        // TEST Source



        // -------------------------------------------------------------------------------
        // TEST Tag     <- Completed
        TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Type     <- Completed
        TypeJDBCExecutor typeJDBCExecutor = new TypeJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Tag


        // -------------------------------------------------------------------------------
        // TEST Spell
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST SpellClass
        SpellClassJDBCExecutor spellClassJDBCExecutor = new SpellClassJDBCExecutor();

        // get by id
        /*
        SpellClass spellClass = spellClassJDBCExecutor.getById(1);
        System.out.println(spellClass);
        /*

         */
        // -------------------------------------------------------------------------------
        // TEST SpellCondition
        SpellConditionJDBCExecutor spellConditionJDBCExecutor = new SpellConditionJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST SpellDamagetype
        SpellDamagetypeJDBCExecutor spellDamagetypeJDBCExecutor = new SpellDamagetypeJDBCExecutor();



        // -------------------------------------------------------------------------------
        // TEST SpellTag
        SpellTagJDBCExecutor spellTagJDBCExecutor = new SpellTagJDBCExecutor();



    }
}
