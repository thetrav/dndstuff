package the.trav.dnd.dungeon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import the.trav.dnd.monster.Monster;
import the.trav.dnd.monster.MonsterEntry;
import the.trav.dnd.treasure.Treasure;

public class RoomContents 
{
	public enum Contents
    {
     TRAP, TREASURE, MONSTER   
    }
    
    public Set<Contents> contents = new HashSet<Contents>();
    public String trap;
    public Treasure treasure;
    
    public List<Monster> monsters;
    
    public String toString()
    {
        if(contents.isEmpty())
        {
            return "empty room";
        }
        StringBuilder sb = new StringBuilder();
        if(contents.contains(Contents.MONSTER))
        {
            MonsterEntry type = monsters.get(0).type;
            sb.append(monsters.size() + " x " +type.name + " ");
        }
        if(contents.contains(Contents.TREASURE))
        {
            sb.append(treasure);
        }
        if(contents.contains(Contents.TRAP))
        {
            sb.append(" TRAPPED!");
        }
        return sb.toString();
    }
}
