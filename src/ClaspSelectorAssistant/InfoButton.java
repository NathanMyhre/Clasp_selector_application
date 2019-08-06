package ClaspSelectorAssistant;

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


