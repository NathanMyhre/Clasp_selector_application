import org.junit.Test;

import static org.junit.Assert.*;
import java.io.File;
import java.util.Scanner;

public class ParametersTest {

    @Test
    public void testNull(){
        Scanner empty = new Scanner("");
        Parameters emptyParams = new Parameters(empty);
        assert(false);
    }

    @Test
    public void testStressOnly(){
        Scanner stressTrue = new Scanner("stressrelease true");
        Scanner stressFalse = new Scanner( "stressrelease false");
        Parameters paramTrue = new Parameters(stressTrue);
        Parameters paramFalse = new Parameters(stressFalse);
        Parameter pT = Parameter.newParameter("stressrelease", "true");
        Parameter pF = Parameter.newParameter("stressrelease", "false");
        assert(paramTrue.params.containsKey("stressrelease"));
        assertTrue(paramTrue.params.get("stressrelease").equalTo(pT));
        assert(paramFalse.params.containsKey("stressrelease"));
        assertTrue(paramFalse.params.get("stressrelease").equalTo(pF));
    }

    @Test
    public void testSurveyLineOnly(){
        Scanner survey1 = new Scanner("surveylineclass 1");
        Scanner survey2 = new Scanner("surveylineclass 2");
        Scanner survey3 = new Scanner("surveylineclass 3");
        Parameters param1 = new Parameters(survey1);
        Parameters param2 = new Parameters(survey2);
        Parameters param3 = new Parameters(survey3);
        assert(param1.params.containsKey("retentiveundercut"));

    }

    //tests addition of single retentive undercut parameter.
    //Bug: Parameters is easy to break with retentive undercut - .01 vs 0.01?
    @Test
    public void testRetentiveUndercutOnly(){
        Scanner retent1 = new Scanner("retentiveundercut 0.01");
        Scanner retent2 = new Scanner("retentiveundercut 0.02");
        Parameters param1 = new Parameters(retent1);
        Parameters param2 = new Parameters(retent2);
        Parameter p1 = Parameter.newParameter("retentiveundercut", "0.01");
        Parameter p2 = Parameter.newParameter("retentiveundercut", "0.02");
        assert(param1.params.containsKey("retentiveundercut"));
        assertTrue(param1.params.get("retentiveundercut").equalTo(p1));
        assert(param2.params.containsKey("retentiveundercut"));
        assertTrue(param2.params.get("retentiveundercut").equalTo(p2));
    }

    @Test
    public void testOcclusionOnly(){
        Scanner occlusionMedial = new Scanner ("occlusion medial");
        Scanner occlusionDistal = new Scanner ("occlusion distal");
        Parameters paramMedial = new Parameters(occlusionMedial);
        Parameters paramDistal = new Parameters(occlusionDistal);

    }

    @Test
    public void softTissueUndercutOnly(){
        Scanner softTissueUndercutTrue = new Scanner("softtissueundercut true");
        Scanner softTissueUndercutFalse = new Scanner("softtissueundercut false");
        Parameters paramTrue = new Parameters(softTissueUndercutTrue);
        Parameters paramFalse = new Parameters(softTissueUndercutFalse);

    }

    @Test
    public void bucalVestibule2mmOnly(){
        Scanner bucalVestibuleTrue = new Scanner("bucalvestibule2mm true");
        Scanner bucalVestibuleFalse = new Scanner("bucalvestibule2mm false");
        Parameters paramTrue = new Parameters(bucalVestibuleTrue);
        Parameters paramFalse = new Parameters(bucalVestibuleFalse);

    }

    @Test
    public void estheticConcernOnly(){
        Scanner estheticTrue = new Scanner("estheticconcern true");
        Scanner estheticFalse = new Scanner("estheticconcern false");
        Parameters paramTrue = new Parameters(estheticTrue);
        Parameters paramFalse = new Parameters(estheticFalse);

    }

    @Test
    public void toothTypeOnly() {
        Scanner toothTypeAnterior = new Scanner("toothtype anterior");
        Scanner toothTypePremolar = new Scanner("toothtype premolar");
        Scanner toothTypeMolar = new Scanner("toothtype molar");
        Parameters paramAnterior = new Parameters(toothTypeAnterior);
        Parameters paramPremolar = new Parameters(toothTypePremolar);
        Parameters paramMolar = new Parameters(toothTypeMolar);

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
            + "estheticconcern true "
            + "toothtype anterior ");
        Parameters full1Parameters = new Parameters (full1);
        assert(full1Parameters.sanityCheck());
    }
}