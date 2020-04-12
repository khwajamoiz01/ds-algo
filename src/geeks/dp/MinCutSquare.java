/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: MinCutSquare.java, v 0.1 2020-04-04 12:19 am khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/paper-cut-minimum-number-squares-set-2/
public class MinCutSquare {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Integer[][] dp = new Integer[a + 1][b + 1];
                /* approach1 fails because of 15, 16
                   output 7 having one squares of sizes 1-10, 2-5, 2-6, 2-3
                System.out.println(noOfSquares1(a, b, dp));
                 */
                System.out.println(noOfSquares(a, b, dp));
            }
        }
    }

    static int noOfSquares(int a, int b, Integer[][] dp) {
        if (a == 0 || b == 0)
            return 0;

        if (a == b)
            return 1;

        if (dp[a][b] == null) {
            int minSquare = Integer.MAX_VALUE;
            for (int i = 1; i <= a / 2; i++) {
                minSquare = Math.min(minSquare, noOfSquares(i, b, dp) + noOfSquares(a - i, b, dp));
            }
            for (int i = 1; i <= b / 2; i++) {
                minSquare = Math.min(minSquare, noOfSquares(a, i, dp) + noOfSquares(a, b - i, dp));
            }
            dp[a][b] = minSquare;
        }
        return dp[a][b];
    }

    static int noOfSquares1(int a, int b, Integer[][] dp) {
        if (a == 0 || b == 0)
            return 0;
        if (a == b)
            return 1;

        if (dp[a][b] == null) {
            int minSquare = Integer.MAX_VALUE;
            for (int i = 1; i <= Math.min(a, b); i++) {
                if (b % i == 0) {
                    minSquare = Math.min(minSquare, b / i + noOfSquares(a - i, b, dp));
                }
            }
            for (int i = 1; i <= Math.min(a, b); i++) {
                if (a % i == 0) {
                    minSquare = Math.min(minSquare,
                            a / i + noOfSquares(a, b - i, dp));
                }
            }
            dp[a][b] = minSquare;
        }
        return dp[a][b];
    }

}