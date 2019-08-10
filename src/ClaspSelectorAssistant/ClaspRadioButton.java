package ClaspSelectorAssistant;

/**
 * Provides a radio button selector for clasp criteria.
 * @author Nate J. Myhre
 * @version 1.0
 * @since 1.0
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClaspRadioButton extends JRadioButton implements ActionListener{
    String criteria;
    String value;
    ClaspGUI gui;

    public ClaspRadioButton (){
        super();
    }

    //Set the radio button to equal its required value, but remember the criteria and gui to which it belongs.
    public ClaspRadioButton (String c, String val, ClaspGUI myGUI) {
        super(val);
        criteria = c;
        value = val;
        gui = myGUI;
        this.setActionCommand(criteria + " ; " + value);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        gui.radioButtonClicked(input);
    }

    public String myString(){
        return (criteria + " ; " + value);
    }

}