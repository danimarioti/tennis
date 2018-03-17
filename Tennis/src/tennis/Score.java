package tennis;

/**
 *
 * @author udesc
 */
public enum Score {
    LOVE("love"), FIFTEEN("fifteen"), THIRTY("thirty"), FORTY("forty");
    private final String score;
    
    private static final Score[] listaDeValoresPossiveis = values();

    
    /**
     * 
     * @return 
     */
    public Score next() {
        return listaDeValoresPossiveis[(this.ordinal() + 1)];
    }

    /**
     * 
     * @param score 
     */
    Score(String score) {
        this.score = score;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return score;
    }

}
