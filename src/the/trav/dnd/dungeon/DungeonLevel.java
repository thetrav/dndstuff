package the.trav.dnd.dungeon;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DungeonLevel
{
    public Map<String, DungeonRoom> rooms;
    int roomCount;
    
    public String addNewRoom()
    {
        String id = String.valueOf(roomCount++);
        rooms.put(id, new DungeonRoom());
        return id;
    }
    
    public String addNewCorridor(List<DungeonRoom> connections)
    {
        StringBuilder sb = new StringBuilder();
        for(Iterator<DungeonRoom> it = connections.iterator(); it.hasNext();)
        {
            sb.append(it.next().id);
            if(it.hasNext())
            {
                sb.append("-");
            }
        }
        String id = sb.toString();
        rooms.put(id, new DungeonRoom(true));
        return id;
    }
    
}
