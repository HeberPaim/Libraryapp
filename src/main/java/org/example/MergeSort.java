package org.example;


class MergeSort {

    public static int ordenar(String[] oldArr, int count) {
        String[] arr = oldArr.clone();
        if (arr.length < 2) {
            return 0;
        }

        int meio = arr.length / 2;
        String[] esquerda = new String[meio];
        String[] direita = new String[arr.length - meio];

        System.arraycopy(arr, 0, esquerda, 0, meio);
        System.arraycopy(arr, meio, direita, 0, arr.length - meio);

        count = ordenar(esquerda, count);
        count = ordenar(direita, count);

        count = merge(arr, esquerda, direita, count);

        return count;
    }



    private static int merge(String[] arr, String[] esquerda, String[] direita, int count) {
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            count++;
            if (esquerda[i].compareTo(direita[j]) <= 0) {
                arr[k++] = esquerda[i++];
            } else {
                arr[k++] = direita[j++];
            }
        }

        while (i < esquerda.length) {
            count++;
            arr[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            count++;
            arr[k++] = direita[j++];
        }
        return count;
    }
}