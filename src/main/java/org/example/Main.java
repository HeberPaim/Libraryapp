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

        usuario19.visualizaLivro(new Livro("titulao", "autor topzera", 1994));
        usuario19.visualizaLivro(new Livro("titulin", "autor nao tao bom assim", 2024));
        usuario19.visualizaLivro(new Livro("titulo", "autor triste", 2003));
        usuario19.visualizaLivro(new Livro("tituleigo", "autor", 2001));
        usuario19.visualizaHistorico();

    }

    static List<Usuario> criaUsuarios(int quantidade){
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            usuarios.add(new Usuario("usuario " + i, "usuario" + i + "@mail.com",""));
        }
        return usuarios;
    }

}
