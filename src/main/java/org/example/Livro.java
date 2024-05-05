package org.example;

public class Livro {
    private final String titulo;
    private final String autor;
    private final int anoDePublicacao;

    public String getTitulo() {
        return titulo;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public Livro(String titulo, String autor, int anoDePublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
    }

    //printa mais bonito
    @Override
    public String toString(){
        return "{titulo: "+ titulo + ",autor: " + autor + ",anoPublicacao: " + anoDePublicacao+"}";
    }

}
