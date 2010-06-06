package the.trav.dnd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import the.trav.dnd.dungeon.Dungeon;
import the.trav.dnd.dungeon.DungeonLevel;
import the.trav.dnd.dungeon.DungeonPortal;
import the.trav.dnd.dungeon.DungeonRoom;

public class DungeonWidget extends Widget
{
    private static final long serialVersionUID = 1L;
    
    Dungeon dungeon;
    DungeonLevel level;
    DungeonRoom room;
    
    JComboBox levelSelect;
    JComboBox roomSelect;
    
    JTextArea notes = new JTextArea();
    JTextArea occupants = new JTextArea();
    JPanel exits = new JPanel();
    
    public DungeonWidget()
    {
        super();
        
        createJumpBar();
        
        createRoomPanel();
    }

    private void createRoomPanel()
    {
        JPanel roomPanel = new JPanel(new BorderLayout());
        
        JPanel roomNotes = new JPanel();
        roomNotes.setPreferredSize(new Dimension(300,200));
        roomNotes.add(new JScrollPane(notes));
        roomPanel.add(roomNotes, BorderLayout.WEST);
        
        JPanel roomOccupants = new JPanel();
        roomOccupants.setPreferredSize(new Dimension(300,200));
        roomOccupants.add(new JScrollPane(occupants));
        roomPanel.add(roomOccupants, BorderLayout.WEST);
        
        JPanel exitsPanel = new JPanel();
        exitsPanel.setPreferredSize(new Dimension(300,400));
        exitsPanel.add(new JScrollPane(exits));
        roomPanel.add(exitsPanel, BorderLayout.EAST);
        
        add(roomPanel, BorderLayout.CENTER);
    }

    private void createJumpBar()
    {
        JPanel jumpBar = new JPanel();
        JLabel level = new JLabel("Level:");
        jumpBar.add(level);
        levelSelect = new JComboBox();
        levelSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectLevel(levelSelect.getSelectedIndex());
            }

        });
        jumpBar.add(levelSelect);
        
        JButton newLevelButton = new JButton("+");
        newLevelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                newLevel();
            }
        });
        jumpBar.add(newLevelButton);
        
        JLabel rooms = new JLabel("Room:");
        jumpBar.add(rooms);
        roomSelect = new JComboBox();
        roomSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectRoom(roomSelect.getSelectedItem().toString());
            }
        });
        jumpBar.add(roomSelect);
        
        JButton newRoomButton = new JButton("+");
        newRoomButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                newRoom();
            }
        });
        jumpBar.add(newRoomButton);
        
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
    
    private void selectRoom(String selectedItem)
    {
        selectRoom(level.rooms.get(selectedItem));
    }
    
    private void selectLevel(int selectedIndex)
    {
        level = dungeon.levels.get(selectedIndex);
        selectRoom(level.rooms.values().iterator().next());
    }

    private void selectRoom(DungeonRoom room2)
    {
        refreshData();
        refresh();
    }
    
    private void refreshData()
    {
        //set room selection box
        roomSelect.removeAllItems();
        for(String room : level.rooms.keySet())
        {
            roomSelect.addItem(room);
        }
        roomSelect.setSelectedItem(String.valueOf(room.id));
        
        //set room notes
        notes.setText(room.notes);
        
        //set room occupants
        occupants.setText(room.occupants.toString());
        
        //set exit panel
        exits.removeAll();
        buildExitPanel();
    }

    private void buildExitPanel()
    {
        exits.add(new JLabel("Exits"), BorderLayout.NORTH);
        for(DungeonPortal exit : room.exits)
        {
            exits.add(buildExitPanel(exit));
        }
    }

    private Component buildExitPanel(DungeonPortal exit)
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel(String.valueOf(exit.type)));
        final String connectionId = String.valueOf(exit.connectsTo.id);
        panel.add(new JLabel(connectionId));
        JButton go = new JButton("go");
        go.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                selectRoom(connectionId);
            }
        });    
        panel.add(go);
        return panel;
    }
}