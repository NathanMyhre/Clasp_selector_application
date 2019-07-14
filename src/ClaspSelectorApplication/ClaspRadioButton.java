package ClaspSelectorApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ClaspRadioButton extends JRadioButton implements ActionListener {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //parse string via e.getActionCommand (I think)
        //If first string == criteria, then do x
        //If Second String == Value

        //Bug: what are the error values we expect?
        //Bug: Special character parsing is flimsy, is there a better way we can do this?
        String[] splitString = e.getActionCommand().split(" ; ");
        //Selection logic - send a message to the clasp GUI that this has been deactivated.
        ClaspGUI.setClaspCriteria(this.criteria, this.value, this.gui);
    }

}