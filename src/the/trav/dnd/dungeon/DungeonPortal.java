package the.trav.dnd.dungeon;

public class DungeonPortal
{
    public enum Type
    {
        DOOR, CORRIDOR, STAIRCASE
    }
    
    public Type type;
    public String notes;
    public DungeonRoom connectsTo;
}
