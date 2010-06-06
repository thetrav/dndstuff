package the.trav.dnd.treasure;

import the.trav.dnd.dice.DiceRoller;

public interface TreasureFactory
{
    Treasure build(DiceRoller dice);
}
