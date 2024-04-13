package org.example;
import java.util.LinkedList;
import java.util.Queue;

//fila de espera para emprestar livros
public class FilaDeEspera {
    private Queue<Usuario> filaDeEspera = new LinkedList<Usuario>();
    public FilaDeEspera(){
    }

    void removerElemento(){
        filaDeEspera.remove();
    }

    void incluirElemento(Usuario user){
        filaDeEspera.add(user);
    }
    void visualizarTopo(){
        System.out.println(filaDeEspera.peek());
    }
}
