package ClaspSelectorAssistant;

import java.util.HashMap;
import java.util.LinkedList;

public class ClaspBackEnd {
    static HashMap<String, String> activeCriteria = new HashMap<String, String>();;
    static LinkedList<HashMap<String, String>> totalActiveCriteria = new LinkedList<>();

    public static final HashMap<String, String> criteriaDefs = makeDefinitions();

    /*
    **************************Tooth Definitions*****************************************************************
     */




    //Teeth, labeled by the US numbering System

    //Maxilla teeth
    static tooth toothOne = new tooth("One",57, 98, 306, 328);
    static tooth toothTwo = new tooth("Two",57, 92, 260, 285);
    static tooth toothThree = new tooth("Three",59, 103, 207, 240);
    static tooth toothFour = new tooth("Four",76, 102, 165,186);
    static tooth toothFive = new tooth("Five",90, 119, 132, 153);
    static tooth toothSix = new tooth("Six",108, 134, 96, 117);
    static tooth toothSeven = new tooth("Seven",134, 166, 67, 101);
    static tooth toothEight = new tooth("Eight",170, 207, 51, 91);
    static tooth toothNine = new tooth("Nine",218, 257, 48, 92);
    static tooth toothTen = new tooth("Ten",262, 292, 65, 101);
    static tooth toothEleven = new tooth("Eleven",290,322,94,120);
    static tooth toothTwelve = new tooth("Twelve",303, 344, 130,155);
    static tooth toothThirteen = new tooth( "Thirteen",316,352,165,188);
    static tooth toothFourteen = new tooth("Fourteen",316,368,203,241);
    static tooth toothFifteen = new tooth("Fifteen",325,377,257,290);
    static tooth toothSixteen = new tooth("Sixteen",330,384,303,336);

    //Mandible teeth
    static tooth toothSeventeen = new tooth("Seventeen",344, 389, 47,91);
    static tooth toothEighteen = new tooth("Eighteen",334,384,100,150);
    static tooth toothNineteen = new tooth("Nineteen",320,369,156,210);
    static tooth toothTwenty = new tooth("Twenty",311,353,210,252);
    static tooth toothTwentyOne = new tooth("Twenty One",300,343,248,287);
    static tooth toothTwentyTwo = new tooth("Twenty Two",284,315,285,321);
    static tooth toothTwentyThree = new tooth("Twenty Three",258,283,301,333);
    static tooth toothTwentyFour = new tooth("Twenty Four",229,254,307,338);
    static tooth toothTwentyFive = new tooth("Twenty Five",200,220,306,336);
    static tooth toothTwentySix = new tooth("Twenty Six",171,191,303,335);
    static tooth toothTwentySeven = new tooth("Twenty Seven",133,161,295,320);
    static tooth toothTwentyEight = new tooth("Twenty Eight",113,151,259,282);
    static tooth toothTwentyNine = new tooth("Twenty Nine",95,140,220,244);
    static tooth toothThirty = new tooth("Thirty",74,134,159,205);
    static tooth toothThirtyOne = new tooth("Thirty One",63,122,100,150);
    static tooth toothThirtyTwo = new tooth("Thirty Two",59,114,48,95);

    //"Tooth Type ; Anterior"
    //"Tooth Type ; PreMolar"
    //"Tooth Type ; Molar"

    //Make the mappings for tooth to integer, and integer to tooth type
    public static final HashMap<tooth, Integer> teethMax = makeTeethMapMaxilla();
    public static final HashMap<tooth, Integer> teethMan = makeTeethMapMandible();
    public static final HashMap<Integer, String> teethDefs = makeToothTypeMap();


    private static HashMap<String, String> makeDefinitions() {
        HashMap<String, String> defs = new HashMap<String, String>();
        defs.put("Stress Release Needed", "Stress Release Definition");
        defs.put("Survey Line Classification", "Survey Line Classification Definition");
        defs.put("Retentive Undercut", "Retentive Undercut Definition");
        defs.put("Occlusion", "Occlusion Definition");
        defs.put("Soft Tissue Undercut", "Soft Tissue Undercut Definition");
        defs.put("2mm or More Buccal Vestibule", "2mm or More Buccal Vestibule Definition");
        defs.put("Esthetically Concerned Patient", "Esthetically Concerned Patient definition");
        defs.put("Tooth Type", "Tooth Type Definition");
        return defs;
    }

    //Make mapping for Tooth number to tooth type
    private static HashMap<Integer, String> makeToothTypeMap() {
        HashMap<Integer, String> teeth = new HashMap<>();
        //Place tooth definitions.
        teeth.put(1,"Tooth Type ; Molar");
        teeth.put(2,"Tooth Type ; Molar");
        teeth.put(3,"Tooth Type ; Molar");
        teeth.put(14, "Tooth Type ; Molar");
        teeth.put(15,"Tooth Type ; Molar");
        teeth.put(16, "Tooth Type ; Molar");
        teeth.put(17, "Tooth Type ; Molar");
        teeth.put(18, "Tooth Type ; Molar");
        teeth.put(19,"Tooth Type ; Molar");
        teeth.put(30,"Tooth Type ; Molar");
        teeth.put(31,"Tooth Type ; Molar");
        teeth.put(32,"Tooth Type ; Molar");
        teeth.put(4,"Tooth Type ; PreMolar");
        teeth.put(5,"Tooth Type ; PreMolar");
        teeth.put(12,"Tooth Type ; PreMolar");
        teeth.put(13,"Tooth Type ; PreMolar");
        teeth.put(20,"Tooth Type ; PreMolar");
        teeth.put(21,"Tooth Type ; PreMolar");
        teeth.put(28,"Tooth Type ; PreMolar");
        teeth.put(29,"Tooth Type ; PreMolar");
        teeth.put(6,"Tooth Type ; Anterior");
        teeth.put(7,"Tooth Type ; Anterior");
        teeth.put(8,"Tooth Type ; Anterior");
        teeth.put(9,"Tooth Type ; Anterior");
        teeth.put(10,"Tooth Type ; Anterior");
        teeth.put(11,"Tooth Type ; Anterior");
        teeth.put(22,"Tooth Type ; Anterior");
        teeth.put(23,"Tooth Type ; Anterior");
        teeth.put(24,"Tooth Type ; Anterior");
        teeth.put(25,"Tooth Type ; Anterior");
        teeth.put(26,"Tooth Type ; Anterior");
        teeth.put(27,"Tooth Type ; Anterior");
        return teeth;
    }

    private static HashMap<tooth, Integer> makeTeethMapMaxilla(){
        HashMap<tooth, Integer> teeth = new HashMap<>();
        teeth.put(toothOne, 1);
        teeth.put(toothTwo, 2);
        teeth.put(toothThree, 3);
        teeth.put(toothFour,4);
        teeth.put(toothFive, 5);
        teeth.put(toothSix, 6);
        teeth.put(toothSeven, 7);
        teeth.put(toothEight, 8);
        teeth.put(toothNine, 9);
        teeth.put(toothTen, 10);
        teeth.put(toothEleven, 11);
        teeth.put(toothTwelve, 12);
        teeth.put(toothThirteen, 13);
        teeth.put(toothFourteen, 14);
        teeth.put(toothFifteen, 15);
        teeth.put(toothSixteen, 16);
        return teeth;
    }

    private static HashMap<tooth, Integer> makeTeethMapMandible(){
        HashMap<tooth, Integer> teeth = new HashMap<>();
        teeth.put(toothSeventeen, 17);
        teeth.put(toothEighteen, 18);
        teeth.put(toothNineteen, 19);
        teeth.put(toothTwenty,20);
        teeth.put(toothTwentyOne, 21);
        teeth.put(toothTwentyTwo, 22);
        teeth.put(toothTwentyThree, 23);
        teeth.put(toothTwentyFour, 24);
        teeth.put(toothTwentyFive, 25);
        teeth.put(toothTwentySix, 26);
        teeth.put(toothTwentySeven, 27);
        teeth.put(toothTwentyEight, 28);
        teeth.put(toothTwentyNine, 29);
        teeth.put(toothThirty, 30);
        teeth.put(toothThirtyOne, 31);
        teeth.put(toothThirtyTwo, 32);
        return teeth;
    }
}

/**
 * Invisible placeholder for teeth. Provides an interactive region which to click, shaped like a rectangle.
 */
class tooth {
    public final int xLeft;
    public final int xRight;
    public final int yTop;
    public final int yBottom;
    public final String name;

    /**
     * Make tooth
     * @param xL x-coordinate location for left side of rectangle.
     * @param xR x-coordinate location for right side of rectangle.
     * @param yB y-coordinate location for top of triangle
     * @param yT
     */
    public tooth(String n, int xL, int xR, int yB, int yT) {
        xLeft = xL;
        xRight = xR;
        yBottom = yB;
        yTop = yT;
        name = n;
    }

    public String myString() {
        return this.name;
    }
}
