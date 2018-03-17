/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.util.SplittableRandom;

/**
 *
 * @author udesc
 */
class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private boolean type_score; //se false -> score , se true -> score_doa
    private SplittableRandom random;
    
    public Game(Player P1,Player P2){
        this.random = new SplittableRandom();
        this.playerOne=P1;
        this.playerTwo=P2;
        this.type_score=false;
    }
    
    private boolean MakePoint(){ 
        int n;
        n = random.nextInt();
        if(n%2==0){
            System.out.println("Jogador 1 fez ponto");
            if(playerTwo.getScore_DoA()==Score_DoA.ADVANTAGE){   
                playerOne.deuce();
                playerTwo.deuce();
                System.out.println("DEUCE");
                System.out.println("--------------------");
            }
            return false; //jogador 1 fez ponto
        }
        else{
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
    
    private void ChangeTypeScore(){
        if(((playerOne.getScore()==Score.THIRTY) || (playerOne.getScore()==Score.FORTY)) && ((playerTwo.getScore()==Score.THIRTY) || (playerTwo.getScore()==Score.FORTY))){
            type_score=true;
        }
        else{
            type_score=false;
        }
    }
    
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
            if(!type_score){
                if(!MakePoint()){
                    playerOne.addPoint();
                }
                else{
                    playerTwo.addPoint();
                }
                ChangeTypeScore();
            }
            else{
                if(playerOne.getScore_DoA()==Score_DoA.DEUCE){
                    if(!MakePoint()){
                        playerOne.addPointDoA();
                        playerTwo.lostPointDoA();
                    }
                    else{
                        playerOne.lostPointDoA();
                        playerTwo.addPointDoA();
                    }
                }                
            }
            PrintScore();
        }
    }
}
