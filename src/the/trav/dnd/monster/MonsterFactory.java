package the.trav.dnd.monster;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import the.trav.dnd.dice.DiceRoller;
import the.trav.util.Assert;

import com.thoughtworks.xstream.XStream;

public class MonsterFactory
{
    public static final Map<String, MonsterEntry> entries = new HashMap<String, MonsterEntry>();
    static
    {
        final XStream xStream = new XStream();
        final File folder = new File("data/monsters");
        for (final File file : folder.listFiles())
        {
            try
            {
                final InputStream fileStream = new FileInputStream(file);
                try
                {
                    final MonsterEntry entry = (MonsterEntry) xStream.fromXML(fileStream);
                    entries.put(entry.name, entry);
                }
                finally
                {
                    fileStream.close();
                }
            }
            catch (final IOException e)
            {
                System.out.println("error reading file: " + file.getName());
                e.printStackTrace();
            }
        }
    }

    private final String name;

    public MonsterFactory(final String name)
    {
        this.name = name;
    }

    public Monster build(final DiceRoller dice)
    {
        final MonsterEntry entry = entries.get(name);
        Assert.assertTrue("no entry for:" + name + " in table:" + entries, entry != null);
        final Monster monster = new Monster();
        monster.type = entry;
        monster.hp = dice.roll(entry.hitDice, 8).total + entry.hpMod;
        return monster;
    }

    public static void main(final String[] args)
    {
        System.out.println("main method to test file loading loaded" + entries);
    }
}
