package org.example;
import com.sun.source.tree.BinaryTree;

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
        System.out.println("======================================================================================================");
        Usuario usuario19 = usuarios.get(19);

        List<Livro> livros = criaLivros();
        usuario19.visualizaLivro(livros.get(15));
        usuario19.visualizaLivro(livros.get(13));
        usuario19.visualizaLivro(livros.get(14));
        usuario19.visualizaLivro(livros.get(16));
        usuario19.visualizaHistorico();             //essa linha da print na tela

        //implementacao do grafo com sistema de recomendacoes
        System.out.println("======================================================================================================");
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
        System.out.println("======================================================================================================");
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



        //criacao da arvore binaria para livros.
        ArvoreBinaria arvorePreenchida = insereLivrosArvoreBinaria(livros);

        //visualizacao da arvore binaria
        System.out.println("\n Visualizacao da Arvore Binaria\n===================================================================");
        arvorePreenchida.mostrar();

        //removendo The Handsmaid Tale para teste
        arvorePreenchida.remover(livros.get(3));

        System.out.println("======================================================================================================");
        System.out.println("busca por livros");


        //pesquisa na arvore binaria
        System.out.println(livros.get(5).getTitulo() + " existe na arvore?");
        arvorePreenchida.buscar(livros.get(5));
        Livro livreto = new Livro("livrin02","lilili02",2020);
        System.out.println(livreto.getTitulo() + " existe na arvore?");
        System.out.println(arvorePreenchida.buscar(livreto));

        System.out.println("\n Visualizacao da Arvore Binaria\n===================================================================");
        arvorePreenchida.mostrar();


        //Profundidade da arvore
        System.out.println("======================================================================================================");
        System.out.println("Calculo de profundidade de arvore");

        System.out.println("\n BFS \n");
        arvorePreenchida.buscar(livros.get(15), "BFS");

        System.out.println("\n DFS \n");
        arvorePreenchida.buscar(livros.get(15), "DFS");


        System.out.println("======================================================================================================");

    }

    static ArvoreBinaria insereLivrosArvoreBinaria(List<Livro> setLivros){
        ArvoreBinaria arvore = new ArvoreBinaria();
        for(int i = 0; i < 20; i++){
            arvore.inserir(setLivros.get(i));
        }
        return arvore;
    }
    static List<Usuario> criaUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            usuarios.add(new Usuario("usuario " + i, "usuario" + i + "@mail.com"));
        }
        return usuarios;
    }


    //overload para criar com as recomendacoes, hardcoded no 10 pora nao ter livros demais nem zoar os testes
    static List<Livro> criaLivros(SugestaoDeLivros recomendacao){

        List<Livro> livros = criaLivros();

        for (int i=0; i< 20; i++){
            //cria um HashSet de recomendacoes
            HashSet<Livro> recomendacoes = new HashSet<>();

            //preenche o HashSet com diferentes livros
            recomendacoes.add(livros.get((int) (Math.random() * 20)));
            recomendacoes.add(livros.get((int) (Math.random() * 20)));
            recomendacoes.add(livros.get((int) (Math.random() * 20)));

            //Insere as 3 recomendacoes ao crior o node do grafo com um livro e suas recomendacoes
            recomendacao.adicionarNode(livros.get(i),recomendacoes);
        }
        return livros;
    }
    //cria 20 livros sem recomendacao para utilizacao da linked list
    static List<Livro> criaLivros(){
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro("The Catcher in the Rye", "J.D. Salinger", 1951));
        livros.add(new Livro("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        livros.add(new Livro("Moby-Dick", "Herman Melville", 1851));
        livros.add(new Livro("The Handmaid's Tale", "Margaret Atwood", 1985));
        livros.add(new Livro("Anna Karenina", "Leo Tolstoy", 1877));
        livros.add(new Livro("To Kill a Mockingbird", "Harper Lee", 1960));
        livros.add(new Livro("1984", "George Orwell", 1949));
        livros.add(new Livro("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        livros.add(new Livro("Brave New World", "Aldous Huxley", 1932));
        livros.add(new Livro("To the Lighthouse", "Virginia Woolf", 1927));
        livros.add(new Livro("The Hobbit", "J.R.R. Tolkien", 1937));
        livros.add(new Livro("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        livros.add(new Livro("The Grapes of Wrath", "John Steinbeck", 1939));
        livros.add(new Livro("Pride and Prejudice", "Jane Austen", 1813));
        livros.add(new Livro("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979));
        livros.add(new Livro("Beloved", "Toni Morrison", 1987));
        livros.add(new Livro("The Road", "Cormac McCarthy", 2006));
        livros.add(new Livro("The Sun Also Rises", "Ernest Hemingway", 1926));
        livros.add(new Livro("Frankenstein", "Mary Shelley", 1818));
        livros.add(new Livro("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        return livros;
    }
}
