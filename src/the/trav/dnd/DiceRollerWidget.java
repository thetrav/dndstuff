package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import the.trav.dnd.dice.DiceRoller;


public class DiceRollerWidget extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    public DiceRollerWidget()
    {
        setLayout(new BorderLayout());
        final JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(1,4));
        final JTextField numDice = new JTextField("1");
        controls.add(numDice);
        controls.add(new JLabel("d"));
        final JTextField diceType = new JTextField("100");
        controls.add(diceType);
        JButton roll = new JButton("roll");
        final JTextArea result = new JTextArea();
        roll.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                result.setText(rollDice(numDice.getText(), diceType.getText()));
                result.setCaretPosition(result.getText().length());
                Main.frame.invalidate();
                Main.frame.repaint();
            }});
        controls.add(roll);
        add(controls, BorderLayout.NORTH);
        final JScrollPane scroll = new JScrollPane(result);
        scroll.setSize(500,500);
        add(scroll, BorderLayout.CENTER);
    }

    private String rollDice(String numDice, String typeDice)
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            final int num = Integer.parseInt(numDice);
            final int type = Integer.parseInt(typeDice);
            final DiceRoller.Result result = Main.dice.roll(num, type);
            for(Integer roll : result.values)
            {
                sb.append(roll+"\n");
            }
            sb.append("==================================\nTotal:"+result.total+"\n==================================");
        }
        catch(Exception e)
        {
            sb.append("error: "+e);
        }
        return sb.toString();
    }
}
