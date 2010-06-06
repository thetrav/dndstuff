package the.trav.dnd.dungeon;

import the.trav.dnd.dungeon.RoomFactory.EmptyRoomFactory;
import the.trav.dnd.dungeon.RoomFactory.MonsterAndTreasureRoomFactory;
import the.trav.dnd.dungeon.RoomFactory.MonsterRoomFactory;
import the.trav.dnd.dungeon.RoomFactory.StairsRoomFactory;
import the.trav.dnd.dungeon.RoomFactory.TreasureRoomFactory;
import the.trav.dnd.dungeon.RoomFactory.TrickRoomFactory;
import the.trav.dnd.table.DiceTable;

public class RoomContents extends DiceTable<RoomFactory>
{
    public RoomContents()
    {
        add(new EmptyRoomFactory(), 1, 7);
        add(new MonsterRoomFactory(), 8, 11);
        add(new MonsterAndTreasureRoomFactory(), 12, 17);
        add(new StairsRoomFactory(), 18, 18);
        add(new TrickRoomFactory(), 19, 19);
        add(new TreasureRoomFactory(), 20, 20);
    }

    @Override
    protected int getDiceType()
    {
        return 20;
    }
}
