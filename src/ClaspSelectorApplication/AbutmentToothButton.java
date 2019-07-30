package ClaspSelectorApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbutmentToothButton extends JButton implements ActionListener {
    ClaspGUI gui;
    String name;
    ImageIcon mandibularArchPic;
    ImageIcon maxillaryArchPic;


    public AbutmentToothButton (String input, ClaspGUI g) {
        super(input);
        gui = g;
        name = "Abutment Tooth Selection";

    }

    @Override
    public void actionPerformed(ActionEvent e){
        ClaspGUI.openArchWindow(this, );
    }

    /**
     * Creates an ImageIcon if the path is valid.
     * @param path - resource path
     * @param description - description of the file
     */
    private static ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
