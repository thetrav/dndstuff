package the.trav.dnd.monster;

import java.util.ArrayList;
import java.util.List;

import the.trav.dnd.dice.DiceRoller;

public class EncounterFactory
{
    public final String name;
    public final int numDice;
    public final int typeDice;
    public final int mod;

    public EncounterFactory(final String name, final int numDice, final int typeDice, final int mod)
    {
        this.name = name;
        this.numDice = numDice;
        this.typeDice = typeDice;
        this.mod = mod;
    }

    public List<Monster> build(final DiceRoller dice)
    {
        final int num = dice.roll(numDice, typeDice).total + mod;
        final List<Monster> monsters = new ArrayList<Monster>(num);
        for (int i = 0; i < num; i++)
        {
            monsters.add(new MonsterFactory(name).build(dice));
        }
        return monsters;
    }

    @Override
    public String toString()
    {
        return "Encounter factory for:" + name;
    }
}
