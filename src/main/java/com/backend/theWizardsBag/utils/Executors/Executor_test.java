package com.backend.theWizardsBag.utils.Executors;


import com.backend.theWizardsBag.models.*;
import com.backend.theWizardsBag.utils.Executables.*;

import java.util.ArrayList;
import java.util.List;

public class Executor_test {
    public static void main(String[] args) {

        // -------------------------------------------------------------------------------
        // TEST Condition
        ConditionJDBCExecutor conditionJDBCExecutor = new ConditionJDBCExecutor();

        // create
        /*
        System.out.println(conditionJDBCExecutor.create("test name", "test description"));
        */

        // get by id
        /*
        System.out.println(conditionJDBCExecutor.getByID(17));
         */

        // get all
        /*
        List<Condition> conditions = conditionJDBCExecutor.getAll();
        for (Condition condition : conditions) {
            System.out.println(condition);
        }
        */

        // get by name
        /*
        System.out.println(conditionJDBCExecutor.getByName("blinded"));
        */


        // update
        /*
        Condition conditionWithNewData = new Condition(17, "Calvin name" , "Mocha Description");
        conditionJDBCExecutor.update(conditionWithNewData);
        */

        // delete
        /*
        conditionJDBCExecutor.delete(17);
         */



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
        System.out.println(damagetypeJDBCExecutor.getByName("acid"));

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
