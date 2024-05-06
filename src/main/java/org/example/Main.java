package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //cria usuarios para teste
        List<Usuario> usuarios = criaUsuarios();
        SugestaoDeLivros recomendacao = new SugestaoDeLivros();
        List<Livro> livrosComRecomendacao = criaLivros(recomendacao);

       //implementação da fila
        FilaDeEspera fila = new FilaDeEspera();
        fila.incluirUsuario(usuarios.get(5));
        fila.incluirUsuario(usuarios.get(3));
        fila.incluirUsuario(usuarios.get(7));
        fila.incluirUsuario(usuarios.get(19));
        fila.visualizarTopo();
        fila.removerUsuario();
        fila.visualizarTopo();

        Usuario usuario15 = usuarios.get(15);


        /* ADICAO DE LIVROS NO HISTORICO DO USUARIO PARA TESTAR RECOMENDACAO*/
        System.out.println("======================================================================================================");
        Livro livro;
        System.out.println("\nInicio da insercao dos livros no historico do usuario ");
        for(int i = 0; i < 5; i++){
            livro = livrosComRecomendacao.get((int) (Math.random() * 20));
            usuario15.visualizaLivro(livro, recomendacao);
        }
        System.out.println("Fim da insercao de livros visualizados no historico do usuario\n");

        //Print das do historico do usuario
        System.out.println("Visualizando o historico do "+usuario15.getNome());
        usuario15.visualizaHistorico();
        System.out.println("\nBOAS RECOMENDACOES SEGUNDO O HISTORICO DO USUARIO");
        usuario15.getRecomendacoes();
        //print das recomendacoes baseadas no historico do usuario

        //criacao da arvore binaria para livros.
        ArvoreBinaria arvorePreenchida = insereLivrosArvoreBinaria(livrosComRecomendacao);

        //visualizacao da arvore binaria
        System.out.println("\n Visualizacao da Arvore Binaria\n===================================================================");
        arvorePreenchida.mostrar();

        //removendo The Handsmaid Tale para teste
        arvorePreenchida.remover(livrosComRecomendacao.get(3));

        System.out.println("======================================================================================================");
        System.out.println("busca por livros");


        //pesquisa na arvore binaria
        System.out.println(livrosComRecomendacao.get(5).getTitulo() + " existe na arvore?");
        arvorePreenchida.buscar(livrosComRecomendacao.get(5));
        Livro livreto = new Livro("livrin02","lilili02",2020);
        System.out.println(livreto.getTitulo() + " existe na arvore?");
        System.out.println(arvorePreenchida.buscar(livreto));

        System.out.println("\n Visualizacao da Arvore Binaria\n===================================================================");
        arvorePreenchida.mostrar();


        //Profundidade da arvore
        System.out.println("======================================================================================================");
        System.out.println("Calculo de profundidade de arvore");

        System.out.println("\n BFS \n");
        arvorePreenchida.buscar(livrosComRecomendacao.get(15), "BFS");

        System.out.println("\n DFS \n");
        arvorePreenchida.buscar(livrosComRecomendacao.get(15), "DFS");


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
