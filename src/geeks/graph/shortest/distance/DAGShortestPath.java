/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph.shortest.distance;

import geeks.graph.GraphAL;
import geeks.graph.IGraph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author khwaja.ali
 * @version $Id: DAG.java, v 0.1 2020-04-29 10:00 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
public class DAGShortestPath {
    public int[] process(IGraph graph) {
        GraphAL graphAL = (GraphAL) graph;
        Stack<Integer> st = topoSort(graphAL);
        int[] dist = new int[graphAL.V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        //can be any source vertex
        dist[1] = 0;

        while (!st.isEmpty()) {
            int u = st.pop();
            if (dist[u] == Integer.MAX_VALUE)
                continue;
            for (GraphAL.Edge edge : graphAL.adjList[u]) {
                dist[edge.vertex] = Math.min(dist[edge.vertex], dist[u] + edge.weight);
            }
        }
        return dist;
    }

    private Stack<Integer> topoSort(GraphAL graphAL) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[graphAL.V];
        for (int i = 0; i < graphAL.V; i++) {
            if (!vis[i]) {
                topSortUtil(i, graphAL.adjList, vis, st);
            }
        }
        return st;
    }

    private void topSortUtil(int u, List<GraphAL.Edge>[] adjList, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;
        for (GraphAL.Edge edge : adjList[u]) {
            if (!vis[edge.vertex]) {
                topSortUtil(edge.vertex, adjList, vis, st);
            }
        }
        st.push(u);
    }

    public static void main(String[] args) {
        DAGShortestPath dagShortestPath = new DAGShortestPath();
        GraphAL graphAL = new GraphAL(6);
        graphAL.addEdge(0, 1, 5);
        graphAL.addEdge(0, 2, 3);
        graphAL.addEdge(1, 3, 6);
        graphAL.addEdge(1, 2, 2);
        graphAL.addEdge(2, 4, 4);
        graphAL.addEdge(2, 5, 2);
        graphAL.addEdge(2, 3, 7);
        graphAL.addEdge(3, 4, -1);
        graphAL.addEdge(4, 5, -2);
        System.out.println(Arrays.toString(dagShortestPath.process(graphAL)));
    }
}