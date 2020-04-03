/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package codeforces;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: A1300.java, v 0.1 2020-02-09 19:39 khwaja.ali Exp 3
 */
//WRONG
public class A1300 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int zeros = 0;
                for (int i = 0; i < n; i++) {
                    if (ar[i] == 0) {
                        ar[i]++;
                        zeros++;
                    }
                }
                System.out.println(zeros + minAdd(ar, n, 0, true));
            }
        }

    }

    private static int minAdd(int[] ar, int n, int sum, boolean include) {
        //System.out.println(n + ", " + sum + ", " + include);
        if (n == 0) {
            return (sum != 0) ? 0 : Integer.MAX_VALUE - 1;
        }
        if (ar[n - 1] == 101) {
            return Integer.MAX_VALUE - 1;
        }
        if (include) {
            sum += ar[n - 1];
        }
        int b = minAdd(ar, n - 1, sum, true);
        ar[n - 1]++;
        sum += 1;
        int a = 1 + minAdd(ar, n, sum, false);
        return Math.min(a, b);
    }
}