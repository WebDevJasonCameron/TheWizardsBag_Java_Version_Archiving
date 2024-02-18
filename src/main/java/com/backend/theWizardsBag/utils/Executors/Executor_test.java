package com.backend.theWizardsBag.utils.Executors;


import com.backend.theWizardsBag.models.*;
import com.backend.theWizardsBag.utils.Executables.*;

import java.sql.Date;
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
        // TEST Effect     <- Completed
        EffectJDBCExecutor effectJDBCExecutor = new EffectJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Note     <- Completed
        NoteJDBCExecutor noteJDBCExecutor = new NoteJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST RpgClass     <- Completed
        RpgClassJDBCExecutor classJDBCExecutor = new RpgClassJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Source     <- Completed
        SourceJDBCExecutor sourceJDBCExecutor = new SourceJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Tag     <- Completed
        TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Type     <- Completed
        TypeJDBCExecutor typeJDBCExecutor = new TypeJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Tag     <- Completed
        TagJDBCExecutor tagJDBCExecutor1 = new TagJDBCExecutor();


        // -------------------------------------------------------------------------------
        // TEST Spell
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();

        // create
        /*
        System.out.println(spellJDBCExecutor.create(
                "Calvin Spell",
                "2nd",
                "Instant",
                "30 ft",
                true,
                true,
                false,
                "",
                "1 hr",
                true,
                false,
                "puppy school",
                "",
                "Calvin can describe this to you later",
                "",
                5));
        */

        // find all
        /*
        List<Spell> spells = spellJDBCExecutor.getAll();
        for (Spell spell : spells) {
            System.out.println(spell);
        }
        */


        // update
        /*
        Spell spellWithNewData = new Spell(
                289,
                "Mocha's Awesome Spell!",
                "8nd",
                "Instant",
                "60 ft",
                true,
                true,
                false,
                "",
                "5 hr",
                true,
                false,
                "mocha school",
                "",
                "Mocha will not tell you cause she knows all",
                "",
                5
                );
        System.out.println(spellJDBCExecutor.update(spellWithNewData));
        */

        // delete
        /*
        spellJDBCExecutor.delete(289);
         */

        // -------------------------------------------------------------------------------
        // TEST SpellClass
        SpellClassJDBCExecutor spellClassJDBCExecutor = new SpellClassJDBCExecutor();


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
