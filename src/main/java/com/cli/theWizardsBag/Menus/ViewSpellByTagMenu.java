package com.cli.theWizardsBag.Menus;

import com.backend.theWizardsBag.models.Tag;
import com.backend.theWizardsBag.utils.Executables.TagJDBCExecutor;

import java.util.List;
import java.util.Scanner;

public class ViewSpellByTagMenu {

    Scanner scanner = new Scanner(System.in);
    TagJDBCExecutor tagJDBCExecutor = new TagJDBCExecutor();
    List<Tag> tags = tagJDBCExecutor.getAllByTagTypes("spell", "both");
    // create new object with list number, tag name, and tag id

    // CONs



    // METHs
    // List tags to select
    // Number selected cause the "get all spells with tag id"





}
