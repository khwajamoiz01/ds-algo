/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author khwaja.ali
 * @version $Id: PartitionProblem.java, v 0.1 2020-03-29 5:38 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/painters-partition-problem/
public class PartitionProblem {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int k = sc.nextInt();
                int n = sc.nextInt();
                int[] ar = new int[n];
                int[] sums = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                    sums[i] = (i == 0 ? 0 : sums[i - 1]) + ar[i];
                }
                Integer[][] dp = new Integer[n + 1][k + 1];
                System.out.println(minTime(ar, n, k, sums, dp));
            }
        }
    }

    static int minTime(int[] ar, int n, int k, int[] sums, Integer[][] dp) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return sum(ar, 0, n - 1, sums);
        }
        if (dp[n][k] == null) {
            int minTime = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                int time = Math.max(sum(ar, i, n - 1, sums), minTime(ar, i, k - 1, sums, dp));
                minTime = Math.min(minTime, time);
            }
            dp[n][k] = minTime;
        }
        return dp[n][k];
    }

    static int sum(int[] ar, int i, int j, int[] sums) {
        return sums[j] - (i == 0 ? 0 : sums[i - 1]);
    }


}