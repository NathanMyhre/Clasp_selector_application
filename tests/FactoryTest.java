import BackEnd.Clasp;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactoryTest {

    /* Write tests for:
       All types of clasps

     */
    @Test
    public void factory() {
    }

    @Test
    public void testIBar() {
        Clasp mesial = Clasp.factory("ibarmesial");
        Clasp distal = Clasp.factory("ibardistal");
        Clasp cingulum = Clasp.factory("ibarcingulum");
        assertEquals("I-Bar Clasp, Mesial Rest", mesial.toString());
        assertEquals("I-Bar Clasp, Distal Rest", distal.toString());
        assertEquals("I-Bar Clasp, Cingulum Rest", cingulum.toString());
    }

    @Test
    public void testModTBar() {
        Clasp mesial = Clasp.factory("modtbarmesial");
        Clasp distal = Clasp.factory("modtbardistal");
        Clasp cingulum = Clasp.factory("modtbarcingulum");
        assertEquals("Mod T-Bar Clasp, Mesial Rest", mesial.toString());
        assertEquals("Mod T-Bar Clasp, Distal Rest", distal.toString());
        assertEquals("Mod T-Bar Clasp, Cingulum Rest", cingulum.toString());
    }

    @Test
    public void testWW() {
        Clasp mesial = Clasp.factory("wwmesial");
        Clasp distal = Clasp.factory("wwdistal");
        Clasp cingulum = Clasp.factory("wwcingulum");
        assertEquals("WW Clasp, Mesial Rest", mesial.toString());
        assertEquals("WW Clasp, Distal Rest", distal.toString());
        assertEquals("WW Clasp, Cingulum Rest", cingulum.toString());
    }

    @Test
    public void testCC() {
        Clasp cingulum = Clasp.factory("cccingulum");
        Clasp distal = Clasp.factory("ccdistal");
        Clasp mesial = Clasp.factory("ccmesial");
        assertEquals("CC Clasp, Cingulum Rest", cingulum.toString());
        assertEquals("CC Clasp, Distal Rest", distal.toString());
        assertEquals("CC Clasp, Mesial Rest", mesial.toString());
    }

    @Test
    public void testRing() {
        Clasp ring = Clasp.factory("ring");
        assertEquals("com.company.Ring Rest", ring.toString());
    }
}