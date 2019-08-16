package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

public class AbutmentTeethWindow extends JPanel{
    JPanel leftPanel;
    JPanel middlePanel;
    JPanel rightPanel;

    //Abutment tooth radio buttons
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

    ButtonGroup abTButtonGroup;

    HashMap<Integer, JRadioButton> abutmentRadioButtons;

    public AbutmentTeethWindow(){
        this.setLayout(new GridBagLayout());

        leftPanel = new JPanel(new GridBagLayout());
        rightPanel = new JPanel(new GridBagLayout());
        middlePanel = new JPanel(new GridBagLayout());

        //variable to set constraints in the window
        GridBagConstraints c = new GridBagConstraints();

        //Start adding abutment Radio Buttons to window
        abTButtonGroup = new ButtonGroup();
        abutmentRadioButtons = new HashMap<>();
        AbutmentTeethWindow.addAbutmentRadioButtons(this, c);
        /*Sets an actionListener to each button in the window. When clicked, each button looks at the Tooth definition
          dictionary in the Back End to figure out how to store data. Example: abT1 is tooth 1, which is Molar, so it
          looks up in the dictionary for Integer 1, and pulls back "Tooth Type ; Molar" as its result. This result is then
          stored in ActiveCriteria.

         */
        for (JRadioButton b : abutmentRadioButtons.values()) {
            abTButtonGroup.add(b);
            b.setActionCommand(b.getText());
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = ClaspBackEnd.teethDefs.get(Integer.parseInt(e.getActionCommand()));
                    ClaspBackEnd.setActiveCriteria(input);
                    System.out.println(ClaspBackEnd.teethDefs.get(Integer.parseInt(e.getActionCommand())));
                }
            });
        }

        middlePanel.add(new ArchPanel(new GridBagLayout(), this));
        rightPanel.add(new JButton("TEST"));


        this.add(leftPanel); this.add(middlePanel); this.add(rightPanel);
    }

    private static void addAbutmentRadioButtons(AbutmentTeethWindow gui, GridBagConstraints c) {
        //add text to left panel
        Insets inset = new Insets(5,5,5,20);
        c.insets = inset;
        c.gridy = 0;
        c.gridheight = 1;
        //add radio buttons to left panel
        c.gridy = 1;
        gui.abT1 = new JRadioButton("1");
        gui.leftPanel.add(gui.abT1, c);
        gui.abutmentRadioButtons.put(1,gui.abT1);

        c.gridy = 2;
        gui.abT2 = new JRadioButton("2");
        gui.leftPanel.add(gui.abT2, c);
        gui.abutmentRadioButtons.put(2,gui.abT2);

        c.gridy = 3;
        gui.abT3 = new JRadioButton("3");
        gui.leftPanel.add(gui.abT3, c);
        gui.abutmentRadioButtons.put(3,gui.abT3);

        c.gridy = 4;
        gui.abT4 = new JRadioButton("4");
        gui.leftPanel.add(gui.abT4, c);
        gui.abutmentRadioButtons.put(4,gui.abT4);

        c.gridy = 5;
        gui.abT5 = new JRadioButton("5");
        gui.leftPanel.add(gui.abT5, c);
        gui.abutmentRadioButtons.put(5,gui.abT5);

        c.gridy = 6;
        gui.abT6 = new JRadioButton("6");
        gui.leftPanel.add(gui.abT6, c);
        gui.abutmentRadioButtons.put(6,gui.abT6);

        c.gridy = 7;
        gui.abT7 = new JRadioButton("7");
        gui.leftPanel.add(gui.abT7, c);
        gui.abutmentRadioButtons.put(7,gui.abT7);

        c.gridy = 8;
        gui.abT8 = new JRadioButton("8");
        gui.leftPanel.add(gui.abT8, c);
        gui.abutmentRadioButtons.put(8,gui.abT8);

        c.gridy = 9;
        gui.abT9 = new JRadioButton("9");
        gui.leftPanel.add(gui.abT9, c);
        gui.abutmentRadioButtons.put(9,gui.abT9);

        c.gridy = 10;
        gui.abT10 = new JRadioButton("10");
        gui.leftPanel.add(gui.abT10, c);
        gui.abutmentRadioButtons.put(10,gui.abT10);

        c.gridy = 11;
        gui.abT11 = new JRadioButton("11");
        gui.leftPanel.add(gui.abT11, c);
        gui.abutmentRadioButtons.put(11,gui.abT11);

        c.gridy = 12;
        gui.abT12 = new JRadioButton("12");
        gui.leftPanel.add(gui.abT12, c);
        gui.abutmentRadioButtons.put(12,gui.abT12);

        c.gridy = 13;
        gui.abT13 = new JRadioButton("13");
        gui.leftPanel.add(gui.abT13, c);
        gui.abutmentRadioButtons.put(13,gui.abT13);
        c.gridy = 14;
        gui.abT14 = new JRadioButton("14");
        gui.leftPanel.add(gui.abT14, c);
        gui.abutmentRadioButtons.put(14,gui.abT14);

        c.gridy = 15;
        gui.abT15 = new JRadioButton("15");
        gui.leftPanel.add(gui.abT15, c);
        gui.abutmentRadioButtons.put(15,gui.abT15);

        c.gridy = 16;
        gui.abT16 = new JRadioButton("16");
        gui.leftPanel.add(gui.abT16, c);
        gui.abutmentRadioButtons.put(16,gui.abT16);

        c.gridy = 17;
        gui.abT17 = new JRadioButton("17");
        gui.rightPanel.add(gui.abT17, c);
        gui.abutmentRadioButtons.put(17,gui.abT17);

        c.gridy = 18;
        gui.abT18 = new JRadioButton("18");
        gui.rightPanel.add(gui.abT18, c);
        gui.abutmentRadioButtons.put( 18,gui.abT18);

        c.gridy = 19;
        gui.abT19 = new JRadioButton("19");
        gui.rightPanel.add(gui.abT19, c);
        gui.abutmentRadioButtons.put( 19,gui.abT19);

        c.gridy = 20;
        gui.abT20 = new JRadioButton("20");
        gui.rightPanel.add(gui.abT20, c);
        gui.abutmentRadioButtons.put( 20,gui.abT20);

        c.gridy = 21;
        gui.abT21 = new JRadioButton("21");
        gui.rightPanel.add(gui.abT21, c);
        gui.abutmentRadioButtons.put( 21,gui.abT21);

        c.gridy = 22;
        gui.abT22 = new JRadioButton("22");
        gui.rightPanel.add(gui.abT22, c);
        gui.abutmentRadioButtons.put( 22,gui.abT22);

        c.gridy = 23;
        gui.abT23 = new JRadioButton("23");
        gui.rightPanel.add(gui.abT23, c);
        gui.abutmentRadioButtons.put( 23,gui.abT23);

        c.gridy = 24;
        gui.abT24 = new JRadioButton("24");
        gui.rightPanel.add(gui.abT24, c);
        gui.abutmentRadioButtons.put( 24,gui.abT24);

        c.gridy = 25;
        gui.abT25 = new JRadioButton("25");
        gui.rightPanel.add(gui.abT25, c);
        gui.abutmentRadioButtons.put( 25,gui.abT25);

        c.gridy = 26;
        gui.abT26 = new JRadioButton("26");
        gui.rightPanel.add(gui.abT26, c);
        gui.abutmentRadioButtons.put( 26,gui.abT26);

        c.gridy = 27;
        gui.abT27 = new JRadioButton("27");
        gui.rightPanel.add(gui.abT27, c);
        gui.abutmentRadioButtons.put( 27,gui.abT27);

        c.gridy = 28;
        gui.abT28 = new JRadioButton("28");
        gui.rightPanel.add(gui.abT28, c);
        gui.abutmentRadioButtons.put( 28,gui.abT28);

        c.gridy = 29;
        gui.abT29 = new JRadioButton("29");
        gui.rightPanel.add(gui.abT29, c);
        gui.abutmentRadioButtons.put( 29,gui.abT29);

        c.gridy = 30;
        gui.abT30 = new JRadioButton("30");
        gui.rightPanel.add(gui.abT30, c);
        gui.abutmentRadioButtons.put( 30,gui.abT30);

        c.gridy = 31;
        gui.abT31 = new JRadioButton("31");
        gui.rightPanel.add(gui.abT31, c);
        gui.abutmentRadioButtons.put( 31,gui.abT31);

        c.gridy = 32;
        gui.abT32 = new JRadioButton("32");
        gui.rightPanel.add(gui.abT32, c);
        gui.abutmentRadioButtons.put( 32,gui.abT32);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Clasp Selector Assistant");
        //Bug: when closing an abutmentTeethWindow, we want active criteria to be cleared somehow. Could also ensure cleared when clicking on initial button choices.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new AbutmentTeethWindow());

        //frame.setLocationByPlatform(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
    }
}
