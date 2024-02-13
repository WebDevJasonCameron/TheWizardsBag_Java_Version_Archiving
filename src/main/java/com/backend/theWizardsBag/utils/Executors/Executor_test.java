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

        // update
        /*
        Condition conditionWithNewData = new Condition(17, "Calvin name" , "Mocha Description");
        conditionJDBCExecutor.update(conditionWithNewData);
        */

        // delete
        conditionJDBCExecutor.delete(17);



        // -------------------------------------------------------------------------------
        // TEST Damagetype



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

        // create
        /*
        Type type = typeJDBCExecutor.create("Calvin", "Mocha");
        System.out.println(type);
        */

        // find by id
        /*
        Type type = typeJDBCExecutor.getById(378);
        System.out.println(type);
        */

        // find all by name
        /*
        List<Type> types = typeJDBCExecutor.getAllByName("document");
        for (Type type : types) {
            System.out.println(type);
        }
        */

        // find by name and sub
        /*
        System.out.println(typeJDBCExecutor.getByNameAndSubType("document", "letters"));
        */

        // delete
        /*
        typeJDBCExecutor.delete(379);
        */

        // update
        /*
        Type typeNetData = new Type(378, "no name", "no sub");
        typeJDBCExecutor.update(typeNetData);
        */

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
