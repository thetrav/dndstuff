package the.trav.dnd.dungeon;

import the.trav.dnd.dungeon.RoomContents.Contents;

interface RoomFactory
{
    RoomContents build();
   
    static class EmptyRoomFactory implements RoomFactory
    {
        public RoomContents build()
        {
            return new RoomContents();
        }
    }
    
    static class MonsterRoomFactory implements RoomFactory
    {
        public RoomContents build()
        {
            RoomContents room = new RoomContents();
            room.contents.add(Contents.MONSTER);
            return room;
        }
    }
    
    static class MonsterAndTreasureRoomFactory implements RoomFactory
    {
        public RoomContents build()
        {
            RoomContents room = new RoomContents();
            room.contents.add(Contents.MONSTER);
            room.contents.add(Contents.TREASURE);
            return room;
        }
    }
    
    static class StairsRoomFactory implements RoomFactory
    {
        public RoomContents build()
        {
            RoomContents room = new RoomContents();
            return room;
        }
    }
    
    static class TrickRoomFactory implements RoomFactory
    {
        public RoomContents build()
        {
            RoomContents room = new RoomContents();
            room.contents.add(Contents.TRAP);
            return room;
        }
    }
    
    static class TreasureRoomFactory implements RoomFactory
    {
        public RoomContents build()
        {
            RoomContents room = new RoomContents();
            room.contents.add(Contents.TREASURE);
            return room;
        }
    }
}
