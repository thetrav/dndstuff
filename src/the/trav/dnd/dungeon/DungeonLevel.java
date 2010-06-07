package the.trav.dnd.dungeon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DungeonLevel
{
    public Map<String, DungeonRoom> rooms = new HashMap<String, DungeonRoom>();
    int roomCount;
    public int powerLevel;

    public String addNewRoom()
    {
        final String id = String.valueOf(roomCount++);
        rooms.put(id, new DungeonRoom(id));
        return id;
    }

    public String addNewCorridor(final List<DungeonRoom> connections)
    {
        final StringBuilder sb = new StringBuilder();
        for (final Iterator<DungeonRoom> it = connections.iterator(); it.hasNext();)
        {
            sb.append(it.next().id);
            if (it.hasNext())
            {
                sb.append("-");
            }
        }
        final String id = sb.toString();
        rooms.put(id, new DungeonRoom(true, id));
        return id;
    }

}
