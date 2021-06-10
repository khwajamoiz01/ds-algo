/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Hamiltonian.java, v 0.1 2020-01-18 17:26 khwaja.ali Exp 3
 */
//https://practice.geeksforgeeks.org/problems/hamiltonian-path/0
//https://www.geeksforgeeks.org/hamiltonian-cycle-backtracking-6/
public class HamiltonianPath {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[][] adj = new int[n][n];
                for (int i = 0; i < m; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    adj[u - 1][v - 1] = 1;
                    adj[v - 1][u - 1] = 1;
                }
                boolean[] vis = new boolean[n];
                boolean exists = false;
                for (int i = 0; i < n; i++) {
                    if (hamPath(i, n, vis, adj, 0)) {
                        exists = true;
                        break;
                    }
                }
                System.out.println(exists ? 1 : 0);
            }
        }
    }


    static boolean hamPath(int i, int n, boolean[] vis, int[][] adj, int count) {
        vis[i] = true;
        count++;
        if (count == n)
            return true;

        for (int j = 0; j < n; j++) {
            if (adj[i][j] == 1 && !vis[j] && hamPath(j, n, vis, adj, count)) {
                return true;
            }
        }
        vis[i] = false;
        return false;
    }


    //geeks solution, little different than normal
    public static boolean hamCycle(int[][] adj, int n) {
        int[] path = new int[n];
        Arrays.fill(path, -1);
        boolean[] vis = new boolean[n];
        path[0] = 0;
        vis[0] = true;
        if (!hamCycle(1, n, vis, adj, path)) {
            return false;
        }
        System.out.println(Arrays.toString(path));
        return true;
    }

    private static boolean hamCycle(int pos, int n, boolean[] vis, int[][] adj, int[] path) {
        if (pos == n) {
            return adj[pos - 1][0] == 1;
        }
        for (int v = 0; v < n; v++) {
            if (adj[path[pos - 1]][v] == 1 && !vis[v]) {
                path[pos] = v;
                if (hamCycle(pos + 1, n, vis, adj, path)) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }
}