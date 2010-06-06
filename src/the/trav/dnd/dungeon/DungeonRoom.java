package the.trav.dnd.dungeon;

import java.util.List;

public class DungeonRoom
{
    public int id;
    public boolean corridor;
    public List<DungeonPortal> exits;
    public RoomContents occupants;
    public String notes;
    
    public DungeonRoom(boolean b)
    {
        corridor = b;
    }
    
    public DungeonRoom()
    {
        this(false);
    }

    public void addNewExit()
    {
        exits.add(new DungeonPortal());
    }
}
