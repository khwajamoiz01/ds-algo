/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: TSP.java, v 0.1 2020-04-11 3:29 pm khwaja.ali Exp 3
 */
public class TSP {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[][] ar = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        ar[i][j] = sc.nextInt();
                    }
                }

                boolean[] vis = new boolean[n];
                System.out.println(minCost(0, vis, ar, n, 0));
            }
        }
    }

    //0 -> 1 -> 2 -> 3
    static int minCost(int i, boolean[] vis, int[][] ar, int n, int c) {
        vis[i] = true;
        c++;
        if (c == n) {
            vis[i] = false;
            return ar[i][0];
        }
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (i != j && !vis[j]) {
                int cost = ar[i][j] + minCost(j, vis, ar, n, c);
                minCost = Math.min(minCost, cost);
            }
        }
        vis[i] = false;
        return minCost;
    }

}