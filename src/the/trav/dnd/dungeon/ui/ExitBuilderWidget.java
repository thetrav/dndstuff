package the.trav.dnd.dungeon.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import the.trav.dnd.Widget;
import the.trav.dnd.dungeon.DungeonPortal;
import the.trav.dnd.dungeon.DungeonRoom;
import the.trav.dnd.dungeon.DungeonPortal.Type;

public class ExitBuilderWidget extends Widget
{
    private static final long serialVersionUID = 1L;
    private final ExitListener listener;

    public ExitBuilderWidget(final Map<String, DungeonRoom> rooms, final ExitListener listener)
    {
        this.listener = listener;
        final JComboBox type = new JComboBox(new Type[] { Type.DOOR, Type.CORRIDOR, Type.STAIRCASE });
        add(type);
        final JTextField exitNotes = new JTextField(10);
        add(exitNotes);
        final JComboBox room = new JComboBox(rooms.keySet().toArray());
        add(room);
        final JButton done = new JButton("ok");
        done.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                ok((Type) type.getSelectedItem(), exitNotes.getText(), rooms.get(room.getSelectedItem()));
            }
        });
        add(done);
    }

    private void ok(final Type type, final String text, final DungeonRoom dungeonRoom)
    {
        final DungeonPortal exit = new DungeonPortal();
        exit.type = type;
        exit.notes = text;
        exit.connectsTo = dungeonRoom;
        listener.done(exit);
    }

    interface ExitListener
    {
        void done(DungeonPortal exit);
    }
}
