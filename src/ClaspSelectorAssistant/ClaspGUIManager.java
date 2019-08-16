package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.*;

public class ClaspGUIManager extends JPanel{
    JButton selectAbutmentTeeth;
    JButton selectOptions;


    public ClaspGUIManager(){
        this.setLayout(new GridBagLayout());

        //Add button to select abutment teeth, and make active
        selectAbutmentTeeth = new JButton("Proceed by selecting abutment teeth");
        selectAbutmentTeeth.addActionListener((ActionListener) -> makeAbutmentTeethWindow());

        selectOptions = new JButton("Proceed by selecting options");
        
        this.add(selectAbutmentTeeth);
        this.add(selectOptions);

    }

    //Creates the window that shows abutment teeth selection
    private static void makeAbutmentTeethWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AbutmentTeethWindow.createAndShowGUI();
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
