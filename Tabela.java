//Código para ler um txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Tabela{
    public static void main(String[] args) {
        String caminhoArquivo = "/workspaces/Exercicio-1-POO/tabela.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            
            //código para imprimir todas as linhas do txt
              while ((linha = br.readLine()) != null) {
                if (linha.startsWith("| Classificação")|| linha.trim().isEmpty() || linha.startsWith("|---")) {
                    continue;
                }
                //Com essa separação cada coisa entre | vira um item do Array
                String[] coluna=linha.trim().split("\\|");
                System.out.println(coluna[2]);
              }
              
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}