package com.geoffmontague.algos.sort;
import java.util.Comparator;

public interface Sort<T> {
    void sort(SortableCollection<T> collection);
    void setSwapper(Swapper swap);
    void setComparator(Comparator<T> compare);
}
