/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Nearest.java, v 0.1 2020-01-16 23:19 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix/
/*
Time limit exceeded on practice, compare with practice and geeks solution
 */
public class Nearest {

    static class Index {
        int i, j;

        Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    static boolean isSafe(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }

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
                Queue<Index> q = new ArrayDeque<>();
                boolean[][] vis = new boolean[r][c];

                int[][] res = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        res[i][j] = Integer.MAX_VALUE;
                        if (ar[i][j] == 1) {
                            vis[i][j] = true;
                            q.offer(new Index(i, j));
                            res[i][j] = 0;
                        }
                    }
                }
                int ht = 0;
                while (!q.isEmpty()) {
                    int size = q.size();
                    while (size-- > 0) {
                        Index index = q.poll();
                        res[index.i][index.j] = ht;
                        for (int[] dir : directions) {
                            int u = index.i + dir[0];
                            int v = index.j + dir[1];
                            if (isSafe(u, v, r, c) && !vis[u][v]) {
                                vis[u][v] = true;
                                q.offer(new Index(u, v));
                            }
                        }
                    }
                    ht++;
                }
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        System.out.print(res[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}