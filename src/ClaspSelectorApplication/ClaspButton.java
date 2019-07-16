package ClaspSelectorApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class ClaspButton extends JButton implements ActionListener {
    public final String name;
    public final String path;

    public ClaspButton(String input) {
        super(input);
        name = input;
        path = input;

    }

    public static ClaspButton factory(String input) {
        ClaspButton output;
        if ("I-Bar Clasp Mesial Rest".equals(input)){
            output = new IBarMesialButton(input);
        }
        else {
            output = null;
        }
        //Bug: Need to make an error class to return any errors that ClaspButton.factory produces
        return output;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Open file if clicked?
    }

    /**Deactivate button if criteria are met.
     *
     */
    public void updateStatus(HashMap<String, String> criteria){}
}

class IBarMesialButton extends ClaspButton{
    IBarMesialButton(String input) {
        super(input);

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
            //If criteria is of certain type, deactivate - see parameters for details.
    }
}

class IBarDistalButton extends ClaspButton{
    IBarDistalButton(String input) {
        super(input);

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
    }
}

class IBarCingulumButton extends ClaspButton{
    IBarCingulumButton(String input) {
        super(input);

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
    }
}

class ModTBarMesialButton extends ClaspButton{
    ModTBarMesialButton(String input) {
        super(input);

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
    }
}

class ModTBarDistalButton extends ClaspButton{
    ModTBarDistalButton(String input) {
        super(input);

    }

    @Override
    public void updateStatus(HashMap<String, String> criteria) {
        //input = list of criteria
        //for each item in criteria list
        //If criteria is of certain type, deactivate - see parameters for details.
    }
}