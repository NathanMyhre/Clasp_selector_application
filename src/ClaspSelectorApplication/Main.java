/**
 * The Clasp Selector application implements functionality to select Removable
 * Partial Denture Prosthesis (RDP) based on patient criteria.
 *
 * @author Nathan J Myhre
 * @version 1.0
 * @since 2019-04-17
 */
package ClaspSelectorApplication;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//probably should rename package at some point.
public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        if(!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        Scanner input = new Scanner("stressrelease false "
                + "surveylineclass 2 "
                + "retentiveundercut .01 "
                + "occlusion mesial "
                + "softtissueundercut false "
                + "bucalvestibule2mm true "
                + "estheticconcern false "
                + "toothtype premolar");
        Parameters paramsBig = new Parameters(input);
        ClaspSelector claspsBig = new ClaspSelector(paramsBig);
        for (String s : claspsBig.clasps.keySet()) {
            Clasp currentClasp = claspsBig.clasps.get(s);
            System.out.println(currentClasp);
            System.out.println(currentClasp.picture);
            File file = new File(currentClasp.picture);
            if (file.exists()) desktop.open(file);
        }
    }
}
