/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author smlle
 */
public class TennisIT {
    
    public TennisIT() {
    }
    
    /*
     * Test of main method, of class Tennis.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        Player playerOne = new Player();
        assertNotEquals(playerOne,null);
        Player playerTwo = new Player();
        assertNotEquals(playerTwo,null);
        assertNotEquals(playerOne,playerTwo);
        Game match = new Game(playerOne,playerTwo);
        assertNotEquals(match,null);
    }
    
}
