package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import the.trav.dnd.monster.MonsterEntry;
import the.trav.dnd.monster.MonsterFactory;

import com.thoughtworks.xstream.XStream;

public class MonsterEntryWidget extends JPanel
{
    private static final long serialVersionUID = 1L;
    MonsterEntry entry = new MonsterEntry("", 1, 1, 10);
    boolean isNew = true;
    final JTextField type = new JTextField();
    final JTextField hitDice = new JTextField("1");
    final JTextField hpMod = new JTextField("1");
    final JTextField fileName = new JTextField("");
    final JList list;

    public MonsterEntryWidget()
    {
        final JPanel grid = new JPanel(new GridLayout(6, 2));
        grid.add(new JLabel("fileName"));
        grid.add(fileName);
        grid.add(new JLabel("Type"));
        grid.add(type);
        grid.add(new JLabel("Hit Dice"));
        grid.add(hitDice);
        grid.add(new JLabel("HP Mod"));
        grid.add(hpMod);
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                save();
            }
        });
        grid.add(save);
        list = new JList(MonsterFactory.entries.keySet().toArray());
        // grid.add(list);
        // final JButton open = new JButton("Open");
        // open.addActionListener(new ActionListener()
        // {
        // public void actionPerformed(ActionEvent arg0)
        // {
        // open((String)list.getSelectedValue());
        // }
        // });
        // grid.add(open);
        // final JButton newButton = new JButton("New");
        // newButton.addActionListener(new ActionListener(){
        // public void actionPerformed(ActionEvent arg0)
        // {
        // newEntry();
        // }
        // });
        // grid.add(newButton);
        setLayout(new BorderLayout());
        add(grid, BorderLayout.CENTER);
    }

    private void newEntry()
    {
        fileName.setText("");
        entry = new MonsterEntry("", 1, 1, 10);
        refresh();
        isNew = true;
    }

    private void save()
    {
        entry.name = type.getText();
        entry.hitDice = Integer.parseInt(hitDice.getText());
        entry.hpMod = Integer.parseInt(hpMod.getText());
        // final JFileChooser dialog = new JFileChooser("data/monsters");
        // final int result = dialog.showSaveDialog(this);
        // final File file = dialog.getSelectedFile();
        // result == JFileChooser.APPROVE_OPTION
        final File file = new File("data/monsters/" + fileName.getText() + ".xml");
        if (file != null)
        {
            try
            {
                final FileOutputStream out = new FileOutputStream(file);
                try
                {
                    final XStream xStream = new XStream();
                    xStream.toXML(entry, out);
                }
                finally
                {
                    out.close();
                }
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }
        }
        if (isNew)
        {
            MonsterFactory.entries.put(entry.name, entry);
        }
        newEntry();
    }

    private void refresh()
    {
        type.setText(entry.name);
        hitDice.setText(String.valueOf(entry.hitDice));
        hpMod.setText(String.valueOf(entry.hpMod));
        list.clearSelection();
        list.setListData(MonsterFactory.entries.keySet().toArray());
        invalidate();
        revalidate();
        repaint();
    }
}
