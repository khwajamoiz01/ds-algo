/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: LargestIsland.java, v 0.1 2019-12-29 19:08 khwaja.ali Exp 3
 */
public class LargestIsland {

    static int SIZE = 100;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int g[][] = new int[n][m];
            boolean vis[][] = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    g[i][j] = sc.nextInt();
            }

            System.out.println(findAreaUtil(n, m, g, vis));
        }
    }

    static int findAreaUtil(int n, int m, int g[][], boolean vis[][]) {
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, n, m, g, vis);
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                }
            }
        }
        return maxCount;
    }


    static void dfs(int i, int j, int n, int m, int[][] g, boolean[][] vis) {

        vis[i][j] = true;
        count++;
        for (int k = 0; k < adj.length; k++) {
            int i2 = i + adj[k][0];
            int j2 = j + adj[k][1];
            if (isSafe(i2, j2, n, m, g) && !vis[i2][j2]) {
                dfs(i2, j2, n, m, g, vis);
            }
        }
    }

    static int count = 0;
    static int[][] adj = {
            {0, -1}, {-1, -1}, {-1, 0}, {-1, +1},
            {0, +1}, {+1, +1}, {+1, 0}, {+1, -1}
    };

    static boolean isSafe(int i, int j, int n, int m, int[][] g) {
        return i >= 0 && i < n && j >= 0 && j < m && g[i][j] == 1;
    }

}