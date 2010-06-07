package the.trav.dnd.dungeon;

import java.util.LinkedList;
import java.util.List;

public class DungeonRoom
{
    public String id;
    public boolean corridor;
    public List<DungeonPortal> exits = new LinkedList<DungeonPortal>();
    public RoomContents occupants = new RoomContents();
    public String notes = "";

    public DungeonRoom(final boolean b, final String id)
    {
        this.id = id;
        corridor = b;
        notes = "room : " + id;
    }

    public DungeonRoom(final String id)
    {
        this(false, id);
    }

    public void addNewExit()
    {
        exits.add(new DungeonPortal());
    }

    @Override
    public String toString()
    {
        return "DungeonRoom[" + id + "]";
    }
}
