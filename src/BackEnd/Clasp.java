package BackEnd;

/**
 * Abstract container for clasps. Each subclass requires a number of
 * parameters defined in order to be constructed: Stress release needed,
 * Survey line classification, Retentive undercut, Occlusion, Soft tissue
 * undercut, 2mm or more buccal vestibule, Esthetic concerned pt, Tooth type.
 */
//Bug: do we need arguments for the abstract class
//Bug: For now, only allow specific clasps, but should keep ability to generate clasps.
//Bug: what traits are common to all clasps?
//Bug: do we include abutment teeth for informational purpose?
//Bug: Flat hierarchy on subclasses?
//
public abstract class Clasp {
    //Contains a document name.
    public String picture;

    public String name;

    Clasp ( ) {
        //Bug: need standardized convention for pic document naming.

    }

    //Bug: Should I have a custom input data type instead of String?
    public static Clasp factory ( String input ) {
        Clasp newClasp = null;
        if (input == null ) {
            //Bug: if a clasp has null input, needs to produce error Clasp.factory

        } else if (input.toLowerCase().equals("ibarmesial")) {
            newClasp = new IBarMesial();
        } else if (input.toLowerCase().equals("ibardistal")) {
            newClasp = new IBarDistal();
        } else if (input.toLowerCase().equals("ibarcingulum")) {
            newClasp = new IBarCingulum();
        } else if (input.toLowerCase().equals("modtbarmesial")) {
            newClasp = new ModTBarMesial();
        } else if (input.toLowerCase().equals("modtbardistal")) {
            newClasp = new ModTBarDistal();
        } else if (input.toLowerCase().equals("modtbarcingulum")) {
            newClasp = new ModTBarCingulum();
        } else if (input.toLowerCase().equals("wwmesial")) {
            newClasp = new WWMesial();
        } else if (input.toLowerCase().equals("wwdistal")) {
            newClasp = new WWDistal();
        } else if (input.toLowerCase().equals("wwcingulum")) {
            newClasp = new WWCingulum();
        } else if (input.toLowerCase().equals("ccmesial")) {
            newClasp = new CCMesial();
        } else if (input.toLowerCase().equals("ccdistal")) {
            newClasp = new CCDistal();
        } else if (input.toLowerCase().equals("cccingulum")) {
            newClasp = new CCCingulum();
        } else if (input.toLowerCase().equals("ring")) {
            newClasp = new Ring();
        } else {
            //Bug: print an error
        }
        return newClasp;
    }

    //NOTE: Factory method should have standardized selection names so I can use GUI to pass them on to factory.
    /** Get the name of this class
     * @return the textual description.
     */
    public String toString() {
        return this.name;
    }

    /** Get name of document containing picture.
     *
     */
}

//Bug: need convention for class naming.
//ClaspnameRestname?

class IBarMesial extends Clasp {
    IBarMesial( ) {
        this.name = "I-Bar Clasp, Mesial Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\ibarmesial.pdf";
    }
}

class IBarDistal extends Clasp {
    IBarDistal ( ) {
        this.name = "I-Bar Clasp, Distal Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\ibardistal.pdf";
    }
}

class IBarCingulum extends Clasp {
    IBarCingulum ( ) {
        this.name = "I-Bar Clasp, Cingulum Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\ibarcingulum.pdf";
    }
}

class ModTBarMesial extends Clasp {
    ModTBarMesial (){
        this.name = "Mod T-Bar Clasp, Mesial Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\modtbarmesial.pdf";
    }
}

class ModTBarDistal extends Clasp {
    ModTBarDistal( ){
        this.name = "Mod T-Bar Clasp, Distal Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\modtbardistal.pdf";
    }
}

class ModTBarCingulum extends Clasp {
    ModTBarCingulum (){
        this.name = "Mod T-Bar Clasp, Cingulum Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\modtbarcingulum.pdf";
    }
}

class WWMesial extends Clasp {
    WWMesial (){
        this.name = "WW Clasp, Mesial Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\wwmesial.pdf";

    }
}

class WWDistal extends Clasp {
    WWDistal (){
        this.name = "WW Clasp, Distal Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\wwdistal.pdf";
    }
}

class WWCingulum extends Clasp {
    WWCingulum (){
        this.name = "WW Clasp, Cingulum Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\wwcingulum.pdf";
    }
}

class CCMesial extends Clasp {
    CCMesial (){
        this.name = "CC Clasp, Mesial Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\ccmesial.pdf";
    }
}

class CCDistal extends Clasp {
    CCDistal (){
        this.name = "CC Clasp, Distal Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\ccdistal.pdf";
    }
}

class CCCingulum extends Clasp {
    CCCingulum (){
        this.name = "CC Clasp, Cingulum Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\cccingulum.pdf";
    }
}

class Ring extends Clasp {
    Ring () {
        this.name = "Ring Rest";
        this.picture = "C:\\Users\\natha\\OneDrive - University of Iowa\\Documents\\Clasp Selector\\ring.pdf";
    }

}