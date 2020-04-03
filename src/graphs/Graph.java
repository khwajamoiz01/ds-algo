/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author khwaja.ali
 * @version $Id: Graph.java, v 0.1 2019-10-26 01:26 khwaja.ali Exp 3
 */
public class Graph {

    private int v;
    private List<List<Integer>> adj;

    Graph(int v) {
        this.v = v;
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.set(i, new LinkedList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void BFS(int s) {
        boolean[] vis = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        vis[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v);

            adj.get(v).forEach(w -> {
                if (!vis[w]) {
                    queue.offer(w);
                    vis[w] = true;
                }
            });
        }
    }

    void DFSUtil(int s) {
        boolean[] vis = new boolean[v];
        DFS(s, vis);
    }

    void DFS(int v, boolean[] vis) {
        System.out.println(v);
        vis[v] = true;

        adj.get(v).forEach(w -> {
            if (!vis[w]) {
                DFS(w, vis);
            }
        });
    }
}