package the.trav.dnd.treasure;

import the.trav.dnd.table.DiceTable;

public class TreasureHiddenTable extends DiceTable<String>
{
    @Override
    protected int getDiceType()
    {
        return 20;
    }
    
    public TreasureHiddenTable()
    {
        add("Behind a loose wall stone", 1, 2);
        add("Illusion to change appearance or hide item", 3, 4);
        add("Invisibility", 5, 7);
        add("In a nearby secret room", 8, 11);
        add("In an ordinary container in plain view", 12);
        add("Inside or under trash or dung heap", 13);
        add("Non magically disguised", 14);
        add("Secret space uner container", 15);
        add("Secret compartment in container", 16, 17);
        add("under a loose flooring stone", 18, 20);
    }
}
