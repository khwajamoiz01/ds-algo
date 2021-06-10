/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import geeks.heap.HeapSort;
import geeks.heap.MinHeap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Time complexity - O(nlogn)
 * Space complexity - O(1)
 * In place - Yes
 * Stable -  Default implementation is not stable
 *
 * @author khwaja.ali
 * @version $Id: Heap.java, v 0.1 2020-05-02 12:21 am khwaja.ali Exp 3
 */
public class Heap {

    //sorts in desc order
    public static void sort(int[] ar) {
        for (int i = ar.length / 2 - 1; i >= 0; i--) {
            MinHeap.heapify(ar, ar.length, i);
        }
        for (int i = ar.length - 1; i >= 0; i--) {
            int min = ar[0];
            ar[0] = ar[i];
            ar[i] = min;
            MinHeap.heapify(ar, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] ar = {12, 11, 13, 5, 6, 7};
        HeapSort.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}