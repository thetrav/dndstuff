package the.trav.dnd;

import the.trav.dnd.dice.DiceRoller;

public interface DiceBuilder<T>
{
    T build(DiceRoller dice);
}
