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
    public static Insets insets = new Insets(5,5,5,5 );
    public static Insets defaultInset = new Insets(0,0,0,0);

    //buttons that go in middle panel
    public JButton stressReleaseInfo;
    public JRadioButton stressReleaseYes, stressReleaseNo;
    public ButtonGroup stressReleaseGroup;
    public JButton surveyLineInfo;
    public JRadioButton surveyLineClass1, surveyLineClass2, surveyLineClass3;
    public ButtonGroup surveyLineGroup;
    public JButton retentiveUndercutInfo;
    public JRadioButton retentiveUndercut1, retentiveUndercut2;
    public ButtonGroup retentiveUndercutGroup;
    public JButton occlusionInfo;
    public JRadioButton occlusionMedial, occlusionDistal;
    public ButtonGroup occlusionGroup;
    public JButton softTissueUndercutInfo;
    public JRadioButton softTissueUndercutYes, softTissueUndercutNo;
    public ButtonGroup softTissueUndercutGroup;
    public JButton buccalVestib2mmInfo;
    public JRadioButton buccalVestib2mmYes, buccalVestib2mmNo;
    public ButtonGroup buccalVestib2mmGroup;
    public JButton estheticInfo;
    public JRadioButton estheticYes, estheticNo;
    public ButtonGroup estheticGroup;
    public JButton toothTypeInfo;
    public JRadioButton toothTypeAnterior, toothTypePremolar, toothTypeMolar;
    public ButtonGroup toothTypeGroup;

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

        //Can't add buttons from static context: can clean up if time later
        iBarMesial = new ClaspButton("I-Bar Clasp Mesial Rest");
        iBarDistal = new ClaspButton("I-Bar Clasp Distal Rest");
        iBarCingulum = new ClaspButton("I-Bar Clasp Cingulum Rest");
        modTBarMesial = new ClaspButton("Mod T-Bar Clasp Mesial Rest");
        modTBarDistal = new ClaspButton("Mod T-Bar Clasp Distal Rest");
        modTBarCingulum = new ClaspButton("Mod T-Bar Clasp Cingulum Rest");
        wwMesial = new ClaspButton("WW Clasp Mesial Rest");
        wwDistal = new ClaspButton("WW Clasp Distal Rest");
        wwCingulum =new ClaspButton("WW Clasp Cingulum Rest");
        ccMesial = new ClaspButton("CC Clasp Mesial Rest");
        ccDistal = new ClaspButton("CC Clasp Distal Rest");
        ccCingulum = new ClaspButton("CC Clasp Cingulum Rest");
        ring = new ClaspButton("Ring Clasp");


        //Add and activate clasp buttons
        ClaspGUI.addClaspButtons(this, c);

        //Add and activate buttons for patient criteria.
        ClaspGUI.addStressReleaseButtons(this, c);
        ClaspGUI.addSurveyLineButtons(this, c);
        ClaspGUI.addRetentiveUndercutButtons(this, c);
        ClaspGUI.addOcclusionButtons(this, c);
        ClaspGUI.addsoftTissueUndercutButtons(this, c);
        ClaspGUI.addBuccalVestibButtons(this, c);
        ClaspGUI.addEstheticConcernButtons(this, c);
        ClaspGUI.addToothTypeButtons(this, c);

        //Bug: Make Reset button Class that implements action listener, deactivating everything. Or, see if possible in button group.
        //ClaspGUI.addResetButton(this, c);

        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);

    }

    //
    class ClaspButton extends JButton implements ActionListener{
        public final String name;

        private ClaspButton(String input) {
            super(input);
            name = input;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Deactivate button if proper button is clicked.
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
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = insets;
        gui.middlePanel.add(gui.stressReleaseInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.stressReleaseGroup = new ButtonGroup();

        //add item listener to stress release info to open a new text window.

        gui.stressReleaseYes = new JRadioButton("Yes");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 0;
        gui.stressReleaseGroup.add(gui.stressReleaseYes);
        gui.middlePanel.add(gui.stressReleaseYes, c);

        //Bug: add item listener to StressRelease radio buttons to deactivate accordingly.
        //Bug: add insets to stress release items

        gui.stressReleaseNo = new JRadioButton("No");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 15;
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
        c.ipady = 45;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = insets;
        gui.middlePanel.add(gui.surveyLineInfo, c);
        //Bug:  add item listener to survey line info to open new text window.
        //Bug: add insets to survey line buttons.

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.surveyLineGroup = new ButtonGroup();

        //add Survey Line Classification Button 1
        gui.surveyLineClass1 = new JRadioButton("I");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 2;
        gui.surveyLineGroup.add(gui.surveyLineClass1);
        gui.middlePanel.add(gui.surveyLineClass1, c);

        //add Survey Line Classification Button 2
        gui.surveyLineClass2 = new JRadioButton("II");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 3;
        gui.surveyLineGroup.add(gui.surveyLineClass2);
        gui.middlePanel.add(gui.surveyLineClass2, c);

        //add Survey Line Classification Button 3
        gui.surveyLineClass3 = new JRadioButton("III");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 4;
        gui.surveyLineGroup.add(gui.surveyLineClass3);
        gui.middlePanel.add(gui.surveyLineClass3, c);
    }

    //Creates info button and radio buttons for Retentive Undercut choices
    private static void addRetentiveUndercutButtons(ClaspGUI gui, GridBagConstraints c){
        //Bug: make sure font for info buttons works.
        gui.retentiveUndercutInfo = new JButton("Retentive Undercut");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 7
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = insets;
        gui.middlePanel.add(gui.retentiveUndercutInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.retentiveUndercutGroup = new ButtonGroup();

        //add Retentive Undercut button 0.01"
        gui.retentiveUndercut1 = new JRadioButton("0.01\"");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 5;
        gui.retentiveUndercutGroup.add(gui.retentiveUndercut1);
        gui.middlePanel.add(gui.retentiveUndercut1, c);

        //add Retentive Undercut button 0.02"
        gui.retentiveUndercut2 = new JRadioButton("0.02\"");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 6;
        gui.retentiveUndercutGroup.add(gui.retentiveUndercut2);
        gui.middlePanel.add(gui.retentiveUndercut2, c);
    }

    //Creates info button and radio buttons for Occlusion choices
    private static void addOcclusionButtons(ClaspGUI gui, GridBagConstraints c) {
        //Bug: make sure font for info buttons works.
        gui.occlusionInfo = new JButton("Occlusion");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 9
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 7;
        c.insets = insets;
        gui.middlePanel.add(gui.occlusionInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.occlusionGroup = new ButtonGroup();

        //Add Occlusion = Medial radio button
        gui.occlusionMedial = new JRadioButton("Medial");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 7;
        gui.occlusionGroup.add(gui.occlusionMedial);
        gui.middlePanel.add(gui.occlusionMedial, c);

        //Add Occlusion= Distal radio button
        gui.occlusionDistal = new JRadioButton("Distal");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 8;
        gui.occlusionGroup.add(gui.occlusionDistal);
        gui.middlePanel.add(gui.occlusionDistal, c);
    }

    private static void addsoftTissueUndercutButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.softTissueUndercutInfo = new JButton("Soft Tissue Undercut");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 9;
        c.insets = insets;
        gui.middlePanel.add(gui.softTissueUndercutInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.softTissueUndercutGroup = new ButtonGroup();

        //Add Soft Tissue Undercut = Yes button
        gui.softTissueUndercutYes = new JRadioButton("Yes");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 9;
        gui.softTissueUndercutGroup.add(gui.softTissueUndercutYes);
        gui.middlePanel.add(gui.softTissueUndercutYes, c);

        //Add Soft Tissue Undercut = No button
        gui.softTissueUndercutNo = new JRadioButton("No");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 10;
        gui.softTissueUndercutGroup.add(gui.softTissueUndercutNo);
        gui.middlePanel.add(gui.softTissueUndercutNo, c);
    }

    //Creates info button and radio buttons for 2mm or more Buccal Vestibule choices
    private static void addBuccalVestibButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.buccalVestib2mmInfo = new JButton("2mm or More Buccal Vestibule");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 13
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 11;
        c.insets = insets;
        gui.middlePanel.add(gui.buccalVestib2mmInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.buccalVestib2mmGroup = new ButtonGroup();

        //Add 2mm or more Buccal Vestibule = Yes button
        gui.buccalVestib2mmYes = new JRadioButton("Yes");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 11;
        gui.buccalVestib2mmGroup.add(gui.buccalVestib2mmYes);
        gui.middlePanel.add(gui.buccalVestib2mmYes, c);

        //Add 2mm or more Buccal Vestibule = No button
        gui.buccalVestib2mmNo = new JRadioButton("No");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 12;
        gui.buccalVestib2mmGroup.add(gui.buccalVestib2mmNo);
        gui.middlePanel.add(gui.buccalVestib2mmNo, c);
    }

    //Creates info button and radio buttons for Esthetically concerned choices
    private static void addEstheticConcernButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.estheticInfo = new JButton("Esthetically Concerned Patient");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 15
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 13;
        c.insets = insets;
        gui.middlePanel.add(gui.estheticInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.estheticGroup = new ButtonGroup();

        //add Esthetically concerned = yes button
        gui.estheticYes = new JRadioButton("Yes");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 13;
        gui.estheticGroup.add(gui.estheticYes);
        gui.middlePanel.add(gui.estheticYes, c);

        //add Esthetically concerned = No button
        gui.estheticNo = new JRadioButton("No");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 14;
        gui.estheticGroup.add(gui.estheticNo);
        gui.middlePanel.add(gui.estheticNo, c);
    }

    //Creates info button and radio buttons for Tooth Type choices
    private static void addToothTypeButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.toothTypeInfo = new JButton("Tooth Type");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 3;
        c.ipady = 45;
        c.gridx = 0;
        c.gridy = 15;
        c.insets = insets;
        gui.middlePanel.add(gui.toothTypeInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.toothTypeGroup = new ButtonGroup();

        //add Esthetically concerned = yes button
        gui.toothTypeAnterior = new JRadioButton("Anterior");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 15;
        gui.toothTypeGroup.add(gui.toothTypeAnterior);
        gui.middlePanel.add(gui.toothTypeAnterior, c);

        //add Esthetically concerned = No button
        gui.toothTypePremolar = new JRadioButton("PreMolar");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 16;
        gui.toothTypeGroup.add(gui.toothTypePremolar);
        gui.middlePanel.add(gui.toothTypePremolar, c);

        //add Esthetically concerned = No button
        gui.toothTypeMolar = new JRadioButton("Molar");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 17;
        gui.toothTypeGroup.add(gui.toothTypeMolar);
        gui.middlePanel.add(gui.toothTypeMolar, c);

    }

    private static void addClaspButtons(ClaspGUI gui, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 175;
        c.ipady = 15;
        c.insets = insets;
        c.gridy = 0;
        c.gridheight = 1;

        //Add buttons to right panel in vertical order
        gui.rightPanel.add(gui.iBarMesial, c);
        c.gridy = 1;
        gui.rightPanel.add(gui.iBarDistal, c);
        c.gridy = 2;
        gui.rightPanel.add(gui.iBarCingulum, c);
        c.gridy = 3;
        gui.rightPanel.add(gui.modTBarMesial, c);
        c.gridy = 4;
        gui.rightPanel.add(gui.modTBarDistal, c);
        c.gridy = 5;
        gui.rightPanel.add(gui.modTBarCingulum, c);
        c.gridy = 6;
        gui.rightPanel.add(gui.wwMesial, c);
        c.gridy = 7;
        gui.rightPanel.add(gui.wwDistal, c);
        c.gridy = 8;
        gui.rightPanel.add(gui.wwCingulum, c);
        c.gridy = 9;
        gui.rightPanel.add(gui.ccMesial, c);
        c.gridy = 10;
        gui.rightPanel.add(gui.ccDistal, c);
        c.gridy = 11;
        gui.rightPanel.add(gui.ccCingulum, c);
        c.gridy = 12;
        gui.rightPanel.add(gui.ring, c);

    }

    private static void addResetButton(ClaspGUI gui, GridBagConstraints c) {
        c.gridy = GridBagConstraints.RELATIVE;
        c.gridx = 0;
        c.ipady = 5;
        c.ipadx = 40;

        c.anchor = GridBagConstraints.PAGE_END;
        c.weightx = 1.0;
        c.weighty = 1.0;

        //Bug: Reset button might need to implement Action Listener, right now, only finished layout.
        JButton reset = new JButton ("RESET");

        gui.rightPanel.add(reset, c);

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
