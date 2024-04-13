package org.example;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LinkedList<Livro> prateleira = new LinkedList<>();
        Livro batata = new Livro("batata", "autor", 1900);
        prateleira.add(batata);
        Livro tomate = new Livro("tomate", "autor", 1998);
        prateleira.add(tomate);

        System.out.println(prateleira);
    }
}