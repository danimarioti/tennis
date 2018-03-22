/**
 * Pacote de jogo de Tênis
 */
package tennis;

/**
 * Classe principal
 *
 * @author DanielaMarioti
 */
public class Tennis {

    /**
     * Método principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Game game = new Game(playerOne, playerTwo);
        game.start();
    }

}
