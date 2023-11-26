# Log

## 2022-11-25 | Planning Mass DB Input
Since I found a lot of great list content that can be used to load my DB, I'm figuring out how to get it ingested.  First, I need to take in a JSON file.  The result will be JSON array.  From there, I need to script out a parser that coverts that array into an array of Spell and Item objects (not both at once mind you).  Once I have my array of hundreds of spells and items, I'll need to run them through a creat spell/item sql record.  The interesting thing here is, as I create a spell or item, I'll need to grab its id.  I also need to grab the ids from the matching tag, effect, condition and effect tables.  Finally, I can loop through the many different tags, effects, conditions, and effects each spell and item has and create the multiple records within their respective junction table using the spell/item id and the matching ids from those tag, type, condition, and effect tables.  That's a lot of small actions to create all these items!  I might want to start with coding out a process to create a single item from the CLI.  The work I do on this smaller task could be replicated towards a larger scale record ingestion!  I'll first work on creating a spell. Then I can build out the mas spell-book ingestion.  With that as a proof-of-concept, I should be able to repurpose most of the template into creating my items.  Although, I haven't really found an in-depth JSON file for items.  I might need to create those by hand. If that's the case, I might end up working on a GUI... We'll see.  

### 1000 | Dir and Pack Org
While java programs are usually set up as com.HighLevelPackageType.nameOfSite.LowerLevelPackageTypes where the higher level package reflects a "frontEnd" or "backEnd," I've decided to include a "cli" higher level package.  This "cli" is where I'll probably build out the java construction code needed for program scaffolding.  I should be able to use it to with the other higher level package labelled "gui."  I debated on this format because I think it could be argued that cli and gui are still backend type stuff.  Then I thought that the distinction between cli and gui are more localized whereas the backend serves to be the junction between frontend, backend, and cli.  In essence, gui is the only package that seems to be a subset of one of the lower level packages (cli).  

---

## 2022-11-24 | About the Start
I started this project a week ago.  I started with a db design.  That has changed as I construct the sql and java classes.  I'm trying to think things out without going too deep. I may want the scope to grow later. However, nothing is going to get done if the scope is too large.  As such, I am focusing on building out a library of D&D items that can be searched through with specific attributes.  I'll include a list of spells that are most likely attached to the magical items.  Later we will use users to log in and write notes on specific items.  Much later, I'd like to remember what the user searched for, what they liked or disliked and how much the wrote about a specific item.  We could use this to help promote items they might want later!  Finally, the items in this library will be presented to users within a web-store called "The Wizards Bag."  Yup, this will be yet another online store.  Fun!!

### 1300 | Spell list
I found that some awesome people have already created a spell list in csv, json, or text.  Here are the websites I'll probably use to help load my database:
- [tadzik GitHub](https://github.com/tadzik/5e-spells/blob/master/spells.json)
- [vopalhex GitHub *Best*](https://github.com/vorpalhex/srd_spells/blob/master/spells.json)

Also, Here are some sites for items:
- [prices can be found here](https://dungeonmastertools.github.io/items.html)

Here are some with everything:
- [BTMorton](https://github.com/BTMorton/dnd-5e-srd/blob/master/json/04%20equipment.json)
