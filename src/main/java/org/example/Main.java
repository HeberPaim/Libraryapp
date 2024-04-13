package org.example;

public class Main {
    public static void main(String[] args) {
        Usuario joana = new Usuario ("joana", "joana@user.com", "user123");
        Usuario jao = new Usuario ("jao", "jao@user.com", "user321");
        Usuario Jose = new Usuario ("Jose", "joana@user.com", "user312");

        //implementação da fila
        FilaDeEspera fila = new FilaDeEspera();
        System.out.println("============Antes============");
        fila.incluirElemento(new Usuario("Janetao", "Janetao@user.com", "user123"));
        fila.incluirElemento(new Usuario("Jubileula", "Jubileula@user.com", "user321"));
        fila.incluirElemento(new Usuario("Jamelao", "Jamelao@user.com", "user123"));
        fila.visualizarTopo();
        fila.removerElemento();
        fila.visualizarTopo();

        //implementacao da pilha

    }
}
