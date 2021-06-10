/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: SubarrayWithGivenSum.java, v 0.1 2019-12-22 16:18 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                /*
                2
                5 12
                1 2 3 7 5
                10 15
                1 2 3 4 5 6 7 8 9 10
                 */
                int sum = 0;
                int s = 0, e = 0;
                boolean found = false;
                for (int i = 0; i < n; i++) {
                    sum += ar[i];
                    while (sum > k) {
                        sum = sum - ar[s++];
                    }

                    if (sum == k) {
                        System.out.println((s + 1) + " " + (i + 1));
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println(-1);

            }
        }
    }
}