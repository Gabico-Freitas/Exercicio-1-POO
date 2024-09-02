//Código para ler um txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Tabela{
    public static void main(String[] args) {
        String caminhoArquivo = "/workspaces/Exercicio-1-POO/tabela.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha= br.readLine();
            //código para imprimir todas as linhas do txt
            //  while ((linha) != null) {
            //     for (int i=0;i<linha.length();i++){
            //     }
            //     System.out.println(linha);
            //  }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}