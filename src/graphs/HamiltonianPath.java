/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package graphs;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Hamiltonian.java, v 0.1 2020-01-18 17:26 khwaja.ali Exp 3
 */
public class HamiltonianPath {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int v = sc.nextInt();
                int e = sc.nextInt();
                int[][] adj = new int[v][v];
                for (int i = 0; i < e; i++) {
                    int fr = sc.nextInt() - 1;
                    int to = sc.nextInt() - 1;
                    adj[fr][to] = 1;
                    adj[to][fr] = 1;
                }
                ham(v, adj);
            }
        }
    }

    static void ham(int v, int[][] adj) {
        boolean[] vis = new boolean[v];
        boolean cycle = hamUtil(0, v, adj, vis, 0);
        System.out.println(cycle ? 1 : 0);
    }

    static boolean hamUtil(int u, int V, int[][] adj, boolean[] vis, int k) {
        vis[u] = true;
        k++;
        if (k == V) {
            return true;
        }
        for (int v = 0; v < V; v++) {
            if (adj[u][v] == 1) {
                if (!vis[v] && hamUtil(v, V, adj, vis, k)) {
                    return true;
                }
            }
        }
        vis[u] = false;
        return false;
    }
}