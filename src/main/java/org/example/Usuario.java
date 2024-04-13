package org.example;
import java.util.Stack;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private final HistoricoDeConsulta historico = new HistoricoDeConsulta();

    // Construtor
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
//    public void visualizaHistorico(){
//        Stack<String> pilhaTemp = new Stack<>();
//        pilhaTemp.addAll(historico);
//        historico.consultarMaisRecente
//    }
    // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}