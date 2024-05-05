package org.example;
import java.util.Arrays;
import java.util.Random;

class GeradorDeNomesDeLivros {
    private static final int TAMANHO_MAXIMO_DO_NOME = 20;
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
    public static void main(String[] args) {
        String[] nomes = gerarNomes(10000);
        System.out.println("contagem bubble = "+BubbleSort.ordenar(nomes));
        System.out.println("contagem merge = "+ MergeSort.ordenar(nomes, 0));
    }


    public static String[] gerarNomes(int numeroDeLivros) {
        Random random = new Random();
        String[] nomesDeLivros = new String[numeroDeLivros];

        for (int i = 0; i < numeroDeLivros; i++) {
            nomesDeLivros[i] = gerarNomeAleatorio(random);
        }

        // Apenas para fins de teste mostraremos os 10 primeiros nomes
        for (int i = 0; i < 10; i++) {
//            System.out.println(nomesDeLivros[i]);
        }

        return nomesDeLivros;
    }

    private static String gerarNomeAleatorio(Random random) {
        int tamanhoDoNome = random.nextInt(TAMANHO_MAXIMO_DO_NOME) + 1;
        StringBuilder sb = new StringBuilder(tamanhoDoNome);

        for (int i = 0; i < tamanhoDoNome; i++) {
            sb.append(ALFABETO.charAt(random.nextInt(ALFABETO.length())));
        }

        return sb.toString();
    }
}