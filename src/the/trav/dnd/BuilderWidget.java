package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BuilderWidget extends ResultWidget
{
    private static final long serialVersionUID = 1L;
    JTextArea result;
    DiceBuilder<?> table;

    public BuilderWidget(final DiceBuilder<?> table)
    {
        super();
        final JPanel controls = new JPanel();
        final JTextField numTries = new JTextField("100");
        final JButton go = new JButton("go");
        go.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                roll(Integer.valueOf(numTries.getText()));
            }

        });
        controls.add(numTries);
        controls.add(go);
        add(controls, BorderLayout.NORTH);
        this.table = table;
    }

    private void roll(final Integer tries)
    {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tries; i++)
        {
            sb.append(table.build(Main.dice) + "\n");
        }
        setResult(sb.toString());
    }
}
