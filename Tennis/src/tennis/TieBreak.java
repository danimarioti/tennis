package tennis;

/**
 * Classe enumerada de construção dos campos extras (empate, vantagem e desvantagem),
 * que são utilizados de acordo com a regra do jogo.
 * @author DanielaMarioti
 */

public enum TieBreak {
    DEUCE("deuce"),ADVANTAGE("advantage"),DISADVANTAGE("disadvantage");
    private final String tieBreak;
    
    private static final TieBreak[] listaDeValoresPossiveis = values();

    /**
     * Método construtor da classe TieBreak
     * @param score_deuce_or_advantage
     */
    TieBreak(String tieBreak) {
        this.tieBreak = tieBreak;
    }
    
    /**
     * @return tieBreak 
     */
    @Override
    public String toString() {
        return tieBreak;
    }

}
