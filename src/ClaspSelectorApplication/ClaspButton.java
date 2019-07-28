package ClaspSelectorApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class ClaspButton extends JButton implements ActionListener {
    public final String name;
    public String path;
    public ClaspGUI gui;

    public ClaspButton(String input, ClaspGUI g) {
        super(input);
        name = input;
        path = input;
        gui = g;
        this.addActionListener(this);
    }

    /**
     * Factory method for creating Clasp buttons. Subclass hierarchy allows us to call updateStatus method for multiple
     * types of ClaspButtons and have different criteria
     * @param input Name of button
     * @return new ClaspButton of a specific type.
     */
    public static ClaspButton factory(String input, ClaspGUI g) {
        ClaspButton output;
        if ("I-Bar Clasp Mesial Rest".equals(input)){
            output = new IBarMesialButton(input, g);
        } else if ("I-Bar Clasp Distal Rest".equals(input)){
            output = new IBarDistalButton(input, g);
        } else if ("I-Bar Clasp Cingulum Rest".equals(input)){
            output = new IBarCingulumButton(input, g);
        } else if ("Mod T-Bar Clasp Mesial Rest".equals(input)) {
            output = new ModTBarMesialButton(input, g);
        } else if ("Mod T-Bar Clasp Distal Rest".equals(input)) {
            output = new ModTBarDistalButton(input, g);
        } else if ("Mod T-Bar Clasp Cingulum Rest".equals(input)) {
            output = new ModTBarCingulumButton(input, g);
        } else if ("WW Clasp Mesial Rest".equals(input)) {
            output = new WWMesialButton(input, g);
        } else if ("WW Clasp Distal Rest".equals(input)) {
            output = new WWDistalButton(input, g);
        } else if ("WW Clasp Cingulum Rest".equals(input)) {
            output = new WWCingulumButton(input, g);
        } else if ("CC Clasp Mesial Rest".equals(input)) {
            output = new CCMesialButton(input, g);
        } else if ("CC Clasp Distal Rest".equals(input)) {
            output = new CCDistalButton(input, g);
        } else if ("CC Clasp Cingulum Rest".equals(input)) {
            output = new CCCingulumButton(input, g);
        } else if ("Ring Clasp".equals(input)) {
            output = new RingButton(input, g);
        } else if ("RESET".equals(input)) {
            output = new ResetButton(input, g);
        }
        else {
            output = null;
        }
        //Bug: Need to make an error class to return any errors that ClaspButton.factory produces
        return output;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon image = createImageIcon(path, name);
        ClaspGUI.makeClaspWindow(this, image);
        System.out.println("Proof");
    }

    /**
     * Deactivate button if criteria are met.
     * @param criteria is the patient criteria for selecting a clasp.
     */
    public void updateStatus(HashMap<String, String> criteria){}

    /**
     * Creates an ImageIcon if the path is valid.
     * @param path - resource path
     * @param description - description of the file
     */
    protected ImageIcon createImageIcon(String path,
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
 * Button to select the I-Bar Mesial Rest clasp.
 */
class IBarMesialButton extends ClaspButton{
    IBarMesialButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\ibarmesial.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        this.setEnabled(true);
        //input = list of criteria
        //for each item in criteria list
            //If criteria is of certain type, deactivate - see parameters for details.
        for (String crit : criteria.keySet()){
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Mesial".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Soft Tissue Undercut".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("2mm or More Buccal Vestibule".equals(crit)) {
                if ("No".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

/**
 * Button to select the I-Bar Distal Rest clasp.
 */
class IBarDistalButton extends ClaspButton{
    IBarDistalButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\ibardistal.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Stress Release Needed".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Distal".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Soft Tissue Undercut".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("2mm or More Buccal Vestibule".equals(crit)) {
                if ("No".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
    }
}

class IBarCingulumButton extends ClaspButton{
    IBarCingulumButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\ibarcingulum.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Soft Tissue Undercut".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("2mm or More Buccal Vestibule".equals(crit)) {
                if ("No".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("PreMolar".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class ModTBarMesialButton extends ClaspButton{
    ModTBarMesialButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\modtbarmesial.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("I".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Mesial".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Soft Tissue Undercut".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("2mm or More Buccal Vestibule".equals(crit)) {
                if ("No".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class ModTBarDistalButton extends ClaspButton{
    ModTBarDistalButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\modtbardistal.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("I".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Distal".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Soft Tissue Undercut".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("2mm or More Buccal Vestibule".equals(crit)) {
                if ("No".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class ModTBarCingulumButton extends ClaspButton{
    ModTBarCingulumButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\modtbarcingulum.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("I".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Soft Tissue Undercut".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("2mm or More Buccal Vestibule".equals(crit)) {
                if ("No".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("PreMolar".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class WWMesialButton extends ClaspButton{
    WWMesialButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\wwmesial.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Retentive Undercut".equals(crit)) {
                if ("0.01\"".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Mesial".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Esthetically Concerned Patient".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) ) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class WWDistalButton extends ClaspButton{
    WWDistalButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\wwdistal.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Retentive Undercut".equals(crit)) {
                if ("0.01\"".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Distal".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Esthetically Concerned Patient".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) ) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class WWCingulumButton extends ClaspButton{
    WWCingulumButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\wwcingulum.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Retentive Undercut".equals(crit)) {
                if ("0.01\"".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Esthetically Concerned Patient".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("PreMolar".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class CCMesialButton extends ClaspButton{
    CCMesialButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\ccmesial.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Stress Release Needed".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Mesial".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Esthetically Concerned Patient".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) ) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class CCDistalButton extends ClaspButton{
    CCDistalButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\ccdistal.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Stress Release Needed".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Occlusion".equals(crit)) {
                if ("Distal".equals(value)){
                    this.setEnabled(false);
                }
            } else if ("Esthetically Concerned Patient".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("Anterior".equals(value) ) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class CCCingulumButton extends ClaspButton{
    CCCingulumButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\cccingulum.png";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Stress Release Needed".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Survey Line Classification".equals(crit)) {
                if ("II".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Esthetically Concerned Patient".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("PreMolar".equals(value) || "Molar".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class RingButton extends ClaspButton{
    RingButton(String input, ClaspGUI g) {
        super(input, g);
        path = "images\\ring.PNG";

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
        this.setEnabled(true);
        for (String crit : criteria.keySet()) {
            String value = criteria.get(crit);
            if ("Stress Release Needed".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Survey Line Classification".equals(crit)) {
                if ("I".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Esthetically Concerned Patient".equals(crit)) {
                if ("Yes".equals(value)) {
                    this.setEnabled(false);
                }
            } else if ("Tooth Type".equals(crit)) {
                if ("PreMolar".equals(value) || "Anterior".equals(value)) {
                    this.setEnabled(false);
                }
            }
        }
    }
}

class ResetButton extends ClaspButton {
    ResetButton (String input, ClaspGUI g) {
        super (input, g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClaspGUI.resetButtons(gui);
        System.out.println("called");
    }
}