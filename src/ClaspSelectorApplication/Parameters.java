package ClaspSelectorApplication;

import java.util.Scanner;
import java.util.HashMap;

/**Parameters is the container for all of the parameters needed for
 * Clasp selection.
 */
public class Parameters {
    public HashMap<String, Parameter> params;


    /**Build Parameters from a file.
     * @param sc Text scanner to provide values to parameters.
     */
    public Parameters(Scanner sc) {
        params = new HashMap<String, Parameter>();
        String currentParamName = null;
        while (sc.hasNext()) {
            String command = sc.next();
            if (currentParamName != null) {
                params.put(currentParamName, Parameter.newParameter(currentParamName, command));
                currentParamName = null;
            } else {
                currentParamName = command;
            }
        }
    }

    //Helper function to set a parameter value to parameters.


    /*private static void resetDefaultParams(Parameters params) {
        params.stressRelease = Boolean.parseBoolean(null);
        params.surveyLineClass = null;
    }*/

    //Bug: Parameters.sanityCheck() should play a role in warning user if all criteria not present.
    //Bug: Parameters.sanityCheck() should check legal values.
    public boolean sanityCheck() {
        return (this.params.containsKey("stressrelease"));
    }
}
