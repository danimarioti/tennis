package tennis;

/**
 * Classe de criação dos jogadores
 *
 * @author DanielaMarioti
 */
public class Player {

    private String name;

    public String getName() {
        return name;
    }
    private Score score;
    private TieBreak tieBreak;

    /**
     * Método construtor de um jogador O atributo Score inicia sempre em LOVE O
 atributo TieBreak inicia sempre Deuce
     */
    public Player(String name) {
        this.name = name;
        this.score = Score.LOVE;
        this.tieBreak = TieBreak.DEUCE;
    }

    public void resetPlayer() {
        this.score = Score.LOVE;
        this.tieBreak = TieBreak.DEUCE;
    }

    /**
     * Jogador padrão
     */
    public Player() {
        this("Guga");
    }

    /**
     * Método para aumentar a pontuação do jogador Adiciona mais um ponto da
     * classe Score
     */
    public void addPoint() {
        score = score.next();
    }

    /**
     * Método para aumentar a pontuação do jogador
     *
     * @return a nova pontuação do jogador, da classe Score
     */
    public Score getScore() {
        return this.score;
    }

    /**
     * Método para aumentar a pontuação do jogador Atribui vantagem ao jogador,
 da classe TieBreak
     */
    public void addPointDoA() {
        tieBreak = TieBreak.ADVANTAGE;
    }

    /**
     * Métodos para diminuir a pontuação do jogador Atribui desvantagem ao
 jogador, da classe TieBreak
     */
    public void lostPointDoA() {
        tieBreak = TieBreak.DISADVANTAGE;
    }

    /**
     * Métodos para atribuir empate ao jogador Atribui DEUCE ao jogador, da
 classe TieBreak
     */
    public void deuce() {
        tieBreak = TieBreak.DEUCE; // Adiciona aos dois jogadores (empate)
    }

    /**
     * @return TieBreak
     */
    public TieBreak getTieBreak() {
        return this.tieBreak;
    }

}
