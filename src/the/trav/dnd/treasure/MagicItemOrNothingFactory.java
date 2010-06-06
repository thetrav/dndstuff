package the.trav.dnd.treasure;

import the.trav.dnd.dice.DiceRoller;

public class MagicItemOrNothingFactory implements TreasureFactory
{
    public Treasure build(DiceRoller dice)
    {
        Treasure treasure = new Treasure();
        if(dice.roll(8) > 5)
        {
            treasure.type = Treasure.Type.MAGIC;
            treasure.qty = 1;
        }
        return treasure;
    }
}
