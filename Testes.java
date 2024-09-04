//Código para ler um txt
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
class Testes{
    public static void main(String[] args) {
        String caminhoArquivo = "/workspaces/Exercicio-1-POO/tabela.txt";
        ArrayList<Time> lista= new ArrayList<Time>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int index=0;
            //código para imprimir todas as linhas do txt
              while ((linha = br.readLine()) != null) {
                if (linha.startsWith("| Classificação")|| linha.trim().isEmpty() || linha.startsWith("|---")) {
                    continue;
                }
                //Com essa separação cada coisa entre | vira um item do Array
                String[] coluna=linha.trim().split("\\|");
                String nomeTime=coluna[2].trim();
                //separação dos elementos do array em variáveis para criar um objeto Time
                int golsFeitos=Integer.valueOf(coluna[8].trim());
                int golsTomados=Integer.valueOf(coluna[9].trim());
                int vitoriasDoTime=Integer.valueOf(coluna[5].trim());

                //criação do objeto time
                Time t= new Time(nomeTime,golsFeitos,golsTomados,vitoriasDoTime);

                //adicionando em um ArrayList
                lista.add(index,t);
                index++;
            }
            String nome="Palmeiras";
            double porcentagem=1.0;
            for(Time t: lista){
                
                if((nome.toLowerCase().equals(t.getNome().toLowerCase()))){
                    
                    porcentagem= t.porcentVit();
                }
            }
            System.out.printf("foi de %.2f %%",porcentagem);
            System.out.printf("");
            //System.out.println((lista.get(0).getQuantVit()/38)*100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
