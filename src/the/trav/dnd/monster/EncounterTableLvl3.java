package the.trav.dnd.monster;


public class EncounterTableLvl3 extends AbstractEncounterTable
{
    public EncounterTableLvl3()
    {
        add(enc(Monsters.BEETLE_BORING,       1, 3, 0),  1, 10);
        add(enc(Monsters.BUGBEAR,             2, 6, 1), 11, 20);
        add(enc(Monsters.CHARACTER,           1, 1, 0), 21, 30);
        add(enc(Monsters.DRAGON,              1, 1, 0), 31, 32);
        add(enc(Monsters.FUNGI_VIOLET,        1, 3, 0), 33, 34);
        add(enc(Monsters.GELATINOUS_CUBE,     1, 1, 0), 35, 40);
        add(enc(Monsters.GHOUL,               1, 4, 0), 41, 45);
        add(enc(Monsters.LIZARD_GIANT,        6, 4, 0), 46, 50);
        add(enc(Monsters.LYCANTHROPE_WERERAT, 1, 3, 0), 51, 54);
        add(enc(Monsters.OCHRE_JELLY,         5, 3, 0), 55, 60);
        add(enc(Monsters.OGRE,                1, 4, 0), 61, 72);
        add(enc(Monsters.PIERCER,             2, 4, 0), 73, 74);
        add(enc(Monsters.ROT_GRUB,            2, 4, 0), 75, 75);
        add(enc(Monsters.SHRIEKER,            2, 4, 0), 76, 77);
        add(enc(Monsters.SPIDER_HUGE,         2, 4, 0), 78, 84);
        add(enc(Monsters.SPIDER_LARGE,        2, 4, 0), 85, 93);
        add(enc(Monsters.TICK_GIANT,          2, 4, 0), 94, 95);
        add(enc(Monsters.WEASEL_GIANT,        2, 4, 0), 96, 100);
    }

}
