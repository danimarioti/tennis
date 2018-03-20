package tennis;

/**
 * Classe enumerada de construção dos campos extras (empate, vantagem e desvantagem),
 * que são utilizados de acordo com a regra do jogo.
 * @author DanielaMarioti
 */

public enum Score_DoA {
    DEUCE("deuce"),ADVANTAGE("advantage"),DISADVANTAGE("disadvantage");
    private final String score_doa;
    
    private static final Score_DoA[] listaDeValoresPossiveis = values();

    /**
     * Método construtor da classe Score_DoA
     * @param score_deuce_or_advantage
     */
    Score_DoA(String score_doa) {
        this.score_doa = score_doa;
    }
    
    /**
     * @return score_doa 
     */
    @Override
    public String toString() {
        return score_doa;
    }

}
