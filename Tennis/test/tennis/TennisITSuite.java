package tennis;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author DanielaMarioti
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({tennis.TennisIT.class, tennis.Score_DoAIT.class, tennis.PlayerIT.class, tennis.ScoreIT.class})
public class TennisITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
