package the.trav.dnd.table;

import java.util.HashMap;
import java.util.Map;

public class DiceTable<T>
{
    protected final Map<Integer, T> table = new HashMap<Integer, T>();

    protected void add(final T encounter, final int low, final int high)
    {
        for (int i = low; i <= high; i++)
        {
            table.put(i, encounter);
        }
    }

    public T result(final int roll)
    {
        if (!table.containsKey(roll))
        {
            throw new NullPointerException("no key for result:" + roll + " in table:" + table);
        }
        return table.get(roll);
    }
}
