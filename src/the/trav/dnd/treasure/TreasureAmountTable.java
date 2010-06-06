package the.trav.dnd.treasure;

import the.trav.dnd.table.DiceTable;
import the.trav.dnd.treasure.Treasure.Type;

public class TreasureAmountTable extends DiceTable<TreasureFactory>
{
    @Override
    protected int getDiceType()
    {
        return 20;
    }
    
    public TreasureAmountTable()
    {
        add(new TreasureFactoryImpl(2, 10, 100, Type.COPPER), 1, 5);
        add(new TreasureFactoryImpl(2, 10, 100, Type.SILVER), 6, 10);
        add(new TreasureFactoryImpl(2, 8, 100, Type.ELECTRUM), 11, 13);
        add(new TreasureFactoryImpl(1, 4, 100, Type.GOLD), 14, 16);
        add(new TreasureFactoryImpl(2, 10, 10, Type.PLATINUM), 17, 18);
        add(new GemOrJewelFactory(), 19);
        add(new MagicItemOrNothingFactory(), 20);
    }
}
