/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.heap;

import java.util.Arrays;

/**
 * @author khwaja.ali
 * @version $Id: HeapSort.java, v 0.1 2020-04-30 12:50 am khwaja.ali Exp 3
 */
public class HeapSort {

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
        int ar[] = {12, 11, 13, 5, 6, 7};
        HeapSort.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}