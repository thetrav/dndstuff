package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import the.trav.dnd.dice.DiceRoller;
import the.trav.dnd.dungeon.RoomContents;

public class Main
{
    static JFrame frame;
    static JPanel pane;
    public static final DiceRoller dice = new DiceRoller();

    public static void main(final String[] args)
    {
        frame = new JFrame("Travs DnDStuff");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JMenuBar menuBar = new JMenuBar();
        // final JMenu menu = new JMenu("tools");

        addWidget(menuBar, "Dice", new DiceRollerWidget());
        addWidget(menuBar, "Encounter", new EncounterWidget());
        addWidget(menuBar, "Monsters", new MonsterEntryWidget());
        addWidget(menuBar, "Rooms", new TableUserWidget(new RoomContents()));

        // menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        pane = new JPanel();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void addWidget(final JMenuBar menuBar, final String menuLabel, final Component widget)
    {
        final JMenuItem encounter = new JMenuItem(menuLabel);
        encounter.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent arg0)
            {
                show(widget);
            }

        });
        menuBar.add(encounter);
    }

    private static void show(final Component c)
    {
        pane.removeAll();
        pane.add(c);
        pane.invalidate();
        pane.revalidate();
        pane.repaint();
    }
}
