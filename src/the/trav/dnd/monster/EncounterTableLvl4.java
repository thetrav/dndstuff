package the.trav.dnd.monster;

public class EncounterTableLvl4 extends AbstractEncounterTable
{
    public EncounterTableLvl4()
    {
        add(enc(Monsters.APE_CARNIVOROUS,       1, 3, 0), 1, 8);
        add(enc(Monsters.BLINK_DOG,             1, 4, 1), 9, 14);
        add(enc(Monsters.CHARACTER,             1, 1, 0), 15, 22);
        add(enc(Monsters.DRAGON,                1, 1, 0), 23, 23);
        add(enc(Monsters.GARGOYLE,              1, 2, 0), 25, 30);
        add(enc(Monsters.GHAST,                 1, 4, 0), 31, 36);
        add(enc(Monsters.GRAY_OOZE,             1, 1, 0), 37, 40);
        add(enc(Monsters.HELL_HOUND,            1, 2, 0), 41, 44);
        add(enc(Monsters.HYDRA,                 1, 1, 0), 45, 47);
        add(enc(Monsters.HYDRA_PYRO,            1, 1, 0), 48, 48);
        add(enc(Monsters.LYCANTHROPE_WEREWOLF,  1, 2, 0), 49, 62);
        add(enc(Monsters.MOLD_YELLOW,           1, 1, 0), 63, 75);
        add(enc(Monsters.OWLBEAR,               1, 2, 0), 76, 78);
        add(enc(Monsters.RUST_MONSTER,          1, 1, 0), 79, 79);
        add(enc(Monsters.SHADOW,                1, 3, 0), 80, 82);
        add(enc(Monsters.SNAKE_GIANT_CONSTRICTOR, 1, 1, 0), 83, 90);
        add(enc(Monsters.SU_MONSTER,            1, 2, 0), 91, 94);
        add(enc(Monsters.TOAD_ICE,              1, 1, 0), 95, 96);
        add(enc(Monsters.TOAD_POISONOUS,        1, 3, 0), 97, 100);
    }

}
