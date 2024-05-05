package org.example;

class DFS {
    public static boolean percorrerArvore(No node, String titulo) {
        if (node == null) {
            return false;
        }
        System.out.println(node.livro.getTitulo());
        if (node.livro.getTitulo().equalsIgnoreCase(titulo)) {
            System.out.println("Livro encontrado com DFS!");
            return true;
        }
        boolean res = percorrerArvore(node.esquerda, titulo);
        if(!res){
            res = percorrerArvore(node.direita, titulo);
        }
        return res;
    }
}