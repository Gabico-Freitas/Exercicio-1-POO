class Time{
  private int golsF, golsT,quantVit;
  private String nome;
  public Time(String nome, int golsF, int golsT, int quantVit){
    this.nome=nome;
    this.golsF=golsF;
    this.golsT=golsT;
    this.quantVit=quantVit;
  }
  public String getNome(){
    return nome;
  }
  public int getGolsF(){
    return golsF;
  }
  public int getGolsT(){
    return golsT;
  }
  public double getQuantVit(){
    return quantVit;
  }
  public double porcentVit(){
    return ((getQuantVit()/38)*100);
  }
  public String toString(){
    return nome+"\nGols: "+golsF+"\nGols contra: "+golsT+"\nJogos vencidos: "+quantVit;
  }
  
}
