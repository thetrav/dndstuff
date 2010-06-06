package the.trav.dnd.treasure;

import the.trav.dnd.dice.DiceRoller;

public class GemOrJewelFactory implements TreasureFactory
{
    public Treasure build(DiceRoller dice)
    {
        Treasure treasure = new Treasure();
        if(dice.roll(8) < 6)
        {
            treasure.qty = dice.roll(3);
            treasure.type = Treasure.Type.GEM;
        }
        else
        {
            treasure.qty = 1;
            treasure.type = Treasure.Type.JEWEL;
        }
        return treasure;
    }
}
