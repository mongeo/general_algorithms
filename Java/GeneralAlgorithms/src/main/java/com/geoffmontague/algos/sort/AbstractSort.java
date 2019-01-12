package com.geoffmontague.algos.sort;

import java.util.Comparator;

public abstract class AbstractSort<T> implements Sort<T> {
    protected Comparator<T> comparator = null;

    @Override
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    protected Swapper swapper = null;

    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }
}