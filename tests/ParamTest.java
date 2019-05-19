import org.junit.Test;

import static org.junit.Assert.*;

public class ParamTest {

    @Test
    public void testStress() {
        Parameter stressTrue = Parameter.newParameter("stressrelease", "true");
        Parameter stressFalse = Parameter.newParameter("stressrelease", "false");
        assert("stressrelease".equals(stressTrue.paramName));
        assert("stressrelease".equals(stressFalse.paramName));
        assertEquals(true, stressTrue.paramValue);
        assertEquals(false, stressFalse.paramValue);
    }

    @Test
    public void testSurveyLine() {
        Parameter surveyLine1 = Parameter.newParameter("surveylineclass", "1");
        Parameter surveyLine2 = Parameter.newParameter("surveylineclass", "2");
        Parameter surveyLine3 = Parameter.newParameter("surveylineclass", "3");
        assert("surveylineclass".equals(surveyLine1.paramName));
        assert("surveylineclass".equals(surveyLine2.paramName));
        assert("surveylineclass".equals(surveyLine3.paramName));
        assertEquals(1, surveyLine1.paramValue);
        assertEquals(2, surveyLine2.paramValue);
        assertEquals(3, surveyLine3.paramValue);
    }

    @Test
    public void testRetentiveUndercut() {
        Parameter retentive1 = Parameter.newParameter("retentiveundercut", ".01");
        Parameter retentive2 = Parameter.newParameter("retentiveundercut", ".02");
        assert("retentiveundercut".equals(retentive1.paramName));
        assert("retentiveundercut".equals(retentive2.paramName));
        assertEquals((float).01, retentive1.paramValue);
        assertEquals((float).02, retentive2.paramValue);
    }

    @Test
    public void testOcclusion(){
        Parameter occlusionMedial = Parameter.newParameter("occlusion", "medial");
        Parameter occlusionDistal = Parameter.newParameter("occlusion", "distal");
        assert("occlusion".equals(occlusionMedial.paramName));
        assert("occlusion".equals(occlusionDistal.paramName));
        assert("medial".equals(occlusionMedial.paramValue));
        assert("distal".equals(occlusionDistal.paramValue));
    }

    @Test
    public void testSoftTissueUndercut(){
        Parameter softTissueTrue = Parameter.newParameter("softtissueundercut", "true");
        Parameter softTissueFalse = Parameter.newParameter("softtissueundercut", "false");
        assert("softtissueundercut".equals(softTissueTrue.paramName));
        assert("softtissueundercut".equals(softTissueFalse.paramName));
        assertEquals(true, softTissueTrue.paramValue);
        assertEquals(false, softTissueFalse.paramValue);

    }

    @Test
    public void testBucalVestibule() {
        Parameter bucalVestibTrue = Parameter.newParameter("bucalvestibule2mm", "true");
        Parameter bucalVestibFalse = Parameter.newParameter("bucalvestibule2mm", "false");
        assert("bucalvestibule2mm".equals(bucalVestibTrue.paramName));
        assert("bucalvestibule2mm".equals(bucalVestibFalse.paramName));
        assertEquals(true, bucalVestibTrue.paramValue);
        assertEquals(false, bucalVestibFalse.paramValue);

    }

    @Test
    public void testesthetic() {
        Parameter estheticTrue = Parameter.newParameter("estheticconcern", "true");
        Parameter estheticFalse = Parameter.newParameter("estheticconcern", "false");
        assert("estheticconcern".equals(estheticTrue.paramName));
        assert("estheticconcern".equals(estheticFalse.paramName));
        assertEquals(true, estheticTrue.paramValue);
        assertEquals(false, estheticFalse.paramValue);
    }

    @Test
    public void testToothType() {
        Parameter toothTypeAnterior = Parameter.newParameter("toothtype", "anterior");
        Parameter toothTypePremolar = Parameter.newParameter("toothtype", "premolar");
        Parameter toothTypeMolar = Parameter.newParameter("toothtype", "molar");
        assert("toothtype".equals(toothTypeAnterior.paramName));
        assert("toothtype".equals(toothTypePremolar.paramName));
        assert("toothtype".equals(toothTypeMolar.paramName));
        assert("anterior".equals(toothTypeAnterior.paramValue));
        assert("premolar".equals(toothTypePremolar.paramValue));
        assert("molar".equals(toothTypeMolar.paramValue));

    }

}