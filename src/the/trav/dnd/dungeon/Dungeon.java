package the.trav.dnd.dungeon;

import java.util.LinkedList;
import java.util.List;

public class Dungeon
{
    public List<DungeonLevel> levels = new LinkedList<DungeonLevel>();

    public void addNewLevel()
    {
        final DungeonLevel dungeonLevel = new DungeonLevel();
        levels.add(dungeonLevel);
        dungeonLevel.powerLevel = levels.size();
    }
}
