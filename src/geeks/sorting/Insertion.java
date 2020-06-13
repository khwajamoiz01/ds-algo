/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.Arrays;

/**
 * Time complexity - worst case O(n*n), best case O(n)
 * Space complexity - O(1)
 * In place - Yes
 * Stable - Yes
 * Online - Yes
 *
 * @author khwaja.ali
 * @version $Id: Insertion.java, v 0.1 2020-05-01 2:12 pm khwaja.ali Exp 3
 */
public class Insertion {
    public static void sort(int[] ar) {
        int n = ar.length;
        for (int i = 1; i < n; i++) {
            int cur = ar[i];
            int j = i - 1;
            for (; j >= 0 && ar[j] > cur; j--) {
                ar[j + 1] = ar[j];
            }
            ar[j + 1] = cur;
        }
    }

    public static void main(String[] args) {
        int ar[] = {12, 11, 13, 5, 6};
        Insertion.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}