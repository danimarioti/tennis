package tennis;

/**
 * 
 * @author udesc
 */
public class Player {
    private Score score;
    private Score_DoA score_doa;

    /**
     * 
     */
    public Player() {
        this.score = Score.LOVE;
        this.score_doa=Score_DoA.DEUCE;
    }
    
    /**
     * 
     */
    public void addPoint() {
       score = score.next();
    }
    
    public Score getScore() {
        return this.score;
    }
    
    public void addPointDoA(){
        score_doa=Score_DoA.ADVANTAGE;
    }
    
    public void lostPointDoA(){
        score_doa=Score_DoA.DISADVANTAGE;
    }
    
    public void deuce(){
        score_doa=Score_DoA.DEUCE;
    }
    
    public Score_DoA getScore_DoA(){
        return this.score_doa;
    }
    
}
