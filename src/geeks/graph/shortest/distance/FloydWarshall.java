/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph.shortest.distance;

import geeks.graph.GraphM;
import geeks.graph.IGraph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author khwaja.ali
 * @version $Id: FloydWarshall.java, v 0.1 2020-04-29 5:25 pm khwaja.ali Exp 3
 */
//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/FloydWarshallAllPairShortestPath.java
public class FloydWarshall {
    private static final int INF = Integer.MAX_VALUE;

    public int[][] process(IGraph graph) throws Exception {
        GraphM graphM = (GraphM) graph;
        int V = graphM.V;
        int[][] adjMat = graphM.adjMat;
        int[][] dist = new int[V][V];
        int[][] path = new int[V][V];

        //if there is no edge then the dist is INF and not 0
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = adjMat[i][j];
                path[i][j] = (dist[i][j] != INF && i != j) ? i : -1;
            }
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
        //Negative weight cycle
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                throw new Exception("Negative weight cycle found");
            }
        }
        printPath(path, 3, 2);
        printPath(path, 0, 3);
        return dist;
    }

    private void printPath(int[][] path, int i, int j) {
        Deque<Integer> st = new ArrayDeque<>();
        int k = j;
        while (true) {
            st.addLast(k);
            k = path[i][k];
            if (k == -1)
                break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //4 3 2 1

        while (!st.isEmpty()) {
            sb.append(st.removeLast());
            if (st.isEmpty()) {
                sb.append("]\n");
            } else {
                sb.append(" -> ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        int[][] graph = {
                {0, 3, 6, 15},
                {INF, 0, -2, INF},
                {INF, INF, 0, 2},
                {1, INF, INF, 0}
        };
        GraphM graphM = new GraphM(graph.length, graph);
        FloydWarshall fw = new FloydWarshall();
        print(fw.process(graphM));
    }

    private static void print(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        System.out.println();
    }

}
