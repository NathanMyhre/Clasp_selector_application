package ClaspSelectorAssistant;

/**
 * Provides a button to open a window with a definition for clasp criterion.
 * @author Nate J. Myhre
 * @version 1.0
 * @since 1.0
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoButton extends JButton implements ActionListener {
    public String name;
    public String description;

    public InfoButton(String input) {
        super(input);
        name = input;
        description = ClaspGUI.definitions.get(input);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClaspGUI.makeInfoWindow(this);
    }
}


