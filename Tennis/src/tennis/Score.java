package tennis;

/**
 * @author DanielaMarioti
 * Clasee enumerada de valores iniciais pré-definidos.
 * Enumera de maneira fixa, os campos escolhidos (LOVE,FIFTEEN, THIRTY E FORTY).
 */
public enum Score {
    LOVE("love"), FIFTEEN("fifteen"), THIRTY("thirty"), FORTY("forty");
    private final String score;
    
    private static final Score[] listaDeValoresPossiveis = values();
    
    /**
     * lista de valores Possíveis + 1
     * @return o próximo valor
     */
    public Score next() {
        return listaDeValoresPossiveis[(this.ordinal() + 1)];
    }

    /**
     * Método construtor da classe Score
     * @param  score
     */
    Score(String score) {
        this.score = score;
    }

    /**
     * @return score
     */
    @Override
    public String toString() {
        return score;
    }

}
