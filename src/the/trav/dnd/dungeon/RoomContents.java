package the.trav.dnd.dungeon;

import the.trav.dnd.table.DiceTable;

public class RoomContents extends DiceTable<String>
{
    public RoomContents()
    {
        add("empty", 1, 7);
        add("Monster", 8, 11);
        add("Monster and treasure", 12, 17);
        add("Stairs", 18, 18);
        add("Trick or Trap", 19, 19);
        add("Treasure", 20, 20);
    }
}
