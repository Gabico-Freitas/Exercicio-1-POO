/**
 * Classe que representa um time do campeonato com informações sobre gols feitos, gols tomados e vitórias.
 *
 * @author pedro.younes@edu.pucrs.br
 * @author g.silva027@edu.pucrs.br
 */
class Time {
  private int golsF, golsT, quantVit;
  private String nome;

  /**
   * Construtor para criar um objeto com as informações fornecidas.
   * 
   * @param nome Nome do time.
   * @param golsF Número de gols feitos pelo time.
   * @param golsT Número de gols tomados pelo time.
   * @param quantVit Número de vitórias do time.
   */
  public Time(String nome, int golsF, int golsT, int quantVit) {
      this.nome = nome;
      this.golsF = golsF;
      this.golsT = golsT;
      this.quantVit = quantVit;
  }

  /**
   * Obtém o nome do time.
   * 
   * @return Nome do time.
   */
  public String getNome() {
      return nome;
  }

  /**
   * Obtém o número de gols feitos pelo time.
   * 
   * @return Número de gols feitos.
   */
  public int getGolsF() {
      return golsF;
  }

  /**
   * Obtém o número de gols tomados pelo time.
   * 
   * @return Número de gols tomados.
   */
  public int getGolsT() {
      return golsT;
  }

  /**
   * Obtém o número de vitórias do time.
   * 
   * @return Número de vitórias.
   */
  public double getQuantVit() {
      return quantVit;
  }

  /**
   * Calcula a porcentagem de vitórias do time em relação ao número total de jogos.
   * 
   * @return Porcentagem de vitórias.
   */
  public double porcentVit() {
      return ((getQuantVit() / 38.0) * 100);
  }

  /**
   * Retorna uma string das informações do time.
   * 
   * @return String contendo o nome do time, gols feitos, gols tomados e vitórias.
   */
  @Override
  public String toString() {
      return nome + "\nGols: " + golsF + "\nGols contra: " + golsT + "\nJogos vencidos: " + quantVit;
  }
}
