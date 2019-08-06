package ClaspSelectorAssistant;

import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

//Note: need to make documentation for AbutmentToothPanel
public class AbutmentToothPanel extends JLayeredPane  {
    ClaspGUI gui;
    ImageIcon maxillaryIcon;
    ImageIcon mandibularIcon;
    JLabel maxillaryLabel;
    JLabel mandibularLabel;




    //Red Circle's xpos, ypos, width, and height
    int circleX = 50;
    int circleY = 50;
    int circleW = 20;
    int circleH = 20;

    HashMap<InvisiSquare, Integer> teethMax;
    HashMap<InvisiSquare, Integer> teethMan;
    HashMap <Integer, String> teethDefs;

    //Teeth, labeled by the US numbering System
    InvisiSquare toothOne, toothTwo, toothThree, toothFour, toothFive, toothSix, toothSeven, toothEight;
    InvisiSquare toothNine, toothTen, toothEleven, toothTwelve, toothThirteen, toothFourteen, toothFifteen;
    InvisiSquare toothSixteen, toothSeventeen, toothEighteen, toothNineteen, toothTwenty, toothTwentyOne;
    InvisiSquare toothTwentyTwo, toothTwentyThree, toothTwentyFour, toothTwentyFive, toothTwentySix;
    InvisiSquare toothTwentySeven, toothTwentyEight, toothTwentyNine, toothThirty, toothThirtyOne, toothThirtyTwo;

    Graphics redCircle;

    public AbutmentToothPanel(GridBagLayout layout, ClaspGUI g) {
        //add images
        //implement mouse listener
        //implement selection

        super();
        this.setLayout(layout);
        gui = g;

        mandibularIcon = this.createImageIcon("images\\mandibular.PNG", "Mandibular Arch US numbering system");
        maxillaryIcon = this.createImageIcon("images\\maxillary.PNG", "Maxillary Arch US numbering system");
        maxillaryLabel = new JLabel(maxillaryIcon);
        mandibularLabel = new JLabel(mandibularIcon);

        //Make new teeth and add them to the list to be remembered.
        //Maxilla teeth
        teethMax = new HashMap<InvisiSquare, Integer>();
        toothOne = new InvisiSquare(57, 98, 306, 328); teethMax.put(toothOne, 1);
        toothTwo = new InvisiSquare(57, 92, 260, 285); teethMax.put(toothTwo, 2);
        toothThree = new InvisiSquare(59, 103, 207, 240); teethMax.put(toothThree,3);
        toothFour = new InvisiSquare(76, 102, 165,186); teethMax.put(toothFour, 4);
        toothFive = new InvisiSquare(90, 119, 132, 153); teethMax.put(toothFive,5);
        toothSix = new InvisiSquare(108, 134, 96, 117); teethMax.put(toothSix, 6);
        toothSeven = new InvisiSquare(134, 166, 67, 101); teethMax.put(toothSeven, 7);
        toothEight = new InvisiSquare(170, 207, 51, 91); teethMax.put(toothEight, 8);
        toothNine = new InvisiSquare(218, 257, 48, 92); teethMax.put(toothNine, 9);
        toothTen = new InvisiSquare(262, 292, 65, 101); teethMax.put(toothTen, 10);
        toothEleven = new InvisiSquare(290,322,94,120); teethMax.put(toothEleven, 11);
        toothTwelve = new InvisiSquare(303, 344, 130,155); teethMax.put(toothTwelve, 12);
        toothThirteen = new InvisiSquare( 316,352,165,188); teethMax.put(toothThirteen,13);
        toothFourteen = new InvisiSquare(316,368,203,241); teethMax.put(toothFourteen, 14);
        toothFifteen = new InvisiSquare(325,377,257,290); teethMax.put(toothFifteen, 15);
        toothSixteen = new InvisiSquare(330,384,303,336); teethMax.put(toothSixteen,16);

        //Mandible teeth
        teethMan = new HashMap<InvisiSquare, Integer>();
        toothSeventeen = new InvisiSquare(344, 389, 47,91); teethMan.put(toothSeventeen, 17);
        toothEighteen = new InvisiSquare(334,384,100,150); teethMan.put(toothEighteen, 18);
        toothNineteen = new InvisiSquare(320,369,156,210);teethMan.put(toothNineteen, 19);
        toothTwenty = new InvisiSquare(311,353,210,252); teethMan.put(toothTwenty, 20);
        toothTwentyOne = new InvisiSquare(300,343,248,287); teethMan.put(toothTwentyOne, 21);
        toothTwentyTwo = new InvisiSquare(284,315,285,321);teethMan.put(toothTwentyTwo, 22);
        toothTwentyThree = new InvisiSquare(258,283,301,333);teethMan.put(toothTwentyThree, 23);
        toothTwentyFour = new InvisiSquare(229,254,307,338);teethMan.put(toothTwentyFour,24);
        toothTwentyFive = new InvisiSquare(200,220,306,336);teethMan.put(toothTwentyFive, 25);
        toothTwentySix = new InvisiSquare(171,191,303,335);teethMan.put(toothTwentySix, 26);
        toothTwentySeven = new InvisiSquare(133,161,295,320);teethMan.put(toothTwentySeven, 27);
        toothTwentyEight = new InvisiSquare(113,151,259,282);teethMan.put(toothTwentyEight, 28);
        toothTwentyNine = new InvisiSquare(95,140,220,244);teethMan.put(toothTwentyNine,29);
        toothThirty = new InvisiSquare(74,134,159,205);teethMan.put(toothThirty, 30);
        toothThirtyOne = new InvisiSquare(63,122,100,150);teethMan.put(toothThirtyOne,31);
        toothThirtyTwo = new InvisiSquare(59,114,48,95);teethMan.put(toothThirtyTwo, 32);

        //Place tooth definitions.
        teethDefs = new HashMap<Integer, String>();
        teethDefs.put(1,"Tooth Type ; Molar");
        teethDefs.put(2,"Tooth Type ; Molar");
        teethDefs.put(3,"Tooth Type ; Molar");
        teethDefs.put(14, "Tooth Type ; Molar");
        teethDefs.put(15,"Tooth Type ; Molar");
        teethDefs.put(16, "Tooth Type ; Molar");
        teethDefs.put(17, "Tooth Type ; Molar");
        teethDefs.put(18, "Tooth Type ; Molar");
        teethDefs.put(19,"Tooth Type ; Molar");
        teethDefs.put(30,"Tooth Type ; Molar");
        teethDefs.put(31,"Tooth Type ; Molar");
        teethDefs.put(32,"Tooth Type ; Molar");
        teethDefs.put(4,"Tooth Type ; PreMolar");
        teethDefs.put(5,"Tooth Type ; PreMolar");
        teethDefs.put(12,"Tooth Type ; PreMolar");
        teethDefs.put(13,"Tooth Type ; PreMolar");
        teethDefs.put(20,"Tooth Type ; PreMolar");
        teethDefs.put(21,"Tooth Type ; PreMolar");
        teethDefs.put(28,"Tooth Type ; PreMolar");
        teethDefs.put(29,"Tooth Type ; PreMolar");
        teethDefs.put(6,"Tooth Type ; Anterior");
        teethDefs.put(7,"Tooth Type ; Anterior");
        teethDefs.put(8,"Tooth Type ; Anterior");
        teethDefs.put(9,"Tooth Type ; Anterior");
        teethDefs.put(10,"Tooth Type ; Anterior");
        teethDefs.put(11,"Tooth Type ; Anterior");
        teethDefs.put(22,"Tooth Type ; Anterior");
        teethDefs.put(23,"Tooth Type ; Anterior");
        teethDefs.put(24,"Tooth Type ; Anterior");
        teethDefs.put(25,"Tooth Type ; Anterior");
        teethDefs.put(26,"Tooth Type ; Anterior");
        teethDefs.put(27,"Tooth Type ; Anterior");

        //"Tooth Type ; Anterior"
        //"Tooth Type ; PreMolar"
        //"Tooth Type ; Molar"

        //Add listener to the Maxillary image
        maxillaryLabel.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                AbutmentToothPanel.this.maxillaClick(e.getX(), e.getY());
                //System.out.println(e.getX());
                //System.out.println(e.getY());
            }
        });

        //Add listener to the mandibular image
        mandibularLabel.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                AbutmentToothPanel.this.mandibleClick(e.getX(), e.getY());
                //System.out.println(e.getX());
                //System.out.println(e.getY());
            }
        });

        GridBagConstraints constraint = new GridBagConstraints();

        //place components on panel, with an inset to separate from middle panel.
        Insets inset = new Insets(0,0, 0, 20);
        constraint.insets = inset;
        constraint.gridy = 0;
        this.add(maxillaryLabel, constraint, 1);
        constraint.gridy = 1;
        this.add(mandibularLabel, constraint, 1);
        //this.add();
        //this.add();
    }

    //Bug: need to figure out how to repaint image so that the red circle appears where clicked.
    //Helper method to decide which tooth is clicked on.
    private void maxillaClick (int x, int y) {
        //System.out.println("x is: " + x);
        //System.out.println("y is: " + y);
        for (InvisiSquare t : teethMax.keySet()) {
            /*System.out.println(t.xLeft);
            System.out.println(t.xRight);
            System.out.println(t.yTop);
            System.out.println(t.yBottom);*/
            if ((x > t.xLeft)  && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                //System.out.println ("True");
                //System.out.println(teethDefs.get(teethMax.get(t)));
                //System.out.println(gui.radioButtons.get(teethDefs.get(teethMax.get(t))).myString());
                gui.radioButtonClicked(teethDefs.get(teethMax.get(t))); //Click the corresponding radio button.
                gui.radioButtons.get(teethDefs.get(teethMax.get(t))).setSelected(true);
                repaint(circleX, circleY, circleW, circleH);
                circleX = x;
                circleY = y;
                repaint(circleX, circleY, circleW, circleH);
            }
        }
    }

    //Helper method to decide which tooth is clicked on.
    //Maxilla and mandible are separately searched because they each have their own mouse listener
    private void mandibleClick (int x, int y) {
        //System.out.println("x is: " + x);
        //System.out.println("y is: " + y);
        for (InvisiSquare t : teethMan.keySet()) {

            if ((x > t.xLeft)  && (x < t.xRight) && (y > t.yBottom) && (y < t.yTop)) {
                //System.out.println ("True");
                //Click the corresponding radio button
                gui.radioButtonClicked(teethDefs.get(teethMan.get(t)));
                gui.radioButtons.get(teethDefs.get(teethMan.get(t))).setSelected(true);
                repaint(circleX, circleY, circleW, circleH);
                circleX = x;
                circleY = y;
                repaint(circleX, circleY, circleW, circleH);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        Color transparentRed = new Color(1f, 0f, 0f, 0.5f); //rgb (colors) a = transparency
        g.setColor(transparentRed); // fill space for rectangle
        g.fillRect(circleX, circleY, circleW, circleH);
        g.setColor(Color.BLACK); // draw outlines
        g.drawRect(circleX, circleY, circleW, circleH);

    }

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

class InvisiSquare {
    public final int xLeft;
    public final int xRight;
    public final int yTop;
    public final int yBottom;

    public InvisiSquare(int xL, int xR, int yB, int yT) {
        xLeft = xL;
        xRight = xR;
        yBottom = yB;
        yTop = yT;
    }
}