# Log

## 2023-12-02 | Clearing Things Up

I find that I'm doing a lot of reorganizing to some of the code as I figure out how I want variables structured to explain their function.  I'm also finding that the structure of DnD's game is only a illusion.  It really is a chaotic mess with some theoretical structures in place.  Did you know that Tags in spells and Items are different?  Conditions are the same but not tags?  That might make sense but they both have overlapping tags.  I'm thinking about keeping the tags in the same table within the DB while structuring their Enums to use when creating new spells.  That way I can ensure the same inputs are being placed into the DB, but then I only have to deal with one tag table.  Of course that causes a problem (and one I've already figured out as I write this... that's why it's important to do these logs!).  If I have two different enums (spellTags and itemTags) for my input forms, I will inevitably need to update the enum later when things change.  That means adding it to the DB tag table, then finding the correct enum and adding it to that!  I don't think I want to do that!  So, what did I figure out?  Too simple. Add another attribute in the tag class marking the tag as a spell, item or both tag!  OMG, too simple.  Then, make the change in the sql table to represent what each tag should be used for.  More work up front, but now I can sort tags by type.  When I need to update the table (and thus keep the edit and creation forms up-to-date by only providing a selection from that table) everything should stay organized.  

So what are enums good for?  I really don't know.  I thought it would keep me from needing to pull data from a DB, which might be yet another query slowing my web application down.   I think I would like to try asking someone who is smarter than me on that question.

### 1800 | Enum Answer

So I asked ChatGPT on that question from above.  I logged the answer in the AI notes.  It's interesting if you want to see the results.

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
