/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

/**
 *
 * @author udesc
 */
public class Tennis {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Game match = new Game(playerOne,playerTwo);
        match.Start();
    }
    
}
