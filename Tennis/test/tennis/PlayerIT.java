package tennis;

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
public class PlayerIT {

    /**
     * Test of addPoint method, of class Player.
     */
    @Test
    public void testAddPoint() {
        System.out.println("addPoint");
        Player instance = new Player();
        for(Score v: Score.values()){
            Score before = instance.getScore();
            if(instance.getScore()==Score.FORTY){
                instance.addPoint();
                assertNotEquals(before,instance.getScore());
            }
        }
    }

    /**
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Player instance = new Player();
        Score expResult = null;
        Score result = instance.getScore();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addPointDoA method, of class Player.
     */
    @Test
    public void testAddPointDoA() {
        System.out.println("addPointDoA");
        Player instance = new Player();
        instance.addPointDoA();
        assertNotEquals(Score_DoA.DEUCE,instance.getScore_DoA());
        assertNotEquals(Score_DoA.DISADVANTAGE,instance.getScore_DoA());
        assertEquals(Score_DoA.ADVANTAGE,instance.getScore_DoA());
        
    }

    /**
     * Test of lostPointDoA method, of class Player.
     */
    @Test
    public void testLostPointDoA() {
        System.out.println("lostPointDoA");
        Player instance = new Player();
        instance.lostPointDoA();
        assertNotEquals(Score_DoA.DEUCE,instance.getScore_DoA());        
        assertNotEquals(Score_DoA.ADVANTAGE,instance.getScore_DoA());  
        assertEquals(Score_DoA.DISADVANTAGE,instance.getScore_DoA());
    }

    /**
     * Test of deuce method, of class Player.
     */
    @Test
    public void testDeuce() {
        System.out.println("deuce");
        Player instance = new Player();
        Player instance2 = new Player();
        assertEquals(instance.getScore_DoA(),Score_DoA.DEUCE);
        assertEquals(instance.getScore_DoA(),instance2.getScore_DoA());
    }

    /**
     * Test of getScore_DoA method, of class Player.
     */
    @Test
    public void testGetScore_DoA() {
        System.out.println("getScore_DoA");
        Player instance = new Player();
        Score_DoA expResult = null;
        Score_DoA result = instance.getScore_DoA();
        assertNotEquals(expResult, result);
    }
    
}
