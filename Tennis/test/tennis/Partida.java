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
 * @author udesc
 */
public class Partida {
    
    public Partida() {
    }
    
    @Test
    public void hello() {
        Player p1 = new Player("André Agassi");
        Player p2 = new Player("Guga");
        Game jogo = new Game(p1, p2);
        jogo.start();
        

    }
}
