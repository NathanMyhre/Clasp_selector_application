package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Entry point into the Clasp Selector Assistant. Manages the opening of windows within application.
 */
public class ClaspGUIManager extends JPanel{
    JButton selectMultipleAbutments;
    JButton selectSingleAbutment;

    static boolean abutmentWindowOpen = false;
    static boolean claspGUIWindowOpen = false;

    //Bug: Make sure users can't pull up different selection windows at same time - e.g. Single and Multiple both open - will mess with database.
    //Bug: Want to make one single window and just repaint options as you proceed through process.

    /**
     * Constructs the main window for GUI management. Allows users to select single or multiple abutment teeth to start.
     */
    public ClaspGUIManager(){
        this.setLayout(new GridBagLayout());

        //Add button to select abutment teeth, and make active
        selectMultipleAbutments = new JButton("Proceed by selecting multiple abutments");
        selectMultipleAbutments.addActionListener((ActionListener) -> makeMultipleAbutWindow());

        selectSingleAbutment = new JButton("Proceed by selecting a single abutment");
        selectSingleAbutment.addActionListener((ActionListener) -> makeClaspGUIWindow());

        this.add(selectMultipleAbutments);
        this.add(selectSingleAbutment);

    }

    /**
     * Opens the Options window for users to select specific criteria and narrow down clasp selection.
     */
    public static void selectOptions() {
        HashMap<Integer, Tooth> abutmentTeeth = ClaspBackEnd.selectedAbutmentTeeth;

        claspGUIWindowOpen = true;
        makeClaspGUIWindow();   //Open options window.
        //Proceed through abutment teeth in order via US tooth number. Since Keyset is unordered, must iterate through 32 ints.
        for (Integer usToothNum = 1; usToothNum < 33; usToothNum++) {
            if (!abutmentTeeth.containsKey(usToothNum)) {
                continue;
            } else if( abutmentTeeth.containsKey(usToothNum)) {
                //make sure options are available
                //add selected options to activeCriteria
                //if "Next tooth" clicked, add selections to total active criteria.
            } else {
                System.err.println("Unknown error sorting through selected abutment teeth.");
            }
        }
    }

    //Creates the window that allows multiple abutment teeth selections
    private static void makeMultipleAbutWindow(){
        ClaspBackEnd.clearData();           //Clear data upon entry to the selection process.
        abutmentWindowOpen = true;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AbutmentTeethWindow.createAndShowGUI();
            }
        });
        //Bug: I am not sure where to indicate abutmentWindowOpen as false - function completes when called.
    }

    //Creates the window that allows single abutment selection.
    private static void makeClaspGUIWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClaspGUI.createAndShowGUI();
            }
        });
    }

    /**
     * Creates and shows the GUI manager. This function executes via main().
     */
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
