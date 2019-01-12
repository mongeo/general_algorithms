package com.geoffmontague.algos;

public class BubbleSort {
    public void sort (String[] names){
        int n = names.length;
        while (n > 1){
            for (int i = 0; i < n - 1; i++){
                if (names[i].compareTo(names[i+1]) > 0){
                    final String temp = names[i];
                    names[i+1] = names[i];
                    names[i] = temp;
                }
            }
            n--;
        }
    }
}
