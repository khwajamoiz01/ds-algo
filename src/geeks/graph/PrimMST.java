/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: PrimMST.java, v 0.1 2020-04-27 8:03 pm khwaja.ali Exp 3
 */
public class PrimMST implements IPrimMST {

    //Time complexity = O(v)2
    @Override
    public Edge[] process(IGraph graph) {
        GraphM graphM = (GraphM) graph;
        Set<Integer> mstSet = new HashSet<>();
        PrimVertexData[] primVertices = new PrimVertexData[graphM.V];
        primVertices[0] = new PrimVertexData(0, -1);
        for (int i = 1; i < graphM.V; i++) {
            primVertices[i] = new PrimVertexData(Integer.MAX_VALUE, -1);
        }
        Edge[] result = new Edge[graphM.V - 1];
        int i = 0;

        //O(v) - verify
        while (i < graphM.V - 1) {
            //O(v)
            int u = minVertex(primVertices, mstSet);
            mstSet.add(u);
            //O(v)
            for (int v = 0; v < graphM.V; v++) {
                if (graphM.adjMat[u][v] != 0 && !mstSet.contains(v) && graphM.adjMat[u][v] < primVertices[v].weight) {
                    primVertices[v].weight = graphM.adjMat[u][v];
                    primVertices[v].parent = u;
                }
            }
            if (primVertices[u].parent != -1) {
                result[i++] = new Edge(primVertices[u].parent, u, primVertices[u].weight);
            }
        }
        return result;
    }

    private int minVertex(PrimVertexData[] vertices, Set<Integer> mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < vertices.length; i++) {
            if (!mstSet.contains(i) && vertices[i].weight < min) {
                min = vertices[i].weight;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};
        PrimMST mst = new PrimMST();
        Edge[] result = mst.process(new GraphM(graph.length, graph));
        System.out.println(Arrays.toString(result));
        //[[src: 0, dest: 1, weight: 2], [src: 1, dest: 2, weight: 3], [src: 1, dest: 4, weight: 5], [src: 0, dest: 3, weight: 6]]
    }
}
