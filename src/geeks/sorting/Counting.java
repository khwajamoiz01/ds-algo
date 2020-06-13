/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.Arrays;

/**
 * Counting sort is efficient when range is less as compared to number of objects
 * <p>
 * Time complexity - O(n + k) where k is the range of elements
 * Space complexity - O(n + k)
 * In place - No
 * Stable - Yes
 *
 * @author khwaja.ali
 * @version $Id: Counting.java, v 0.1 2020-04-30 10:52 pm khwaja.ali Exp 3
 */
public class Counting {

    public static void sort(int[] ar) {
        int n = ar.length;
        int min = Arrays.stream(ar).min().getAsInt();
        int max = Arrays.stream(ar).max().getAsInt();
        int k = max - min + 1;
        int[] count = new int[k];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[ar[i] - min]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[ar[i] - min] - 1] = ar[i];
            count[ar[i] - min]--;
        }
        for (int i = 0; i < n; i++) {
            ar[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] ar = {-5, -10, 0, -3, 8, 5, -1, 10};
        Counting.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}