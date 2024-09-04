import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
class Campeonato{
    private String caminhoArquivo = "/workspaces/Exercicio-1-POO/tabela.txt";
    private ArrayList<Time> lista= new ArrayList<Time>();; // Transformei em Array, pois com ArrayList não estava conseguindo acessar os métodos da classe Time
    public Campeonato(){
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
                String nomeTime=coluna[2];
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String melhorDef(){
        int melhorDef=lista.get(0).getGolsT();
        String melhor="";
        for(int i=1; i<lista.size();i++){
            if(melhorDef>=lista.get(i).getGolsT()){
                melhorDef=lista.get(i).getGolsT();
            }
        }
        for (Time t: lista){
            if(t.getGolsT()==melhorDef){
                melhor+=t.getNome()+" ";
            }
        }
        return melhor.trim();
    }
    public double mediaVitCampeonato(){
        double soma=0;
        for(Time t: lista){
            soma+=t.getQuantVit();
        }
        return soma/380;
    }
    public double mediaCamp(){
        double soma=0;
        for(Time t: lista){
            soma+=t.getGolsF();
        }
        return (soma/380);
    }
}