import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

/**
 * Parameters is the container for all of the parameters needed for
 * Clasp selection.
 */
public class Parameters {
    public HashMap<String, Parameter> params;


    /**
     * Build Parameters from a file.
     * @param sc Text scanner to provide values to parameters.
     */
    public Parameters(Scanner sc) {

    }

    //Helper function to set a parameter value to parameters.
    private static void setParameter(Parameters selection, String parameter, String value) {

    }

    /*private static void resetDefaultParams(Parameters params) {
        params.stressRelease = Boolean.parseBoolean(null);
        params.surveyLineClass = null;
    }*/

    //Bug: this should play a role in warning user if all criteria not present.
    public boolean checkFullCriteria() {
        return false;
    }
}
