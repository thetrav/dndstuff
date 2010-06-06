package the.trav.dnd.treasure;

import the.trav.dnd.table.DiceTable;

public class TreasureContainerTable extends DiceTable<String>
{
    @Override
    protected int getDiceType()
    {
        return 20;
    }
    
    public TreasureContainerTable()
    {
        add("Bags", 1, 2);
        add("Sacks", 3, 4);
        add("Coffers", 5, 6);
        add("Chests", 7, 8);
        add("Large Chests", 9, 10);
        add("Pottery Jars", 11, 12);
        add("Metal Urns", 13, 14);
        add("Stone Containers", 15, 16);
        add("Iron Trunks", 17, 18);
        add("None, loose", 19, 20);
    }
}
