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
public class TieBreakIT {
    
    public TieBreakIT(){
    }
    
    @Test
    public void testValues() {
        System.out.println("values");
        TieBreak[] expResult = null;
        TieBreak[] result = TieBreak.values();
        assertThat(expResult, IsNot.not(IsEqual.equalTo(result)));
    }
    
    
}
