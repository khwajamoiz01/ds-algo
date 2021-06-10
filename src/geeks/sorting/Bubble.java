/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.Arrays;

/**
 * @author khwaja.ali
 * @version $Id: Bubble.java, v 0.1 2020-04-30 8:46 pm khwaja.ali Exp 3
 */

/**
 * Time complexity - worst case O(n*n), best case O(n)
 * Space complexity - O(1)
 * In place - yes
 * Stable - yes
 */
//https://www.geeksforgeeks.org/bubble-sort/
public class Bubble {
    //process is similar to heapify
    public static void sort(int[] ar) {
        int n = ar.length;
        for (int i = n - 2; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 0; j <= i; j++) {
                if (ar[j] > ar[j + 1]) {
                    swap(ar, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    public static void main(String[] args) {
        int[] ar = {4, 5, 3, 2, 4, 1};
        Bubble.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}