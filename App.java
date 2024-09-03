
import java.util.ArrayList;
class App{
    public static void main (String [] args){
        Campeonato jogo= new Campeonato();
        Time [] lista;
        lista=jogo.lerArquivo();
        
        System.out.println(lista[0].getNome());
    }
}