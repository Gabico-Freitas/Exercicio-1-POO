//Código para ler um txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Tabela{
    public static void main(String[] args) {
        String caminhoArquivo = "/workspaces/Exercicio-1-POO/tabela.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}