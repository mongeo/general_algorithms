package com.geoffmontague.algos.sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QuickSort<T> extends AbstractSort<T> {

    public QuickSort(Comparator<T> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    private static class Stack {
        final int begin;
        final int fin;

        public Stack(int begin, int fin) {
            this.begin = begin;
            this.fin = fin;
        }
    }

    @Override
    public void sort(SortableCollection sortable) {
        final List<Stack> stack = new LinkedList<Stack>();
        int start = 0;
        int end = sortable.size() -1;
        stack.add(new Stack(start, end));
        int i = 1;
        while (!stack.isEmpty()) {
            Stack iter = stack.remove(0);
            if (iter.begin < iter.fin) {
                final T pivot = (T) sortable.get(iter.begin);
                int cutIndex = partition(sortable, iter.begin, iter.fin, pivot);
                if( cutIndex == iter.begin ){
                    cutIndex++;
                }
                stack.add(new Stack(iter.begin, cutIndex - 1));
                stack.add(new Stack(cutIndex, iter.fin));
            }
        }
    }

    public int partition(SortableCollection<T> sortable, int start, int end, T pivot) {
        int small = start;
        int large = end;
        while (large > small) {
            while (comparator.compare(sortable.get(small), pivot) < 0 && small < large ) {
                small++;
            }
            while (comparator.compare(sortable.get(large), pivot) >= 0 && small < large) {
                large--;
            }
            if (small < large) {
                swapper.swap(small, large);
            }
        }
        return large;
    }
}