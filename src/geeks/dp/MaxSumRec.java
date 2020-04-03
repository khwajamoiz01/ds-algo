/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: MaxSumRec.java, v 0.1 2020-01-11 00:24 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
public class MaxSumRec {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int[][] ar = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        ar[i][j] = sc.nextInt();
                    }
                }

                int[][] dp = new int[r + 1][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        dp[i + 1][j] = dp[i][j] + ar[i][j];
                    }
                }
                System.out.println(Arrays.deepToString(dp));
                int maxSum = Integer.MIN_VALUE;
                for (int row = 0; row < r; row++) {
                    for (int i = row; i < r; i++) {
                        int sum = 0;
                        for (int j = 0; j < c; j++) {
                            int colSum = dp[i + 1][j] - dp[row][j];
                            sum = Math.max(sum + colSum, colSum);
                            maxSum = Math.max(maxSum, sum);
                        }
                    }
                }
                System.out.println(maxSum);
            }
        }
    }

}