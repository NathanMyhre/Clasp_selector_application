package ClaspSelectorApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ClaspRadioButton extends JRadioButton implements ActionListener{
    String criteria;
    String value;
    ClaspGUI gui;

    public ClaspRadioButton (){
        super();
    }

    //Set the radio button to equal its required value, but remember the criteria and gui to which it belongs.
    public ClaspRadioButton (String c, String value, ClaspGUI myGUI) {
        super(value);
        criteria = c;
        value = value;
        gui = myGUI;
        this.setActionCommand(criteria + " ; " + value);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        gui.radioButtonClicked(input);
    }

}