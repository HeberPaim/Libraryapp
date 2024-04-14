package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class SugestaoDeLivros{
    private final HashMap<Livro, Set<Livro>> recomendacoes;

    //construtor
    public SugestaoDeLivros(){
        this.recomendacoes = new HashMap<>();
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
}
