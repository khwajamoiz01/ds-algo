/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author khwaja.ali
 * @version $Id: GraphAL.java, v 0.1 2020-04-28 5:34 pm khwaja.ali Exp 3
 */
public class GraphAL implements IGraph {
    public int V;
    public List<Edge>[] adjList;

    public GraphAL(int v) {
        this.V = v;
        this.adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        this.adjList[src].add(edge);
    }

    public static class Edge {
        public int vertex;
        public int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}