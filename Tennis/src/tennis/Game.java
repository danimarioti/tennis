package tennis;

import java.util.SplittableRandom;

/**
 * Classe responsável pela lógica e controle do jogo
 * @author DanielaMarioti
 */
class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private boolean type_score; //se false -> score , se true -> score_doa
    private SplittableRandom random;
    
     /**
     * Método construtor do jogo.  
     * Recebe como parâmetros 2 jogadores.
     * Apresenta valor default: type_score=false.
     */
    
    public Game(Player P1,Player P2){
        this.random = new SplittableRandom(); //Instância desplittableRandom.Números aleatórios não uniformes
        this.playerOne=P1;
        this.playerTwo=P2;
        this.type_score=false; // Valor padrão
    }
    
    /**
     * Método de pontuação dos jogadores
     * Adiciona a pontuação do jogador,de acordo com o return.
     * @return false, para jogador1 e true, para jogador2 
     */
    private boolean MakePoint(){ 
        int n;
        n = random.nextInt(); // gera próximo número aleatório
        if(n%2==0){  // jogador1 
            System.out.println("Jogador 1 fez ponto");
            if(playerTwo.getScore_DoA()==Score_DoA.ADVANTAGE){   
                playerOne.deuce();
                playerTwo.deuce();
                System.out.println("DEUCE");
                System.out.println("--------------------");
            }
            return false; //jogador 1 fez ponto
        }
        else{ //jogador2
            System.out.println("Jogador 2 fez ponto");
            if(playerOne.getScore_DoA()==Score_DoA.ADVANTAGE){
                playerOne.deuce();
                playerTwo.deuce();
                System.out.println("DEUCE");
                System.out.println("--------------------");
            }
            return true; //jogador 2 fez ponto
        }
    }
    
     /**
     * Métodos de verificação do vencedor
     * Segue o padrão, de acordo com as 4 regras do jogo de tênis.  
     */
    private boolean Finished(){
        if(type_score &&  playerOne.getScore_DoA()==Score_DoA.ADVANTAGE && !MakePoint()){
            System.out.println("Jogador 1 ganhou o jogo");
            return true;
        }
       else if(type_score && playerTwo.getScore_DoA()==Score_DoA.ADVANTAGE && MakePoint()){
            System.out.println("Jogador 2 ganhou o jogo");
            return true;
        }
        else if(!type_score && playerOne.getScore()==Score.FORTY && (playerTwo.getScore()==Score.FIFTEEN || playerTwo.getScore()==Score.LOVE)){
            System.out.println("Jogador 1 ganhou o jogo");
            return true;
        }
        else if(!type_score && playerTwo.getScore()==Score.FORTY && (playerOne.getScore()==Score.FIFTEEN || playerOne.getScore()==Score.LOVE)){
            System.out.println("Jogador 2 ganhou o jogo");
            return true;
        }
        return false;
    }
    
     /**
     * Métodos de troca de score
     * Segundo as regras do jogo de tênis, troca o score para score_doa.
     */
    private void ChangeTypeScore(){
        if(((playerOne.getScore()==Score.THIRTY) || (playerOne.getScore()==Score.FORTY)) && ((playerTwo.getScore()==Score.THIRTY) || (playerTwo.getScore()==Score.FORTY))){
            type_score=true; // Score_DoA
        }
        else{
            type_score=false; // Score
        }
    }
    
     /**
     * Método que imprime o score do jogo
     */
    private void PrintScore(){ 
        if(!type_score){
            System.out.println("SCORE: "+playerOne.getScore()+" x " + playerTwo.getScore());
        }
        else{
           if(playerOne.getScore_DoA()==Score_DoA.DEUCE){
               System.out.println("DEUCE");
           } 
           else if(playerOne.getScore_DoA()==Score_DoA.ADVANTAGE){
               System.out.println("Jogador 1: ADVANTAGE");
           }
           else{
               System.out.println("Jogador 2: ADVANTAGE");
           }
        }
        System.out.println("--------------------");
    }
    
    public void Start(){
        while(!Finished()){
            if(!type_score){ // score
                if(!MakePoint()){ //jogador1
                    playerOne.addPoint(); //add +1 
                }
                else{
                    playerTwo.addPoint(); // add +1
                }
                ChangeTypeScore(); // verifica a necessidade de troca de score
            }
            else{ //score_doa
                if(playerOne.getScore_DoA()==Score_DoA.DEUCE){ //empate
                    if(!MakePoint()){ //jogador1
                        playerOne.addPointDoA(); // em vantagem
                        playerTwo.lostPointDoA(); // em desvantagem
                    }
                    else{
                        playerOne.lostPointDoA(); // em desvantagem
                        playerTwo.addPointDoA(); // em vantagem
                    }
                }                
            }
            PrintScore();
        }
    }
}
