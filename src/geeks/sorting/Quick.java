/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.Arrays;

/**
 * <p>
 * QS performs better as compared to MS on arrays as MS uses extra space along with allocation and de allocation in it
 * QS needs to do random access at memory location which cannot be done in O(1) on LinkedList
 * So basically, QS is better on arrays and MS better on LinkedList
 * Analysis when last element is chosen as pivot
 * </p>
 *
 * Time complexity - worst case O(n*n), best and avg case O(nlogn)
 * Space complexity - O(1)
 * In place - O(1)
 * Stable - Default implementation is not stable
 *
 * @author khwaja.ali
 * @version $Id: Quick.java, v 0.1 2020-05-01 5:57 pm khwaja.ali Exp 3
 */
public class Quick {

    private static void swap(int[] ar, int a, int b) {
        int t = ar[a];
        ar[a] = ar[b];
        ar[b] = t;
    }

    //a random number is chosen between i and j, both inclusive
    private static int partitionRandom(int[] ar, int low, int high) {
        int p = low + (int) (Math.random() * (high - low + 1));
        swap(ar, p, high);
        return partition(ar, low, high);
    }

    private static int partition(int[] ar, int low, int high) {
        int key = ar[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (ar[j] < key) {
                swap(ar, i, j);
                i++;
            }
        }
        swap(ar, i, high);
        return i;
    }

    private static void sortUtil(int[] ar, int i, int j) {
        if (i < j) {
            int k = partitionRandom(ar, i, j);
            sortUtil(ar, i, k - 1);
            sortUtil(ar, k + 1, j);
        }
    }

    public static void sort(int[] ar) {
        sortUtil(ar, 0, ar.length - 1);
    }

    public static void main(String[] args) {
        int ar[] = {10, 7, 8, 9, 1, 5, 7};
        Quick.sort(ar);
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));
    }

}