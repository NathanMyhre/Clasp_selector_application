/**
 * ClaspSelector implements clasp selection logic and contains the list of
 * valid clasps in a given patient case. Parameters defined in order to be
 * constructed: Stress release needed, Survey line classification, Retentive undercut,
 * Occlusion, Soft tissue undercut, 2mm or more buccal vestibule, Esthetic concerned pt,
 * Tooth type.
 */

import java.util.HashMap;
import java.util.List;

public class ClaspSelector {
    public final HashMap<String, Clasp> clasps;
    public Parameters params;



    //Bug: If I decide later that I want to improve performance, might be good here
    public ClaspSelector(HashMap<String, String> input, Parameters inputParams) {
        clasps = ClaspSelector.buildNewMap();

    }


    public HashMap<String, Clasp> getClaspList() {
        return this.clasps;
    }

    private static void checkParameter(ClaspSelector claspSel, Parameter currentParam) {
        if (currentParam.paramName.equals("stressrelease")){
            if (currentParam.paramValue.equals(true))  {
                claspSel.clasps.remove("ibardistal");
                claspSel.clasps.remove("ccmesial");
                claspSel.clasps.remove("ccdistal");
                claspSel.clasps.remove("cccingulum");
                claspSel.clasps.remove("ring");
            } else if (currentParam.paramValue.equals(false)) {
                //no need to do anything
            } else {
                //Bug: throw error w/in ClaspSelector, but should never happen here.
            }
        } else if (currentParam.paramName.equals("surveylineclass")) {
            if (currentParam.paramValue.equals(1)) {
                claspSel.clasps.remove("modtbarmesial");
                claspSel.clasps.remove("modtbardistal");
                claspSel.clasps.remove("modtbarcingulum");
                claspSel.clasps.remove("ring");
            } else if (currentParam.paramValue.equals(2)) {
                claspSel.clasps.remove("ibarmesial");
                claspSel.clasps.remove("ibardistal");
                claspSel.clasps.remove(("ibarcingulum"));
                claspSel.clasps.remove("wwmesial");
                claspSel.clasps.remove("wwdistal");
                claspSel.clasps.remove("wwcingulum");
                claspSel.clasps.remove("ccmesial");
            } else if (currentParam.paramValue.equals(3)) {
                //Do nothing here
            } else {
                //Bug: throw error w/in ClaspSelector, but should never happen here.
            }
        } else if (currentParam.paramName.equals("retentiveUndercut")) {
            if (currentParam.paramValue.equals(.01)) {
                claspSel.clasps.remove("wwmesial");
                claspSel.clasps.remove("wwdistal");
                claspSel.clasps.remove("wwcingulum");
            } else if (currentParam.paramValue.equals(.02)) {
                //do nothing here
            }
        } else if (currentParam.paramName.equals("occlusion")) {
            if (currentParam.paramValue.equals("mesial")) {
                claspSel.clasps.remove("ibarmesial");
                claspSel.clasps.remove("modtbarmesial");
                claspSel.clasps.remove("wwmesial");
                claspSel.clasps.remove("ccmesial");
            } else if (currentParam.paramValue.equals("distal")) {
                claspSel.clasps.remove("ibardistal");
                claspSel.clasps.remove("modtbardistal");
                claspSel.clasps.remove("wwdistal");
                claspSel.clasps.remove("ccdistal");
            }
        } else if (currentParam.paramName.equals("softtissueundercut")) {
            if (currentParam.paramValue.equals(true)){
                claspSel.clasps.remove("ibarmesial");
                claspSel.clasps.remove("ibardistal");
                claspSel.clasps.remove("ibarcingulum");
                claspSel.clasps.remove("modtbarmesial");
                claspSel.clasps.remove("modtbardistal");
                claspSel.clasps.remove("modtbarcingulum");
            }
        } else if (currentParam.paramName.equals("bucalvestibule2mm")) {

        } else if (currentParam.paramName.equals("estheticconcern")) {

        } else if (currentParam.paramName.equals("toothtype")) {

        } else {
            //Bug: throw error or s/t if ClaspSelector.checkParameter is unable to find a parameter.
        }
    }

    private static HashMap<String, Clasp> buildNewMap() {
        HashMap<String, Clasp> map = new HashMap<String, Clasp>();
        map.put("ibarmesial", Clasp.factory("ibarmesial"));
        map.put("ibardistal", Clasp.factory("ibardistal"));
        map.put("ibarcingulum", Clasp.factory("ibardcingulum"));
        map.put("modtbarmesial", Clasp.factory("modtbarmesial"));
        map.put("modtbardistal", Clasp.factory("modtbardistal"));
        map.put("modtbarcingulum", Clasp.factory("modtbarcingulum"));
        map.put("wwmesial", Clasp.factory("wwmesial"));
        map.put("wwdistal", Clasp.factory("wwdistal"));
        map.put("wwcingulum", Clasp.factory("wwcingulum"));
        map.put("ccmesial", Clasp.factory("ccmesial"));
        map.put("ccdistal", Clasp.factory("ccdistal"));
        map.put("cccingulum", Clasp.factory("cccingulum"));
        map.put("ring", Clasp.factory("ring"));
        return map;
    }

}

