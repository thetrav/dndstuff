package the.trav.dnd.dungeon;

import java.util.HashSet;
import java.util.Set;

import the.trav.dnd.monster.MonsterEntry;

public class Room 
{
	public enum Contents
    {
     NONE, TRAP, TREASURE, MONSTER   
    }
    
    public Set<Contents> contents = new HashSet<Contents>();
    public String treasureContainer;
    public String trap;
    public String treasureHidden;
    public int treasureAmount;
    public String treasureType;
    
    public MonsterEntry monster;
    
    
}
