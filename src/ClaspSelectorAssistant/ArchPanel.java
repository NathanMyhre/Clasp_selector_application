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
    static String archImagePath = "../resources/icons/ArchesCombined.PNG";
    ImageIcon archIcon;
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
        archIcon = createImageIcon(archImagePath, "Maxillary and Mandibular arches, US Numbering System");
        JLabel archIconLabel = new JLabel(archIcon);



        //maxillaryPanel = new ArchPicPanel(this, "maxillary");

        //Add listener to the archIcon image that responds appropriately for ClaspGUI
        archIconLabel.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                ArchPanel.this.toothClick(e.getX(), e.getY());
            }
        });


        GridBagConstraints constraint = new GridBagConstraints();

        //place components on panel, with an inset to separate from middle panel.
        Insets inset = new Insets(0,0, 0, 20);
        constraint.insets = inset;
        constraint.gridy = 0;
        this.add(archIconLabel, constraint);


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
        archIcon = createImageIcon(archImagePath, "Maxillary and Mandibular arches, US Numbering System");
        JLabel archIconLabel = new JLabel(archIcon);


        //maxillaryPanel = new ArchPicPanel(this, "maxillary");

        //Add listener to the archIcon image that responds appropriately for ClaspGUI
        archIconLabel.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                ArchPanel.this.toothClick(e.getX(), e.getY());
            }
        });

        GridBagConstraints constraint = new GridBagConstraints();

        //place components on panel, with an inset to separate from middle panel.
        Insets inset = new Insets(0,0, 0, 20);
        constraint.insets = inset;
        constraint.gridy = 0;
        this.add(archIconLabel, constraint);


        //this.add(mandibularPanel, constraint);
        //this.add();
        //this.add();

    }

    //Calculates if click is within a tooth's coordinate space.
    //Makes call to add abutment tooth to map if it is a valid tooth space.
    private void toothClick(int x, int y) {
        for (Integer i : ClaspBackEnd.teethMap.keySet()) {
            Tooth t = ClaspBackEnd.teethMap.get(i);
            if ((x > t.xLeft) && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {

                System.out.println("Tooth number is: " + t.usNumber);
                ClaspBackEnd.putAbutmentTooth(t);
                //if abutment teeth.contains tooth, remove from set
                //repaint so that circle is removed
                //if !abutmentTooth.contains(t)
                //System.out.println(teethDefs.get(teethMax.get(t)));
                //System.out.println(gui.radioButtons.get(teethDefs.get(teethMax.get(t))).myString());
                //claspGUI.radioButtonClicked(ClaspBackEnd.teethDefs.get(ClaspBackEnd.teethMax.get(t))); //Click the corresponding radio button.
                //claspGUI.radioButtons.get(ClaspBackEnd.teethDefs.get(ClaspBackEnd.teethMax.get(t))).setSelected(true);
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
