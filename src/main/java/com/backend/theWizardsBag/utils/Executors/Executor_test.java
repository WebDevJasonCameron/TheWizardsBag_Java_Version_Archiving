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
        // TEST Damagetype     <- Completed
        DamagetypeJDBCExecutor damagetypeJDBCExecutor = new DamagetypeJDBCExecutor();


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
