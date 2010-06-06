package the.trav.dnd.treasure;

import the.trav.dnd.dice.DiceRoller;
import the.trav.dnd.treasure.Treasure.Type;

public class TreasureFactoryImpl implements TreasureFactory
{
    private int numDice;
    private int diceType;
    private int multiplier;
    private Treasure.Type treasureType;
    
    public TreasureFactoryImpl(int numDice, int diceType, int multiplier, Type treasureType)
    {
        this.numDice = numDice;
        this.diceType = diceType;
        this.multiplier = multiplier;
        this.treasureType = treasureType;
    }
    
    public TreasureFactoryImpl(int numDice, int diceType, Type treasureType)
    {
        this.numDice = numDice;
        this.diceType = diceType;
        this.multiplier = 1;
        this.treasureType = treasureType;
    }
    
    public TreasureFactoryImpl(int num, Type treasureType)
    {
        this.numDice = num;
        this.diceType = 1;
        this.multiplier = 1;
        this.treasureType = treasureType;
    }
    
    public TreasureFactoryImpl(Type treasureType)
    {
        this.numDice = 1;
        this.diceType = 1;
        this.multiplier = 1;
        this.treasureType = treasureType;
    }

    public Treasure build(DiceRoller dice)
    {
        final Treasure treasure = new Treasure();
        treasure.qty = dice.roll(numDice, diceType).total * multiplier;
        treasure.type = treasureType;
        return treasure;
    }
    
    @Override
    public String toString()
    {
        return "TreasureFactory["+numDice+"d"+diceType+" "+treasureType+"x"+multiplier+"]";
    }
}
