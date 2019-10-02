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

//For circles, blue for abutment selection
//Red to remember old selections


//Note: need to make documentation for ArchPanel
//Bug: need error reporting mechanisms
public class ArchPanel extends JPanel  {
    ClaspGUI claspGUI;
    AbutmentTeethWindow abutmentGUI;
    String guiType;
    JLayeredPane archPane;
    static String archImagePath = "../resources/icons/ArchesCombined.PNG";
    ImageIcon archIcon;
    ArchLabel archIconLabel;
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
        archIconLabel = new ArchLabel(archIcon, this);



        //maxillaryPanel = new ArchPicPanel(this, "maxillary");




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

    public ArchPanel(GridBagLayout layout, AbutmentTeethWindow gui) {
        //Bug: abutmentGUI or claspGUI can be null and potentially accessed, resulting in null pointer exception.
        //Bug: need better way to distinguish type of parent GUI that doesn't result in NPE.
        super(layout);
        abutmentGUI = gui;
        guiType = "AbutmentTeethWindow";
        archPane = new JLayeredPane();
        archPane.setPreferredSize(new Dimension(1000, 1000));

        //Make images of arches
        archIcon = createImageIcon(archImagePath, "Maxillary and Mandibular arches, US Numbering System");
        archIconLabel = new ArchLabel(archIcon, this);


        //maxillaryPanel = new ArchPicPanel(this, "maxillary");

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

class ArchLabel extends JLabel {
    ArchPanel parentPanel;
    ImageIcon archImage;

    Circle testCircle;

    static HashMap<Integer, Circle> circleMap = makeCircleMap();

    public ArchLabel(ImageIcon image, ArchPanel gui) {
        super(image);
        archImage = image;
        parentPanel = gui;

        //testCircle  = new Circle(89,322);
        //testCircle.setActiveBoolean();

        //Add listener to the archIcon image that responds appropriately for ClaspGUI
        this.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                ArchLabel.this.toothClick(e.getX(), e.getY());
            }
        });
    }

    //Make the mapping of numbers to circles. Allows us to activate and deactivate circles by looking up number.
    private static HashMap<Integer, Circle> makeCircleMap() {
        HashMap<Integer, Circle> circles = new HashMap<Integer,Circle>();
        Tooth usTooth;
        for (Integer usToothNumber = 1; usToothNumber < 33; usToothNumber++) {
            usTooth = ClaspBackEnd.teethMap.get(usToothNumber);
            circles.put(usToothNumber, new Circle(usTooth.xCenterPoint, usTooth.yCenterPoint));
        }

        return circles;
    }

    //Calculates if click is within a tooth's coordinate space.
    //Makes call to add abutment tooth to map if it is a valid tooth space.

    protected void toothClick(int x, int y) {
        for (Integer i : ClaspBackEnd.teethMap.keySet()) {
            Tooth t = ClaspBackEnd.teethMap.get(i);
            Circle thisCircle = circleMap.get(i);
            if ((x > t.xLeft) && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                thisCircle.setActiveBoolean();
                this.repaint(thisCircle.getX(),thisCircle.getY(),thisCircle.getWidth()+1,thisCircle.getHeight()+1);
                //System.out.println("Tooth number is: " + t.usNumber);
                parentPanel.abutmentGUI.setAbtRadioButton(i);
                ClaspBackEnd.putAbutmentTooth(t);

            }
        }
    }

    /**
     * Repaints tooth space from ArchLabel; removes circle if one already painted, or vice versa. Contains the exact code
     * as toothClick, but without adding a new tooth to the abutment list.
     * @param x x coordinate of "click"
     * @param y y coordinate of "click"
     */
    protected void toothRepaint(int x, int y) {
        for (Integer i : ClaspBackEnd.teethMap.keySet()) {
            Tooth t = ClaspBackEnd.teethMap.get(i);
            Circle thisCircle = circleMap.get(i);
            if ((x > t.xLeft) && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                thisCircle.setActiveBoolean();
                this.repaint(thisCircle.getX(),thisCircle.getY(),thisCircle.getWidth()+1,thisCircle.getHeight()+1);
                //System.out.println("Tooth number is: " + t.usNumber);
                parentPanel.abutmentGUI.setAbtRadioButton(i);
            }
        }
    }

    //all painting goes through here.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Integer index = 1; index < 33; index++) {
            circleMap.get(index).paintCircle(g);
        }
    }

}

/**
 * Opaque red circle used to highlight selected teeth
 */
class Circle  {
    private int xPos;
    private int yPos;
    private int width = 20;
    private int height = 20;
    private boolean active = false;
    private static Color transRed = new Color(1,0,0, 0.5f);
    private static Color clear = new Color(0,0,0,0.0f);

    public Circle(int xCenter, int yCenter) {
        xPos = xCenter - 10;
        yPos = yCenter - 10;
        //this.active = true;
    }

    public void setActiveBoolean(){
        if (active) {
            active = false;
        } else if (!active) {
            active = true;
        }
    }

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
        //If the circle is active, then paint a red circle over the space indicated by top left corner.
        //Place logic for selecting missing/abutment/saved teeth here.
        if (active) {
            g.setColor(Color.RED);
            g.fillOval(xPos,yPos,width,height);
            g.setColor(Color.BLACK);
            g.drawOval(xPos,yPos,width,height);
        }

    }

}
