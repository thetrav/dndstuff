package the.trav.dnd.monster;


public class EncounterTableLvl2 extends AbstractEncounterTable
{
    public EncounterTableLvl2()
    {
        add(enc(Monsters.BADGER_GIANT,    1, 4, 0),  1, 1);
        add(enc(Monsters.CENTIPEDE_GIANT, 2, 6, 1),  2, 16);
        add(enc(Monsters.CHARACTER,       1, 1, 0), 17, 27);
        add(enc(Monsters.DEVIL_LEMURE,    1, 4, 1), 28, 29);
        add(enc(Monsters.GAS_SPORE,       1, 2, 0), 30, 31);
        add(enc(Monsters.GNOLL,           3, 3, 1), 32, 38);
        add(enc(Monsters.PIERCER,         1, 4, 0), 39, 46);
        add(enc(Monsters.RAT_GIANT,       6, 4, 0), 47, 58);
        add(enc(Monsters.ROT_GRUB,        6, 4, 0), 59, 60);
        add(enc(Monsters.SHRIEKER,        1, 3, 0), 61, 72);
        add(enc(Monsters.STIRGE,          5, 3, 0), 73, 77);
        add(enc(Monsters.TOAD_GIANT,      1, 4, 0), 78, 87);
        add(enc(Monsters.TROGLODYTE,      2, 4, 0), 88, 100);
        
    }
}
