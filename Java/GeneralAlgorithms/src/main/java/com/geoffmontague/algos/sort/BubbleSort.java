package com.geoffmontague.algos.sort;

import java.util.Comparator;

public class BubbleSort<T> implements Sort<T> {
    @Override
    public void sort(SortableCollection collection) {
        int n = collection.size();
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                if (comparator.compare(collection.get(i),
                        collection.get(i + 1)) > 0) {
                    swapper.swap(i,i+ 1);
                }
                n--;
            }
        }
    }

    private Comparator comparator = null;

    @Override
    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    private Swapper swapper = null;

    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }


}
