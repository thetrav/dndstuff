package the.trav.dnd;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import the.trav.dnd.dungeon.RoomAssembler;

public class RoomBuilderWidget extends ResultWidget
{
    private static final long serialVersionUID = 1L;
    RoomAssembler builder;

    public RoomBuilderWidget(final RoomAssembler builder)
    {
        super();
        final JPanel controls = new JPanel();
        final JTextField numTries = new JTextField("100");
        final JTextField dungeonLevel = new JTextField("10");
        final JButton go = new JButton("go");
        go.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                roll(Integer.valueOf(numTries.getText()), Integer.valueOf(dungeonLevel.getText()));
            }
        });
        controls.add(numTries);
        controls.add(dungeonLevel);
        controls.add(go);
        add(controls, BorderLayout.NORTH);
        this.builder = builder;
    }

    private void roll(final int tries, final int dungeonLevel)
    {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tries; i++)
        {
            sb.append(builder.build(Main.dice, dungeonLevel) + "\n");
        }
        setResult(sb.toString());
    }
}
