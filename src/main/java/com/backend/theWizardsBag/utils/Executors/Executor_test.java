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
        // TEST Note
        NoteJDBCExecutor noteJDBCExecutor = new NoteJDBCExecutor();

        // create
        /*
        System.out.println(noteJDBCExecutor.create("Calvin Note", Date.valueOf("2024-01-01"), "Much to be said here", "Mocha"));
        */

        // find by id
        /*
        System.out.println(noteJDBCExecutor.getById(2));
        */

        // find all
        /*
        List<Note> notes = noteJDBCExecutor.getAll();
        for (Note note : notes) {
            System.out.println(note);
        }
        */

        // update
        /*
        Note noteWithNewData = new Note(2, "Mocha note",  Date.valueOf("2024-02-02"), "Calvin objects!", "Mocha Cameron");
        noteJDBCExecutor.update(noteWithNewData);
        */

        // delete
        /*
        noteJDBCExecutor.delete(2);
        */

        // find all by author
        /*
        List<Note> notes = noteJDBCExecutor.getAllByAuthor("teSt author");
        for (Note note : notes){
            System.out.println(note);
        }
        */


        // -------------------------------------------------------------------------------
        // TEST RpgClass



        // -------------------------------------------------------------------------------
        // TEST Source
        SourceJDBCExecutor sourceJDBCExecutor = new SourceJDBCExecutor();

        /*
        // create
        System.out.println(sourceJDBCExecutor.create("Calvin Rules", Date.valueOf("2024-02-23"), "Mocha Publishing's", "RPG X"));
        */

        // find by id
        /*
        System.out.println(sourceJDBCExecutor.getById(85));
        */

        // find all
        /*
        List<Source> sources = sourceJDBCExecutor.getAll();
        for(Source source : sources){
            System.out.println(source);
        }
        */

        // find all by ttrpg
        /*
        List<Source> sources = sourceJDBCExecutor.getAllByTTRPG("");
        for (Source source : sources){
            System.out.println(source);
        }
         */

        // update
        /*
        Source sourceWithNewData = new Source(85, "Mocha Rules", Date.valueOf("2024-01-12"), "Mocha's Mega Publishing's", "Cool RPG");
        sourceJDBCExecutor.update(sourceWithNewData);
        */

        // delete
        /*
        sourceJDBCExecutor.delete(85);
        */


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
