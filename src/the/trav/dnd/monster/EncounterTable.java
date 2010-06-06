package the.trav.dnd.monster;

import java.util.ArrayList;
import java.util.List;

import the.trav.dnd.dice.DiceRoller;
import the.trav.dnd.table.DiceTable;

public class EncounterTable
{
    final List<DiceTable<DiceTable<EncounterFactory>>> encounters = new ArrayList<DiceTable<DiceTable<EncounterFactory>>>();

    public EncounterTable()
    {
        final List<DiceTable<EncounterFactory>> encounterTables = createEncounterTables();
        encounters.add(createDungeonLevel1(encounterTables));
        encounters.add(createDungeonLevel2(encounterTables));
        // lvl 3 is the same as lvl 2
        encounters.add(createDungeonLevel2(encounterTables));
    }

    private DiceTable<DiceTable<EncounterFactory>> createDungeonLevel1(final List<DiceTable<EncounterFactory>> encounterTables)
    {
        final DungeonLevelEncounterTable table = new DungeonLevelEncounterTable();
        table.add(encounterTables.get(0), 1, 16);
        table.add(encounterTables.get(1), 17, 19);
        table.add(encounterTables.get(2), 20, 20);
        return table;
    }

    private DiceTable<DiceTable<EncounterFactory>> createDungeonLevel2(final List<DiceTable<EncounterFactory>> encounterTables)
    {
        final DungeonLevelEncounterTable table = new DungeonLevelEncounterTable();
        table.add(encounterTables.get(0), 1, 12);
        table.add(encounterTables.get(1), 13, 16);
        table.add(encounterTables.get(2), 17, 18);
        table.add(encounterTables.get(3), 19, 19);
        table.add(encounterTables.get(4), 20, 20);
        return table;
    }

    private List<DiceTable<EncounterFactory>> createEncounterTables()
    {
        final List<DiceTable<EncounterFactory>> encounterTables = new ArrayList<DiceTable<EncounterFactory>>(10);
        encounterTables.add(new EncounterTableLvl1());
        encounterTables.add(new EncounterTableLvl2());
        encounterTables.add(new EncounterTableLvl3());
        encounterTables.add(new EncounterTableLvl4());
        encounterTables.add(new EncounterTableLvl5());
        return encounterTables;
    }

    public List<Monster> generate(final DiceRoller dice, final int dungeonLevel)
    {
        final DiceTable<DiceTable<EncounterFactory>> dungeonLevelTable = encounters.get(dungeonLevel - 1);
        final DiceTable<EncounterFactory> monsterLevelTable = dungeonLevelTable.result(dice);
        final EncounterFactory encounter = monsterLevelTable.result(dice);
        return encounter.build(dice);
    }

    private class DungeonLevelEncounterTable extends DiceTable<DiceTable<EncounterFactory>>
    {
        @Override
        public void add(final DiceTable<EncounterFactory> encounter, final int low, final int high)
        {
            super.add(encounter, low, high);
        }

        @Override
        protected int getDiceType()
        {
            return 20;
        }
    }
}
