package ClaspSelectorApplication;

//Notes to self: Key words to search in development:
    //Bug: Something that needs to be fixed later, or a feature that could be added later.
    //Javadoc: Something to note for Javadoc
    //Note: logic reminders

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClaspGUI extends JPanel{
    public JPanel leftPanel, middlePanel, rightPanel;

    //buttons that go in middle panel
    public JButton stressReleaseInfo;
    public JRadioButton stressReleaseYes, stressReleaseNo;
    public ButtonGroup stressReleaseGroup;
    public JButton surveyLineInfo;
    public JRadioButton surveyLineClass1, surveyLineClass2, surveyLineClass3;
    public ButtonGroup surveyLineGroup;
    public JButton retentiveUndercutInfo;
    public JRadioButton retentiveUndercut1, getRetentiveUndercut2;
    public JButton occlusionInfo;
    public JRadioButton occlusionMedial, occlusionDistal;
    public JButton softTissueUndercutInfo;
    public JRadioButton softTissueUndercutYes, softTissueUndercutNo;
    public JButton buccalVestib2mmInfo;
    public JRadioButton bucalVestib2mmYes, bucalVestib2mmNo;
    public JButton estheticInfo;
    public JRadioButton estheticYes, estheticNo;
    public JButton toothTypeInfo;
    public JRadioButton toothTypeAnterior, toothTypePremolar, toothTypeMolar;

    //buttons that go in right panel
    public ClaspButton iBarMesial;
    public ClaspButton iBarDistal;
    public ClaspButton iBarCingulum;
    public ClaspButton modTBarMesial;
    public ClaspButton modTBarDistal;
    public ClaspButton modTBarCingulum;
    public ClaspButton wwMesial;
    public ClaspButton wwDistal;
    public ClaspButton wwCingulum;
    public ClaspButton ccMesial;
    public ClaspButton ccDistal;
    public ClaspButton ccCingulum;
    public ClaspButton ring;



//Javadoc: 3 columns, 1 row. 1 JPanel per column
    //Javadoc: Jpanels: 1 cell = 20 height
    public ClaspGUI() {
        this.setLayout(new GridBagLayout());
        leftPanel = new JPanel(new GridBagLayout());
        middlePanel = new JPanel(new GridBagLayout());
        rightPanel = new JPanel(new GridBagLayout());

        //Note: create GBC now, and only change within static methods - scope keeps safe.
        GridBagConstraints c = new GridBagConstraints();

        //Add buttons and functionality to GUI.
        ClaspGUI.addStressReleaseButtons(this, c);
        ClaspGUI.addSurveyLineButtons(this, c);

        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);

    }

    //
    class ClaspButton extends JButton{
        public final String name;



        private ClaspButton(String input) {
            super(input);
            name = input;

        }

        private void openFile(){

        }
    }

    //Creates info button and radio buttons for Stress Release choices
    private static void addStressReleaseButtons(ClaspGUI gui, GridBagConstraints c){
        //add info button for Stress Release criteria
        gui.stressReleaseInfo = new JButton("Stress Release Needed");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;
        c.ipady = 40;
        c.gridx = 0;
        c.gridy = 0;
        gui.middlePanel.add(gui.stressReleaseInfo, c);

        //add item listener to stress release info to open a new text window.
        gui.stressReleaseGroup = new ButtonGroup();
        gui.stressReleaseYes = new JRadioButton("Yes");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 20;
        c.gridx = 1;
        c.gridy = 0;
        gui.stressReleaseGroup.add(gui.stressReleaseYes);
        gui.middlePanel.add(gui.stressReleaseYes, c);

        //Bug: add item listener to StressRelease radio buttons to deactivate accordingly.
        //Bug: add insets to stress release items

        gui.stressReleaseNo = new JRadioButton("No");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 20;
        c.gridx = 1;
        c.gridy = 1;
        gui.stressReleaseGroup.add(gui.stressReleaseNo);
        gui.middlePanel.add(gui.stressReleaseNo, c);

    }

    //Creates info button and radio buttons for Survey Line choices
    private static void addSurveyLineButtons(ClaspGUI gui, GridBagConstraints c){
        //Bug: make sure font for info buttons works.
        gui.surveyLineInfo = new JButton("Survey Line Classification");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 3;   //next gridy = 5
        c.ipady = 60;
        c.gridx = 0;
        c.gridy = 2;
        gui.middlePanel.add(gui.surveyLineInfo, c);
        //Bug:  add item listener to survey line info to open new text window.
        //Bug: add insets to survey line buttons.

        gui.surveyLineGroup = new ButtonGroup();

        //add Survey Line Classification Button 1
        gui.surveyLineClass1 = new JRadioButton("I");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 20;
        c.gridx = 1;
        c.gridy = 2;
        gui.surveyLineGroup.add(gui.surveyLineClass1);
        gui.middlePanel.add(gui.surveyLineClass1, c);

        //add Survey Line Classification Button 2
        gui.surveyLineClass2 = new JRadioButton("II");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 20;
        c.gridx = 1;
        c.gridy = 3;
        gui.surveyLineGroup.add(gui.surveyLineClass2);
        gui.middlePanel.add(gui.surveyLineClass2, c);

        //add Survey Line Classification Button 3
        gui.surveyLineClass3 = new JRadioButton("III");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 20;
        c.gridx = 1;
        c.gridy = 4;
        gui.surveyLineGroup.add(gui.surveyLineClass3);
        gui.middlePanel.add(gui.surveyLineClass3, c);
    }

    //Creates info button and radio buttons for Retentive Undercut choices
    private static void makeRetentiveUndercutButton(){

    }

    //Creates info button and radio buttons for Occlusion choices
    private static void makeOcclusionButton() {

    }

    //Creates info button and radio buttons for 2mm or more Buccal Vestibule choices
    private static void makeBuccalVestibButton() {

    }

    //Creates info button and radio buttons for Esthetically concerned choices
    private static void makeEstheticConcernButton() {

    }

    //Creates info button and radio buttons for Tooth Type choices
    private static void makeToothTypeButton() {


    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new ClaspGUI());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
