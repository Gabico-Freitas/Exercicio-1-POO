import java.util.Scanner;
import java.util.ArrayList;
class App{
    private static Scanner teclado = new Scanner(System.in);
    public static void main (String [] args){
        
        Campeonato jogo= new Campeonato();
        int escolha;
        do {
            System.out.println("\f");
            System.out.println("O que você deseja fazer?");
            menu();
            escolha=teclado.nextInt();
            switch (escolha) {
                case 1:
                    System.out.printf("O time com a melhor defesa do campeonato foi o "+ escolha);
                    break;
                case 2:
                    System.out.printf("O time com o melhor ataque do campeonato foi o "+ escolha);
                    break;
                case 3:
                    System.out.printf("O time com o pior ataque do campeonato foi o "+ escolha);    
                    break;
                case 4:
                    System.out.printf("O time com a pior defesa do campeonato foi o "+ escolha);
                    break;
                case 5:
                    System.out.printf("A média de gols por partida no campeonato foi de ");  
                    break;
                case 6:
                    System.out.printf("Quer a porcentagem de vitorias em relação ao numero de jogos total do campeonato ou específica de algum time?");
                    System.out.printf("\nDigite 1 para total e 2 para individual\n");
                    int opcao=teclado.nextInt();                   
                    if(opcao==1){
                        System.out.printf("\nPorcentagem de vitorias em relação ao numero de jogos total do campeonato foi de "+ escolha);
                    }
                    else{
                        System.out.printf("\nPorcentagem de vitorias em relação ao numero de jogos individual do time escolhido foi de"+ escolha);
                    }
                    break;
                default:
                    break;
            }
            
        }while (escolha!=7);
        teclado.close();
    }
    //Método para esperar antes de aparecer o menu, não está funcionando corretamente
    // public static void waitLine() {
    //     System.out.println("\nPressione Enter para continuar...");
    //     teclado.nextLine();
    // }
    
    //Método de menu, pode ser feito em outro local futuramente
    public static void menu(){
        System.out.printf("1 Time com a melhor defesa ");
        System.out.printf("\n2 Time com o melhor ataque do campeonato");
        System.out.printf("\n3 Time com o pior ataque");
        System.out.printf("\n4 Time com a pior defesa");
        System.out.printf("\n5 Média de gols por partida no campeonato");
        System.out.printf("\n6 Porcentagem de vitorias em relação ao numero de jogos");
        System.out.printf("\n7 Encerrar a aplicação");
    }


}
