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
