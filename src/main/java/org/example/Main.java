package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //cria usuarios para teste
        List<Usuario> usuarios = criaUsuarios();

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

        List<Livro> livros = criaLivros();
        usuario19.visualizaLivro(livros.get(15));
        usuario19.visualizaLivro(livros.get(13));
        usuario19.visualizaLivro(livros.get(14));
        usuario19.visualizaLivro(livros.get(16));
        usuario19.visualizaHistorico();             //essa linha da print na tela

        //implementacao do grafo com sistema de recomendacoes

        SugestaoDeLivros recomendacao = new SugestaoDeLivros();
        List<Livro> livrosComRecomendacao = criaLivros(recomendacao);

        Usuario usuario15 = usuarios.get(15);
        //simulando visualização de 3 livros para o usuario 15
        Livro livroTeste = livrosComRecomendacao.get((int) (Math.random() * 20));
        //visualizando recomendacoes do livroTeste antes do usuario visualizar outros livros
        System.out.println(livroTeste);
        System.out.println(recomendacao.obterRecomendacoes(livroTeste));

        System.out.println("\nInicio da insercao dos livros");
        /* ADICAO DE LIVROS NO HISTORICO DO USUARIO PARA TESTAR RECOMENDACAO*/
        Livro livro = livrosComRecomendacao.get((int) (Math.random() * 20));
        System.out.println(livro);
        usuario15.visualizaLivro(livro, recomendacao);
        livro = livrosComRecomendacao.get((int) (Math.random() * 20));
        System.out.println(livro);
        usuario15.visualizaLivro(livro, recomendacao);
        livro = livrosComRecomendacao.get((int) (Math.random() * 20));
        System.out.println(livro);
        usuario15.visualizaLivro(livro, recomendacao);
        livro = livrosComRecomendacao.get((int) (Math.random() * 20));
        System.out.println(livro);
        usuario15.visualizaLivro(livro, recomendacao);
        livro = livrosComRecomendacao.get((int) (Math.random() * 20));
        System.out.println(livro);
        usuario15.visualizaLivro(livro, recomendacao);
        System.out.println("Fim da insercao dos livros\n");

        //Print das recomendacoes do livroTeste depois da insercao de outros livros no historico do usuario
        System.out.println("Visualizando o historioco do "+livroTeste.getTitulo());
        usuario15.visualizaLivro(livroTeste, recomendacao);

        System.out.println(recomendacao.obterRecomendacoes(livroTeste));
    }

    static List<Usuario> criaUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            usuarios.add(new Usuario("usuario " + i, "usuario" + i + "@mail.com",""));
        }
        return usuarios;
    }
    //cria 20 livros sem recomendacao para utilizacao da linked list
    static List<Livro> criaLivros(){
        List<Livro> livros = new ArrayList<>();
        for (int i = 1; i <= 20; i++){
            livros.add(new Livro("livro"+i, "autor"+i,199+i));
        }
        return livros;
    }

    //overload para criar com as recomendacoes, hardcoded no 10 pora nao ter livros demais nem zoar os testes
    static List<Livro> criaLivros(SugestaoDeLivros recomendacao){
        List<Livro> livros = new ArrayList<>();
        for (int i = 0;  i <= 20; i++){
            livros.add(new Livro("livro "+i, "autor"+i,199+i));
        }
        for (int i=0; i<= 20; i++){
            //cria um HashSet de recomendacoes
            HashSet<Livro> recomendacoes = new HashSet<Livro>();

            //preenche o HashSet com diferentes livros
            recomendacoes.add(livros.get((int) (Math.random() * 20)));
            recomendacoes.add(livros.get((int) (Math.random() * 20)));
            recomendacoes.add(livros.get((int) (Math.random() * 20)));

            //Insere as 3 recomendacoes ao crior o node do grafo com um livro e suas recomendacoes
            recomendacao.adicionarNode(livros.get(i),recomendacoes);
        }
        return livros;
    }
}
