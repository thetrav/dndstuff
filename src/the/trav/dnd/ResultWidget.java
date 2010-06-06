package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultWidget extends Widget
{
    private static final long serialVersionUID = 1L;
    private JTextArea result;
    
    public ResultWidget()
    {
        super();
        result = new JTextArea();
        setPreferredSize(new Dimension(700,500));
        add(new JScrollPane(result), BorderLayout.CENTER);
    }
    
    protected void setResult(String text)
    {
        result.setText(text);
        refresh();
    }
}
