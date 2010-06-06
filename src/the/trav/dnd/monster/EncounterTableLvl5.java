package the.trav.dnd.monster;

public class EncounterTableLvl5 extends AbstractEncounterTable
{
    public EncounterTableLvl5()
    {
        add(enc(Monsters.CHARACTER,                 1, 1, 0), 1, 8);
        add(enc(Monsters.COCKATRICE,                1, 2, 0), 9, 15);
        add(enc(Monsters.DISPLACER_BEAST,           1, 2, 0), 16, 18);
        add(enc(Monsters.DOPPLEGANGER,              1, 3, 0), 19, 22);
        add(enc(Monsters.DRAGON,                    1, 1, 0), 23, 24);
        add(enc(Monsters.HYDRA,                     1, 1, 0), 25, 26);
        add(enc(Monsters.HYDRA_PYRO,                1, 1, 0), 27, 27);
        add(enc(Monsters.IMP,                       1, 2, 0), 28, 28);
        add(enc(Monsters.LEUCROTTA,                 1, 2, 0), 29, 31);
        add(enc(Monsters.LIZARD_SUBTERRANEAN,       1, 3, 0), 32, 50);
        add(enc(Monsters.LYCANTHROPE_WEREBOAR,      1, 3, 0), 51, 52);
        add(enc(Monsters.MINOTAUR,                  1, 3, 0), 53, 60);
        add(enc(Monsters.MOULD_YELLOW,              1, 3, 0), 61, 64);
        add(enc(Monsters.QUASIT,                     1, 1, 0), 65, 65);
        add(enc(Monsters.RUST_MONSTER,              1, 1, 0), 66, 67);
        add(enc(Monsters.SHRIEKER,                  1, 4, 1), 68, 70);
        add(enc(Monsters.SLITHERING_TRACKER,        1, 1, 0), 71, 72);
        add(enc(Monsters.SNAKE_GIANT_AMPHISBAENA,   1, 1, 0), 73, 74);
        add(enc(Monsters.SNAKE_GIANT_POISONOUS,     1, 1, 0), 75, 82);
        add(enc(Monsters.SNAKE_GIANT_SPITTING,      1, 1, 0), 83, 86);
        add(enc(Monsters.SPIDER_GIANT,              1, 2, 0), 87, 100);
    }
}
