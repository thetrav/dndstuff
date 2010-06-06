package the.trav.dnd.treasure;

import the.trav.dnd.table.DiceTable;

public class TreasureTrapTable extends DiceTable<String>
{
    @Override
    protected int getDiceType()
    {
        return 20;
    }
    
    public TreasureTrapTable()
    {
        add("Blade scything across inside", 1, 2);
        add("Contact poison on container", 3, 4);
        add("Contact poison on treasure", 5, 6);
        add("Gas released by opening container", 7);
        add("Explosive runes", 8);
        add("Poisoned needles in lock", 9, 10);
        add("Poisoned needles in handles", 11);
        add("Poisonous insect or reptire living inside container", 12);
        add("Spears released from walls when container opened", 13);
        add("Spring darts firing from front of container", 14);
        add("Spring darts firing from top of container", 15);
        add("Spring darts firing up from inside bottom of container", 16);
        add("Stone block dropping in front of contianer", 17);
        add("Symbol", 18);
        add("Trapdoor opening in front of container", 19);
        add("Trapdoor opening 6 ft in front of container", 20);
    }
}
