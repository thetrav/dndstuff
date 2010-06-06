package the.trav.dnd.dungeon;

import the.trav.dnd.dice.DiceRoller;

public class RoomAssembler
{
    RoomContents table = new RoomContents();
    
    public Room build(DiceRoller dice, int dungeonLevel)
    {
        return table.result(dice).build();
        
    }
}
