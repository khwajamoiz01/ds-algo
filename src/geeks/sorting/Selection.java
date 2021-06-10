/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.Arrays;


/**
 * Stable version of selection sort
 * <p>
 * Time complexity - O(n*n) <br>
 * Space complexity - O(1) <br>
 * In place - Yes <br>
 * Stable - Default version is not stable but below version is.
 * </p>
 *
 * @author khwaja.ali
 * @version $Id: sorting.java, v 0.1 2020-04-30 7:54 pm khwaja.ali Exp 3
 */
public class Selection {

    public static void sort(int[] ar) {
        int n = ar.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (ar[j] < ar[minIndex]) {
                    minIndex = j;
                }
            }
            int min = ar[minIndex];
            int j = minIndex - 1;
            while (j >= i) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = min;
        }
    }

    public static void main(String[] args) {
        int[] ar = {4, 5, 3, 2, 4, 1};
        Selection.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}