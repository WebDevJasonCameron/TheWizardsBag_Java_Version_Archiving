# Notes from AI

## 2024 01 02 | Better LIsts
Me: 
> I have a list of items from a CSV.  Each row has three column names: class_id, class_name, and subclass_name.   I need to produce a list that keeps the class_id number and class_name if nothing is found in the third subclass_name column.  If there is text in all three columns, I need to keep the first column, class_id, and the third column, subclass_name.  This is how it should look:

> "class_name": class_id,
> "subclass_name": class_id
> 
> Here is my list:
> 
> 1,rouge,""
> 2,rouge,thief
> 3,rouge,assassin
> 4,rouge,arcane trickster
> 5,rouge,inquisitive
> 6,rouge,mastermind
> 7,rouge,scout
> 8,rouge,swashbuckler
> 9,rouge,phantom
> 10,rouge,soulknife
> 11,fighter,""
> 12,fighter,champion
> 13,fighter,battle master
> 14,fighter,eldritch knight
> 15,fighter,arcane archer
> 16,fighter,cavalier
> 17,fighter,samurai
> 18,fighter,psi warrior
> 19,fighter,rune knight
> 20,fighter,echo fighter
> 21,fighter,purple dragon knight
> 22,cleric,""
> 23,cleric,knowledge domain
> 24,cleric,life domain
> 25,cleric,light domain
> 26,cleric,nature domain
> 27,cleric,tempest domain
> 28,cleric,trickery domain
> 29,cleric,war domain
> 30,cleric,death domain
> 31,cleric,twilight domain
> 32,cleric,order domain
> 33,cleric,forge domain
> 34,cleric,grave domain
> 35,cleric,peace domain
> 36,cleric,arcane domain
> 37,ranger,""
> 38,ranger,fey wanderer
> 39,ranger,swarmkeeper
> 40,ranger,gloom stalker
> 41,ranger,horizon walker
> 42,ranger,monster slayer
> 43,ranger,hunter
> 44,ranger,beast master
> 45,ranger,drakewarden
> 46,druid,""
> 47,druid,circle of the land
> 48,druid,circle of the moon
> 49,druid,circle of dreams
> 50,druid,circle of the shepherd
> 51,druid,circle of spores
> 52,druid,circle of stars
> 53,druid,circle of wildfire
> 54,warlock,""
> 55,warlock,the archfey
> 56,warlock,the fiend
> 57,warlock,the great old one
> 58,warlock,the celestial
> 59,warlock,undying
> 60,warlock,the hexblade
> 61,warlock,the fathomless
> 62,warlock,the genie
> 63,warlock,the undead
> 64,paladin,""
> 65,paladin,oath of devotion
> 66,paladin,oath of the ancients
> 67,paladin,oath of vengeance
> 68,paladin,oathbreaker
> 69,paladin,oath of conquest
> 70,paladin,oath of redemption
> 71,paladin,oath of glory
> 72,paladin,oath of the watchers
> 73,paladin,oath of the crown
> 74,monk,""
> 75,monk,way of the open hand
> 76,monk,way of the shadow
> 77,monk,way of the four elements
> 78,monk,way of mercy
> 79,monk,way of the astral self
> 80,monk,way of the drunken master
> 81,monk,way of the kensei
> 82,monk,way of the sun soul
> 83,monk,way of long death
> 84,monk,way of the ascendant dragon
> 85,wizard,""
> 86,wizard,school of abjuration
> 87,wizard,school of conjuration
> 88,wizard,school of divination
> 89,wizard,school of enchantment
> 90,wizard,school of evocation
> 91,wizard,school of illusion
> 92,wizard,school of necromancy
> 93,wizard,school of transmutation
> 94,wizard,school of graviturgy
> 95,wizard,school of chronurgy
> 96,wizard,war magic
> 97,wizard,bladesinging
> 98,wizard,order of scribes
> 99,barbarian,""
> 100,barbarian,berserker
> 101,barbarian,totem warrior
> 102,barbarian,ancestral guardian
> 103,barbarian,storm herald
> 104,barbarian,zealot
> 105,barbarian,beast
> 106,barbarian,wild soul
> 107,barbarian,battlerager
> 108,artificer,""
> 109,artificer,armorer
> 110,artificer,alchemist
> 111,artificer,artillerist
> 112,artificer,battle smith
> 113,bard,""
> 114,bard,college of lore
> 115,bard,college of valor
> 116,bard,college of creation
> 117,bard,college of glamor
> 118,bard,college of swords
> 119,bard,college of whispers
> 120,bard,college of eloquence
> 121,bard,college of spirits
> 122,sorcerer,""
> 123,sorcerer,aberrant mind
> 124,sorcerer,clockwork soul
> 125,sorcerer,divine soul
> 126,sorcerer,shadow magic
> 127,sorcerer,storm sorcery
> 128,sorcerer,draconic bloodline
> 129,sorcerer,wild magic
> 130,blood hunter,""
> 131,blood hunter,Order of the Ghostslayer
> 132,blood hunter,Order of the Lycan
> 133,blood hunter,Order of the Mutant
> 134,blood hunter,Order of the Profane Soul

GPT:
> Based on your requirements, you want to create a new list that keeps the class_id and class_name if subclass_name is empty. Otherwise, you want to keep the class_id and subclass_name. Here's a Python script that does this:
> 
 ```
 import csv
 
 # Your list of items
 data = """1,rouge,""
 2,rouge,thief
 3,rouge,assassin
 4,rouge,arcane trickster
 5,rouge,inquisitive
 6,rouge,mastermind
 7,rouge,scout
 8,rouge,swashbuckler
 9,rouge,phantom
 10,rouge,soulknife
 11,fighter,""
 12,fighter,champion
 13,fighter,battle master
 14,fighter,eldritch knight
 15,fighter,arcane archer
 16,fighter,cavalier
 17,fighter,samurai
 18,fighter,psi warrior
 19,fighter,rune knight
 20,fighter,echo fighter
 21,fighter,purple dragon knight
 22,cleric,""
 23,cleric,knowledge domain
 24,cleric,life domain
 25,cleric,light domain
 26,cleric,nature domain
 27,cleric,tempest domain
 28,cleric,trickery domain
 29,cleric,war domain
 30,cleric,death domain
 31,cleric,twilight domain
 32,cleric,order domain
 33,cleric,forge domain
 34,cleric,grave domain
 35,cleric,peace domain
 36,cleric,arcane domain
 37,ranger,""
 38,ranger,fey wanderer
 39,ranger,swarmkeeper
 40,ranger,gloom stalker
 41,ranger,horizon walker
 42,ranger,monster slayer
 43,ranger,hunter
 44,ranger,beast master
 45,ranger,drakewarden
 46,druid,""
 47,druid,circle of the land
 48,druid,circle of the moon
 49,druid,circle of dreams
 50,druid,circle of the shepherd
 51,druid,circle of spores
 52,druid,circle of stars
 53,druid,circle of wildfire
 54,warlock,""
 55,warlock,the archfey
 56,warlock,the fiend
 57,warlock,the great old one
 58,warlock,the celestial
 59,warlock,undying
 60,warlock,the hexblade
 61,warlock,the fathomless
 62,warlock,the genie
 63,warlock,the undead
 64,paladin,""
 65,paladin,oath of devotion
 66,paladin,oath of the ancients
 67,paladin,oath of vengeance
 68,paladin,oathbreaker
 69,paladin,oath of conquest
 70,paladin,oath of redemption
 71,paladin,oath of glory
 72,paladin,oath of the watchers
 73,paladin,oath of the crown
 74,monk,""
 75,monk,way of the open hand
 76,monk,way of the shadow
 77,monk,way of the four elements
 78,monk,way of mercy
 79,monk,way of the astral self
 80,monk,way of the drunken master
 81,monk,way of the kensei
 82,monk,way of the sun soul
 83,monk,way of long death
 84,monk,way of the ascendant dragon
 85,wizard,""
 86,wizard,school of abjuration
 87,wizard,school of conjuration
 88,wizard,school of divination
 89,wizard,school of enchantment
 90,wizard,school of evocation
 91,wizard,school of illusion
 92,wizard,school of necromancy
 93,wizard,school of transmutation
 94,wizard,school of graviturgy
 95,wizard,school of chronurgy
 96,wizard,war magic
 97,wizard,bladesinging
 98,wizard,order of scribes
 99,barbarian,""
 100,barbarian,berserker
 101,barbarian,totem warrior
 102,barbarian,ancestral guardian
 103,barbarian,storm herald
 104,barbarian,zealot
 105,barbarian,beast
 106,barbarian,wild soul
 107,barbarian,battlerager
 108,artificer,""
 109,artificer,armorer
 110,artificer,alchemist
 111,artificer,artillerist
 112,artificer,battle smith
 113,bard,""
 114,bard,college of lore
 115,bard,college of valor
 116,bard,college of creation
 117,bard,college of glamor
 118,bard,college of swords
 119,bard,college of whispers
 120,bard,college of eloquence
 121,bard,college of spirits
 122,sorcerer,""
 123,sorcerer,aberrant mind
 124,sorcerer,clockwork soul
 125,sorcerer,divine soul
 126,sorcerer,shadow magic
 127,sorcerer,storm sorcery
 128,sorcerer,draconic bloodline
 129,sorcerer,wild magic
 130,blood hunter,""
 131,blood hunter,Order of the Ghostslayer
 132,blood hunter,Order of the Lycan
 133,blood hunter,Order of the Mutant
 134,blood hunter,Order of the Profane Soul
 """
 ```
> 
> # Split the input data into rows
> rows = [row.split(',') for row in data.strip().split('\n')]
> 
> # Process the data and create the new list
> result_list = []
> for row in rows:
>     class_id = row[0]
>     class_name = row[1]
>     subclass_name = row[2].strip()
> 
>     if subclass_name == "":
>         result_list.append(f'"{class_name}": {class_id}')
>     else:
>         result_list.append(f'"{subclass_name}": {class_id}')
> 
> # Print the result
> for item in result_list:
>     print(item)
> ```
> 
> This script parses the input data, processes each row according to your rules, and prints the desired output. Copy and paste this script into a Python environment to execute it.

ME:
> Thanks but I didn't need a script to parse the list.  I was hoping you could give me the final product.  Is that possible?

GPT:
> "rouge": 1
"thief": 2
"assassin": 3
"arcane trickster": 4
"inquisitive": 5
"mastermind": 6
"scout": 7
"swashbuckler": 8
"phantom": 9
"soulknife": 10
"fighter": 11
"champion": 12
"battle master": 13
"eldritch knight": 14
"arcane archer": 15
"cavalier": 16
"samurai": 17
"psi warrior": 18
"rune knight": 19
"echo fighter": 20
"purple dragon knight": 21
"cleric": 22
"knowledge domain": 23
"life domain": 24
"light domain": 25
"nature domain": 26
"tempest domain": 27
"trickery domain": 28
"war domain": 29
"death domain": 30
"twilight domain": 31
"order domain": 32
"forge domain": 33
"grave domain": 34
"peace domain": 35
"arcane domain": 36
"ranger": 37
"fey wanderer": 38
"swarmkeeper": 39
"gloom stalker": 40
"horizon walker": 41
"monster slayer": 42
"hunter": 43
"beast master": 44
"drakewarden": 45
"druid": 46
"circle of the land": 47
"circle of the moon": 48
"circle of dreams": 49
"circle of the shepherd": 50
"circle of spores": 51
"circle of stars": 52
"circle of wildfire": 53
"warlock": 54
"the archfey": 55
"the fiend": 56
"the great old one": 57
"the celestial": 58
"undying": 59
"the hexblade": 60
"the fathomless": 61
"the genie": 62
"the undead": 63
"paladin": 64
"oath of devotion": 65
"oath of the ancients": 66
"oath of vengeance": 67
"oathbreaker": 68
"oath of conquest": 69
"oath of redemption": 70
"oath of glory": 71
"oath of the watchers": 72
"oath of the crown": 73
"monk": 74
"way of the open hand": 75
"way of the shadow": 76
"way of the four elements": 77
"way of mercy": 78
"way of the astral self": 79
"way of the drunken master": 80
"way of the kensei": 81
"way of the sun soul": 82
"way of long death": 83
"way of the ascendant dragon": 84
"wizard": 85
"school of abjuration": 86
"school of conjuration": 87
"school of divination": 88
"school of enchantment": 89
"school of evocation": 90
"school of illusion": 91
"school of necromancy": 92
"school of transmutation": 93
"school of graviturgy": 94
"school of chronurgy": 95
"war magic": 96
"bladesinging": 97
"order of scribes": 98
"barbarian": 99
"berserker": 100
"totem warrior": 101
"ancestral guardian": 102
"storm herald": 103
"zealot": 104
"beast": 105
"wild soul": 106
"battlerager": 107
"artificer": 108
"armorer": 109
"alchemist": 110
"artillerist": 111
"battle smith": 112
"bard": 113
"college of lore": 114
"college of valor": 115
"college of creation": 116
"college of glamor": 117
"college of swords": 118
"college of whispers": 119
"college of eloquence": 120
"college of spirits": 121
"sorcerer": 122
"aberrant mind": 123
"clockwork soul": 124
"divine soul": 125
"shadow magic": 126
"storm sorcery": 127
"draconic bloodline": 128
"wild magic": 129
"blood hunter": 130
"Order of the Ghostslayer": 131
"Order of the Lycan": 132
"Order of the Mutant": 133
"Order of the Profane Soul": 134


## 2024 01 01 | Easier than If
Me:
> User
> I have a list of words with corresponding numbers.  If I input a word and it matches one of the words in the list, the corresponding number needs to be returned.  I'm doing this in python.  Can you help me write if statement to do this?  I also need all the words in the list to have lowercase letters.  Here is my list and their related numbers:
> 
>     5	"Banishment"
>     8	"Buff"
>     9	"Charmed"
>     10	"Combat"
>     11	"Communication"
>     12	"Compulsion"
>     15	"Control"
>     16	"Creation"
>     18	"Damage"
>     19	"Debuf"
>     20	"Deception"
>     21	"Detection"
>     23	"Dunamancy"
>     26	"Environment"
>     28	"Exploration"
>     33	"Foreknowledge"
>     34	"Foresight"
>     36	"Healing"
>     44	"Movement"
>     47	"Negation"
>     52	"Sangromancy"
>     55	"Scrying"
>     57	"Shapechanging"
>     58	"Social"
>     59	"Special"
>     61	"Summoning"
>     66	"Teleportation"

Gpt:
> Certainly! You can use an `if` statement or a dictionary to achieve this in Python. Here's an example using an `if` statement:
 
 ```
 def get_number_for_word(word):
     # Convert the input word to lowercase
     lowercased_word = word.lower()
 
     # List of words and their corresponding numbers
     word_number_mapping = {
         "banishment": 5,
         "buff": 8,
         "charmed": 9,
         "combat": 10,
         "communication": 11,
         "compulsion": 12,
         "control": 15,
         "creation": 16,
         "damage": 18,
         "debuf": 19,
         "deception": 20,
         "detection": 21,
         "dunamancy": 23,
         "environment": 26,
         "exploration": 28,
         "foreknowledge": 33,
         "foresight": 34,
         "healing": 36,
         "movement": 44,
         "negation": 47,
         "sangromancy": 52,
         "scrying": 55,
         "shapechanging": 57,
         "social": 58,
         "special": 59,
         "summoning": 61,
         "teleportation": 66,
     }
 
     # Check if the lowercased_word is in the dictionary
     if lowercased_word in word_number_mapping:
         return word_number_mapping[lowercased_word]
     else:
         return None  # Return None if the word is not in the list
> ```
 # Example usage:
 input_word = input("Enter a word: ")
 result = get_number_for_word(input_word)
 if result is not None:
     print(f"The corresponding number for '{input_word}' is {result}.")
 else:
     print(f"'{input_word}' is not in the list.")
 > ```
> 
> This function, `get_number_for_word`, takes an input word, converts it to lowercase, and checks if it's in the dictionary. If it is, it returns the corresponding number; otherwise, it returns `None`.