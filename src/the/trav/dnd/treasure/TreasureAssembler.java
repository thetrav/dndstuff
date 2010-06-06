package the.trav.dnd.treasure;

import the.trav.dnd.dice.DiceRoller;

public class TreasureAssembler
{
    TreasureAmountTable amountTable = new TreasureAmountTable();
    TreasureContainerTable containerTable = new TreasureContainerTable();
    TreasureTrapTable trapTable = new TreasureTrapTable();
    TreasureHiddenTable hideTable = new TreasureHiddenTable();
    
    public Treasure build(DiceRoller dice)
    {
        Treasure treasure = amountTable.result(dice).build(dice);
        if(treasure.type != null)
        {
            treasure.container = containerTable.result(dice);
            if(dice.roll(100) <= 50)
            {
                treasure.hidden = hideTable.result(dice);
            }
            if(dice.roll(100) <= 50)
            {
                treasure.trap = trapTable.result(dice);
            }
        }
        
        return treasure;
    }
}
