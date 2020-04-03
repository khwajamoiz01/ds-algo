/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package codeforces;


import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: C1_1313.java, v 0.1 2020-02-23 14:48 khwaja.ali Exp 3
 */
public class C1_1313 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            //1 2 4 4 1
            //1 10 2 4 4 1
            //10 2 4 4
            //10 2 4 2
            //10 4 5 6 8 3
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            dp(ar, 0, n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print(ar[i] + " ");
            }
            System.out.println();
        }
    }

    private static void dp(int[] ar, int i, int j) {
        if (i == j || i + 1 == j)
            return;

        int ai2 = ar[i + 1];
        int aj2 = ar[j - 1];
        int min2 = Math.min(ai2, aj2);
        if (ar[i] > min2 && ar[j] > min2) {
            if (ar[i] < ar[j]) {
                ar[i] = min2;
            } else {
                ar[j] = min2;
            }
        }
        dp(ar, i + 1, j - 1);
    }

}