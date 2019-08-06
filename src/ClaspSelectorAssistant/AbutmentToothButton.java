package ClaspSelectorAssistant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
   NOTE: Change AbutmentToothButton to a new class that embeds an image.
   We can use the example in SwingPainting.java to extend a JPanel and custom paint
   shapes over the image to select teeth. Define teeth as having specific coordinates
   and implement a mouse Listener to pass coordinates of a click to a method which compares
   the passed coordinates to the set ones. If equal to one of them, do some logic - e.g.
   pass the tooth information to GUI, informing Tooth Type and auto-selecting.

   To test, I can use a mouse listener and print out the coordinates to the terminal.

   Highly recommended to finish the custom painting tutorial in Swing Trail.
 */

public class AbutmentToothButton extends JButton implements ActionListener {
    ClaspGUI gui;
    String name;
    ImageIcon mandibularArchPic;
    ImageIcon maxillaryArchPic;


    public AbutmentToothButton (String input, ClaspGUI g) {
        super(input);
        gui = g;
        name = "Abutment Tooth Selection";
        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        ImageIcon mandibularArchPic = this.createImageIcon("images\\mandibular.PNG", "Mandibular Arch US numbering system");
        ImageIcon maxillaryArchPic = this.createImageIcon("images\\maxillary.PNG", "Maxillary Arch US numbering system");
        ClaspGUI.openArchWindow(this, maxillaryArchPic, mandibularArchPic);
    }

    /**
     * Creates an ImageIcon if the path is valid.
     * @param path - resource path
     * @param description - description of the file
     */
    private ImageIcon createImageIcon(String path,
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
