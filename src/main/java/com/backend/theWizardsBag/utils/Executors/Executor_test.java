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
        // TEST Spell     <- Completed
        SpellJDBCExecutor spellJDBCExecutor = new SpellJDBCExecutor();

        // -------------------------------------------------------------------------------
        // TEST SpellClass
        SpellClassJDBCExecutor spellClassJDBCExecutor = new SpellClassJDBCExecutor();

        List<SpellClass> spellClasses = spellClassJDBCExecutor.getAllByClassId(1);
        for(SpellClass spellClass : spellClasses){
            System.out.println(spellClass);
        }


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
