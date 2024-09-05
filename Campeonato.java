import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe campeonato, responsável por a tabela e fornecer estatísticas sobre os times.
 */
class Campeonato {
    private String caminhoArquivo = "/workspaces/Exercicio-1-POO/tabela.txt";
    private ArrayList<Time> lista = new ArrayList<Time>();

    /**
     * Construtor que lê os dados de um arquivo e inicializa a tabela.
     */
    public Campeonato() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int index = 0;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("| Classificação") || linha.trim().isEmpty() || linha.startsWith("|---")) {
                    continue;
                }

                String[] coluna = linha.trim().split("\\|");
                String nomeTime = coluna[2].trim();
                int golsFeitos = Integer.valueOf(coluna[8].trim());
                int golsTomados = Integer.valueOf(coluna[9].trim());
                int vitoriasDoTime = Integer.valueOf(coluna[5].trim());

                Time t = new Time(nomeTime, golsFeitos, golsTomados, vitoriasDoTime);

                lista.add(index, t);
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtém a lista de times com a melhor defesa (menor número de gols tomados).
     * 
     * @return Lista de times com a melhor defesa.
     */
    public ArrayList<Time> melhorDef() {
        int melhorDef = lista.get(0).getGolsT();
        ArrayList<Time> melhorD = new ArrayList<Time>();

        for (int i = 1; i < lista.size(); i++) {
            if (melhorDef >= lista.get(i).getGolsT()) {
                melhorDef = lista.get(i).getGolsT();
            }
        }

        for (Time t : lista) {
            if (t.getGolsT() == melhorDef) {
                melhorD.add(t);
            }
        }

        return melhorD;
    }

    /**
     * Obtém a lista de times com o melhor ataque (maior número de gols feitos).
     * 
     * @return Lista de times com o melhor ataque.
     */
    public ArrayList<Time> melhorAtq() {
        int melhorAtq = lista.get(0).getGolsF();
        ArrayList<Time> melhorA = new ArrayList<Time>();

        for (int i = 1; i < lista.size(); i++) {
            if (melhorAtq <= lista.get(i).getGolsF()) {
                melhorAtq = lista.get(i).getGolsF();
            }
        }

        for (Time t : lista) {
            if (t.getGolsF() == melhorAtq) {
                melhorA.add(t);
            }
        }

        return melhorA;
    }

    /**
     * Obtém a lista de times com o pior ataque (menor número de gols feitos).
     * 
     * @return Lista de times com o pior ataque.
     */
    public ArrayList<Time> piorAtq() {
        int piorAtq = lista.get(0).getGolsF();
        ArrayList<Time> piorA = new ArrayList<Time>();

        for (int i = 1; i < lista.size(); i++) {
            if (piorAtq >= lista.get(i).getGolsF()) {
                piorAtq = lista.get(i).getGolsF();
            }
        }

        for (Time t : lista) {
            if (t.getGolsF() == piorAtq) {
                piorA.add(t);
            }
        }

        return piorA;
    }

    /**
     * Obtém a lista de times com a pior defesa (maior número de gols tomados).
     * 
     * @return Lista de times com a pior defesa.
     */
    public ArrayList<Time> piorDef() {
        int piorDef = lista.get(0).getGolsT();
        ArrayList<Time> piorD = new ArrayList<Time>();

        for (int i = 1; i < lista.size(); i++) {
            if (piorDef <= lista.get(i).getGolsT()) {
                piorDef = lista.get(i).getGolsT();
            }
        }

        for (Time t : lista) {
            if (t.getGolsT() == piorDef) {
                piorD.add(t);
            }
        }

        return piorD;
    }

    /**
     * Verifica se um time especifico está presente na lista de times.
     * 
     * @param nome Nome do time a ser verificado.
     * @return {@code true} se o time estiver na lista, {@code false} caso contrário.
     */
    public boolean validaTime(String nome) {
        for (Time t : lista) {
            if (nome.toLowerCase().equals(t.getNome().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula a porcentagem de vitórias de um time específico em relação ao número total de jogos do campeonato.
     * 
     * @param nome Nome do time para o qual a porcentagem de vitórias deve ser calculada.
     * @return Porcentagem de vitórias do time especificado, ou 0 se o time não for encontrado.
     */
    public double mediaVitTime(String nome) {
        double porcentagem = 0;
        for (Time t : lista) {
            if (nome.toLowerCase().equals(t.getNome().toLowerCase())) {
                return t.porcentVit();
            }
        }
        return porcentagem;
    }

    /**
     * Calcula a média de gols feitos por partida no campeonato.
     * 
     * @return Média de gols por partida.
     */
    public double mediaCamp() {
        double soma = 0;
        for (Time t : lista) {
            soma += t.getGolsF();
        }
        return (soma / 380);
    }
}
