package the.trav.dnd.monster;

import the.trav.dnd.table.DiceTable;

public class AbstractEncounterTable extends DiceTable<EncounterFactory>
{
    protected EncounterFactory enc(String type, int dice, int diceType, int diceMod)
    {
        return new EncounterFactory(type, dice, diceType, diceMod);
    }

    @Override
    protected int getDiceType()
    {
        return 100;
    }
}
