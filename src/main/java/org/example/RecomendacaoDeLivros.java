package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

class SugestaoDeLivros{
    private final HashMap<Livro, Set<Livro>> recomendacoes;

    //construtor
    public SugestaoDeLivros(){
        this.recomendacoes = new HashMap<>();
    }

    //adiciona node e suas arestas como um set de objetos Livro
    public void adicionarNode(Livro livro, Set<Livro> sugestoes){
        recomendacoes.put(livro, sugestoes);
    }
    //retorna recomendacoes de determinado node
    public Set<Livro> obterRecomendacoes(Livro livro){
        return recomendacoes.getOrDefault(livro, Collections.emptySet());
    }
}
