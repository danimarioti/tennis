package tennis;

import java.util.Scanner;
import java.util.SplittableRandom;

/**
 * Classe responsável pela lógica e controle do jogo
 *
 * @author DanielaMarioti
 */
class Game {

    private final Player playerOne;
    private final Player playerTwo;
    private Player winner;
        private Scanner scan;

    int scoreP1;
    int scoreP2;
    private Set[] matches = new Set[3];

    /**
     * Método construtor do jogo. Recebe como parâmetros 2 jogadores. Apresenta
     * valor default: type_score=false.
     */
    public Game(Player p1, Player p2) {
        this.playerOne = p1;
        this.playerTwo = p2;
        this.scoreP1 = 0;
        this.scoreP2 = 0;
        this.winner = null;
         this.scan= new Scanner(System.in); 
    }

    /**
     * Métodos de verificação do vencedor Segue o padrão, de acordo com as 4
     * regras do jogo de tênis.
     */
    private boolean isFinished(int currentMatch) {
        if (currentMatch == 3 || scoreP1 == 2 || scoreP2 == 2) {
            if (scoreP1 == 2) {
                winner = playerOne;
                System.out.println("O jogador 1 ganhou o jogo");
            } else {
                winner = playerTwo;
                System.out.println("O jogador 2 ganhou o jogo");
            }
            return true;
        }
        return false;
    }

    /**
     * Inicia o jogo
     */
    public void start() {
        System.out.println("Deseja que o jogo execute sozinho(1) ou entrar com a pontuação(2)?");
        int opcao=scan.nextInt();
        for (int i = 0; i < matches.length; i++) {
            playerOne.resetPlayer();
            playerTwo.resetPlayer();
            if(opcao==1)
                matches[i] = new Set(playerOne, playerTwo,false);
            else
                matches[i] = new Set(playerOne, playerTwo,true);
            System.out.println("#############################################");
            System.out.println("Comecando o SET " + (i + 1));
            matches[i].start();
            if (matches[i].getWinner() == playerOne) {
                scoreP1++;
            } else {
                scoreP2++;
            }
            System.out.println("#############################################");

            if (isFinished(i)) {
                return;
            }
        }
    }
}
