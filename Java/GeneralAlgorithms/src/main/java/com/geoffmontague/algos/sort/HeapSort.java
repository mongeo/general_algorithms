package com.geoffmontague.algos.sort;

import java.util.Collections;
import java.util.Comparator;

public class HeapSort<T> extends AbstractSort<T> {

    public HeapSort(Comparator<T> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
    }

    @Override
    public void sort(SortableCollection<T> sortable){
        for (int i = sortable.size() - 1; i > 1; i--){
            swapper.swap(0, i);
            maxHeapify(sortable, 0);
        }
    }

    private int parent(int i){
        return i / 2;
    }

    private int left(int i){
        return i * 2;
    }

    private int right(int i){
        return (i * 2) + 1;
    }

    public void maxHeapify(SortableCollection<T> sortable, int i){
        int l = left(i);
        int r = right(i);
        int largest = 0;
        if (l < sortable.size() && sortable.get(l).toString().compareTo(sortable.get(i).toString()) > 0){
            largest = l;
        } else {
            largest = i;
        }
        if (r < sortable.size() && sortable.get(r).toString().compareTo(sortable.get(largest).toString()) > 0){
            largest = r;
        }
        if (largest != r) {
            Collections.swap(sortable, i, largest);
            maxHeapify(sortable, largest);
        }
    }

    public void buildMaxHeap(SortableCollection<T> sortable){
        for (int i = sortable.size() / 2; i > 0; i--){
            maxHeapify(sortable, i);
        }
    }

    public void heapIncreaseKey(SortableCollection<T> sortable, int i, Object key){
        if (sortable.get(i).toString().compareTo(key.toString()) < 0){
            System.out.println("!!! Error: new key is smaller than current key !!!");
        }
        sortable.set(i, key);
        while (i > 0 && sortable.get(parent(i)).toString().compareTo(sortable.get(i).toString()) < 0){
            Collections.swap(sortable, i, parent(i));
            i = parent(i);
        }
    }

    public void maxHeapInsert(SortableCollection<T> sortable, Object key){
        sortable.add("");
        heapIncreaseKey(sortable, sortable.size() - 1, key);
    }

    public void sort(SortableCollection<T> sortable){
        for (int i = sortable.size() - 1; i > 1; i--){
            Collections.swap(sortable, 0, i);
            maxHeapify(sortable, 0);
        }
    }

    public Object heapMax(SortableCollection<T> sortable){
        return sortable.get(0);
    }

    public Object heapExtractMax(SortableCollection<T> sortable){
        if (sortable.size() < 0){
            System.out.println("!!! Error: Heap underflow !!!");
        }
        Object max = sortable.get(0);
        sortable.set(0, sortable.get(pL.size() - 1));
        maxHeapify(sortable, 0);
        return max;
    }

}
