package org.example;

public class Livro {
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    private String titulo;
    private String autor;
    private int anoDePublicacao;

    public Livro(String titulo, String autor, int anoDePublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
    }

    //printa mais bonito
    @Override
    public String toString(){
        return titulo + " de " + autor + ", publicado em " + anoDePublicacao;
    }
    public void Main(String[] args){
        Livro book = new Livro("livrao ae", "um cara conhecido sepa", 1925);
        System.out.println("Title: " + book.getTitulo());
        System.out.println("Author: " + book.getAutor());
        System.out.println("Year of Publish: " + book.getAnoDePublicacao());
    }

}
