package ClaspSelectorAssistant;

/**
 * Provides a panel for selecting teeth - either abutment or missing teeth.
 * @author Nate J. Myhre
 * @version 1.0
 * @since 1.0
 */

import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;

//Note: need to make documentation for ArchPanel
//Bug: need error reporting mechanisms
public class ArchPanel extends JPanel  {
    ClaspGUI claspGUI;
    AbutmentTeethWindow abutmentGUI;
    String guiType;
    JLayeredPane archPane;
    static String maxillaryImagePath = "../resources/icons/maxillary.PNG";
    static String mandibularImagePath = "../resources/icons/mandibular.PNG";
    ImageIcon maxillaryIcon;
    ImageIcon mandibularIcon;
    //ArchPicPanel maxillaryPanel;
    //ArchPicPanel mandibularPanel;

    //Red Circle's xpos, ypos, width, and height
    int circleX = 50;
    int circleY = 50;
    int circleW = 20;
    int circleH = 20;

    Graphics redCircle;

    public ArchPanel(GridBagLayout layout, ClaspGUI g) {
        //add images
        //implement mouse listener
        //implement selection

        super(layout);
        claspGUI = g;
        guiType = "ClaspGUI";
        archPane = new JLayeredPane();
        archPane.setPreferredSize(new Dimension(1000, 1000));

        //Make images of arches
        mandibularIcon = createImageIcon(mandibularImagePath, "Mandibular Arch, US Numbering System");
        maxillaryIcon = createImageIcon(maxillaryImagePath, "Maxillary Arch, US Numbering System");
        JLabel maxillaryLabel = new JLabel(maxillaryIcon);
        JLabel mandibularLabel = new JLabel(mandibularIcon);


        //maxillaryPanel = new ArchPicPanel(this, "maxillary");

        //Add listener to the Maxillary image that responds appropriately for ClaspGUI
        maxillaryLabel.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArchPanel.this.maxillaClickClaspGUI(e.getX(), e.getY());
                //System.out.println(e.getX());
                //System.out.println(e.getY());
            }
        });

        //Add listener to the mandibular image that responds appropriately for ClaspGUI
        mandibularLabel.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArchPanel.this.mandibleClickClaspGUI(e.getX(), e.getY());
                //System.out.println(e.getX());
                //System.out.println(e.getY());
            }
        });

        GridBagConstraints constraint = new GridBagConstraints();

        //place components on panel, with an inset to separate from middle panel.
        Insets inset = new Insets(0,0, 0, 20);
        constraint.insets = inset;
        constraint.gridy = 0;
        this.add(maxillaryLabel, constraint);
        constraint.gridy = 1;
        this.add(mandibularLabel, constraint);

        //this.add(mandibularPanel, constraint);
        //this.add();
        //this.add();

    }

    public ArchPanel(GridBagLayout layout, AbutmentTeethWindow g) {
        //Bug: abutmentGUI or claspGUI can be null and potentially accessed, resulting in null pointer exception.
        //Bug: need better way to distinguish type of parent GUI that doesn't result in NPE.
        super(layout);
        abutmentGUI = g;
        guiType = "AbutmentTeethWindow";
        archPane = new JLayeredPane();
        archPane.setPreferredSize(new Dimension(1000, 1000));

        //Make images of arches
        mandibularIcon = createImageIcon(mandibularImagePath, "Mandibular Arch, US Numbering System");
        maxillaryIcon = createImageIcon(maxillaryImagePath, "Maxillary Arch, US Numbering System");
        JLabel maxillaryLabel = new JLabel(maxillaryIcon);
        JLabel mandibularLabel = new JLabel(mandibularIcon);


        //maxillaryPanel = new ArchPicPanel(this, "maxillary");

        //Add listener to the Maxillary image
        maxillaryLabel.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArchPanel.this.maxillaClickAbutmentGUI(e.getX(), e.getY());
                //System.out.println(e.getX());
                //System.out.println(e.getY());
            }
        });

        //Add listener to the mandibular image
        mandibularLabel.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ArchPanel.this.mandibleClickAbutmentGUI(e.getX(), e.getY());
                //System.out.println(e.getX());
                //System.out.println(e.getY());
            }
        });

        GridBagConstraints constraint = new GridBagConstraints();

        //place components on panel, with an inset to separate from middle panel.
        Insets inset = new Insets(0,0, 0, 20);
        constraint.insets = inset;
        constraint.gridy = 0;
        this.add(maxillaryLabel, constraint);
        constraint.gridy = 1;
        this.add(mandibularLabel, constraint);

        //this.add(mandibularPanel, constraint);
        //this.add();
        //this.add();

    }

    //Bug: need to figure out how to repaint image so that the red circle appears where clicked.
    //Helper method to decide which tooth is clicked on.
    private void maxillaClickClaspGUI (int x, int y) {
        //System.out.println("x is: " + x);
        //System.out.println("y is: " + y);
        for (tooth t : ClaspBackEnd.teethMax.keySet()) {
            /*System.out.println(ClaspBackEnd.teethMax.get(t));
            System.out.println(t);
            System.out.println(t.xLeft);
            System.out.println(t.xRight);
            System.out.println(t.yTop);
            System.out.println(t.yBottom);*/
            if ((x > t.xLeft)  && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                //System.out.println ("True");
                //System.out.println(teethDefs.get(teethMax.get(t)));
                //System.out.println(gui.radioButtons.get(teethDefs.get(teethMax.get(t))).myString());
                claspGUI.radioButtonClicked(ClaspBackEnd.teethDefs.get(ClaspBackEnd.teethMax.get(t))); //Click the corresponding radio button.
                claspGUI.radioButtons.get(ClaspBackEnd.teethDefs.get(ClaspBackEnd.teethMax.get(t))).setSelected(true);
                //repaint circle
                /*repaint(circleX, circleY, circleW, circleH);
                circleX = x;
                circleY = y;
                repaint(circleX, circleY, circleW, circleH);*/
            }
        }
    }

    //Helper method to decide which tooth is clicked on.
    //Maxilla and mandible are separately searched because they each have their own mouse listener
    private void mandibleClickClaspGUI (int x, int y) {
        //System.out.println("x is: " + x);
        //System.out.println("y is: " + y);
        for (tooth t : ClaspBackEnd.teethMan.keySet()) {

            if ((x > t.xLeft)  && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                //System.out.println ("True");
                //Click the corresponding radio button
                claspGUI.radioButtonClicked(ClaspBackEnd.teethDefs.get(ClaspBackEnd.teethMan.get(t)));
                claspGUI.radioButtons.get(ClaspBackEnd.teethDefs.get(ClaspBackEnd.teethMan.get(t))).setSelected(true);
                //repaint circle
                /*repaint(circleX, circleY, circleW, circleH);
                circleX = x;
                circleY = y;
                repaint(circleX, circleY, circleW, circleH);*/
            }
        }
    }

    //Helper method to decide which tooth is clicked on. Used in the AbutmentTooth Window
    //Avoids if/else logic at every radio button click.
    private void maxillaClickAbutmentGUI (int x, int y) {
        //System.out.println("x is: " + x);
        //System.out.println("y is: " + y);
        for (tooth t : ClaspBackEnd.teethMax.keySet()) {
            /*System.out.println(ClaspBackEnd.teethMax.get(t));
            System.out.println(t);
            System.out.println(t.xLeft);
            System.out.println(t.xRight);
            System.out.println(t.yTop);
            System.out.println(t.yBottom);*/
            if ((x > t.xLeft)  && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                //System.out.println ("True");
                Integer toothNumber = Integer.parseInt(t.name);
                abutmentGUI.abutmentRadioButtons.get(toothNumber).setSelected(true);
                //Add to Active Criteria - gets tooth type from the Integer number
                ClaspBackEnd.setActiveCriteria(ClaspBackEnd.teethDefs.get(toothNumber));
                System.out.println(ClaspBackEnd.activeCriteria.get("Tooth Type"));


                //repaint circle
                /*repaint(circleX, circleY, circleW, circleH);
                circleX = x;
                circleY = y;
                repaint(circleX, circleY, circleW, circleH);*/
            }
        }
    }

    private void mandibleClickAbutmentGUI (int x, int y) {
        //System.out.println("x is: " + x);
        //System.out.println("y is: " + y);
        for (tooth t : ClaspBackEnd.teethMan.keySet()) {

            if ((x > t.xLeft)  && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                //System.out.println ("True");
                //Click the corresponding radio button
                Integer toothNumber = Integer.parseInt(t.name);
                abutmentGUI.abutmentRadioButtons.get(toothNumber).setSelected(true);
                //Add to Active Criteria - gets tooth type from the Integer number
                ClaspBackEnd.setActiveCriteria(ClaspBackEnd.teethDefs.get(toothNumber));
                System.out.println(ClaspBackEnd.activeCriteria.get("Tooth Type"));
                //repaint circle
                /*repaint(circleX, circleY, circleW, circleH);
                circleX = x;
                circleY = y;
                repaint(circleX, circleY, circleW, circleH);*/
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Draw Text
        /*Color transparentRed = new Color(1f, 0f, 0f, 0.5f); //rgb (colors) a = transparency
        g.setColor(transparentRed); // fill space for rectangle
        g.fillRect(circleX, circleY, circleW, circleH);
        g.setColor(Color.BLACK); // draw outlines
        g.drawRect(circleX, circleY, circleW, circleH);*/

    }

    //Create an image icon for adding to a JLabel
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

    /*public Image createImage(String path,
                                     String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new Image(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }*/

}


/**
 * Opaque red circle used to highlight selected teeth
 */
class RedCircle  {
    private int xPos = 50;
    private int yPos = 50;
    private int width = 20;
    private int height = 20;

    public void setX(int xPos){
        this.xPos = xPos;
    }

    public int getX(){
        return xPos;
    }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void paintCircle(Graphics g){
        Color transRed = new Color(1,0,0, 0.5f);
        g.setColor(transRed);
        g.fillOval(xPos,yPos,width,height);
        g.setColor(Color.BLACK);
        g.drawOval(xPos,yPos,width,height);
    }

}
