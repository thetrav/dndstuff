package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import the.trav.dnd.dice.DiceRoller;


public class DiceRollerWidget extends ResultWidget
{
    private static final long serialVersionUID = 1L;
    
    public DiceRollerWidget()
    {
        super();
        final JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(1,4));
        final JTextField numDice = new JTextField("1");
        controls.add(numDice);
        controls.add(new JLabel("d"));
        final JTextField diceType = new JTextField("100");
        controls.add(diceType);
        JButton roll = new JButton("roll");
        roll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                setResult(rollDice(numDice.getText(), diceType.getText()));
            }});
        controls.add(roll);
        add(controls, BorderLayout.NORTH);
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
