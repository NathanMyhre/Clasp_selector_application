package ClaspSelectorApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbutmentToothButton extends JButton implements ActionListener {
    ClaspGUI gui;
    String name;


    public AbutmentToothButton (String input, ClaspGUI g) {
        super(input);
        gui = g;
        name = "Abutment Tooth Selection";
    }

    @Override
    public void actionPerformed(ActionEvent e){
        ClaspGUI.openArchWindow(this);
    }
}
