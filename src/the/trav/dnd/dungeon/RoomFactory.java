package the.trav.dnd.dungeon;

import the.trav.dnd.dungeon.Room.Contents;

interface RoomFactory
{
    Room build();
   
    static class EmptyRoomFactory implements RoomFactory
    {
        public Room build()
        {
            return new Room();
        }
    }
    
    static class MonsterRoomFactory implements RoomFactory
    {
        public Room build()
        {
            Room room = new Room();
            room.contents.add(Contents.MONSTER);
            return room;
        }
    }
    
    static class MonsterAndTreasureRoomFactory implements RoomFactory
    {
        public Room build()
        {
            Room room = new Room();
            room.contents.add(Contents.MONSTER);
            room.contents.add(Contents.TREASURE);
            return room;
        }
    }
    
    static class StairsRoomFactory implements RoomFactory
    {
        public Room build()
        {
            Room room = new Room();
            return room;
        }
    }
    
    static class TrickRoomFactory implements RoomFactory
    {
        public Room build()
        {
            Room room = new Room();
            room.contents.add(Contents.TRAP);
            return room;
        }
    }
    
    static class TreasureRoomFactory implements RoomFactory
    {
        public Room build()
        {
            Room room = new Room();
            room.contents.add(Contents.TREASURE);
            return room;
        }
    }
}
