package com.backend.theWizardsBag.utils.Executors;


import com.backend.theWizardsBag.models.*;
import com.backend.theWizardsBag.utils.Executables.*;

import java.util.ArrayList;
import java.util.List;

public class Executor_test {
    public static void main(String[] args) {

        // -------------------------------------------------------------------------------
        // TEST Condition



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
        // TEST Tag
        TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();

        // by id
        /*
        Tag tag = tagJDBCExecutor.getById(12);
        System.out.printf(tag.toString());
        */

        // by name
        /*
        Tag tag = tagJDBCExecutor.getByName("Shapechanging");
        System.out.println(tag);
         */

        // all
        /*
        List<Tag> tags = tagJDBCExecutor.getAll();
        for (Tag tag : tags) {
            System.out.println(tag);
        }
         */

        // create
        /*
        System.out.println("Created: \n" + tagJDBCExecutor.create("Tag Test Name 2", "Tag Test Type 2").toString());
         */

        // update

        Tag inputTag = new Tag(80, "Mocha", "Mocha Description");
        tagJDBCExecutor.update(inputTag);


        // delete
        /*
        tagJDBCExecutor.delete(78);
         */

        // -------------------------------------------------------------------------------
        // TEST Type
        TypeJDBCExecutor typeJDBCExecutor = new TypeJDBCExecutor();

        // create
        /*
        Type type = typeJDBCExecutor.create("Test type 1", "Test sub type 1");
        System.out.println(type);
        */

        // find by id
        /*
        Type type = typeJDBCExecutor.getById(6);
        System.out.println(type);
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
