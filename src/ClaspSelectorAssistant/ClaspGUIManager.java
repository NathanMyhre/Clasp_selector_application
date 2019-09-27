package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Entry point into the Clasp Selector Assistant. Manages the opening of windows within application.
 */
public class ClaspGUIManager extends JFrame{
    JButton selectMultipleAbutments;
    JButton selectSingleAbutment;

    private JPanel entryPanel;
    private AbutmentTeethWindow abutmentTeethWindow;
    private ClaspGUI claspGUI;
    private ResultsWindow resultsWindow;

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    static boolean introWindowOpen = false;
    static boolean abutmentWindowOpen = false;
    static boolean claspGUIWindowOpen = false;
    static boolean resultsWindowOpen = false;

    //Bug: Make sure users can't pull up different selection windows at same time - e.g. Single and Multiple both open - will mess with database.
    //Bug: Want to make one single window and just repaint options as you proceed through process.

    /**
     * Constructs the main window for GUI management. Allows users to select single or multiple abutment teeth to start.
     */
    public ClaspGUIManager(String titleText){
        super(titleText);
        entryPanel = new JPanel(new GridBagLayout());
        entryPanel.setLayout(new GridBagLayout());
        abutmentTeethWindow = new AbutmentTeethWindow(this);
        claspGUI = new ClaspGUI(this);
        resultsWindow = new ResultsWindow(this);




        this.setPreferredSize(new Dimension(screenSize.width, screenSize.height));


        //Add button to select abutment teeth, and make active
        selectMultipleAbutments = new JButton("Proceed by selecting multiple abutments");
        selectMultipleAbutments.addActionListener((ActionListener) -> makeMultipleAbutWindow());

        //selectSingleAbutment = new JButton("Proceed by selecting a single abutment");
        //selectSingleAbutment.addActionListener((ActionListener) -> makeClaspGUIWindow());

        entryPanel.add(selectMultipleAbutments);
        //entryPanel.add(selectSingleAbutment);

    }

    /**
     * Opens the Options window for users to select specific criteria and narrow down clasp selection.
     */
    public void selectOptions() {
        makeClaspGUIWindow();   //Open options window.
    }

    public void getResults() {
        makeResultsWindow();
    }

    //Creates the window that allows multiple abutment teeth selections
    private void makeMultipleAbutWindow(){
        //ClaspBackEnd.clearData();           //Clear data upon entry to the selection process.
        setWindowBooleans(1);
        abutmentWindowOpen = true;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClaspGUIManager.this.getContentPane().remove(entryPanel);
                ClaspGUIManager.this.setContentPane(abutmentTeethWindow);
                ClaspGUIManager.this.pack();
                //AbutmentTeethWindow.createAndShowGUI();
            }
        });
        //Bug: I am not sure where to indicate abutmentWindowOpen as false - function completes when called.
    }

    //Creates the window that allows single abutment selection.
    private void makeClaspGUIWindow() {
        setWindowBooleans(2);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClaspGUIManager.this.getContentPane().remove(abutmentTeethWindow);
                ClaspGUIManager.this.setContentPane(claspGUI);
                ClaspGUIManager.this.pack();
                //ClaspGUI.createAndShowGUI();
            }
        });
        claspGUI.selectOptionsOnAbutments();
    }

    //Makes a new window for results
    private void makeResultsWindow() {
        setWindowBooleans(3);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClaspGUIManager.this.getContentPane().remove(claspGUI);
                ClaspGUIManager.this.setContentPane(resultsWindow);
                ClaspGUIManager.this.pack();
            }
        });
        resultsWindow.addComponentsToWindow();
    }

    /**
     * Restarts the clasp selection process from the start.
     * @param code determines whether to clear data or keep selections.
     */
    public void restartSelection(int code) {
        if (code == 0 ){
            ClaspBackEnd.clearData();
        }
        setWindowBooleans(0);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ClaspGUIManager.this.getContentPane().remove(resultsWindow);
                ClaspGUIManager.this.setContentPane(entryPanel);
                ClaspGUIManager.this.pack();
            }
        });
    }

    /**
     * Helper method to determine which window is open and set to true accordingly.
     * @param codeForBoolean integer code for determining logic: 0 = entry; 1 = AbutmentWindow; 2 = ClaspGUI window;
     *                       3 = Results window
     */
    private static void setWindowBooleans (int codeForBoolean) {
        if (codeForBoolean == 0) {
            introWindowOpen = true;
            abutmentWindowOpen = false;
            claspGUIWindowOpen = false;
            resultsWindowOpen = false;
        } else if (codeForBoolean == 1) {
            introWindowOpen = false;
            abutmentWindowOpen = true;
            claspGUIWindowOpen = false;
            resultsWindowOpen = false;
        } else if (codeForBoolean == 2) {
            introWindowOpen = false;
            abutmentWindowOpen = false;
            claspGUIWindowOpen = true;
            resultsWindowOpen = false;
        } else if (codeForBoolean == 3) {
            introWindowOpen = false;
            abutmentWindowOpen = false;
            claspGUIWindowOpen = false;
            resultsWindowOpen = true;
        } else {
            System.err.println("Invalid codeForBoolean");
        }
    }

    private static void makeFrameFullSize(JFrame aFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }

    /**
     * Creates and shows the GUI manager. This function executes via main().
     */
    public static void createAndShowGUI() {
        ClaspGUIManager claspGUIManagerFrame = new ClaspGUIManager("Clasp Selector Assistant");
        claspGUIManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        claspGUIManagerFrame.setContentPane(claspGUIManagerFrame.entryPanel);
        //makeFrameFullSize(claspGUIManagerFrame);
        //frame.setLocationByPlatform(true);
        claspGUIManagerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        claspGUIManagerFrame.pack();
        claspGUIManagerFrame.setVisible(true);
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
