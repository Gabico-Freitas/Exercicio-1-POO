import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
class App{
    private static Scanner teclado = new Scanner(System.in);
    public static void main (String [] args) throws IOException{
        
        Campeonato jogo= new Campeonato();
        int escolha;
        do {
            menu();
            escolha=teclado.nextInt();
            switch (escolha) {
                case 1:
                    ArrayList<Time> melhorDef= jogo.melhorDef();
                    int quantTimesD=melhorDef.size();
                    if(quantTimesD==1){
                        System.out.printf("O time com a melhor defesa do campeonato foi o "+melhorDef.get(0).getNome());
                    }
                    else{
                        System.out.printf("Houve empate entre "+quantTimesD+"!!\nOs times com a melhor defesa do campeonato foram o ");
                        for(int i=0;i<quantTimesD;i++){
                            if(i==0){
                                System.out.printf(melhorDef.get(i).getNome());
                            }
                            else if(i==(quantTimesD-1)){
                                System.out.printf(" e o "+melhorDef.get(i).getNome()+"\n");
                            }else{
                                System.out.printf(", o "+melhorDef.get(i).getNome());
                            }
                        }
                    }
                    break;
                case 2:
                    ArrayList<Time> melhorAtq= jogo.melhorAtq();
                    int quantTimesA=melhorAtq.size();
                    if(quantTimesA==1){
                        System.out.printf("O time com o melhor ataque do campeonato foi o "+melhorAtq.get(0).getNome());
                    }
                    else{
                        System.out.printf("Houve empate entre "+quantTimesA+"!!\nOs times com o melhor ataque do campeonato foram o ");
                        for(int i=0;i<quantTimesA;i++){
                            if(i==0){
                                System.out.printf(melhorAtq.get(i).getNome());
                            }
                            else if(i==(quantTimesA-1)){
                                System.out.printf(" e o "+melhorAtq.get(i).getNome()+"\n");
                            }else{
                                System.out.printf(", o "+melhorAtq.get(i).getNome());
                            }
                        }
                    }
                    break;
                case 3:
                    ArrayList<Time> piorAtq= jogo.piorAtq();
                    int quantTimesPa=piorAtq.size();
                    if(quantTimesPa==1){
                        System.out.printf("O time com o pior ataque do campeonato foi o "+piorAtq.get(0).getNome());
                    }
                    else{
                        System.out.printf("Houve empate entre "+quantTimesPa+"!!\nOs times com o pior ataque do campeonato foram o ");
                        for(int i=0;i<quantTimesPa;i++){
                            if(i==0){
                                System.out.printf(piorAtq.get(i).getNome());
                            }
                            else if(i==(quantTimesPa-1)){
                                System.out.printf(" e o "+piorAtq.get(i).getNome()+"\n");
                            }else{
                                System.out.printf(", o "+piorAtq.get(i).getNome());
                            }
                        }
                    }    
                    break;
                case 4:
                    ArrayList<Time> piorDef= jogo.piorDef();
                    int quantTimesPd=piorDef.size();
                    if(quantTimesPd==1){
                        System.out.printf("O time com a pior defesa do campeonato foi o "+piorDef.get(0).getNome());
                    }
                    else{
                        System.out.printf("Houve empate entre "+quantTimesPd+"!!\nOs times com a pior defesa do campeonato foram o ");
                        for(int i=0;i<quantTimesPd;i++){
                            if(i==0){
                                System.out.printf(piorDef.get(i).getNome());
                            }
                            else if(i==(quantTimesPd-1)){
                                System.out.printf(" e o "+piorDef.get(i).getNome()+"\n");
                            }else{
                                System.out.printf(", o "+piorDef.get(i).getNome());
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.printf("A média de gols por partida no campeonato foi de %.2f", jogo.mediaCamp());  
                    break;
                case 6:
                    teclado.nextLine();
                    System.out.printf("\nDe qual time você quer saber?\n");
                    String timeEscolhido=teclado.nextLine();
                    //trtamento de exceção, caso a pessoa digite um time que não existe
                    if(jogo.validaTime(timeEscolhido)){
                        System.out.printf("\nPorcentagem de vitorias em relação ao numero de jogos do "+timeEscolhido+" foi de %.2f %%", jogo.mediaVitTime(timeEscolhido));
                    }
                    else{
                        System.out.printf("\nSinto muito, mas parece que "+timeEscolhido+" não se esncontra na lista de times classificados,\n"
                                        +"verifique se não houve um erro de digitação.");
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.printf("A opção escolhida não está entre as indicadas, por favor tente novamente");
                    break;
            }    
        }while (escolha!=7);
        System.out.println("Obrigado por usar nossa aplicação");
        teclado.close();
    }
    //Método para esperar antes de aparecer o menu, não está funcionando corretamente
    // public static void waitLine() {
    //     System.out.println("\nPressione Enter para continuar...");
    //     teclado.nextLine();
    // }
    
    //Método de menu, pode ser feito em outro local futuramente
    public static void menu(){
        System.out.println("\f");
        System.out.println("O que você deseja fazer?");
        System.out.printf("1 Time com a melhor defesa ");
        System.out.printf("\n2 Time com o melhor ataque");
        System.out.printf("\n3 Time com o pior ataque");
        System.out.printf("\n4 Time com a pior defesa");
        System.out.printf("\n5 Média de gols por partida no campeonato");
        System.out.printf("\n6 Porcentagem de vitorias em relação ao numero de jogos");
        System.out.printf("\n7 Encerrar a aplicação\n");
    }
}