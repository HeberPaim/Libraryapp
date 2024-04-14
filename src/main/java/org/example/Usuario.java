package org.example;
import java.util.HashSet;
import java.util.Stack;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private final HistoricoDeConsulta historico = new HistoricoDeConsulta();
    private final HashSet<Livro> recomendados;

    // Construtor
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.recomendados = new HashSet<>();
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void visualizaLivro(Livro livro){
        historico.registrarConsulta(livro);
    }
    //overload p adicionar novos livros as recomendacoes de um livro quando ele for visualizado
    public void visualizaLivro(Livro livro, SugestaoDeLivros recomendacao){
        historico.registrarConsulta(livro);
        recomendacao.adicionarRecomendacoes(livro, this.getHistorico());
    }
    //visualiza o historico recente do usuario
    public void visualizaHistorico(){
        Stack<Livro> historicoDeConsulta = historico.getHistorico();
        System.out.println("\nVisualizando histórico para o seguinte usuário: "+this.nome+"\n");

        for (Object livro : historicoDeConsulta){
            System.out.println(livro);
        }
    }

    public HashSet<Livro> getHistorico(){
        HashSet<Livro> set = new HashSet<>(this.historico.getHistorico());
        return set;
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