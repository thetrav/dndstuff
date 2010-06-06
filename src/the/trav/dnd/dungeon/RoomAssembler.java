package the.trav.dnd.dungeon;

import the.trav.dnd.dice.DiceRoller;
import the.trav.dnd.dungeon.RoomContents.Contents;
import the.trav.dnd.monster.EncounterTable;
import the.trav.dnd.treasure.TreasureAssembler;

public class RoomAssembler
{
    RoomContentsTable contentsTable = new RoomContentsTable();
    EncounterTable encounterTable = new EncounterTable();
    TreasureAssembler treasureAssembler = new TreasureAssembler();
    
    public RoomContents build(DiceRoller dice, int dungeonLevel)
    {
        final RoomContents room = contentsTable.result(dice).build();
        if(room.contents.contains(Contents.MONSTER))
        {
            room.monsters = encounterTable.generate(dice, dungeonLevel);
        }
        if(room.contents.contains(Contents.TREASURE))
        {
            room.treasure = treasureAssembler.build(dice);
            room.treasure.qty *= dungeonLevel;
        }
        return room;
    }
}
