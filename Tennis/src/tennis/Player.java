package tennis;
/**
 * Classe de criação dos jogadores
 * @author DanielaMarioti
 */
public class Player {
    private Score score;
    private Score_DoA score_doa;

    /**
     * Método construtor de um jogador
     * O atributo Score inicia sempre em LOVE
     * O atributo Score_DoA inicia sempre Deuce
     */
    public Player() {
        this.score = Score.LOVE;
        this.score_doa=Score_DoA.DEUCE;
    }
    
    /**
     * Método para aumentar a pontuação do jogador
     * Adiciona mais um ponto da classe Score
     */
    public void addPoint() {
       score = score.next(); 
    }
    
    /**
     * Método para aumentar a pontuação do jogador
     * @return  a nova pontuação do jogador, da classe Score
     */
    public Score getScore() {
        return this.score; 
    }
    
    /**
     * Método para aumentar a pontuação do jogador
     * Atribui vantagem ao jogador, da classe Score_DoA
     */
    public void addPointDoA(){
        score_doa=Score_DoA.ADVANTAGE; 
    }
    
     /**
     * Métodos para diminuir a pontuação do jogador
     * Atribui desvantagem ao jogador, da classe Score_DoA
     */
    public void lostPointDoA(){
        score_doa=Score_DoA.DISADVANTAGE; 
    }
    
     /**
     * Métodos para atribuir empate ao jogador
     * Atribui DEUCE ao jogador, da classe Score_DoA
     */
    public void deuce(){
        score_doa=Score_DoA.DEUCE; // Adiciona aos dois jogadores (empate)
    }
    
     /**
     *@return Score_DoA
     */
    public Score_DoA getScore_DoA(){
        return this.score_doa; 
    }
    
}
