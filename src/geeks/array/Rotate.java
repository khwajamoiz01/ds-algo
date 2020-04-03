/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Rotate.java, v 0.1 2020-01-18 00:03 khwaja.ali Exp 3
 */
public class Rotate {
    /*Function to left rotate arr[] of siz n by d*/
    static void leftRotate(int arr[], int d, int n) {
        int i, j, k, temp;
        int gcd = gcd(d, n);
        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }


    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(arr, 3, 7);
        System.out.println(Arrays.toString(arr));
    }

}