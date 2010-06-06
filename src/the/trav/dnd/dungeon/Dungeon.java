package the.trav.dnd.dungeon;

import java.util.List;

public class Dungeon
{
    public List<DungeonLevel> levels;
    
    public void addNewLevel()
    {
        levels.add(new DungeonLevel());
    }
}
