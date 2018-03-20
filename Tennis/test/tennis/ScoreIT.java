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
public class ScoreIT {
    
    public ScoreIT() {
    }


    /**
     * Test of values method, of class Score.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Score[] expResult = null;
        Score[] result = Score.values();
        assertThat(expResult, IsNot.not(IsEqual.equalTo(result)));
    }
    
}
