# Log

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