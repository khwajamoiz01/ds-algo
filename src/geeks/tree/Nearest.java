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
min not required as in solution of geeks
unable to submit with scanner change to br
 */
public class Nearest {


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                int r = sc.nextInt();
                int c = sc.nextInt();

                int[][] mat = new int[r][c];
                boolean[][] vis = new boolean[r][c];
                int[][] dist = new int[r][c];
                Queue<Vertex> q = new ArrayDeque<>();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        mat[i][j] = sc.nextInt();
                        if (mat[i][j] == 1) {
                            vis[i][j] = true;
                            q.offer(new Vertex(i, j));
                        }
                    }
                }
                while (!q.isEmpty()) {
                    Vertex vt = q.poll();
                    for (int i = 0; i < edges.length; i++) {
                        int u = vt.i + edges[i][0];
                        int v = vt.j + edges[i][1];
                        if (isSafe(r, c, u, v) && !vis[u][v]) {
                            vis[u][v] = true;
                            q.offer(new Vertex(u, v));
                            dist[u][v] = dist[vt.i][vt.j] + 1;
                        }
                    }
                }
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append(dist[i][j] + " ");
                    }
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }

    static int[][] edges = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static boolean isSafe(int r, int c, int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }

    static class Vertex {
        int i, j;

        Vertex(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}