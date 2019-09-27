package ClaspSelectorAssistant;

import javax.swing.*;
import javax.swing.plaf.synth.SynthLabelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.HashMap;

public class ResultsWindow extends JPanel{
    static JFrame resultsFrame = new JFrame("Results on Selected Abutments");
    ClaspGUIManager claspGUIManager;
    JPanel panelOne;
    JPanel panelTwo;
    JPanel panelThree;
    JPanel panelFour;

    JScrollPane resultsScrollPane;

    JTextArea resultsText;

    JButton finishAndReset;
    JButton saveAndChooseMoreAbutments;


    static String archImagePath = "../resources/icons/ArchesCombined.PNG";
    ImageIcon archIcon;
    StaticArchLabel archLabel;


    public ResultsWindow(ClaspGUIManager gui) {
        //this.setLayout();
        claspGUIManager = gui;
        GridBagConstraints constraints = new GridBagConstraints();
        this.setPreferredSize(new Dimension(ClaspGUIManager.screenSize.width, ClaspGUIManager.screenSize.height));


        panelOne = new JPanel();
        panelOne.setPreferredSize(new Dimension(ClaspGUIManager.screenSize.width/4, ClaspGUIManager.screenSize.height));
        panelTwo = new JPanel(new GridBagLayout());
        panelThree = new JPanel(new GridBagLayout());
        panelFour = new JPanel(new GridBagLayout());

        archIcon = createImageIcon(archImagePath, "Maxillary and Mandibular arches, US Numbering System.");

        panelOne.add(new JLabel(archIcon));

        resultsText = new JTextArea();
        resultsText.setWrapStyleWord(true);
        resultsText.setEditable(false);
        resultsText.setOpaque(false);
        resultsText.setFont(new Font("Arial", Font.BOLD, 16));

        resultsScrollPane = new JScrollPane(resultsText);
        resultsScrollPane.setPreferredSize(new Dimension(ClaspGUIManager.screenSize.width/2, ClaspGUIManager.screenSize.height));

        panelTwo.add(resultsScrollPane);

        finishAndReset = new JButton("Finish and Reset");
        finishAndReset.addActionListener((ActionListener) -> ResultsWindow.this.claspGUIManager.restartSelection(0));
        panelThree.add(finishAndReset);
        saveAndChooseMoreAbutments = new JButton("Save and Continue Selection");
        saveAndChooseMoreAbutments.addActionListener((ActionListener) -> ResultsWindow.this.claspGUIManager.restartSelection(1));
        panelThree.add(saveAndChooseMoreAbutments);



        this.add(panelOne);
        this.add(panelTwo);
        this.add(panelThree);
    }

    public void printResults() {

    }

    /**
     * Adds the text, button, and scrollbar components to panel two.
     */
    public void addComponentsToWindow() {
        int gridX = 0;
        int gridY = 0;
        GridBagConstraints constraints = new GridBagConstraints();
        Insets abutmentInset = new Insets(20,20,0,5);
        Insets criteriaInset = new Insets(1,5,1,5);
        JTextArea toothTextArea = new JTextArea();
        for (Tooth abutment : ClaspBackEnd.selectedAbutmentTeeth){
            Integer abutmentNumber = abutment.usNumber;
            LinkedList<String> criteria = buildResultTextContent(abutmentNumber);
            resultsText.append("Abutment Tooth " + abutmentNumber +": \n");
            for(String s : criteria) {
                System.out.println(s);
                resultsText.append(s +"\n");
            }
            HashMap<String, String> activeCriteria = ClaspBackEnd.totalActiveCriteria.get(abutmentNumber);
            //String criteriaString = ClaspBackEnd.criteriaToString(activeCriteria);
            //String[] splitCriteriaString = criteriaString.split(" ; ");
            /*constraints.gridx = gridX;
            constraints.gridy = gridY;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = abutmentInset;
            constraints.gridx++;
            constraints.insets = criteriaInset;*/
            gridY++;
        }
        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.gridheight = GridBagConstraints.REMAINDER;
        //JTextArea toothAndOptions = new JTextArea(10,30);
        //toothAndOptions.setWrapStyleWord(true);
        //toothAndOptions.setEditable(false);
        //toothAndOptions.append("PlaceHolder text: alksdf \n\n\n\n\n\n askdjfflak aksdff ks kka \n jals kdndak");
        //toothAndOptions.setPreferredSize(new Dimension(ClaspGUIManager.screenSize.width/4, ClaspGUIManager.screenSize.height));



        //panelTwo.add(toothAndOptions, constraints);

        /*constraints.gridx = gridX;
        constraints.gridheight = GridBagConstraints.REMAINDER;
        System.out.println(constraints.gridx);
        panelTwo.add(scrollBar, constraints);*/
    }


    private static LinkedList<String> buildResultTextContent(Integer toothNum){
        LinkedList<String> resultText = new LinkedList<String>();
        HashMap<String, String> activeCriteria = ClaspBackEnd.totalActiveCriteria.get(toothNum);
        LinkedList<String> criteriaList = ClaspBackEnd.criteriaToString(activeCriteria);
        LinkedList<String> currentValidClaspsList = ClaspBackEnd.validClasps.get(toothNum);
        if (criteriaList.size() > currentValidClaspsList.size()) {
            for (int i = 0; i < criteriaList.size(); i++) {
                if (i < currentValidClaspsList.size() ){
                    resultText.add(criteriaList.get(i) + "       " + currentValidClaspsList.get(i));
                } else if (i>= currentValidClaspsList.size()) {
                    resultText.add(criteriaList.get(i));
                }
                int lastIndex = i;
            }
        } else if (criteriaList.size() < currentValidClaspsList.size()) {
            for (int i = 0; i < currentValidClaspsList.size(); i++) {
                if (i < criteriaList.size() ){
                    resultText.add(criteriaList.get(i) + "          " + currentValidClaspsList.get(i));
                } else if (i>= criteriaList.size()) {
                    resultText.add("                    " + currentValidClaspsList.get(i));
                }
                int lastIndex = i;
            }
        } else {
            for (int i = 0; i < criteriaList.size(); i++) {
                resultText.add(criteriaList.get(i) + "       " + currentValidClaspsList.get(i));
            }
        }
        return resultText;
    }

    public static void makePanelFour(ResultsWindow gui) {
        JPanel fourthPanel = gui.panelFour;
        GridBagConstraints constraints = new GridBagConstraints();
        int x = 0;
        int y = 0;

        constraints.gridx = x;
        constraints.gridy = y;
        gui.panelFour.add(gui.finishAndReset, constraints);
        constraints.gridy = y+1;
        gui.panelFour.add(gui.saveAndChooseMoreAbutments, constraints);
        constraints.gridx = x+1;
        constraints.gridy = y;
        constraints.gridheight = GridBagConstraints.REMAINDER;
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

    public static void createAndShowGUI(){
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //resultsFrame.setContentPane(new ResultsWindow());
        //frame.setLocationByPlatform(true);
        resultsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        resultsFrame.pack();
        resultsFrame.setVisible(true);
    }
}
