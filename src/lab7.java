import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class lab7 {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Notifications and Activity");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        frame.getContentPane().setBackground(new Color(102, 102, 102)); 

        // General Section
        JCheckBox muteAll = new JCheckBox("Mute all notifications (except for calls and meetings)");
        muteAll.setForeground(Color.WHITE);
        muteAll.setBackground(new Color(0, 0, 0));

        // Sound Section
        JCheckBox playSound = new JCheckBox("Play sounds with notifications", true);
        JCheckBox playUrgentSound = new JCheckBox("Play sounds with urgent and priority contact notifications", true);
        JCheckBox playCallSound = new JCheckBox("Play sounds with incoming calls, requests to join, and meeting start notifications", true);
        JCheckBox playBusySound = new JCheckBox("Play sounds when I'm busy or in a meeting", true);

        // Display Section
        JCheckBox showPreviews = new JCheckBox("Show message and content previews in notifications", true);
        JCheckBox showDuringCalls = new JCheckBox("Show notifications during calls and meetings", true);

        // Set background and foreground for checkboxes
        JCheckBox[] checkboxes = {playSound, playUrgentSound, playCallSound, playBusySound, showPreviews, showDuringCalls};
        for (JCheckBox checkbox : checkboxes) {
            checkbox.setForeground(Color.WHITE);
            checkbox.setBackground(new Color(0, 0, 0));
        }

        // Item Listener to print selected option
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox source = (JCheckBox) e.getItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Selected: " + source.getText());
                }
            }
        };

        for (JCheckBox checkbox : checkboxes) {
            checkbox.addItemListener(listener);
        }

        muteAll.addItemListener(listener);

        // Add components to the frame
        frame.add(muteAll);
        frame.add(new JLabel("Sound Settings"));
        frame.add(playSound);
        frame.add(playUrgentSound);
        frame.add(playCallSound);
        frame.add(playBusySound);
        frame.add(new JLabel("Display Settings"));
        frame.add(showPreviews);
        frame.add(showDuringCalls);

        // Show the frame
        frame.setVisible(true);
    }
}