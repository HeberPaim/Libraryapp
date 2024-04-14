package org.example;
import java.util.LinkedList;
import java.util.Queue;

//fila de espera para emprestar livros
public class FilaDeEspera {
    private final Queue<Usuario> filaDeEspera;
    public FilaDeEspera(){
        filaDeEspera = new LinkedList<>();
    }

    void removerUsuario(){
        filaDeEspera.remove();
    }

    void incluirUsuario(Usuario user){
        filaDeEspera.add(user);
    }
    void visualizarTopo(){
        if (filaDeEspera.isEmpty()) {
            System.out.println("A lista de espera está vazia.");
        } else {
            System.out.println(filaDeEspera.peek());
        }
    }
}
