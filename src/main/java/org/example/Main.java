package org.example;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //cria usuarios para teste
        List<Usuario> usuarios = criaUsuarios(20);

       //implementação da fila
        FilaDeEspera fila = new FilaDeEspera();
        fila.incluirUsuario(usuarios.get(5));
        fila.incluirUsuario(usuarios.get(3));
        fila.incluirUsuario(usuarios.get(7));
        fila.incluirUsuario(usuarios.get(19));
        fila.visualizarTopo();
        fila.removerUsuario();
        fila.visualizarTopo();

        //implementacao da pilha
        Usuario usuario19 = usuarios.get(19);

        List<Livro> livros = criaLivros(19);

        usuario19.visualizaLivro(livros.get(15));
        usuario19.visualizaLivro(livros.get(13));
        usuario19.visualizaLivro(livros.get(14));
        usuario19.visualizaLivro(livros.get(16));
        usuario19.visualizaHistorico();

        //implementacao do grafo com sistema de recomendacoes

    }

    static List<Usuario> criaUsuarios(int quantidade){
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            usuarios.add(new Usuario("usuario " + i, "usuario" + i + "@mail.com",""));
        }
        return usuarios;
    }


    static List<Livro> criaLivros(int quantidade){
        List<Livro> livros = new ArrayList<>();
        for (int i = 1; i <= quantidade; i++){
            livros.add(new Livro("livro "+i, "autor"+i,199+i));
        }

        return livros;
    }
}
