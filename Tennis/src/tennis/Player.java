package tennis;

/**
 * sadfasdf
 * @author udesc
 */
public class Player {
    private Score score;

    /**
     * 
     */
    public Player() {
        this.score = Score.LOVE1;
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
}
