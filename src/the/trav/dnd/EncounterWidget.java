package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import the.trav.dnd.monster.EncounterTable;
import the.trav.dnd.monster.Monster;
import the.trav.dnd.monster.MonsterEntry;

/**
 * Currently just consults DMG for probability table of creatures, then does a
 * bunch of hit dice rolls. I want it to also: Display AC, armor type, weapon
 * equipment + weapon stats Display original HP, current HP, and allow for a
 * "damage this round" to be entered and applied as separate clicks Display
 * moralle, and make moralle checks, allow me to modify the check Roll up
 * treasure on the encounters person Maybe eventually add pictures?
 * 
 * @author travis
 */
public class EncounterWidget extends JPanel
{

    JPanel newEncounterControls = new JPanel();
    JPanel encounterPanel = new JPanel();
    List<List<Monster>> encounters = new LinkedList<List<Monster>>();

    public EncounterWidget()
    {
        super(new BorderLayout());
        encounterPanel.setLayout(new BoxLayout(encounterPanel, BoxLayout.Y_AXIS));

        // encounterPanel.setBorder(null);

        newEncounterControls.add(new JLabel("Dungeon Level"));
        final JTextField dungeonLevel = new JTextField("01");
        newEncounterControls.add(dungeonLevel);

        newEncounterControls.add(new JLabel("Encounters"));
        final JTextField encounters = new JTextField("01");
        newEncounterControls.add(encounters);

        final JButton generate = new JButton("generate");
        generate.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                final int num = Integer.parseInt(encounters.getText());
                for (int i = 0; i < num; i++)
                {
                    generate(dungeonLevel.getText());
                }
            }
        });
        newEncounterControls.add(generate);

        final JButton print = new JButton("print summary");
        print.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                printSummary();
            }
        });

        newEncounterControls.add(print);
        add(newEncounterControls, BorderLayout.NORTH);
        setPreferredSize(new Dimension(700, 500));
        add(new JScrollPane(encounterPanel), BorderLayout.CENTER);
    }

    private void printSummary()
    {
        for (final List<Monster> monsters : encounters)
        {
            final MonsterEntry type = monsters.get(0).type;
            System.out.println(monsters.size() + "|" + type.name);
        }
    }

    private void generate(final String text)
    {
        final List<Monster> monsters = new EncounterTable().generate(Main.dice, Integer.parseInt(text));
        debug(monsters);
        // encounterPanel.removeAll();

        final JPanel monsterGroupPanel = new MonsterGroupPanel(monsters);
        encounterPanel.add(monsterGroupPanel);
        // removeAll();
        //        
        refresh();
    }

    private void refresh()
    {
        invalidate();
        revalidate();
        repaint();
    }

    private void debug(final List<Monster> monsters)
    {
        final StringBuilder sb = new StringBuilder();
        sb.append(monsters.size() + " Monsters\n");
        for (final Monster m : monsters)
        {
            sb.append(m.type.name + " with " + m.hp + " hit points\n");
        }
        System.out.println(sb.toString());
        encounters.add(monsters);
    }

}
