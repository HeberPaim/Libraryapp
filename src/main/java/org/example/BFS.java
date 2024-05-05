package org.example;
import java.util.Queue;

import java.util.LinkedList;


class BFS {
    public static boolean percorrerArvore(No raiz, String titulo) {
        if (raiz == null) {
            return false;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No node = fila.poll();

            System.out.println(node.livro.getTitulo());

            if (node.livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Livro encontrado com BFS!");
                return true;
            }

            if (node.esquerda != null) {
                fila.add(node.esquerda);
            }
            if (node.direita != null) {
                fila.add(node.direita);
            }
        }
        return false;
    }
}
