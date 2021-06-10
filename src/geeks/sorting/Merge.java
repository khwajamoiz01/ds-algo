/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.Arrays;

/**
 * Time complexity - O(nlogn) in all the cases i.e. best, worst and average
 * Space complexity - O(n)
 * In place - No
 * Stable - Yes
 *
 * @author khwaja.ali
 * @version $Id: Merge.java, v 0.1 2020-05-01 9:54 pm khwaja.ali Exp 3
 */
public class Merge {

    private static void merge(int[] ar, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (ar[i] <= ar[j]) {
                temp[k++] = ar[i++];
            } else {
                temp[k++] = ar[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = ar[i++];
        }
        while (j <= end) {
            temp[k++] = ar[j++];
        }
        k = 0;
        for (i = start; i <= end; i++) {
            ar[i] = temp[k++];
        }
    }

    private static void sortUtil(int[] ar, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            sortUtil(ar, i, mid);
            sortUtil(ar, mid + 1, j);
            merge(ar, i, mid, j);
        }
    }

    public static void sort(int[] ar) {
        sortUtil(ar, 0, ar.length - 1);
    }

    public static void main(String[] args) {
        int ar[] = {12, 11, 13, 5, 6, 7};
        Merge.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}