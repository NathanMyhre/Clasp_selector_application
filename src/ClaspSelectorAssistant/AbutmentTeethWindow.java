package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class AbutmentTeethWindow extends JPanel{
    JPanel leftPanel;
    JPanel middlePanel;
    JPanel rightPanel;

    JRadioButton abT1;
    JRadioButton abT2;
    JRadioButton abT3;
    JRadioButton abT4;
    JRadioButton abT5;
    JRadioButton abT6;
    JRadioButton abT7;
    JRadioButton abT8;
    JRadioButton abT9;
    JRadioButton abT10;
    JRadioButton abT11;
    JRadioButton abT12;
    JRadioButton abT13;
    JRadioButton abT14;
    JRadioButton abT15;
    JRadioButton abT16;
    JRadioButton abT17;
    JRadioButton abT18;
    JRadioButton abT19;
    JRadioButton abT20;
    JRadioButton abT21;
    JRadioButton abT22;
    JRadioButton abT23;
    JRadioButton abT24;
    JRadioButton abT25;
    JRadioButton abT26;
    JRadioButton abT27;
    JRadioButton abT28;
    JRadioButton abT29;
    JRadioButton abT30;
    JRadioButton abT31;
    JRadioButton abT32;

    LinkedList<JRadioButton> abutmentRadioButtons;

    public AbutmentTeethWindow(){
        this.setLayout(new GridBagLayout());

        leftPanel = new JPanel();
        rightPanel = new JPanel();
        middlePanel = new JPanel();

        //variable to set constraints in the window
        GridBagConstraints c = new GridBagConstraints();

        //Start adding abutment Radio Buttons to window
        abutmentRadioButtons = new LinkedList<>();
        AbutmentTeethWindow.addAbutmentRadioButtons(this, c);
        for (JRadioButton b : abutmentRadioButtons) {
            b.setActionCommand(b.getText());
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = ClaspBackEnd.teethDefs.get(Integer.parseInt(e.getActionCommand()));
                    ClaspBackEnd.putActiveCriteria(input);
                }
            });
        }



        this.add(leftPanel); this.add(rightPanel); this.add(middlePanel);
    }

    private static void addAbutmentRadioButtons(AbutmentTeethWindow gui, GridBagConstraints c) {
        //add text to left panel
        c.gridx = 0;
        //add radio buttons to left panel
        c.gridx = 1;
        gui.abT1 = new JRadioButton("1");
        gui.leftPanel.add(gui.abT1);
        gui.abutmentRadioButtons.add(gui.abT1);

        gui.abT2 = new JRadioButton("2");
        gui.leftPanel.add(gui.abT2);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Clasp Selector Assistant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new AbutmentTeethWindow());

        //frame.setLocationByPlatform(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
    }
}
