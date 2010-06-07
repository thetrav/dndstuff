package the.trav.dnd.dungeon.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import the.trav.dnd.Main;
import the.trav.dnd.Widget;
import the.trav.dnd.dungeon.Dungeon;
import the.trav.dnd.dungeon.DungeonLevel;
import the.trav.dnd.dungeon.DungeonPortal;
import the.trav.dnd.dungeon.DungeonRoom;
import the.trav.dnd.dungeon.RoomAssembler;
import the.trav.dnd.dungeon.ui.ExitBuilderWidget.ExitListener;

import com.thoughtworks.xstream.XStream;

public class DungeonWidget extends Widget
{
    private static final long serialVersionUID = 1L;

    Dungeon dungeon;
    DungeonLevel level;
    int levelIndex;
    DungeonRoom room;

    JComboBox levelSelect;
    JComboBox roomSelect;

    JTextArea notes = new JTextArea(15, 20);
    JTextArea occupants = new JTextArea(15, 20);
    JPanel exits;

    ItemListener levelSelected;
    ItemListener roomSelected;

    DocumentListener notesListener;

    RoomAssembler roomAssembler = new RoomAssembler();

    public DungeonWidget()
    {
        super();
        exits = new JPanel();
        exits.setLayout(new BoxLayout(exits, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(700, 500));
        createJumpBar();
        createRoomPanel();

        dungeon = new Dungeon();
        dungeon.addNewLevel();
        pickDefaultLevelAndRoom();
    }

    private void pickDefaultLevelAndRoom()
    {
        level = dungeon.levels.get(0);
        final String roomId = level.addNewRoom();
        selectRoom(roomId);
    }

    private void createRoomPanel()
    {
        final JPanel roomPanel = new JPanel(new BorderLayout());
        roomPanel.setPreferredSize(new Dimension(700, 500));

        final JPanel westPanel = new JPanel(new GridLayout(2, 1));
        westPanel.setPreferredSize(new Dimension(300, 500));

        final JPanel roomNotes = new JPanel(new BorderLayout());
        roomNotes.setPreferredSize(new Dimension(300, 200));
        roomNotes.add(new JLabel("Notes:"), BorderLayout.NORTH);
        roomNotes.add(new JScrollPane(notes), BorderLayout.CENTER);
        westPanel.add(roomNotes);
        notesListener = new DocumentListener()
        {
            public void changedUpdate(final DocumentEvent arg0)
            {
                updateNotes();
            }

            public void insertUpdate(final DocumentEvent arg0)
            {
                updateNotes();
            }

            public void removeUpdate(final DocumentEvent arg0)
            {
                updateNotes();
            }
        };
        notes.getDocument().addDocumentListener(notesListener);

        final JPanel roomOccupants = new JPanel(new BorderLayout());
        roomOccupants.setPreferredSize(new Dimension(300, 200));
        roomOccupants.add(new JLabel("Occupants:"), BorderLayout.NORTH);
        roomOccupants.add(new JScrollPane(occupants), BorderLayout.CENTER);
        final JButton generate = new JButton("generate");
        generate.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                generateOccupants();
            }
        });
        roomOccupants.add(generate, BorderLayout.SOUTH);
        westPanel.add(roomOccupants);
        roomPanel.add(westPanel, BorderLayout.WEST);

        final JPanel exitsPanel = new JPanel();
        exitsPanel.setPreferredSize(new Dimension(300, 400));
        exitsPanel.add(new JScrollPane(exits));
        roomPanel.add(exitsPanel, BorderLayout.EAST);

        add(roomPanel, BorderLayout.CENTER);
    }

    private void createJumpBar()
    {
        final JPanel jumpBar = new JPanel();
        final JLabel level = new JLabel("Level:");
        jumpBar.add(level);
        levelSelect = new JComboBox();
        levelSelected = new ItemListener()
        {
            public void itemStateChanged(final ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    selectLevel(levelSelect.getSelectedIndex());
                }
            }
        };
        levelSelect.addItemListener(levelSelected);
        jumpBar.add(levelSelect);

        final JButton newLevelButton = new JButton("+");
        newLevelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                newLevel();
            }
        });
        jumpBar.add(newLevelButton);

        final JLabel rooms = new JLabel("Room:");
        jumpBar.add(rooms);
        roomSelect = new JComboBox();
        roomSelected = new ItemListener()
        {
            public void itemStateChanged(final ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    selectRoom(roomSelect.getSelectedItem().toString());
                }
            }
        };
        roomSelect.addItemListener(roomSelected);
        jumpBar.add(roomSelect);

        final JButton newRoomButton = new JButton("+");
        newRoomButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                newRoom();
            }
        });
        jumpBar.add(newRoomButton);

        final JButton save = new JButton("save");
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                saveDungeon();
            }
        });
        jumpBar.add(save);

        final JButton load = new JButton("load");
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                loadDungeon();
            }
        });
        jumpBar.add(load);

        add(jumpBar, BorderLayout.NORTH);
    }

    private void newRoom()
    {
        selectRoom(level.addNewRoom());
    }

    private void newLevel()
    {
        dungeon.addNewLevel();
    }

    private void selectRoom(final String selectedItem)
    {
        selectRoom(level.rooms.get(selectedItem));
    }

    private void selectLevel(final int selectedIndex)
    {
        levelIndex = selectedIndex;
        level = dungeon.levels.get(selectedIndex);
        selectRoom(level.rooms.values().iterator().next());
    }

    private void selectRoom(final DungeonRoom selectedRoom)
    {
        room = selectedRoom;
        refreshData();
        refresh();
    }

    private void refreshData()
    {
        // set level selection box
        levelSelect.removeItemListener(levelSelected);
        levelSelect.removeAllItems();
        for (int i = 0; i < dungeon.levels.size(); i++)
        {
            levelSelect.addItem("Level " + (i + 1));
        }
        levelSelect.setSelectedIndex(levelIndex);
        levelSelect.addItemListener(levelSelected);

        // set room selection box
        roomSelect.removeItemListener(roomSelected);
        roomSelect.removeAllItems();
        for (final String room : level.rooms.keySet())
        {
            roomSelect.addItem(room);
        }
        final String roomId = String.valueOf(room.id);
        roomSelect.setSelectedItem(roomId);
        roomSelect.addItemListener(roomSelected);

        // set room notes
        notes.setText(room.notes);

        // set room occupants
        occupants.setText(room.occupants.toString());

        // set exit panel
        exits.removeAll();
        buildExitPanel();
    }

    private void buildExitPanel()
    {
        exits.add(new JLabel("Exits"));
        for (final DungeonPortal exit : room.exits)
        {
            exits.add(buildExitPanel(exit));
        }
        final JButton newExit = new JButton("+");
        newExit.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent e)
            {
                newExit();
            }
        });
        exits.add(newExit);
    }

    private void newExit()
    {
        final JFrame newExitWindow = new JFrame("Build Exit");
        newExitWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        newExitWindow.setSize(500, 200);
        final ExitBuilderWidget exitBuilder = new ExitBuilderWidget(level.rooms, new ExitListener()
        {
            public void done(final DungeonPortal exit)
            {
                room.exits.add(exit);
                newExitWindow.setVisible(false);
                newExitWindow.dispose();
                refreshData();
                refresh();
            }
        });
        newExitWindow.getContentPane().add(exitBuilder);
        newExitWindow.setVisible(true);
    }

    private Component buildExitPanel(final DungeonPortal exit)
    {
        final JPanel panel = new JPanel();
        panel.add(new JLabel(String.valueOf(exit.type)));
        final String connectionId = String.valueOf(exit.connectsTo.id);
        panel.add(new JLabel(connectionId));
        final JButton go = new JButton("go");
        go.addActionListener(new ActionListener()
        {
            public void actionPerformed(final ActionEvent arg0)
            {
                selectRoom(connectionId);
            }
        });
        panel.add(go);
        return panel;
    }

    private void saveDungeon()
    {
        final JFileChooser fc = new JFileChooser();
        final int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            final File file = fc.getSelectedFile();
            final XStream xs = new XStream();
            try
            {
                final FileOutputStream fileOut = new FileOutputStream(file);
                try
                {
                    xs.toXML(dungeon, fileOut);
                }
                finally
                {
                    fileOut.close();
                }
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void loadDungeon()
    {
        final JFileChooser fc = new JFileChooser();
        final int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            final File file = fc.getSelectedFile();
            final XStream xs = new XStream();
            try
            {
                final FileInputStream fileIn = new FileInputStream(file);
                try
                {
                    dungeon = (Dungeon) xs.fromXML(fileIn);
                    pickDefaultLevelAndRoom();
                }
                finally
                {
                    fileIn.close();
                }
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void updateNotes()
    {
        room.notes = notes.getText();
    }

    private void generateOccupants()
    {
        room.occupants = roomAssembler.build(Main.dice, level.powerLevel);
        refreshData();
        refresh();
    }
}
