package the.trav.dnd.monster;

public class MonsterEntry
{
    public String name;
    public int hitDice;
    public int hpMod;
    public int ac;
    
    public MonsterEntry(String name, int hitDice, int hpMod, int ac)
    {
        this.name = name;
        this.hitDice = hitDice;
        this.hpMod = hpMod;
        this.ac = ac;
    }
}
