package tennis;

/**
 *
 * @author udesc
 */
public enum Score_DoA {
    DEUCE("deuce"),ADVANTAGE("advantage"),DISADVANTAGE("disadvantage");
    private final String score_doa;
    
    private static final Score_DoA[] listaDeValoresPossiveis = values();

    /**
     * 
     * @param score_deuce_or_advantage
     */
    Score_DoA(String score_doa) {
        this.score_doa = score_doa;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return score_doa;
    }

}
