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
public class Bubble {
    //process is similar to heapify
    public static void sort(int[] ar) {
        int n = ar.length;
        for (int i = n - 2; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 0; j <= i; j++) {
                if (ar[j] > ar[j + 1]) {
                    int t = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = {4, 5, 3, 2, 4, 1};
        Bubble.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}