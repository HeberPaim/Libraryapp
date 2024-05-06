package org.example;

import java.util.*;

public class SugestaoDeLivros{
    private final HashMap<Livro, Set<Livro>> recomendacoes;

    //construtor
    public SugestaoDeLivros(){
        this.recomendacoes = new HashMap<>();
    }
    public HashMap<Livro, Set<Livro>> getRecomendacoes(){
        return recomendacoes;
    }
    //adiciona node e suas arestas como um set de objetos Livro
    public void adicionarNode(Livro livro, HashSet<Livro> sugestoes){
        recomendacoes.putIfAbsent(livro, sugestoes);
    }

    //retorna recomendacoes de determinado node
    public HashSet<Livro> obterRecomendacoes(Livro livro){
        return (HashSet<Livro>) recomendacoes.getOrDefault(livro, null);
    }

    public void adicionarRecomendacoes(Livro livro, HashSet<Livro> novasRecomendacoes){
        HashSet<Livro> recomendacoesAtuais = this.obterRecomendacoes(livro);
        recomendacoesAtuais.addAll(novasRecomendacoes);
        recomendacoes.put(livro, novasRecomendacoes);
    }

    public static Map<Livro, Integer> recomendacoesPrioritarias(HashMap<Livro, Set<Livro>> grafo, Livro origem) {

        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        distancias.put(origem, 0); // como não temos pesos entre os nós, o peso padrão é 0
        fila.add(origem);

        while (!fila.isEmpty()) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    fila.add(vizinho);
                }
            }
        }
        // Converte o Mapa em uma lista de todos os registros do mapa
        List<Map.Entry<Livro, Integer>> entradasOrdenadas = new ArrayList<>(distancias.entrySet());

        // ordena ele baseado nas distancias (values)
        entradasOrdenadas.sort(Map.Entry.comparingByValue());

        // LinkedHashmap to maintain the order of insertion
        Map<Livro, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<Livro, Integer> entry : entradasOrdenadas) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }

        return mapaOrdenado;
    }
}