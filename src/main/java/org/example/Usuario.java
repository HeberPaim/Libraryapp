package org.example;
import java.util.HashSet;

public class Usuario {
    private String nome;
    private String email;
    private final HistoricoDeConsulta historico = new HistoricoDeConsulta();
    private final HashSet<Livro> recomendacoes = new HashSet<>();

    // Construtor
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void visualizaLivro(Livro livro, SugestaoDeLivros recomendacao){
        historico.registrarConsulta(livro);
        //logo apos visualizar o livro ja adiciona as recomendacoes do livro no hashset de recomendacoes do usuario, assim o caminho ja fica meio andado
        recomendacoes.addAll(recomendacao.obterRecomendacoes(livro));
    }

    //overload p adicionar novos livros às recomendacoes de um livro quando ele for visualizado
//    public void visualizaLivro(Livro livro, SugestaoDeLivros recomendacao){
//        historico.registrarConsulta(livro);
//        recomendacao.adicionarRecomendacoes(livro, this.getHistorico());
//    }

    //visualiza o historico recente do usuario
    public void visualizaHistorico(){
        System.out.println("\nVisualizando histórico para o seguinte usuário: "+this.nome+"\n");

        for (Livro livro : historico.getHistorico()){
            System.out.println(livro);
        }
    }

    public void getRecomendacoes(){
        System.out.println("\nVisualizando recomendações para o seguinte usuário: "+this.nome+"\n");

        for (Livro livro : recomendacoes){
            System.out.println(livro);
        }
    }

    public HashSet<Livro> getHistorico(){
        return new HashSet<>(this.historico.getHistorico());
    }

    // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}