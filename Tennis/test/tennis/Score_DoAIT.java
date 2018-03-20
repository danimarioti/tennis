package tennis;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DanielaMarioti
 */
public class Score_DoAIT {
    
    public Score_DoAIT() {
    }
    
     /**
     * Test of values method, of class Score_DoA.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Score_DoA[] expResult = null;
        Score_DoA[] result = Score_DoA.values();
        assertThat(expResult, IsNot.not(IsEqual.equalTo(result)));
    }
    
}
