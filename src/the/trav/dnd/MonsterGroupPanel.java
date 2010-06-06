package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import the.trav.dnd.monster.Monster;
import the.trav.dnd.monster.MonsterEntry;

public class MonsterGroupPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private final JPanel monsterTablePanel;
    private boolean show = true;

    public MonsterGroupPanel(final List<Monster> monsters)
    {
        super(new BorderLayout());
        final JButton label = new JButton(buildMonsterGroupLabel(monsters));
        label.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                if (show)
                {
                    add(monsterTablePanel, BorderLayout.CENTER);
                }
                else
                {
                    remove(monsterTablePanel);
                }
                show = !show;
                refresh();
            }
        });
        add(label, BorderLayout.NORTH);
        monsterTablePanel = new JPanel(new BorderLayout());
        final JTable monsterTable = new JTable(MonsterTabler.buildData(monsters), MonsterTabler.COLUMN_NAMES);
        monsterTablePanel.add(monsterTable.getTableHeader(), BorderLayout.NORTH);
        monsterTablePanel.add(monsterTable, BorderLayout.CENTER);

    }

    private void refresh()
    {
        invalidate();
        revalidate();
        repaint();
    }

    private String buildMonsterGroupLabel(final List<Monster> monsters)
    {
        final MonsterEntry type = monsters.get(0).type;
        return monsters.size() + " * " + type.name + " AC:" + type.ac + " HIT BONUS:" + "hit dice:" + type.hitDice + " " + type.hpMod + " Weapon:";
    }

    private static class MonsterTabler
    {
        private static final String[] COLUMN_NAMES = { "starting HP", "damage", "HP" };

        private static Object[][] buildData(final List<Monster> monsters)
        {
            final Object[][] rows = new Object[monsters.size()][COLUMN_NAMES.length];
            for (int i = 0; i < rows.length; i++)
            {
                rows[i] = convertMonster(monsters.get(i));
            }
            return rows;
        }

        private static Object[] convertMonster(final Monster m)
        {
            final Object[] data = new Object[COLUMN_NAMES.length];
            int i = 0;
            data[i++] = m.hp;
            data[i++] = 0;
            data[i++] = m.hp;
            return data;
        }
    }
}
