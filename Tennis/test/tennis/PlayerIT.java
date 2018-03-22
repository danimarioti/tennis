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
    public void testAddPointTieBreak() {
        System.out.println("addTieBreak");
        Player instance = new Player();
        instance.addPointDoA();
        assertNotEquals("deuce",instance.getTieBreak());
        assertNotEquals("disadvantage",instance.getTieBreak());
        assertEquals("advantage",instance.getTieBreak());
    }

    /**
     * Test of lostPointDoA method, of class Player.
     */
    @Test
    public void testLostPointDoA() {
        System.out.println("lostPointDoA");
        Player instance = new Player();
        instance.lostPointDoA();
        assertNotEquals("deuce",instance.getTieBreak());        
        assertNotEquals("advantage",instance.getTieBreak());  
        assertEquals("disadvantage",instance.getTieBreak());
    }

    /**
     * Test of deuce method, of class Player.
     */
    @Test
    public void testDeuce() {
        System.out.println("deuce");
        Player instance = new Player();
        Player instance2 = new Player();
        assertEquals(instance.getTieBreak(),"deuce");
        assertEquals(instance.getTieBreak(),instance2.getTieBreak());
    }

    /**
     * Test of getScore_DoA method, of class Player.
     */
    @Test
    public void testGetTieBreak() {
        System.out.println("getTieBreak");
        Player instance = new Player();
        TieBreak expResult = null;
        TieBreak result = instance.getTieBreak();
        assertNotEquals(expResult, result);
    }
    
}
