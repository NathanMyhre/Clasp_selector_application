package ClaspSelectorAssistant;

/**
 * Graphical User Interface for selecting prostho-orthodontic builds
 * @author Nate J. Myhre
 * @version 1.0
 * @since 1.0
 */

//Notes to self: Key words to search in development:
//Bug: Something that needs to be fixed later, or a feature that could be added later.
//Javadoc: Something to note for Javadoc
//Note: logic reminders

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.HashMap;

//Bug: need a data container class to manage the stored data between clasp windows.
//Note: make a list of data structures that I need for making a data storage class.

/** Bug: Javadoc for fields
 * ClaspGUI is the interface for selecting options per selected abutment tooth. ClaspGUI is also referred to as Options window.
 */
public class ClaspGUI extends JPanel{
    private static JFrame claspGUIFrame = new JFrame ("Options Selection by Abutment");
    public ClaspGUIManager guiManager;

    private JPanel leftPanel;
    private JPanel middlePanel, rightPanel;

    private static Insets insets = new Insets(5,5,5,5 );
    private static Insets defaultInset = new Insets(0,0,0,0);
    private ImageIcon arches;
    private static boolean noValidClasps = false;

    //buttons that go in middle pane
    private InfoButton stressReleaseInfo;
    private InfoButton surveyLineInfo;
    private InfoButton retentiveUndercutInfo;
    private InfoButton occlusionInfo;
    private InfoButton softTissueUndercutInfo;
    private InfoButton buccalVestib2mmInfo;
    private InfoButton estheticInfo;
    private InfoButton toothTypeInfo;

    private ClaspRadioButton stressReleaseYes, stressReleaseNo;
    private ClaspRadioButton surveyLineClass1, surveyLineClass2, surveyLineClass3;
    private ClaspRadioButton retentiveUndercut1, retentiveUndercut2;
    private ClaspRadioButton occlusionMesial, occlusionDistal;
    private ClaspRadioButton softTissueUndercutYes, softTissueUndercutNo;
    private ClaspRadioButton buccalVestib2mmYes, buccalVestib2mmNo;
    private ClaspRadioButton estheticYes, estheticNo;
    private ClaspRadioButton toothTypeAnterior, toothTypePremolar, toothTypeMolar;

    private ButtonGroup stressReleaseGroup;
    private ButtonGroup surveyLineGroup;
    private ButtonGroup retentiveUndercutGroup;
    private ButtonGroup occlusionGroup;
    private ButtonGroup softTissueUndercutGroup;
    private ButtonGroup buccalVestib2mmGroup;
    private ButtonGroup estheticGroup;
    private ButtonGroup toothTypeGroup;

    //buttons that go in right panel
    private ClaspButton iBarMesial;
    private ClaspButton iBarDistal;
    private ClaspButton iBarCingulum;
    private ClaspButton modTBarMesial;
    private ClaspButton modTBarDistal;
    private ClaspButton modTBarCingulum;
    private ClaspButton wwMesial;
    private ClaspButton wwDistal;
    private ClaspButton wwCingulum;
    private ClaspButton ccMesial;
    private ClaspButton ccDistal;
    private ClaspButton ccCingulum;
    private ClaspButton ring;
    private JButton reset;
    private JButton previousButton;
    private JButton nextButton;
    private JButton finishButton;

    private HashMap<String, String> activeCriteria;     //Links tooth options to values and stores for later

    //Data structures to hold buttons
    LinkedList<ClaspButton> buttons;
    HashMap<String, ClaspRadioButton> radioButtons;
    LinkedList<ButtonGroup> buttonGroups;

    //Bug: make sure previous is disabled when currentAbutment is 0.
    static int currentAbutment = 0;

    //Javadoc: 3 columns, 1 row. 1 JPanel per column
    //Javadoc: Jpanels: 1 cell = 20 height
    public ClaspGUI(ClaspGUIManager gui) {
        guiManager = gui;
        this.setLayout(new GridBagLayout());
        leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setPreferredSize(new Dimension(500, 1000));
        middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setPreferredSize(new Dimension (500, 1000));
        rightPanel = new JPanel(new GridBagLayout());

        //create images arches
        //Bug: need to implement painting on arches.
        arches = createImageIcon("../resources/icons/ArchesCombined.PNG",
                "Maxillary and Mandibular arches, US Numbering System");
        JLabel archLabel = new JLabel(arches);
        leftPanel.add(archLabel);

        //Note: create GBC now, and only change within static methods - scope keeps safe.
        GridBagConstraints c = new GridBagConstraints();

        //Map of active criteria

        //List of all clasp buttons for checking criteria
        buttons = new LinkedList<ClaspButton>();
        radioButtons = new HashMap<String, ClaspRadioButton>();
        buttonGroups = new LinkedList<ButtonGroup>();

        //Add Left most buttons to GUI
        //addLeftHandButtons(this, c);

        //initialize buttons and add them to the button List
        iBarMesial = ClaspButton.factory("I-Bar Clasp Mesial Rest", this); buttons.add(iBarMesial);
        iBarDistal = ClaspButton.factory("I-Bar Clasp Distal Rest", this); buttons.add(iBarDistal);
        iBarCingulum = ClaspButton.factory("I-Bar Clasp Cingulum Rest", this); buttons.add(iBarCingulum);
        modTBarMesial = ClaspButton.factory("Mod T-Bar Clasp Mesial Rest", this); buttons.add(modTBarMesial);
        modTBarDistal = ClaspButton.factory("Mod T-Bar Clasp Distal Rest", this); buttons.add(modTBarDistal);
        modTBarCingulum = ClaspButton.factory("Mod T-Bar Clasp Cingulum Rest", this); buttons.add(modTBarCingulum);
        wwMesial = ClaspButton.factory("WW Clasp Mesial Rest", this); buttons.add(wwMesial);
        wwDistal = ClaspButton.factory("WW Clasp Distal Rest", this); buttons.add(wwDistal);
        wwCingulum =ClaspButton.factory("WW Clasp Cingulum Rest", this); buttons.add(wwCingulum);
        ccMesial = ClaspButton.factory("CC Clasp Mesial Rest", this); buttons.add(ccMesial);
        ccDistal = ClaspButton.factory("CC Clasp Distal Rest", this); buttons.add(ccDistal);
        ccCingulum = ClaspButton.factory("CC Clasp Cingulum Rest", this); buttons.add(ccCingulum);
        ring = ClaspButton.factory("Ring Clasp", this); buttons.add(ring);
        reset = new JButton("RESET");
        reset.addActionListener((ActionListener) -> ClaspGUI.this.resetButtons());
        previousButton = new JButton("PREVIOUS");
        //previousButton.addActionListener((ActionListener) -> pressPreviousButton(ClaspGUI.this);
        nextButton = new JButton("NEXT");
        nextButton.addActionListener((ActionListener) -> pressNextButton());
        finishButton = new JButton("FINISH");


        //Add and place clasp buttons to GUI
        ClaspGUI.addClaspButtons(this, c);

        //Add and place radio buttons for patient selection criteria
        c.gridwidth = 1;
        ClaspGUI.addStressReleaseButtons(this, c);
        ClaspGUI.addSurveyLineButtons(this, c);
        ClaspGUI.addRetentiveUndercutButtons(this, c);
        ClaspGUI.addOcclusionButtons(this, c);
        ClaspGUI.addsoftTissueUndercutButtons(this, c);
        ClaspGUI.addBuccalVestibButtons(this, c);
        ClaspGUI.addEstheticConcernButtons(this, c);
        ClaspGUI.addToothTypeButtons(this, c);

        //Add Radio buttons and button groups to lists for use later if needed.
        radioButtons.put("Stress Release Needed ; Yes", stressReleaseYes); radioButtons.put("Stress Release Needed ; No", stressReleaseNo);
        radioButtons.put("Survey Line Classification ; I", surveyLineClass1); radioButtons.put("Survey Line Classification ; II", surveyLineClass2);
        radioButtons.put("Survey Line Classification ; II", surveyLineClass3); radioButtons.put("Retentive Undercut ; 0.01\"", retentiveUndercut1);
        radioButtons.put("Retentive Undercut ; 0.02\"", retentiveUndercut2); radioButtons.put("Occlusion ; Distal", occlusionDistal);
        radioButtons.put("Occlusion ; Medial", occlusionMesial); radioButtons.put("Soft Tissue Undercut ; Yes", softTissueUndercutYes);
        radioButtons.put("Soft Tissue Undercut ; No",softTissueUndercutNo); radioButtons.put("2mm or More Buccal Vestibule ; Yes", buccalVestib2mmYes);
        radioButtons.put("2mm or More Buccal Vestibule ; No", buccalVestib2mmNo); radioButtons.put("Esthetically Concerned Patient ; Yes", estheticYes);
        radioButtons.put("Esthetically Concerned Patient ; No", estheticNo); radioButtons.put("Tooth Type ; Anterior",toothTypeAnterior);
        radioButtons.put("Tooth Type ; Molar", toothTypeMolar); radioButtons.put("Tooth Type ; PreMolar", toothTypePremolar);

        buttonGroups.add(stressReleaseGroup); buttonGroups.add(surveyLineGroup); buttonGroups.add(retentiveUndercutGroup);
        buttonGroups.add(occlusionGroup); buttonGroups.add(softTissueUndercutGroup); buttonGroups.add(buccalVestib2mmGroup);
        buttonGroups.add(estheticGroup); buttonGroups.add(toothTypeGroup);

        //Add the three thirds of the GUI.
        c.gridx = 0;
        this.add(leftPanel);
        c.gridx = 1;
        this.add(middlePanel);
        c.gridx = 2;
        this.add(rightPanel);

        //selectOptionsOnAbutments();
    }


    //Creates info button and radio buttons for Stress Release choices
    private static void addStressReleaseButtons(ClaspGUI gui, GridBagConstraints c){
        //add info button for Stress Release criteria
        gui.stressReleaseInfo = new InfoButton("Stress Release Needed");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = insets;
        gui.middlePanel.add(gui.stressReleaseInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.stressReleaseGroup = new ButtonGroup();

        //add item listener to stress release info to open a new text window.

        gui.stressReleaseYes = new ClaspRadioButton("Stress Release Needed", "Yes", gui);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 3;
        gui.stressReleaseGroup.add(gui.stressReleaseYes);
        gui.middlePanel.add(gui.stressReleaseYes, c);

        //Bug: add item listener to StressRelease radio buttons to deactivate accordingly.
        //Bug: add insets to stress release items

        gui.stressReleaseNo = new ClaspRadioButton("Stress Release Needed", "No", gui);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 4;
        gui.stressReleaseGroup.add(gui.stressReleaseNo);
        gui.middlePanel.add(gui.stressReleaseNo, c);

    }

    //Creates info button and radio buttons for Survey Line choices
    private static void addSurveyLineButtons(ClaspGUI gui, GridBagConstraints c){
        //Bug: make sure font for info buttons works.
        gui.surveyLineInfo = new InfoButton("Survey Line Classification");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 3;   //next gridy = 5
        c.ipady = 45;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = insets;
        gui.middlePanel.add(gui.surveyLineInfo, c);
        //Bug:  add item listener to survey line info to open new text window.
        //Bug: add insets to survey line buttons.

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.surveyLineGroup = new ButtonGroup();

        //add Survey Line Classification Button 1
        gui.surveyLineClass1 = new ClaspRadioButton("Survey Line Classification", "I", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 5;
        gui.surveyLineGroup.add(gui.surveyLineClass1);
        gui.middlePanel.add(gui.surveyLineClass1, c);

        //add Survey Line Classification Button 2
        gui.surveyLineClass2 = new ClaspRadioButton("Survey Line Classification", "II", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 6;
        gui.surveyLineGroup.add(gui.surveyLineClass2);
        gui.middlePanel.add(gui.surveyLineClass2, c);

        //add Survey Line Classification Button 3
        gui.surveyLineClass3 = new ClaspRadioButton("Survey Line Classification", "III", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 7;
        gui.surveyLineGroup.add(gui.surveyLineClass3);
        gui.middlePanel.add(gui.surveyLineClass3, c);
    }

    //Creates info button and radio buttons for Retentive Undercut choices
    private static void addRetentiveUndercutButtons(ClaspGUI gui, GridBagConstraints c){
        //Bug: make sure font for info buttons works.
        gui.retentiveUndercutInfo = new InfoButton("Retentive Undercut");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 7
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 8;
        c.insets = insets;
        gui.middlePanel.add(gui.retentiveUndercutInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.retentiveUndercutGroup = new ButtonGroup();

        //add Retentive Undercut button 0.01"
        gui.retentiveUndercut1 = new ClaspRadioButton("Retentive Undercut", "0.01\"", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 8;
        gui.retentiveUndercutGroup.add(gui.retentiveUndercut1);
        gui.middlePanel.add(gui.retentiveUndercut1, c);

        //add Retentive Undercut button 0.02"
        gui.retentiveUndercut2 = new ClaspRadioButton("Retentive Undercut", "0.02\"", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 9;
        gui.retentiveUndercutGroup.add(gui.retentiveUndercut2);
        gui.middlePanel.add(gui.retentiveUndercut2, c);
    }

    //Creates info button and radio buttons for Occlusion choices
    private static void addOcclusionButtons(ClaspGUI gui, GridBagConstraints c) {
        //Bug: make sure font for info buttons works.
        gui.occlusionInfo = new InfoButton("Occlusion");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 9
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 10;
        c.insets = insets;
        gui.middlePanel.add(gui.occlusionInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.occlusionGroup = new ButtonGroup();

        //Add Occlusion = mesial radio button
        gui.occlusionMesial = new ClaspRadioButton("Occlusion", "Mesial", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 10;
        gui.occlusionGroup.add(gui.occlusionMesial);
        gui.middlePanel.add(gui.occlusionMesial, c);

        //Add Occlusion= Distal radio button
        gui.occlusionDistal = new ClaspRadioButton("Occlusion", "Distal", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 11;
        gui.occlusionGroup.add(gui.occlusionDistal);
        gui.middlePanel.add(gui.occlusionDistal, c);
    }

    //Creates info button and radio buttons for soft tissue undercut choices
    private static void addsoftTissueUndercutButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.softTissueUndercutInfo = new InfoButton("Soft Tissue Undercut");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 12;
        c.insets = insets;
        gui.middlePanel.add(gui.softTissueUndercutInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.softTissueUndercutGroup = new ButtonGroup();

        //Add Soft Tissue Undercut = Yes button
        gui.softTissueUndercutYes = new ClaspRadioButton("Soft Tissue Undercut", "Yes", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 12;
        gui.softTissueUndercutGroup.add(gui.softTissueUndercutYes);
        gui.middlePanel.add(gui.softTissueUndercutYes, c);

        //Add Soft Tissue Undercut = No button
        gui.softTissueUndercutNo = new ClaspRadioButton("Soft Tissue Undercut", "No", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 13;
        gui.softTissueUndercutGroup.add(gui.softTissueUndercutNo);
        gui.middlePanel.add(gui.softTissueUndercutNo, c);
    }

    //Creates info button and radio buttons for 2mm or more Buccal Vestibule choices
    private static void addBuccalVestibButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.buccalVestib2mmInfo = new InfoButton("2mm or More Buccal Vestibule");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 13
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 14;
        c.insets = insets;
        gui.middlePanel.add(gui.buccalVestib2mmInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.buccalVestib2mmGroup = new ButtonGroup();

        //Add 2mm or more Buccal Vestibule = Yes button
        gui.buccalVestib2mmYes = new ClaspRadioButton("2mm or More Buccal Vestibule", "Yes", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 14;
        gui.buccalVestib2mmGroup.add(gui.buccalVestib2mmYes);
        gui.middlePanel.add(gui.buccalVestib2mmYes, c);

        //Add 2mm or more Buccal Vestibule = No button
        gui.buccalVestib2mmNo = new ClaspRadioButton("2mm or More Buccal Vestibule", "No", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 15;
        gui.buccalVestib2mmGroup.add(gui.buccalVestib2mmNo);
        gui.middlePanel.add(gui.buccalVestib2mmNo, c);
    }

    //Creates info button and radio buttons for Esthetically concerned choices
    private static void addEstheticConcernButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.estheticInfo = new InfoButton("Esthetically Concerned Patient");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 2;   //next gridy = 15
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 16;
        c.insets = insets;
        gui.middlePanel.add(gui.estheticInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.estheticGroup = new ButtonGroup();

        //add Esthetically concerned = yes button
        gui.estheticYes = new ClaspRadioButton("Esthetically Concerned Patient", "Yes", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 16;
        gui.estheticGroup.add(gui.estheticYes);
        gui.middlePanel.add(gui.estheticYes, c);

        //add Esthetically concerned = No button
        gui.estheticNo = new ClaspRadioButton("Esthetically Concerned Patient", "No", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 17;
        gui.estheticGroup.add(gui.estheticNo);
        gui.middlePanel.add(gui.estheticNo, c);
    }

    //Creates info button and radio buttons for Tooth Type choices
    private static void addToothTypeButtons(ClaspGUI gui, GridBagConstraints c) {
        gui.toothTypeInfo = new InfoButton("Tooth Type");
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 3;
        c.ipady = 45;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = insets;
        gui.middlePanel.add(gui.toothTypeInfo, c);

        //reset insets and add the radio button manager
        c.insets = defaultInset;
        c.ipadx = 50;
        gui.toothTypeGroup = new ButtonGroup();

        //add Esthetically concerned = yes button
        gui.toothTypeAnterior = new ClaspRadioButton("Tooth Type", "Anterior", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 0;
        gui.toothTypeGroup.add(gui.toothTypeAnterior);
        gui.middlePanel.add(gui.toothTypeAnterior, c);

        //add Esthetically concerned = No button
        gui.toothTypePremolar = new ClaspRadioButton("Tooth Type", "PreMolar", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 1;
        gui.toothTypeGroup.add(gui.toothTypePremolar);
        gui.middlePanel.add(gui.toothTypePremolar, c);

        //add Esthetically concerned = No button
        gui.toothTypeMolar = new ClaspRadioButton("Tooth Type", "Molar", gui);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.ipady = 15;
        c.gridx = 1;
        c.gridy = 2;
        gui.toothTypeGroup.add(gui.toothTypeMolar);
        gui.middlePanel.add(gui.toothTypeMolar, c);

    }

    //adds and places ClaspButtons in the GUI
    private static void addClaspButtons(ClaspGUI gui, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 150;
        c.ipady = 15;
        c.insets = insets;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 3;

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

        //add the "Next" and Finish buttons
        c.fill = 0;
        c.gridy = 13;
        c.gridx = 0;
        c.ipadx = 40;
        c.ipady = 5;
        c.gridwidth = 1;
        gui.rightPanel.add(gui.previousButton, c);

        c.gridx =2;
        gui.rightPanel.add(gui.nextButton, c);

        c.gridx = 1;
        gui.rightPanel.add(gui.finishButton, c);

        //Add the reset button
        c.fill = 0;
        c.gridy = 14;
        c.gridx = 2;
        //c.ipady = 5;
        //c.ipadx = 40;

        c.anchor = GridBagConstraints.PAGE_END;
        //c.weightx = 1.0;
        //c.weighty = 1.0;
        gui.rightPanel.add(gui.reset, c);

    }


    /**
     * Listens and acts the clicking of radio button. Updates the valid clasps based on selected radio buttons.
     * @param input String input from the action event performed.
     */

    //Bug: no way for invalid tally to decrement
    public void radioButtonClicked(String input) {
        Integer toothNum = ClaspBackEnd.selectedAbutmentTeeth.get(currentAbutment).usNumber;
        LinkedList<String> currentValidClasps = ClaspBackEnd.validClasps.get(toothNum);
        ClaspBackEnd.setActiveCriteria(input, activeCriteria);
        int invalidTally = 0;
        for (ClaspButton button : buttons) {
            button.updateStatus(activeCriteria);    //Update activity status of the ClaspButtons
            if (button.isEnabled()) {
                addWithoutDuplicating(currentValidClasps, button.name);
            } else if(!button.isEnabled()) {
                invalidTally++;
                currentValidClasps.remove(button.name);
            }
        }
        // Make a new window to alert users that there are no valid clasps available.
        //Bug: invalidTally needs to be changed to accommodate change from no valid to some valid clasps.
        if (invalidTally >= 13 && !noValidClasps) {
            ClaspGUI.noValidClasps = true;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new JFrame("Alert: No Valid Clasps");
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    JTextArea textArea = new JTextArea(15, 50);
                    textArea.setWrapStyleWord(true);
                    textArea.setEditable(false);
                    textArea.append(" No viable clasps exist with the current configuration.\n" +
                            "\n" +
                            "Please consider the following:" +
                            "\n" +

                            "    1: Surveyed crowns: surveyed crowns can be made to provide appropriate depth and location of undercuts.  \n" +
                            "\n" +
                            "    2: Composite addition: composite can be added to the tooth to provide appropriate depth and location of undercuts \n " +
                            "       (composite added to the tooth should be based on a surveyed wax pattern made on a surveyed diagnostic cast)\n" +
                            "\n" +
                            "    3: Preparation of an enamel dimple: a dimple can be prepared in the enamel of the abutment tooth to provide an  \n " +
                            "       appropriate undercut in an appropriate location.\n" +
                            "\n" +
                            "    4: Choose a different abutment");
                    JPanel infoPanel = new JPanel();
                    infoPanel.add(textArea);
                    frame.add(infoPanel);
                    frame.pack();
                    frame.setLocationByPlatform(true);
                    frame.setVisible(true);
                    frame.setResizable(false);

                }
            });
        }
        //Bug: what are the error values we expect?
        //Bug: Special character parsing is flimsy, is there a better way we can do this?
    }

    private static LinkedList<String> addWithoutDuplicating(LinkedList myList, String element) {
        if (!myList.contains(element)) {
            myList.add(element);
        }
        return myList;
    }



    /**
     * Takes the action when Next button is pressed. Either goes to next abutment selection or triggers opening of results window.
     */
    private void pressNextButton() {
        int sizeOfAbutmentList = ClaspBackEnd.selectedAbutmentTeeth.size();
        //Make sure input is valid: i.e.
        currentAbutment++;
        if ((currentAbutment > -1) && (currentAbutment < sizeOfAbutmentList)) {
            this.selectOptionsOnAbutments();
        } else if (currentAbutment == sizeOfAbutmentList) {
            guiManager.getResults();
            claspGUIFrame.dispose();
        } else {
            System.err.println("Invalid index pressing next button in Clasp GUI");
        }

    }

    /**
     * Gets the lowest numbered active criteria map and allows users to select options via button presses.
     */
    //Bug: make the tooth type selection enabled for abutments after first one.
    //Bug: need to make sure that current abutment is remembered for future passes that are saved.
    public void selectOptionsOnAbutments() {
        resetButtons();
        //if the current abutment index is valid, pull the active criteria map corresponding to this tooth.
        Integer toothNum = ClaspBackEnd.selectedAbutmentTeeth.get(currentAbutment).usNumber;
        activeCriteria = ClaspBackEnd.totalActiveCriteria.get(toothNum);
        //Finish selections if we have reached the end
        System.out.println(activeCriteria);
        checkAndSetToothType();
}

    //Checks to see if the value "Tooth Type" is in the active criteria, if yes, then click the requisite button.
    private void checkAndSetToothType() {
        String toothTypeOption = activeCriteria.get("Tooth Type");
        System.out.println(toothTypeOption);
        //Make sure tooth type selected was valid, and that there was indeed a Tooth type value added.
        if (toothTypeOption != null && activeCriteria.keySet().contains("Tooth Type")) {
            toothTypeOption = "Tooth Type ; " + toothTypeOption;
            radioButtonClicked(toothTypeOption);
            radioButtons.get(toothTypeOption).setSelected(true);
            Enumeration<AbstractButton> toothTypeButtons = toothTypeGroup.getElements();
            while (toothTypeButtons.hasMoreElements()) {
                JRadioButton button = (JRadioButton) toothTypeButtons.nextElement();
                if (!button.isSelected()) {
                    button.setEnabled(false);
                }

            }
        }
    }



    /**
     * Opens a new window when a ClaspButton is clicked
     * @param claspButton The clasp button clicked.
     * @param claspImage The image related to clasp.
     */
    public static void makeClaspWindow(ClaspButton claspButton, ImageIcon claspImage) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame(claspButton.name);
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                JPanel infoPanel = new JPanel();
                JLabel label = new JLabel(claspImage);
                infoPanel.add(label);
                frame.add(infoPanel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);

            }
        });

    }



    /**
     * Produces an information window by clicking on one of the Patient Criteria buttons
     * @param infoButton The specific criterion which the window describes.
     */
    public static void makeInfoWindow(InfoButton infoButton) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame(infoButton.name);
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                JTextArea textArea = new JTextArea(15, 50);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                textArea.append(infoButton.description);
                JPanel infoPanel = new JPanel();
                infoPanel.add(textArea);
                frame.add(infoPanel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);

            }
        });
    }


    /**
     * Resets all buttons to default state. Only called when RESET button is clicked.
     *
     */
    //Bug: Can reset all buttons at present. Should know which tooth type button to leave clicked.
    public void resetButtons( ) {
        //ClaspBackEnd.getActiveCriteria().clear();
        ClaspGUI.noValidClasps = false;
        for (ClaspButton b : buttons) {
            b.setEnabled(true);
        }
        for(ButtonGroup b : this.buttonGroups) {
            b.clearSelection();
        }
    }


    /**
     * Creates an ImageIcon if the path is valid.
     * @param path - resource path
     * @param description - description of the file
     */
    public ImageIcon createImageIcon(String path,
                                     String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    //Builds and shows the GUI.
    static void createAndShowGUI() {
        claspGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //claspGUIFrame.setContentPane(new ClaspGUI());

        //frame.setLocationByPlatform(true);
        claspGUIFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        claspGUIFrame.pack();
        claspGUIFrame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


