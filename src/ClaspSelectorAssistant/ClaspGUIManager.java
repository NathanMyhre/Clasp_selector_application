package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.*;

/**
 * Entry point into the Clasp Selector Assistant. Manages the opening of windows within application.
 */
public class ClaspGUIManager extends JPanel{
    JButton selectMultipleAbutments;
    JButton selectSingleAbutment;

    //Bug: Make sure users can't pull up different selection windows at same time - e.g. Single and Multiple both open - will mess with database.

    /**
     * Constructs the main window for GUI management. Allows users to select single or multiple abutment teeth to start.
     */
    public ClaspGUIManager(){
        this.setLayout(new GridBagLayout());

        //Add button to select abutment teeth, and make active
        selectMultipleAbutments = new JButton("Proceed by selecting multiple abutments");
        selectMultipleAbutments.addActionListener((ActionListener) -> makeMultipleAbutWindow());

        selectSingleAbutment = new JButton("Proceed by selecting a single abutment");
        selectSingleAbutment.addActionListener((ActionListener) -> makeSingleAbutWindow());

        this.add(selectMultipleAbutments);
        this.add(selectSingleAbutment);

    }

    //Creates the window that allows multiple abutment teeth selections
    private static void makeMultipleAbutWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AbutmentTeethWindow.createAndShowGUI();
            }
        });
    }

    //Creates the window that allows single abutment selection.
    private static void makeSingleAbutWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClaspGUI.createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Clasp Selector Assistant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new ClaspGUIManager());

        //frame.setLocationByPlatform(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
