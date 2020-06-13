/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.Arrays;

/**
 * Used when the numbers are in range 1 to n*n
 * Time complexity:  O(d*(n+b)) where d is max no of digits and b is the base which is 10 for decimal systems
 * Space complexity: O(n + k)
 * In place: No
 * Stable: Yes
 *
 * @author khwaja.ali
 * @version $Id: Radix.java, v 0.1 2020-04-30 11:52 pm khwaja.ali Exp 3
 */
public class Radix {

    private static void countingSort(int[] ar, int d) {
        int n = ar.length;
        int[] count = new int[10];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            count[(ar[i] / d) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            result[count[(ar[i] / d) % 10] - 1] = ar[i];
            count[(ar[i] / d) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            ar[i] = result[i];
        }
    }

    public static void sort(int[] ar) {
        int max = Arrays.stream(ar).max().getAsInt();
        for (int d = 1; max / d > 0; d = d * 10) {
            countingSort(ar, d);
        }
    }

    public static void main(String[] args) {
        int ar[] = {170, 45, 75, 90, 802, 24, 2, 66};
        Radix.sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}