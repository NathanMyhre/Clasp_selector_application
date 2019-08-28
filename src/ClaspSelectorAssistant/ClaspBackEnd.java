package ClaspSelectorAssistant;

import java.util.HashMap;
import java.util.LinkedList;

public class ClaspBackEnd {

    /*
    **************************Tooth Definitions*****************************************************************
     */

    //Teeth, labeled by the US numbering System

    //Maxilla teeth
    static Tooth toothOne = new Tooth("1",67, 113, 301 ,341);
    static Tooth toothTwo = new Tooth("2",59, 119, 254, 300);
    static Tooth toothThree = new Tooth("3",70, 117, 196, 248);
    static Tooth toothFour = new Tooth("4",83, 131, 159, 198);
    static Tooth toothFive = new Tooth("5",96, 143, 125, 166);
    static Tooth toothSix = new Tooth("6",123, 151, 92, 121);
    static Tooth toothSeven = new Tooth("7",154, 183, 66, 105);
    static Tooth toothEight = new Tooth("8",183, 227, 48, 96);
    static Tooth toothNine = new Tooth("9",232, 270, 47, 99);
    static Tooth toothTen = new Tooth("10",279, 302, 61, 112);
    static Tooth toothEleven = new Tooth("11",310, 340, 89, 120);
    static Tooth toothTwelve = new Tooth("12",312, 361, 128, 159);
    static Tooth toothThirteen = new Tooth( "13",328, 373, 167, 192);
    static Tooth toothFourteen = new Tooth("14",327, 384, 201, 248);
    static Tooth toothFifteen = new Tooth("15",333, 394, 257, 293);
    static Tooth toothSixteen = new Tooth("16",341, 399, 305, 343);

    //Mandible teeth
    static Tooth toothSeventeen = new Tooth("17",343, 395, 416, 468);
    static Tooth toothEighteen = new Tooth("18",337, 387, 474, 527);
    static Tooth toothNineteen = new Tooth("19",324, 376, 529, 585);
    static Tooth toothTwenty = new Tooth("20",314, 358, 588, 626);
    static Tooth toothTwentyOne = new Tooth("21",305, 342, 626, 657);
    static Tooth toothTwentyTwo = new Tooth("22",289, 321, 659, 692);
    static Tooth toothTwentyThree = new Tooth("23",263, 287, 673, 707);
    static Tooth toothTwentyFour = new Tooth("24",231, 259, 678, 711);
    static Tooth toothTwentyFive = new Tooth("25",204, 227, 678, 712);
    static Tooth toothTwentySix = new Tooth("26",177, 199, 674, 711);
    static Tooth toothTwentySeven = new Tooth("27",138, 169, 666, 692);
    static Tooth toothTwentyEight = new Tooth("28",118, 159, 632, 656);
    static Tooth toothTwentyNine = new Tooth("29",101, 147, 593, 620);
    static Tooth toothThirty = new Tooth("30",83, 139, 534, 580);
    static Tooth toothThirtyOne = new Tooth("31",71, 126, 476, 524);
    static Tooth toothThirtyTwo = new Tooth("32",66, 115, 418, 468);

    //"Tooth Type ; Anterior"
    //"Tooth Type ; PreMolar"
    //"Tooth Type ; Molar"

    static HashMap<String, String> activeCriteria = new HashMap<String, String>();;
    static LinkedList<HashMap<String, String>> totalActiveCriteria = new LinkedList<>();

    //criteriaDefs is used to parse tooth type category and value - molar, premolar, or anterior.
    public static final HashMap<String, String> criteriaDefs = makeDefinitions();
    //Make the mappings for tooth to integer, and integer to tooth type
    //teethMax and teethMan are used in selecting abutment teeth from an image.
    public static final HashMap<Integer, Tooth> teethMap = makeTeethMap();
    public static final HashMap<Tooth, Integer> teethIntegers = makeTeethIntegers();

    //teethDefs is used to reference the tooth from the US numbering system. References number to tooth type
    public static final HashMap<Integer, String> teethDefs = makeToothTypeMap();

    static HashMap<Integer, Tooth> abutmentTeeth = new HashMap<>();

    static void setActiveCriteria(String input) {
        String[] splitString = input.split(" ; ");
        String crit = splitString[0];   //Get the current criterion
        String val = splitString[1];    //Get the current value
        ClaspBackEnd.activeCriteria.put(crit, val);  //remember criteria, value pairing
    }

    static HashMap<String, String> getActiveCriteria() {
        return ClaspBackEnd.activeCriteria;
    }

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

    private static HashMap<Integer, Tooth> makeTeethMap(){
        HashMap<Integer, Tooth> teeth = new HashMap<>();
        teeth.put(1, toothOne);
        teeth.put(2, toothTwo);
        teeth.put(3, toothThree);
        teeth.put(4, toothFour);
        teeth.put(5, toothFive);
        teeth.put(6, toothSix);
        teeth.put(7, toothSeven);
        teeth.put(8,toothEight);
        teeth.put(9, toothNine);
        teeth.put(10, toothTen);
        teeth.put(11, toothEleven);
        teeth.put(12, toothTwelve);
        teeth.put(13, toothThirteen);
        teeth.put(14, toothFourteen);
        teeth.put(15, toothFifteen);
        teeth.put(16, toothSixteen);
        teeth.put(17, toothSeventeen);
        teeth.put(18, toothEighteen);
        teeth.put(19, toothNineteen);
        teeth.put(20, toothTwenty);
        teeth.put(21, toothTwentyOne);
        teeth.put(22, toothTwentyTwo);
        teeth.put(23, toothTwentyThree);
        teeth.put(24, toothTwentyFour);
        teeth.put(25, toothTwentyFive);
        teeth.put(26, toothTwentySix);
        teeth.put(27, toothTwentySeven);
        teeth.put(28, toothTwentyEight);
        teeth.put(29, toothTwentyNine);
        teeth.put(30, toothThirty);
        teeth.put(31, toothThirtyOne);
        teeth.put(32, toothThirtyTwo);
        return teeth;
    }

    //Make the mapping of teeth to integers.
    //Bug: could probably use a BiMap to do two way dictionary search for teeth and integers.
    private static HashMap<Tooth, Integer> makeTeethIntegers(){
        HashMap teeth = new HashMap<Tooth, Integer>();
        teeth.put(toothOne, 1);
        teeth.put(toothTwo, 2);
        teeth.put(toothThree, 3);
        teeth.put(toothFour, 4);
        teeth.put(toothFive, 5);
        teeth.put(toothSix, 6);
        teeth.put(toothSeven, 7);
        teeth.put(toothEight,8);
        teeth.put(toothNine, 9);
        teeth.put(toothTen, 10);
        teeth.put(toothEleven, 11);
        teeth.put(toothTwelve, 12);
        teeth.put(toothThirteen, 13);
        teeth.put(toothFourteen, 14);
        teeth.put(toothFifteen, 15);
        teeth.put(toothSixteen, 16);
        teeth.put(toothSeventeen, 17);
        teeth.put(toothEighteen, 18);
        teeth.put(toothNineteen, 19);
        teeth.put(toothTwenty, 20);
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
class Tooth {
    public final int xLeft;
    public final int xRight;
    public final int yTop;
    public final int yBottom;
    public final String name;

    /**
     * Make Tooth
     * @param n Name of the tooth, using the US Numbering system
     * @param xL x-coordinate location for left side of rectangle.
     * @param xR x-coordinate location for right side of rectangle.
     * @param yB y-coordinate location for top of triangle
     * @param yT
     */
    public Tooth(String n, int xL, int xR, int yB, int yT) {
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
