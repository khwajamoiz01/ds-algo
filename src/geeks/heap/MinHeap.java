/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.heap;

/**
 * @author khwaja.ali
 * @version $Id: MinHeap.java, v 0.1 2019-12-15 16:06 khwaja.ali Exp 3
 */
//Todo check java collection for this
//    https://www.geeksforgeeks.org/binary-heap/
public class MinHeap<T extends Comparable> implements IMinHeap<T> {

    T heap[];
    int size;
    int maxSize;
    boolean empty;

    MinHeap(T[] ar) {
        this.maxSize = ar.length;
        this.size = ar.length;
        heap = ar;
        for (int i = (this.size - 2) / 2; i >= 0; i--) {
            heapify(i);
        }

    }

    @Override
    public T getMin() {
        return heap[0];
    }

    @Override
    public T removeMin() {
        if (size == 0)
            return null;
        T min = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return min;
    }

    @Override
    public void insert(T k) {
        if (size == maxSize)
            return;
        heap[size++] = k;
        int i = size - 1;
        while (i > 0 && heap[parent(i)].compareTo(heap[i]) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public void decreaseKey(int i, T val) {
        heap[i] = val;
        while (i > 0 && heap[parent(i)].compareTo(heap[i]) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public void deleteKey(int i) {
        //check geeksforgeeks
    }

//    @Override
//    public void deleteKey(int i) {
//        decreaseKey(i, Integer.MIN_VALUE);
//        removeMin();
//    }

    public void replaceMin(T val) {
        heap[0] = val;
        heapify(0);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int min = i;
        if (l < size && heap[l].compareTo(heap[min]) < 0) {
            min = l;
        }
        if (r < size && heap[r].compareTo(heap[min]) < 0) {
            min = r;
        }
        if (min != i) {
            swap(i, min);
            heapify(min);
        }
    }

    private void swap(int i, int j) {
        T t = heap[j];
        heap[j] = heap[i];
        heap[i] = t;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
}