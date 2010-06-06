package the.trav.dnd;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Widget extends JPanel
{
    private static final long serialVersionUID = 1L;


    public Widget()
    {
        super(new BorderLayout());
    }
    
    
    protected void refresh()
    {
        invalidate();
        revalidate();
        repaint();
    }
}
