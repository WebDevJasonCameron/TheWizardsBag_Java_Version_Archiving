# Log

## 2024 09 07 

Not really sure how this works

---

## 2024 08 29

I should remember that work of this project could be divided into different aspects.  One, of course there is the code.  Second, there is the writing of different items and spells.  I should start that at some point.  Third, there is the design (or sketching out) the product look.  Fourth, there is the sculpting and final item product look that should be collected for display.  It may take some time, but I think we can provide a fantastic shop for our customers.  

---

## 2024 08 27

Wow, I'm a dunce sometimes.  I didn't realize that... yes, I did create a log in the "notes" directory.  As such, I moved my most recent rants... I mean logs, into their proper place. Here. Here is the proper place. **Sigh

---

## 2024 08 26

Let's figure out how the CLI should function.  A main menu should ask the user what they would like to do.  1. Search for an Item or Spell.  This is one branch.  If they choose to search for 1.A Item or 1.B spell, we should then ask them how they want to search the Item or Spell: (1) name, or some searchable attribute (2...3).  After they find the Spell or Item, we may ask them if they want to edit it or copy and edit the existing one to make it their own.  I don't think it is smart to try to remove a spell since it may be tied to items later.

Although this function might be doable if we run a query for all items and then remove it from those records.  This also means that if this is done then we potentially will need to re-add a spell for those items, and we won't know what items need a spell added to them.  With that thought, I think it is probably best to just not remove a spell at this point.  One other thing we can do is show the user how removing the spell will affect all the different items.  This can be given to the user as a confirmation box.  For example, a box of text can "show a WARNING, that removing a spell will affect item 111, item 222, item 333, etc." and if they still want to remove the spell they will need to confirm.  However, I think we can do this from the main menu's branch of removing something.

The main menu should include whether the user wants to edit, delete, or add an Item or Spell.  These will also spawn their own branches or options.  Additionally, one may need to create a spell that is associated with an item if the spell doesn't already exist. 　I should look into the attributes of each and draw out a user flow chart of how each menu branch will need to be worked out within the CLI.

I find it interesting that CLI will need to get the user to make decisions as a flow due to its nature.  However, when we use a GUI, the user can kind of bypass all these flows because the user can select multiple choices prior to call an execution.  And yet, I expect the program will still need to follow the CLI flow to function properly.  That's why I think working out this CLI flow should be done right now (especially when I'm trying to feel out the application's development rather than just "knowing").

---

## 2024 08 24

Alright.  I have a python tool that needs to be built for work.  After that is done, I'll come back to this.  Should take about a week.  Fingers crossed!

---

## 2024 08 23
Good progress in today's reintegration of the code.  I am still not sure how to go about handling all the CLI menus.  However, I was able to get back to the basics of input and response within the CLI.  It is good to finally get back into the simple stuff.  I hope I will look back at all this and think that I am being too simple as I will have grown to grasp the more complex modular stuff.  I am not even using Java beyond its most basic capes.  Still, got to start (or keep restarting) somewhere.

---

## 2024 08 22
I was trying to figure out where to start back into.  I think I was first working on trying to create a GUI system with JavaFX.  The problem, I hadn't figured out the interaction that needs to be done.  That means, I want to run through the CLI menu commands.  I want to figure out how the User should interact with the DB.  That leaves me to wonder (once again) where to begin.  Since the DB is created and the CRUD commands are already created, lets write a simple menu (test menu) that ask the User to input a "spell name" to search for.  If the name returns a response, we can display it and ask if the user wants to search again or finish the program.  If it doesn't, it should tell the user that nothing was found and (once again), ask them if they want to try again or finish the program.  Really simple I know.  That's what happens when you don't get to write code all day... instead, I'm spending my time at work as a "sys-ad," something I can do but really don't want to do.  I digress... this is where we are for tonight's work.

---

## 2024 08 21
I started this project earlier this year.  I got really far, but (as with everything) I got side track with so many other things.  I was learning so much with this project and I want to come back to it.  I really think it was organized pretty well.  However, I can't remember what I was getting stuck on.  That is why I should have had a log.  Even though it's a little late in the game, I figured I would create a log now.  I think I can figure out where I left off.  I'll put my thoughts on the subject here.  At least I had a plan written in the RM.

I think I was working on the Java GUI by looking up all the JavaFX tutorials.

---

## 2024-02-22 | Next

I need to figure out what is next.  The Spell SQL commands and executors are completed.  I now need to build something around them.  I thought that "something" should be a CLI program that CRUDs all the different spells and attributes.  Another option is to build a GUI with JavaFX.  That is something I'm leaning towards wanting to do rather than the CLI.  It's something I really haven't built before.  Third option is to just push everything to Web browser.  This is probably the quickest and most fruitful.  Let me think about this for a couple of days.  I might even start a JavaFX Udemy course for a month to really decide.  We'll see...

---

## 2024-02-05 | Mixed Classes

I was having a hard time figuring how to build out my DAOs.  For example, the SpellClass DAO was making SQL queries for all the classes.  This it hit me, I don't want that.  That should go to the class (prgClasses) DAO.  If I want to create, update or delete a rpg class, I should use a targeted class DAO.  The SpellClass DAO should let me target the junction table and CRUD data relating this.  Then, I should be able to use the executables within the narrower class DAO to read the class information.  I also need to realize that it doesn't matter if I don't use rpg class in the items attributes.  Doing it this way means things stay confined to the "best answer" so-to-spake.  So!  I need a:

- Conditions DAO
- Effects DAO
- Damagetypes DAO
- Sources DAO
- RPG Class dAO
- Tags DAO
- Types DAO

When that is done, I'll need to rework the following DAOs to focus on junction table CRUD functions

- spellClasses
- spellConditions
- spellDamagetypes
- spellTags 

---

## 2024-01-29 | Spells 

After taking a week or so to do a quick blog project, I'm back.  Honestly, I wanted a blog to talk more about what we are doing here at Wizard Bag Co.  I am just so freaking excited at the things we've been learning and I wanted to share it in an area where I can be a little more creative.  So, if you feel like it, check out my stuff on Jason-Codes.blog.  

I digress, as so often I do.  We now can query a spell and get the list of attributes stored in many-to-many tables.  That was indeed complicated. But worth it.  Yes, I know I could use an ORM, but I wanted to do it the "hard way" so I can understand just what is going on behind the scenes.  Every good wizard is curious about such things, you know.  With that said, I first had to build the spell look up script.  Once that was done, I needed to build look up scripts for all the one-to-many and many-to-many tables that are connected to the Spell object.  These scripts included the "SpellClass", "SpellConditions", "SpellDamagetype", and "SpellTag" lists.  Each one of these list objects needed a special query towards the junction table to find all relating objects with the specified spell id number.  Then, that list response was applied to the Spell object's appropriate list attributes.  As such, we have all the attributes for a spell object available for query!  

I find it funny that this only the beginning because we need to do the same for ALL the items within our inventory.  That means you will have an Item object with attributes that also have list of attributes which will include spell objects that have their own attributes and list of attributes that are also collected through junctions tables.  The rabbit hole is deep my friend.  So very deep.  

---

## 2024-01-17 | Hey Log

I've been able to do quite a lot when we're in the middle of the "Freeze of 24."  Is this still winter of 2023 or do we switch to saying it's the winter of 2024?  And does that mean we have two winters in one year???  Google!? Okay, as far as I can tell... We say this is still the winter of 2023 because winter starts in December.  Thus, we have yet to experience the winter of 2024.  So, We are experience the "Freeze of 23 but happed in 2024." Clear?  I digress. I've updated the sql tables to be syntactically clearer.  I've also been able to do searches by id of attribute, or search all attributes by spell id number.  This is cool.  The purpose of this is so we can get a spell with all it's many-to-many attributes (i.e. tags).  So, when we do a search for a spell (next thing, search by name), we can include all the tags, damagetypes, and other stuff.  Also, since these are java objects, we will have all their attributes.  That is pretty cool.  Wow, pretty soon, I need to create a CLI application to view what we have in the DB.  That's cool. 

---

## 2024-01-16 | Labels and IDs Matter

I spent a lot of time the last couple of days refactoring the labels of vars and in some case, just adding and deleting them, because the DB was slightly off from what I imagined it to be while writing Java code.  I know!  I'm surprised as you!  Yet, the DB is roughly done with data inside (That took a long month and a half) and I noted some of my var labels sucked.  Some of them still do.  However, I think taking to the time to ensure your labels make clear contestant meaning will help much later down the road.  I also found that I needed to distinguish the attribute id such as conditionID and classID from the spellConditionId and spellClassID.  My reasoning is, I have quite a lot of junction tables!  Each model could have (should have) identified the classID along with the junction's spellClassID.  This way, I can target the junction's spellClassID and delete it... while not deleting neither the item/spell or the class from their respective tables!  I can also modify a missed relation by grabbing the junction's id for an item and changing it to a different classID.  Are you confused?  That's magic baby!  LOL, it's not all twinkling lights and explosions (^>_<^)

---

## 2024-01-15 | Hard Freeze

So, there is a hard freeze (weather) going on here where I live.  Jut wanted to log that prior to figuring out what to do next.  The DB is loaded with all the spells and items I got from my md collection of the basic rules.  There is a ton more I can pull from the other books.  I guess that is where I can begin.  I need a nicer GUI to input more items and spells.  That said, I should probably just build a working CLI that can go through the flow of creating or inputting spells and items. 

Question: Should we be able to read or write first?  If I were five, I suspect I should learn to read then write.  

Reading:
- Need to pull a spell from db (without its many-to-many relationships)
- Next, pull the full spell including all its relationships 
- Need to pull a item from db (without its many-to-many relationships)
- Next, pull the full item including all its inner relationships
- Lastly, pull the full item including all its inner and outer relationships (spells... lets stop there)

Writing:
1. So, let see... Entering anything into the DB from the CLI should be figured out.  I'll use Java because it's where its were I started out.  Gryffindor all the way, baby!  Okay, it also because I need the continued practice.
2. Spells are their own thing.  They should be added to the db, so we can use them as "attached spells" to our items.  We can use the frameworks established in the foundational db construction.
3. Items will be the third step.

---

## 2024-01-08 | Insert Item Data Plan

Once again I find myself in front of a very large task and its very easily an overwhelming one.  Just like the spell data, I need to insert all the item data I have collected as mark down files.  It would be nice to say that I could just reproduce what I did for the spell data.  In a few cases, I can.  Mostly, I'll need to grab data from the MD files with different algorithms.  I like what I previously did for planning out the spell data, so I'm going to that again.  Let's start with looking at the item attributes.  These will be set in the "Create table" sql document.  
1. Name can be grabbed from the MD document by checking for any line that starts with "#"
2. TTRPG will be set to 5 for now.  
      - I'll need to actually go through and reset them once the GUI is completed, or I can use PG to select them
3. Rarity will come from the MD's "rarity:" label
      - An enum will be used to keep things consistent when adding new items
      - Remember, an item can only carry one rarity status.  Thus, I don't need a many-to-many table  
4. Renowned will come from the MD's "renowned_quality" label
      - An enum will be used to keep things consistent when adding new items
      - Remember, an item can only carry one rarity status.  Thus, I don't need a many-to-many table
5. Attunement requirement will come from the MD's "req_attunement" label
      - This will be a boolean
6. Using charge notation will come from scanning the item description for the word "charges"
      - This will be a boolean
7. Cursed notation will come from the MD's "is_cursed" label
8. Cost will be set to blank 
9. Weight will be set to blank
10. Description will come from the MD's description 
       - I'll need to count how the number of times "---" shows up on the page.  After the third time, we can gather the text 
       - We will also have to ignore the following "Notes:", "Item Tags:", and image MD syntax 
       - I want to keep any existing tables that are used in the MD description portion of the MD
11. Image URL will be set to blank
12. Magic bonus plus 1, 2, or/and 3 will need to be grabbed from scraping the description for "+1 bonus"... etcetera
13. Description notes will be grabbed from the MD's lines by scanning for any line that starts "Notes: "
      - The Notes consist of multiple distinguishing notes without much order.  I may need to fix this

The following explains the many-to-many tables that will require junction tables with the items table:
1. item_types : from "asset_type:" in MD and compared with "types" table list
2. item_tags : from "item_tag:" in MD and compared with "tags" table list
3. item_notes : Mostly blank
4. item_conditions : scraped from "description" in MD and compared with "conditions" table list
5. item_attached_spells : scraped from "description" in MD and compared with "spells" table list
6. item_effects : scraped from "description" in MD and compared with "effects" table list

---

## 2024-01-07 | Items Table

Happy New Year!  I just finish the set-up for ingesting all the spells I have from the basic rules books.  I used python to scrape all the markdown files I had and then rewrite the data into five separate sql files for inserting them into their proper tables.  SQL is often a pain when it comes down to organizing many-to-many relations.  You need junction tables to keep track of the relations.  That being said, I need to remind my self that you don't always need to go straight into building complex tables.  I'm now working on the scripts to ingest the items I have already stored in markdown files.  I was trying to figure why I hadn't created "create table" for rarities.  Then it hit me, an Item won't have multiple rarities... well, it could, but that's why we have a "varies" denominator.  So! No need to put more work on my shoulders.  KISS.  Then refactor it so you can Kiss again!!  

---

## 2023-12-31 | Insert Spell Data Plan

Hello everyone.  It's been a bit while I've been focussing on how best to build the DB.  I've actually been running through some very awesome PG training.  With that said, I now need to plan on how to take the markdown files that I've collected and convert them into a insert data sql script!  To do this, I'm going to:
1. Copy the files into one massive directory, so they can be organized alphabetical.  Right now, they are seperated by magic domains (i.e. abjuration, evocation, etcetera).  
2. I'm going to build a script to produce several insert sql files.  These will be produced at the same time, but I'll explain it in sequential order. 
   1. I need to build the INSERT INTO spells sql file.  This will Parse out the specifics that will go straight into the spells table.  While this is being done, I'll keep track with what PRIMARY KEY number we should be on, so it can be used in the following INSERT INTO sql files.
   2. I need to build the INSERT INTO spell_tags sql file.  This will be a combination of the captured spell_id (previously mentioned in #1) and comparing the spell_tags metadata with what can be found within the tags table.  Multiple matches will have multiple insert value lines.
   3. I need to build the INSERT INTO spell_conditions sql file.  This will be a combination of the captured spell_id (previously mentioned in #1) and comparing the DAMAGE/EFFECT table with what can be found within the conditions table.  Multiple matches will have multiple insert value lines.
   4. I need to build the INSERT INTO spell_damagetypes sql file.  This will be a combination of the captured spell_id (previously mentioned in #1) and comparing the DAMAGE/EFFECT table with what can be found within the damagetype table.  Multiple matches will have multiple insert value lines.
   5. I need to build the INSERT INTO spell_classes sql file.  This will be a combination of the captured spell_id (previously mentioned in #1) and comparing the available_fore metadata with what can be found within the rpg_classes table.  Multiple matches will have multiple insert value lines.
3. Finally, I need to run these sql scripts in order and test the results.  

There is a lot of parsing to make all this work, so I expect it to take some trial and error.  The main reason why I'm doing this is to help build "rebuild" sql scripts, so I can start over when I inevitably need to do just that.  Eventually I'll get to a point when I'm PG dumping backups to the DB (during production).  Right now I just need to have a basic DB construction build our little Arcane Application!

---

## 2023-12-04 | Postgres

I've decided I need to learn more about Postgres.  There are functions that might help with to overwhelming join queries I will need to call linked data.  I did a LinkedIn lesson to refresh my knowledge on PG DB.  I don't think I know as much as I thought I did.  I would like the SQL to work for me better than my simplistic and basic understanding allows me to use.  As such, I'm going to take a couple of weeks and dive deeper using a Udemy course I purchased a year ago.  It should help with this project as well as the many other work and personal projects I'll need to do later.  I'm not sure how to demonstrate my activity on GH. I'll probably just create another repo for "learningPostgres."  See you in a couple of weeks!

---

## 2023-12-02 | Clearing Things Up

I find that I'm doing a lot of reorganizing to some of the code as I figure out how I want variables structured to explain their function.  I'm also finding that the structure of DnD's game is only a illusion.  It really is a chaotic mess with some theoretical structures in place.  Did you know that Tags in spells and Items are different?  Conditions are the same but not tags?  That might make sense but they both have overlapping tags.  I'm thinking about keeping the tags in the same table within the DB while structuring their Enums to use when creating new spells.  That way I can ensure the same inputs are being placed into the DB, but then I only have to deal with one tag table.  Of course that causes a problem (and one I've already figured out as I write this... that's why it's important to do these logs!).  If I have two different enums (spellTags and itemTags) for my input forms, I will inevitably need to update the enum later when things change.  That means adding it to the DB tag table, then finding the correct enum and adding it to that!  I don't think I want to do that!  So, what did I figure out?  Too simple. Add another attribute in the tag class marking the tag as a spell, item or both tag!  OMG, too simple.  Then, make the change in the sql table to represent what each tag should be used for.  More work up front, but now I can sort tags by type.  When I need to update the table (and thus keep the edit and creation forms up-to-date by only providing a selection from that table) everything should stay organized.  

So what are enums good for?  I really don't know.  I thought it would keep me from needing to pull data from a DB, which might be yet another query slowing my web application down.   I think I would like to try asking someone who is smarter than me on that question.

---

### 1800 | Enum Answer

So I asked ChatGPT on that question from above.  I logged the answer in the AI notes.  It's interesting if you want to see the results.

---

### 2100 | Executors

I spent a lot of time today clearing up the DB tables.  I now have three spells to us for query testing purposes.  I can't wait to build some python scripts to convert the JSON file into table entries.  Although, I'm having some doubts about being able to strip the data and enter it across the multiple many-to-many tables.  Although, I think I can do it since the side tables won't change... I'll just need to create junction table entries based on the spell number entry and if it has matching attributes to those side tables' records.  I think that could actually be done.  Is it worth the work?  Hell, yeah (^>.<^).  Magic isn't free!  

I'm getting off target with this log.

I wanted to discus what I need to do to create executable query classes.  Specifically, I want an executable clases to have classes that let me target specific executable query tasks.  Let me try to flesh this out...

Within the SpellDAO
- Execute get all spells
- Execute get a spell by spell_id
- Execute get all spell_damage_types by spell_id  <-- (called from the SpellDamageDAO)
- Execute get all spell_tag_types by spell_id  <-- (called from the SpellTagDAO)

---

## 2023-11-26 | SQL Plans
I continue to need to mod my db plans.  I create a design, but it never really solidifies.  That's mainly because I keep discovering more attributes within the items and spells that require lists of possible inputs.  For example, I thought I could just ascribe a single damage type to a spell.  Then I realized, some spells let you choose your form of damage.  As such, you might have acid, fire or cold type damage for a single spell.  That meant I needed to add yet another table listing all the types we have listed within a TTRPG.  Then, I need a junction table to keep the pairing of that spell id (from the spell table) and the damage id (from the damage type table). I have a visual built out in the Visual Paradigm application.  I'll take a snapshot of it so ppl can review it for their own amusement.  However, as I said, this changes quite often right now.  I'll need to wait.

With that said, I need to build out a Read function, so I can see what I have preloaded into the db.  I'm only doing the first spell on my list right now (Acid Splash). It has a foreign key (source) and couple junction tables to access a list of other record lists (damage type and rpg classes).  This is going to be tough at first since using straight SQL join queries is not something I'm not really good at doing.  I know I could use Springboot or something to help.  I wanted this project to help me work through these situations.  That way, I can get better.  

---

## 2023-11-25 | Planning Mass DB Input
Since I found a lot of great list content that can be used to load my DB, I'm figuring out how to get it ingested.  First, I need to take in a JSON file.  The result will be JSON array.  From there, I need to script out a parser that coverts that array into an array of Spell and Item objects (not both at once mind you).  Once I have my array of hundreds of spells and items, I'll need to run them through a creat spell/item sql record.  The interesting thing here is, as I create a spell or item, I'll need to grab its id.  I also need to grab the ids from the matching tag, effect, condition and effect tables.  Finally, I can loop through the many different tags, effects, conditions, and effects each spell and item has and create the multiple records within their respective junction table using the spell/item id and the matching ids from those tag, type, condition, and effect tables.  That's a lot of small actions to create all these items!  I might want to start with coding out a process to create a single item from the CLI.  The work I do on this smaller task could be replicated towards a larger scale record ingestion!  I'll first work on creating a spell. Then I can build out the mas spell-book ingestion.  With that as a proof-of-concept, I should be able to repurpose most of the template into creating my items.  Although, I haven't really found an in-depth JSON file for items.  I might need to create those by hand. If that's the case, I might end up working on a GUI... We'll see.  

---

### 1000 | Dir and Pack Org
While java programs are usually set up as com.HighLevelPackageType.nameOfSite.LowerLevelPackageTypes where the higher level package reflects a "frontEnd" or "backEnd," I've decided to include a "cli" higher level package.  This "cli" is where I'll probably build out the java construction code needed for program scaffolding.  I should be able to use it to with the other higher level package labelled "gui."  I debated on this format because I think it could be argued that cli and gui are still backend type stuff.  Then I thought that the distinction between cli and gui are more localized whereas the backend serves to be the junction between frontend, backend, and cli.  In essence, gui is the only package that seems to be a subset of one of the lower level packages (cli).  

---

## 2023-11-24 | About the Start
I started this project a week ago.  I started with a db design.  That has changed as I construct the sql and java classes.  I'm trying to think things out without going too deep. I may want the scope to grow later. However, nothing is going to get done if the scope is too large.  As such, I am focusing on building out a library of D&D items that can be searched through with specific attributes.  I'll include a list of spells that are most likely attached to the magical items.  Later we will use users to log in and write notes on specific items.  Much later, I'd like to remember what the user searched for, what they liked or disliked and how much the wrote about a specific item.  We could use this to help promote items they might want later!  Finally, the items in this library will be presented to users within a web-store called "The Wizards Bag."  Yup, this will be yet another online store.  Fun!!

### 1300 | Spell list
I found that some awesome people have already created a spell list in csv, json, or text.  Here are the websites I'll probably use to help load my database:
- [tadzik GitHub](https://github.com/tadzik/5e-spells/blob/master/spells.json)
- [vopalhex GitHub *Best*](https://github.com/vorpalhex/srd_spells/blob/master/spells.json)

Also, Here are some sites for items:
- [prices can be found here](https://dungeonmastertools.github.io/items.html)

Here are some with everything:
- [BTMorton](https://github.com/BTMorton/dnd-5e-srd/blob/master/json/04%20equipment.json)
