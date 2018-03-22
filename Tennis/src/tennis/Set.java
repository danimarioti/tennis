/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.Scanner;
import java.util.SplittableRandom;

/**
 *
 * @author DanielaMarioti
 */
public class Set {

    private final Player playerOne;
    private final Player playerTwo;
    private boolean type_score; //se false -> score , se true -> tieBreak
    private boolean playerMakePoint;
    private boolean advantage;
    private boolean type_scan;
    private Scanner scan;
    private SplittableRandom random;
    private Player winner;

    public Set(Player p1, Player p2, boolean type_scan) {
        this.random = new SplittableRandom(); //Instância desplittableRandom.Números aleatórios não uniformes
        this.scan = new Scanner(System.in);
        //Scanner scanner = new Scanner(System.in);
        // System.out.println("novo ponto");
        // String s = scanner.nextLine();
        this.playerOne = p1;
        this.playerTwo = p2;
        this.winner = null;
        this.type_score = false; // Valor padrão
        this.playerMakePoint = false; // false -> jogador 1 , true -> jogador 2
        this.advantage = false; // false -> deuce, true -> advantage
        this.type_scan = type_scan;//false -> random, true -> scan
    }

    public Player getWinner() {
        return winner;
    }

    /**
     * Método de pontuação dos jogadores Adiciona a pontuação do jogador,de
     * acordo com o return.
     */
    public void makePoint() {
        int n;
        if (type_scan) {
            System.out.println("Digite qual jogador fez o ponto (1/2)");
            n = scan.nextInt();
            n -= 1;
        } else {
            n = random.nextInt();// gera próximo número aleatório
        }
        if (n % 2 == 0) {  // jogador1 
            playerMakePoint = false;
            System.out.println("Jogador 1 fez ponto");
        } else { //jogador2
            playerMakePoint = true;
            System.out.println("Jogador 2 fez ponto");
        }
    }

    /**
     * Métodos de verificação do vencedor Segue o padrão, de acordo com as 4
     * regras do jogo de tênis.
     *
     * @return true se o set acabou e false caso ainda não tenha terminado.
     */
    public boolean isFinished() {
        if (type_score && playerOne.getTieBreak() == TieBreak.ADVANTAGE && !playerMakePoint && advantage) {
            System.out.println("Jogador 1 ganhou o set");
            winner = playerOne;
            return true;
        } else if (type_score && playerTwo.getTieBreak() == TieBreak.ADVANTAGE && playerMakePoint && advantage) {
            System.out.println("Jogador 2 ganhou o set");
            winner = playerTwo;
            return true;
        } else if (!type_score && playerOne.getScore() == Score.FORTY && (playerTwo.getScore() == Score.FIFTEEN || playerTwo.getScore() == Score.LOVE)) {
            System.out.println("Jogador 1 ganhou o set");
            winner = playerOne;
            return true;
        } else if (!type_score && playerTwo.getScore() == Score.FORTY && (playerOne.getScore() == Score.FIFTEEN || playerOne.getScore() == Score.LOVE)) {
            System.out.println("Jogador 2 ganhou o set");
            winner = playerTwo;
            return true;
        }
        return false;
    }

    /**
     * Métodos de troca de score Segundo as regras do jogo de tênis, troca o
     * score para tieBreak.
     */
    public void changeTypeScore() {
        if (((playerOne.getScore() == Score.THIRTY) || (playerOne.getScore() == Score.FORTY)) && ((playerTwo.getScore() == Score.THIRTY) || (playerTwo.getScore() == Score.FORTY))) {
            type_score = true; // TieBreak
        } else {
            type_score = false; // Score
        }
    }

    /**
     * Método que imprime o score do jogo
     */
    private void printScore() {
        if (!type_score) {
            System.out.println("SCORE: " + playerOne.getScore() + " x " + playerTwo.getScore());
        } else {
            if (playerOne.getTieBreak() == TieBreak.DEUCE || playerTwo.getTieBreak() == TieBreak.DEUCE) {
                System.out.println("DEUCE");
            } else if (playerOne.getTieBreak() == TieBreak.ADVANTAGE) {
                System.out.println("Jogador 1: ADVANTAGE");
            } else {
                System.out.println("Jogador 2: ADVANTAGE");
            }
        }
        System.out.println("--------------------");
    }

    public void start() {
        while (!isFinished()) {

            makePoint();

            if (!type_score) { // score
                if (!playerMakePoint) { //jogador1
                    playerOne.addPoint(); //add +1 
                } else {
                    playerTwo.addPoint(); // add +1
                }
            } else { //tieBreak
                if (playerOne.getTieBreak() == TieBreak.DEUCE) { //empate
                    if (!playerMakePoint) { //jogador1
                        playerOne.addPointDoA(); // em vantagem
                        playerTwo.lostPointDoA(); // em desvantagem
                    } else {
                        playerOne.lostPointDoA(); // em desvantagem
                        playerTwo.addPointDoA(); // em vantagem
                    }
                    advantage = true;
                } else {
                    if (playerOne.getTieBreak() == TieBreak.ADVANTAGE && playerMakePoint) {// jogador 2 fez ponto
                        playerOne.deuce();
                        playerTwo.deuce();
                        advantage = false;
                    } else if (playerTwo.getTieBreak() == TieBreak.ADVANTAGE && !playerMakePoint) { // jogador 1 fez ponto
                        playerOne.deuce();
                        playerTwo.deuce();
                        advantage = false;
                    } else {
                        if (isFinished()) {
                            return;
                        }
                    };
                }
            }
            changeTypeScore(); // verifica a necessidade de troca de score
            printScore();
        }

    }

}
