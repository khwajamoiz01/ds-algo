/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph.shortest.distance;

import geeks.graph.Edge;
import geeks.graph.GraphAL;
import geeks.graph.IGraph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author khwaja.ali
 * @version $Id: PrimMSTOptimized.java, v 0.1 2020-04-27 11:47 pm khwaja.ali Exp 3
 */
//ALSO SEE - https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
public class Dijkstra {

    //Time complexity = O(V + E)logV
    public int[] process(IGraph graph) {
        GraphAL graphAL = (GraphAL) graph;

        int[] dist = new int[graphAL.V];
        //O(V)
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                int diff = dist[i] - dist[j];
                return (diff == 0) ? i - j : diff;
                // otherwise for same compare values keys are not getting inserted
            }
        });

        //O(V)
        for (int i = 0; i < graphAL.V; i++) {
            treeSet.add(i);
        }

        //O(V + E)logV
        while (!treeSet.isEmpty()) {
            //mst set is not used as treeSet is enough as it does not contains included vertices, verify
            int u = treeSet.pollFirst();
            for (GraphAL.Edge edge : graphAL.adjList[u]) {
                int v = edge.vertex;
                int w = edge.weight;
                if (treeSet.contains(v) && dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    treeSet.remove(v);
                    //remove before updating distance, otherwise the key wont be found due to updated distance
                    dist[v] = dist[u] + w;
                    treeSet.add(v);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        Dijkstra sp = new Dijkstra();
        GraphAL graphAL = new GraphAL(graph.length);
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0) {
                    graphAL.addEdge(u, v, graph[u][v]);
                }
            }
        }
        int[] result = sp.process(graphAL);
        System.out.println(Arrays.toString(result));
        //[[src: 0, dest: 1, weight: 2], [src: 1, dest: 2, weight: 3], [src: 1, dest: 4, weight: 5], [src: 0, dest: 3, weight: 6]]
    }

}