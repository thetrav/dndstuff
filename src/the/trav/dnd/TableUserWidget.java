package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import the.trav.dnd.table.DiceTable;

public class TableUserWidget extends JPanel
{
    private static final long serialVersionUID = 1L;
    JTextArea result;
    DiceTable<?> table;

    public TableUserWidget(final DiceTable<?> table)
    {
        super(new BorderLayout());
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
        result = new JTextArea();
        add(new JScrollPane(result), BorderLayout.CENTER);
    }

    private void refresh()
    {
        invalidate();
        revalidate();
        repaint();
    }

    private void roll(final Integer tries)
    {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tries; i++)
        {
            sb.append(table.result(Main.dice) + "\n");
        }
        result.setText(sb.toString());
        refresh();
    }
}
