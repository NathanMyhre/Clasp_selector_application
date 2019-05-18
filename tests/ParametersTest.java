import org.junit.Test;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Scanner;

public class ParametersTest {

    @Test
    public void testNull(){
        Scanner empty = new Scanner("");
        Parameters emptyParams = new Parameters(empty);

    }

    @Test
    public void testStressOnly(){
        Scanner stressTrue = new Scanner("stressrelease true");
        Scanner stressFalse = new Scanner( "stressrelease false");
        Parameters paramTrue = new Parameters(stressTrue);
        Parameters paramFalse = new Parameters(stressFalse);
        assertEquals(true, paramTrue.stressRelease);
        assertEquals( false, paramFalse.stressRelease);
    }

    @Test
    public void testSurveyLineOnly(){
        Scanner survey1 = new Scanner("surveylineclass 1");
        Scanner survey2 = new Scanner("surveylineclass 2");
        Scanner survey3 = new Scanner("surveylineclass 3");
        Parameters param1 = new Parameters(survey1);
        Parameters param2 = new Parameters(survey2);
        Parameters param3 = new Parameters(survey3);
        assertEquals(1, param1.surveyLineClass);
        assertEquals(2, param2.surveyLineClass);
        assertEquals(3, param3.surveyLineClass);
    }

    //Test to make sure scanner logic is properly implemented when complete criteria present.
    //Note: order is proper, testing one set of parameters
    @Test
    public void testFull1 () {
        Scanner full1 = new Scanner ("stressrelease true "
            + "surveylineclass 1 "
            + "retentiveundercut 0.01 "
            + "occlusion medial "
            + "softtissueundercut true "
            + "bucalvestibule2mm true "
            + "aestheticconcern true "
            + "toothtype anterior ");
        Parameters full1Parameters = new Parameters (full1);
        assert(full1Parameters.metFullCriteria());
    }
}