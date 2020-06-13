/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: PrimMSTOptimized.java, v 0.1 2020-04-27 11:47 pm khwaja.ali Exp 3
 */
public class PrimMSTOptimized implements IPrimMST {

    //Time complexity = O(V + E)logV
    @Override
    public Edge[] process(IGraph graph) {
        GraphAL graphAL = (GraphAL) graph;

        PrimVertexData[] primVertices = new PrimVertexData[graphAL.V];
        primVertices[0] = new PrimVertexData(0, -1);

        //O(V)
        for (int i = 1; i < graphAL.V; i++) {
            primVertices[i] = new PrimVertexData(Integer.MAX_VALUE, -1);
        }

        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                int diff = primVertices[i].weight - primVertices[j].weight;
                return (diff == 0) ? i - j : diff;
                // otherwise for same compare values keys are not getting inserted
            }
        });

        //O(V)
        for (int i = 0; i < graphAL.V; i++) {
            treeSet.add(i);
        }

        Edge[] result = new Edge[graphAL.V - 1];
        int i = 0;
        //O(V + E)logV
        while (i < graphAL.V - 1) {
            //mst set is not used as treeSet is enough as it does not contains included vertices, verify
            int u = treeSet.pollFirst();

            for (GraphAL.Edge edge : graphAL.adjList[u]) {
                int v = edge.vertex;
                int w = edge.weight;
                if (treeSet.contains(v) && w < primVertices[v].weight) {
                    treeSet.remove(v);
                    //remove before updating distance, otherwise the key wont be found due to updated distance
                    primVertices[v].weight = w;
                    primVertices[v].parent = u;
                    treeSet.add(v);
                }
            }
            if (primVertices[u].parent != -1) {
                result[i++] = new Edge(primVertices[u].parent, u, primVertices[u].weight);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};
        PrimMSTOptimized mst = new PrimMSTOptimized();
        GraphAL graphAL = new GraphAL(graph.length);
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0) {
                    graphAL.addEdge(u, v, graph[u][v]);
                }
            }
        }
        Edge[] result = mst.process(graphAL);
        System.out.println(Arrays.toString(result));
        //[[src: 0, dest: 1, weight: 2], [src: 1, dest: 2, weight: 3], [src: 1, dest: 4, weight: 5], [src: 0, dest: 3, weight: 6]]
    }

    void test() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
    }
}