CREATE SEQUENCE class_seq start with 1;

CREATE TABLE rpg_classes (
                       class_id bigint NOT NULL DEFAULT nextval('class_seq'),
                       class_name varchar(255) NOT NULL ,
                       class_subclass_name varchar(255),
                       class_description TEXT,

                       PRIMARY KEY (class_id)
);

ALTER SEQUENCE class_seq OWNED BY rpg_classes.class_id;

ALTER SEQUENCE class_seq RESTART WITH 1;

INSERT INTO rpg_classes (class_name, class_subclass_name, class_description)
VALUES
    ('rouge','', 'rogues are talented individuals who hone skills of the unethical or criminal. a rogue''s skill in thieving, killing, etc. is rivaled by none as they become experts in their field.'),

    ('rouge','thief', 'thieves are rogues who are experts at breaking into things and stealing'),
    ('rouge','assassin', 'assassins are masters at killing while unseen'),
    ('rouge','arcane trickster', 'tricksters mix magic into their skills, enhancing them'),
    ('rouge','inquisitive', 'like a detective, inquisitive rogues watch their targets and use their patterns'),
    ('rouge','mastermind', 'these rogues are deadly smart, using their intelligence to fight'),
    ('rouge','scout', 'ambushing and stealthing with speed, these rogues are always ahead'),
    ('rouge','swashbuckler', 'rogues that are fast and light on their feet, impossible to pin'),
    ('rouge','phantom', 'shadow magic is within the hearts of these rogues, stealing souls'),
    ('rouge','soulknife', 'blessed with a psychic mind, their roguish skills are enhanced'),


    ('fighter', '', 'swordsman ship, spears, shields, bows and crossbows. all these bring about images of fighters. warriors who hone their combative ability to a deadly skill that rivals none. some use magic to enhance their ability, while others crush magic in favor of pure muscle or acrobatic skills'),

    ('fighter', 'champion', 'hone your martial ability into an incredibly deadly skill with constant crits'),
    ('fighter', 'battle master', 'use the art of war and tactics to gain advantages and command to victory'),
    ('fighter', 'eldritch knight', 'learning wizard-like spells to gain the upper-hand in any fight'),
    ('fighter', 'arcane archer', 'mix magic with your arrows to rain literal fire down upon your foes'),
    ('fighter', 'cavalier', 'you will never break; your skill, while mounted or not, can not be beaten'),
    ('fighter', 'samurai', 'your fighting spirit will allow you to rain a hurricane of deadly blows'),
    ('fighter', 'psi warrior', 'blessed with psychic energy, your mind is sharpened just like your weapon'),
    ('fighter', 'rune knight', 'learn the ancient power of giants and their powerful magic runes'),
    ('fighter', 'echo fighter', 'using magical energy, create an “echo” to fight with you.'),
    ('fighter', 'purple dragon knight', 'a warrior that braves any battle through inspiration'),

    ('cleric', '', 'ideas are not just a simple blueprint for a machine or an urge to buy new farming equipment. ideas are immortal things that can topple empires and bring justice to those that threaten others. ideas are some of the most powerful forces in the universe. all it needs is a champion, and clerics are those champions. usually following a pantheon or a god/goddess, they devote their lives to serving that idea.'),

    ('cleric', 'knowledge domain', 'serve the idea that knowledge is power, and it must endure'),
    ('cleric', 'life domain', 'serve the idea of life; every life and living thing is a wonder'),
    ('cleric', 'light domain', 'serve the idea of light; it will burn back the forces of shadow'),
    ('cleric', 'nature domain', 'serve the idea of nature; the natural world can’t ever fall'),
    ('cleric', 'tempest domain', 'serve the idea of change, storms are powerful and resistant'),
    ('cleric', 'trickery domain', 'serve the idea of deception, pranks, or more keeps the world moving'),
    ('cleric', 'war domain', 'serve the idea of war, whether it’s war for honor or power'),
    ('cleric', 'death domain', 'serve the idea of death; everything must eventually end'),
    ('cleric', 'twilight domain', 'serve the idea of balance; those that attempt to disrupt it must be stopped'),
    ('cleric', 'order domain', 'serve the idea of order and law; you are the voice of justice'),
    ('cleric', 'forge domain', 'serve the idea of creation; the forges you touch will never fail'),
    ('cleric', 'grave domain', 'serve the idea of life and death; the balance must be maintained'),
    ('cleric', 'peace domain', 'serve the idea of peace; violence is almost never the answer'),
    ('cleric', 'arcane domain', 'serve the idea of magic; magic is a power and a wonder'),


    ('ranger', '', 'rangers are those that wander and live within the wild. their skill to survive in harsh nature places is bested by none. many rangers take on a role, usually in various ways to hunt special types of monsters.'),

    ('ranger', 'fey wanderer', 'with the power of fey on their side, these rangers charm their foes'),
    ('ranger', 'swarmkeeper', 'insects, pixies or a similar swarm creature. these rangers take care of them'),
    ('ranger', 'gloom stalker', 'these hunters wander in the shadows to defeat creatures of the night'),
    ('ranger', 'horizon walker', 'these hunters seek out creatures from other worlds to end them'),
    ('ranger', 'monster slayer', 'these warriors hunt down to slay powerful monsters'),
    ('ranger', 'hunter', 'a warrior who hones different parts of their fighting style to hunt'),
    ('ranger', 'beast master', 'a warrior who has gained the assistance of a spiritual beas'),
    ('ranger', 'drakewarden', 'a warrior who has gained the assistance of a powerful drake that follows them'),


    ('druid', '', 'druids are protectors of nature. they are the embodiment of it’s wrath and it’s beauty. they have the ability to shapeshift into creatures and special skills, based on which circle they follow which is a further representation of different parts of nature.'),

    ('druid', 'circle of the land', 'grown within a certain biome, your power comes from there'),
    ('druid', 'circle of the land (arctic)', 'grown within a arctic biome, your power comes from there'),
    ('druid', 'circle of the land (coast)', 'grown within a coast biome, your power comes from there'),
    ('druid', 'circle of the land (desert)', 'grown within a desert biome, your power comes from there'),
    ('druid', 'circle of the land (forest)', 'grown within a forest biome, your power comes from there'),
    ('druid', 'circle of the land (grassland)', 'grown within a grassland biome, your power comes from there'),
    ('druid', 'circle of the land (mountain)', 'grown within a mountain biome, your power comes from there'),
    ('druid', 'circle of the land (swamp)', 'grown within a swamp biome, your power comes from there'),
    ('druid', 'circle of the land (underdark)', 'grown within an underdark biome, your power comes from there'),

    ('druid', 'circle of the moon', 'like a werewolf, your power is based on changing forms'),
    ('druid', 'circle of dreams', 'the feywild’s nature has blessed you with the power to heal'),
    ('druid', 'circle of the shepherd', 'like a shepherd, you protect the animals of the world'),
    ('druid', 'circle of spores', 'mycelium has many uses and abilities, including raising the dead'),
    ('druid', 'circle of stars', 'the answer and guidance can always be found in the stars'),
    ('druid', 'circle of wildfire', 'wildfires bring about change, ecosystems always revive'),


    ('warlock', '', 'with the dark stereotype of being evil, warlocks are feared. usually, these are mortals who have signed a magical contract with immortal entities where the entity will gift them magical power for the price of servitude.'),

    ('warlock', 'the archfey', 'a magical pact with an archfey of the feywild'),
    ('warlock', 'the fiend', 'a magical pact with a demonic or devilish entity'),
    ('warlock', 'the great old one', 'an ancient and powerful unknown entity from worlds beyond'),
    ('warlock', 'the celestial', 'a magical pact with an entity of good, law and order'),
    ('warlock', 'the undying', 'a magical pact with an entity that represents the dead'),
    ('warlock', 'the hexblade', 'a magical pact with an entity that is or gifted a powerful weapon'),
    ('warlock', 'the fathomless', 'a magical pact with a creature of the deep oceans of the world'),
    ('warlock', 'the genie', 'a magical pact with a powerful elemental'),
    ('warlock', 'the undead', 'a magical pact with a powerful deathless being that defies the cycle'),


    ('paladin', '', 'paladins, much like clerics, hold up ideas. however, they serve tenants with a multitude of ideas. some of joy, others of light and conquest. paladin holds an oath which is the representation of said ideas.'),

    ('paladin', 'oath of devotion', 'light, lawful, honesty, the pure holy warrior'),
    ('paladin', 'oath of the ancients', 'joy and love, the ancients blessed this warrior with nature'),
    ('paladin', 'oath of vengeance', 'anger and vengeance, something bad pushed this warrior to seek vengeance'),
    ('paladin', 'oathbreaker', 'they broke an oath long ago and are cursed for it'),
    ('paladin', 'oath of conquest', 'destruction and victory, nothing will stop this warrior'),
    ('paladin', 'oath of redemption', 'a warrior that uses words instead of the sword'),
    ('paladin', 'oath of glory', 'a warrior that is destined for glory, fight for your destiny'),
    ('paladin', 'oath of the watchers', 'a warrior sworn to fight anything that isn’t normal'),
    ('paladin', 'oath of the crown', 'a warrior that serves a crown or kingdom'),('paladin', 'oath of the open sea', 'The Oath of the Open Sea calls to seafaring warriors, swashbuckling sailors, and traveling guardians who seek the thrill of a limitless horizon. Driven to search for adventure and mystery across and beneath every endless oceanic expanse, paladins who swear this oath stand against those who would deny liberty to likeminded travelers, rooting out tyranny and corruption wherever it is found'),


    ('monk', '', 'kung fu, karate, drunken fighting, dr. strange, ect. all of these are what the d&d monks train in. whether it’s using your fist, spirit, ki or weapons that are nothing but an extension of your will. monks can deliver a storm of powerful melee attacks.'),

    ('monk', 'way of the open hand', 'use your fists and palms to annihilate your foe'),
    ('monk', 'way of the shadow', 'usually called, ninjas and so forth. their fists strike from the shadow'),
    ('monk', 'way of the four elements', 'control all 4 elements, earth, water, fire and wind in your ways'),
    ('monk', 'way of mercy', 'your ki and spirit is meant to heal wounds, not create them'),
    ('monk', 'way of the astral self', 'your spirit becomes an entity around you to help you'),
    ('monk', 'way of the drunken master', 'confuse your foes with unpredictable attacks'),
    ('monk', 'way of the kensei', 'your weapons become an extension of yourself. a form of art '),
    ('monk', 'way of the sun soul', 'your soul and will is so powerful that it can ignite in fire'),
    ('monk', 'way of long death', 'your soul and fists become the tools of death'),
    ('monk', 'way of the ascendant dragon', 'following the way of dragons, your spirit manifests their power'),


    ('wizard', '', 'spending a lot of their life in education and schooling, wizards are considered the apex of the arcane. with their massive knowledge of magic, they know exactly how to shape magical forces to do what they desire. most of the time, wizards tend to walk down a school of magic to master in.'),

    ('wizard', 'school of abjuration', 'study the defensive powers of magic'),
    ('wizard', 'school of conjuration', 'study the ways to control the creatures you summon'),
    ('wizard', 'school of divination', 'study the ways magic can show you the future and past'),
    ('wizard', 'school of enchantment', 'study the ways that magic can bend the minds of others'),
    ('wizard', 'school of evocation', 'study the ways that magic can destroy and offense'),
    ('wizard', 'school of illusion', 'study the ways that magic can make the eyes of others lie'),
    ('wizard', 'school of necromancy', 'study the forces of life and death'),
    ('wizard', 'school of transmutation', 'study the ways magic can shift reality'),
    ('wizard', 'school of graviturgy', 'study the ways magic can shift and manipulate gravity'),
    ('wizard', 'school of chronurgy', 'study the ways magic can shift and bend time itself'),
    ('wizard', 'war magic', 'study the ways magic can be used in combat and how it can be stored'),
    ('wizard', 'bladesinging', 'study a tradition of wizardry that incorporates swordplay and dance'),
    ('wizard', 'order of scribes', 'study the ways magic can be enhanced through books of power'),


    ('barbarian', '', 'barbarians are powerful warriors whose strength comes from their rage. able to use their anger as a weapon. the subclass represents different paths they walk, which teaches them special ways to use their anger.'),

    ('barbarian', 'berserker', 'fall into your rage entirely to deliver a tide of powerful blows'),
    ('barbarian', 'totem warrior', 'your rage comes from the animal spirits of the world who aid'),
    ('barbarian', 'ancestral guardian', 'your rage is the combination of all your ancestors'),
    ('barbarian', 'storm herald', 'your rage is second only to that of mother nature, who joins you'),
    ('barbarian', 'zealot', 'the rage acts as a gift from the gods. you are their champion'),
    ('barbarian', 'beast', 'gifts from the beasts of this world as you manifest their power'),
    ('barbarian', 'wild soul', 'your rage is strong enough to shatter the walls of magic'),
    ('barbarian', 'battlerager', 'giving yourself over to your rage, make your body a weapon'),


    ('artificer', '', 'artificers are powerful magic wielders who are experts at creating and forging magic items and potions to assist their allies or bring doom to their foes.'),

    ('artificer', 'armorer', 'fuse powerful magic with your armor to create exoskeleton suits'),
    ('artificer', 'alchemist', 'a master of potion-making to heal, assist and destroy'),
    ('artificer', 'artillerist', 'control the battlefield by summoning powerful magic cannons'),
    ('artificer', 'battle smith', 'creating magical machines that fight and protect others'),


    ('bard', '', 'a poet, a singer, a storyteller. there are those that seek to bring wonder to the world, and their magic comes from their emotions from the stories they tell and the songs they sing. bards have different colleges that they follow to hone their skills in magic.'),

    ('bard', 'college of lore', 'a way to keep the stories of history and civilizations alive'),
    ('bard', 'college of valor', 'those that tell vibrant and powerful war stories'),
    ('bard', 'college of creation', 'your music and stories shape the very fabric of reality'),
    ('bard', 'college of glamor', 'blessed by the feywild, your looks are rivaled by none'),
    ('bard', 'college of swords', 'become the best and most elegant sword fighter in the world'),
    ('bard', 'college of whispers', 'the hypnotic power of bards can be used for stealth'),
    ('bard', 'college of eloquence', 'words have power; use them to shape any situation'),
    ('bard', 'college of spirits', 'the dead tell stories and have experiences that you can draw on'),


    ('sorcerer', '', 'usually born with magical energy running through their veins. sorcerers are what people usually think of when the image of a "spellslinger" comes to mind. their magical force is linked to their emotions and mind.'),

    ('sorcerer', 'aberrant mind', 'cursed or blessed with a powerful psychic mind, their magic comes from their head'),
    ('sorcerer', 'clockwork soul', 'the balance of the universe flows through their veins'),
    ('sorcerer', 'divine soul', 'with blood from something divine, gods watch them with interest'),
    ('sorcerer', 'shadow magic', 'cursed with shadow magic, their power manipulates the shadows'),
    ('sorcerer', 'storm sorcery', 'with the blood of a powerful hurricane, storms are a comfort'),
    ('sorcerer', 'draconic bloodline', 'with the ancestors of dragons, they show draconic natures'),
    ('sorcerer', 'wild magic', 'the chaos of the universe flows through their veins'),

    ('blood hunter', '', 'marred but resolute, his grimacing face dripping with sweat, a half-orc reddens a finger in the blood of his own wounds, then draws a glowing ruby glyph in the air between him and the bloody behemoth facing him. he grips the weightless sigil, twisting it to unleash streams of dark energy that curse the blood of the monster’s own veins to even the odds.'),

    ('blood hunter', 'Order of the Ghostslayer', 'The Order of the Ghostslayer is the oldest of the blood hunter orders, its members having originally rediscovered the secrets of hemocraft and refined them for combat against the scourge of undeath. Ghostslayers seek out and study the moment of death, obsessing over the mystery of the transition from life, and the unholy power that can cause the dead to rise once more. These zealous blood hunters make it their life’s work to destroy the scourge of undeath wherever it is found, tuning their abilities to engage undead creatures and those who manipulate the necromancy that creates them.'),
    ('blood hunter', 'Order of the Lycan', 'The ancient curse of lycanthropy is feared by nearly all peoples and cultures, passed through blood and seeding a host with the savage strength and hunger for violence of a wicked beast. The Order of the Lycan is a proud group of blood hunters who undergo “the Taming”—the ceremonial infliction of lycanthropy by a senior member of the order, for those who do not already carry the curse before seeking this path. These hunters then use the magic of their blood to harness the power of the monster they harbor, without losing themselves to it. Using intense will and secret blood magic rituals, members of the Order of the Lycan learn to control and unleash their hybrid forms for short periods of time. Enhanced physical prowess, unnatural resilience, and razor-sharp claws make these warriors a terrible foe to any evil that crosses their path. Yet no training is perfect, and without care and complete focus, even the greatest of blood hunters can temporarily lose themselves to their own hunger.'),
    ('blood hunter', 'Order of the Mutant', 'The process of undertaking the Hunter’s Bane ritual is a painful, scarring, and sometimes fatal experience. Those who survive are irrevocably changed—and not always for the better. Over generations of experimentation, a splinter order of blood hunters honed the way in which hemocraft alters the body, using corrupted alchemy and toxic elixirs to alter their blood even further. Over time, they have modified their capabilities in battle, becoming something beyond what they once were. Calling themselves the Order of the Mutant, these blood hunters now specialize in assessing the strengths and weaknesses of their foes, altering their biology to be best prepared for any conflict.'),
    ('blood hunter', 'Order of the Profane Soul', 'Blood hunters belonging to the Order of the Profane Soul have pushed the limits of hemocraft for use against some of the most terrifying creatures corrupting the world. Ancient fiends and cruel magic-users have long counted on their ability to meld into the background and escape those who hunt them, vanishing into noble courts without a trace, or bending the minds of the most stalwart warriors with but a glance. So the blood hunters who founded this order trusted to their resilience as they delved into the same well of corrupting arcane knowledge, making pacts with lesser evils to better combat the greater threats. And though they might have traded a part of themselves for their power, the members of this order know the benefits of that power far outweigh the price.')

;