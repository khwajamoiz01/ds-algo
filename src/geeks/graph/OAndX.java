/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: OAndX.java, v 0.1 2020-04-12 1:25 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/
public class OAndX {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                char[][] ar = new char[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        ar[i][j] = sc.next().charAt(0);
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (ar[i][j] == 'O') {
                            ar[i][j] = '-';
                        }
                    }
                }
                //dfs for only boundary elements
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (ar[i][j] == '-' && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
                            floodFill(ar, i, j, n, m);
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (ar[i][j] == '-') {
                            ar[i][j] = 'X';
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(ar[i][j] + " ");
                    }
                }
                System.out.println();

                //approach1(n, m, ar, res, vis);
                /**
                 * approach1 fails for this input
                 * 1
                 * 4 7
                 * O O O O X X O O X O X O O X X X X X O X O O X X X O O O
                 * when i = 1 and j = 4 then i = 1 and j = 5 is replaced which should not have been
                 */

            }
        }
    }

    static void floodFill(char[][] ar, int i, int j, int n, int m) {
        ar[i][j] = 'O';
        for (int[] dir : directions) {
            int u = i + dir[0];
            int v = j + dir[1];
            if (isSafe(u, v, n, m) && ar[u][v] == '-') {
                floodFill(ar, u, v, n, m);
            }
        }
    }

    static boolean isSafe(int u, int v, int n, int m) {
        return u >= 0 && u < n && v >= 0 && v < m;
    }

    static int[][] directions = {{0, -1}, {-1, 0}, {0, +1}, {+1, 0}};

    ///////////////////////////////////////////////////////////////////////
    private static void approach1(int n, int m, char[][] ar, char[][] res, boolean[][] vis) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ar[i][j] == 'O' && !vis[i][j]) {
                    process(i, j, n, m, ar, res, vis, true);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
        }
        System.out.println();
    }


    static boolean process(int i, int j, int n, int m, char[][] ar, char[][] res, boolean[][] vis, boolean replace) {
        vis[i][j] = true;

        for (int[] dir : directions) {
            int u = i + dir[0];
            int v = j + dir[1];
            replace = replace && isSafe(u, v, n, m);
        }

        if (replace) {
            res[i][j] = 'X';
        }
        for (int[] dir : directions) {
            int u = i + dir[0];
            int v = j + dir[1];
            if (isSafe(u, v, n, m) && !vis[u][v] && ar[u][v] == 'O') {
                //replace = replace && process(u, v, n, m, ar, res, vis, replace);//process is not called if replace is false
                boolean replaceRecursive = process(u, v, n, m, ar, res, vis, replace);
                replace = replace && replaceRecursive;
            }
        }
        if (!replace) {
            res[i][j] = 'O';
        }
        return replace;
    }

}