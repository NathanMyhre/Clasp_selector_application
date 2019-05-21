import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Scanner;
import java.io.File;

public class ClaspSelectorTest {

    @Test
    public void testNone() {
        Scanner input = new Scanner("stressrelease true " //2,10,11,12,13
            + "surveylineclass 2 " //4,5,6
            + "retentiveundercut .01 " //789
            + "occlusion mesial " //1
            + "softtissueundercut true " //all have been removed
            + "bucalvestibule2mm true "
            + "estheticconcern false "
            + "toothtype molar");
        Parameters paramsBig = new Parameters(input);
        ClaspSelector claspsBig = new ClaspSelector(paramsBig);
        for (String s : claspsBig.clasps.keySet()) {
            System.out.println(claspsBig.clasps.get(s));
        }
    }

    @Test
    public void testModTBarD() {
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
            System.out.println(claspsBig.clasps.get(s));
        }
    }
}