package the.trav.dnd.treasure;

public class Treasure
{
    public int qty;
    public enum Type
    {
        COPPER, SILVER, ELECTRUM, GOLD, PLATINUM,
        GEM, JEWEL, MAGIC
    }
    public Type type;
    public String container;
    public String trap;
    public String hidden;
    
    public String toString()
    {
        if(type == null)
        {
            return "No Treasure";
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            sb.append(qty + " " + type + " " + container);
            if(hidden != null) sb.append(" " + hidden);
            if(trap != null) sb.append(" " + trap);
            return sb.toString();
        }
    }
}
