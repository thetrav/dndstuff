package the.trav.dnd.monster;


public class EncounterTableLvl1 extends AbstractEncounterTable
{
    public EncounterTableLvl1()
    {
        add(enc(Monsters.DEVIL_ASAGGIM,     1,10, 0),  1, 2);
        add(enc(Monsters.HALFLING,          3, 6, 0), 3, 4);
        add(enc(Monsters.NPC_PARTY,         1, 1, 0), 5, 7);
        add(enc(Monsters.DEMON_SOUL_WORM,   1, 1, 0), 8, 11);
        add(enc(Monsters.RAT_GIANT,         5,10, 0), 12, 15);
        add(enc(Monsters.VULCHLING,         1, 4, 0), 16, 20);
        add(enc(Monsters.BAT,               5,10, 0), 21, 25);
        add(enc(Monsters.GOBLIN,            2,10, 0), 26, 30);
        add(enc(Monsters.MEN_BANDIT,        2, 4, 0), 31, 40);
        add(enc(Monsters.ORC,               3,10, 0), 41, 50);
        add(enc(Monsters.FROG_GIANT,        1, 8, 0), 51, 60);
        add(enc(Monsters.BEETLE_GIANT_FIRE, 1, 4, 0), 61, 70);
        add(enc(Monsters.KOBOLD,            4,10, 0), 71, 75);
        add(enc(Monsters.DOG_WILD,          1, 4, 0), 76, 80);
        add(enc(Monsters.BAT_GIANT,         1, 6, 0), 81, 85);
        add(enc(Monsters.SKELETON,          1,10, 0), 86, 89);
        add(enc(Monsters.ROT_GRUB,          5, 4, 0), 90, 93);
        add(enc(Monsters.VILSTRAK,          1, 6, 0), 94, 96);
        add(enc(Monsters.GNOME,             4, 6, 0), 97, 98);
        add(enc(Monsters.MEN_BESERKER,      1, 6, 0), 99, 100);
    }

}
