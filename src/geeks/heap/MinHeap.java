/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.heap;

/**
 * @author khwaja.ali
 * @version $Id: MinHeap.java, v 0.1 2019-12-15 16:06 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/binary-heap/
//https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
public class MinHeap implements IMinHeap {

    int heap[];
    int size;
    int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    @Override
    public int getMin() {
        return heap[0];
    }

    @Override
    public int removeMin() {
        if (size == 0)
            return Integer.MAX_VALUE;
        if (size == 1)
            return heap[--size];
        int min = heap[0];
        heap[0] = heap[--size];
        heapify(heap, size, 0);
        return min;
    }

    @Override
    public void insert(int val) {
        if (size == maxSize)
            return;
        heap[size++] = val;
        int i = size - 1;
        percolateUp(i);
    }

    @Override
    public void decreaseKey(int i, int val) {
        heap[i] = val;
        percolateUp(i);
    }

    private void percolateUp(int i) {
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        removeMin();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void replaceMin(int val) {
        heap[0] = val;
        heapify(heap, size, 0);
    }

    public static void heapify(int[] heap, int size, int i) {
        int l = left(i);
        int r = right(i);
        int min = i;
        if (l < size && heap[l] < heap[min]) {
            min = l;
        }
        if (r < size && heap[r] < heap[min]) {
            min = r;
        }
        if (min != i) {
            swap(heap, i, min);
            heapify(heap, size, min);
        }
    }

    private static void swap(int[] heap, int i, int j) {
        int t = heap[j];
        heap[j] = heap[i];
        heap[i] = t;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }
}