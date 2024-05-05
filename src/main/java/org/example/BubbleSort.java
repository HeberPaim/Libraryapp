package org.example;

class BubbleSort {

    public static int ordenar(String[] oldArr) {
        String[] arr = oldArr.clone();
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                count++;
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return count;
    }
}