import java.util.Scanner;
import java.io.File;

/**
 * Parameters is the container for all of the parameters needed for
 * Clasp selection.
 */
public class Parameters {
    public boolean stressRelease;
    public int surveyLineClass;
    public float retentiveUndercut;
    public String occlusion;
    public boolean softTissueUndercut;
    public boolean bucalVestibule2mm;
    public boolean aestheticConcern;
    public String toothType;

    /**
     * Build Parameters from a file.
     * @param sc File input.
     */
    public Parameters(Scanner sc) {
        String currentParam = new String();
        while (sc.hasNext()){
            String command = sc.next();
            if (currentParam != null) {
                Parameters.setParameter(this, command);
            }
        }
    }

    //Helper function to set a parameter value to parameters.
    private static void setParameter(Parameters param, String command) {
        param.stressRelease = Boolean.parseBoolean(command);
    }


    //Bug: this should play a role in warning user if all criteria not present.
    public boolean checkFullCriteria() {
        return false;
    }
}
