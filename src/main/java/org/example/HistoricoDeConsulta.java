package org.example;
import java.util.Stack;

public class HistoricoDeConsulta {
    private Stack<Livro> historicoConsulta;

    public HistoricoDeConsulta() {
        this.historicoConsulta = new Stack<>();
    }

    public void registrarConsulta(Livro livro) {
        historicoConsulta.push(livro);
    }
    public Livro consultarMaisRecente() {
        return historicoConsulta.isEmpty() ? null : historicoConsulta.peek();
    }

    public Livro removerMaisRecente() {
        return historicoConsulta.isEmpty() ? null : historicoConsulta.pop();
    }
}
