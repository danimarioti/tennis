package tennis;

/**
 *
 * @author udesc
 */
public enum Score {
    LOVE1("love 1"), LOVE2("love 2"), LOVE3("love 3"), FIFTEEN("fifteen"), THIRTY("thirty"), FORTY("forty");
    private final String score;

    private static Score[] listaDeValoresPossiveis = values();

    /**
     * 
     * @return 
     */
    public Score next() {
        return listaDeValoresPossiveis[(this.ordinal() + 1) % listaDeValoresPossiveis.length];
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
    public String toString() {
        return score;
    }

}
