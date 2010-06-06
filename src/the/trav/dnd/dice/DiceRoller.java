package the.trav.dnd.dice;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DiceRoller
{
    private final Random random = new Random(System.currentTimeMillis());
    
    public int roll(int type)
    {
        final int roll = random.nextInt(type) + 1;
        System.out.println("d" + type + " rolled: "+roll);
        return roll;
    }
    
    public Result roll(int num, int type)
    {
        System.out.println("rolling "+num + "d"+type);
        final Result result = new Result(0, new LinkedList<Integer>());
        for(int i=0; i<num; i++)
        {
            result.add(roll(type));
        }
        System.out.println("total: "+result.total);
        return result;
    }
    
    public static class Result
    {
        public List<Integer> values;
        public int total;
        public Result(int total, List<Integer> values)
        {
            this.total = total;
            this.values = values;
        }
        
        private void add(int roll)
        {
            values.add(roll);
            total += roll;
        }
    }
}
