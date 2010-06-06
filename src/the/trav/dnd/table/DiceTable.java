package the.trav.dnd.table;

import java.util.HashMap;
import java.util.Map;

import the.trav.dnd.DiceBuilder;
import the.trav.dnd.dice.DiceRoller;

public abstract class DiceTable<T> implements DiceBuilder<T>
{
    protected final Map<Integer, T> table = new HashMap<Integer, T>();
    
    protected void add(final T encounter, final int roll)
    {
        add(encounter, roll, roll);
    }
    
    protected void add(final T encounter, final int low, final int high)
    {
        for (int i = low; i <= high; i++)
        {
            table.put(i, encounter);
        }
    }
    
    public T build(final DiceRoller dice)
    {
        return result(dice);
    }

    public T result(final DiceRoller dice)
    {
        int roll = dice.roll(getDiceType());
        if (!table.containsKey(roll ))
        {
            throw new NullPointerException("no key for result:" + roll + " in table:" + table);
        }
        return table.get(roll);
    }

    protected abstract int getDiceType();
}
