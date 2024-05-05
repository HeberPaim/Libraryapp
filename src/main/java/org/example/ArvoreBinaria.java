package org.example;

class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Inserção
    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    private No inserirRecursivo(No atual, Livro book) {
        if (atual == null) {
            return new No(book);
        }

        if (book.getAnoDePublicacao() < atual.livro.getAnoDePublicacao()) {
            atual.esquerda = inserirRecursivo(atual.esquerda, book);
        } else if (book.getAnoDePublicacao() > atual.livro.getAnoDePublicacao()) {
            atual.direita = inserirRecursivo(atual.direita, book);
        }

        return atual;
    }

    // Busca
    public boolean buscar(Livro book){
        return buscarRecursivo(raiz, book);
    }

    private boolean buscarRecursivo(No atual, Livro book) {
        if (atual == null) {
            return false;
        }

        if (book.getAnoDePublicacao() == atual.livro.getAnoDePublicacao()) {
            return true;
        }

        return book.getAnoDePublicacao() < atual.livro.getAnoDePublicacao()
                ? buscarRecursivo(atual.esquerda, book)
                : buscarRecursivo(atual.direita, book);
    }

    // Remoção
    public void remover(Livro book) {
        raiz = removerRecursivo(raiz, book);
    }

    private No removerRecursivo(No atual, Livro book) {
        if (atual == null) {
            return null;
        }

        if (book.getAnoDePublicacao() == atual.livro.getAnoDePublicacao() ) {
            // Nó sem filho
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }
            // Nó com um filho
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }

            // Nó com dois filhos
            Livro maiorValor = buscarMaiorValor(atual.esquerda);
            atual.livro = maiorValor;
            atual.esquerda = removerRecursivo(atual.esquerda, maiorValor);
            return atual;
        }

        if (book.getAnoDePublicacao() < atual.livro.getAnoDePublicacao()) {
            atual.esquerda = removerRecursivo(atual.esquerda, book);
            return atual;
        }

        atual.direita = removerRecursivo(atual.direita, book);
        return atual;
    }

    private Livro buscarMaiorValor(No raiz) {
        return raiz.direita == null ? raiz.livro : buscarMaiorValor(raiz.direita);
    }

    // Mostrar árvore em preordem
    public void mostrar() {
        mostrarRecursivo(raiz, 0);
    }

    private void mostrarRecursivo(No atual, int nivel) {
        if (atual != null) {
            if (nivel > 0){
                System.out.print("     ".repeat(nivel - 1) +  "└----");
            }

            System.out.println(atual.livro);
            // Para cada nível, aumentamos o nível para os nós filhos
            mostrarRecursivo(atual.esquerda, nivel + 1);
            mostrarRecursivo(atual.direita, nivel + 1);
        }
    }
}
class No {
    Livro livro;
    No esquerda;
    No direita;

    public No(Livro livro) {
        this.livro = livro;
        esquerda = null;
        direita = null;
    }
}

