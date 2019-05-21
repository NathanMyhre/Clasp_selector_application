package ClaspSelectorApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** ParameterFile contains the File attributes of the generated file from GUI
 */
public class ParameterFile {
    File paramFile;

    /** Initialize the file specified from the GUI's selection criteria.
     * @param params contains specified parameter information including name,
     *               followed by selection criteria.
     */
    public ParameterFile (String[] params) throws IOException {
        paramFile = new File(params[0]);
        //Bug: I don't know how to handle FileWriter exceptions. How do I break?
        FileWriter writeFile = new FileWriter(paramFile);

    }

    public static void main (String[] args){

    }
}
