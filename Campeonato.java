import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
class Campeonato{
    private String caminhoArquivo = "/workspaces/Exercicio-1-POO/tabela.txt";
    private ArrayList<Time> lista= new ArrayList<Time>(); // Transformei em Array, pois com ArrayList não estava conseguindo acessar os métodos da classe Time
    public Campeonato() throws IOException{
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

        } catch (IOException e) {
            System.out.println("Erro: Não foi possível ler o arquivo no caminho fornecido: " + caminhoArquivo);
            System.out.println("Verifique se o caminho está correto e se o arquivo existe.");
            throw e;
        }
    }
    public ArrayList <Time> melhorDef(){
        int melhorDef=lista.get(0).getGolsT();
        ArrayList<Time> melhorD= new ArrayList<Time>();
        for(int i=1; i<lista.size();i++){
            if(melhorDef>=lista.get(i).getGolsT()){
                melhorDef=lista.get(i).getGolsT();
            }
        }
        for (Time t: lista){
            if(t.getGolsT()==melhorDef){
                melhorD.add(t);
            }
        }
        return melhorD;
    }
    public ArrayList <Time> melhorAtq(){
        int melhorAtq=lista.get(0).getGolsF();
        ArrayList<Time> melhorA= new ArrayList<Time>();
        for(int i=1; i<lista.size();i++){
            if(melhorAtq<=lista.get(i).getGolsF()){
                melhorAtq=lista.get(i).getGolsF();
            }
        }
        for (Time t: lista){
            if(t.getGolsF()==melhorAtq){
                melhorA.add(t);
            }
        }
        return melhorA;
    }
    public ArrayList <Time> piorAtq(){
        int piorAtq=lista.get(0).getGolsF();
        ArrayList<Time> piorA= new ArrayList<Time>();
        for(int i=1; i<lista.size();i++){
            if(piorAtq>=lista.get(i).getGolsF()){
                piorAtq=lista.get(i).getGolsF();
            }
        }
        for (Time t: lista){
            if(t.getGolsF()==piorAtq){
                piorA.add(t);
            }
        }
        return piorA;
    }
    public ArrayList <Time> piorDef(){
        int piorDef=lista.get(0).getGolsT();
        ArrayList<Time> piorD= new ArrayList<Time>();
        for(int i=1; i<lista.size();i++){
            if(piorDef<=lista.get(i).getGolsT()){
                piorDef=lista.get(i).getGolsT();
            }
        }
        for (Time t: lista){
            if(t.getGolsT()==piorDef){
                piorD.add(t);
            }
        }
        return piorD;
    }
    public boolean validaTime(String nome){
        for(Time t: lista){
            if((nome.toLowerCase().equals(t.getNome().toLowerCase()))){
                return true;
            }
        }
        return false;
    }
    public double mediaVitTime(String nome){
        double porcentagem=0;
        for(Time t: lista){
            if((nome.toLowerCase().equals(t.getNome().toLowerCase()))){
                return t.porcentVit();
            }
        }
        return porcentagem;
    }
    public double mediaCamp(){
        double soma=0;
        for(Time t: lista){
            soma+=t.getGolsF();
        }
        return (soma/380);
    }
}