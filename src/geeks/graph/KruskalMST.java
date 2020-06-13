/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: Kruskal.java, v 0.1 2020-04-26 8:48 pm khwaja.ali Exp 3
 */
public class KruskalMST {

    //Time complexity = O(ElogE + ELogV)
    Edge[] process(GraphE graph) {
        //O(ElogE)
        Collections.sort(graph.edges, Comparator.comparingInt(e -> e.weight));
        UnionFind unionFind = new UnionFind(graph);
        Edge[] result = new Edge[graph.V - 1];
        int i = 0, j = 0;
        //O(ELogV)
        while (j < graph.V - 1) {
            //condition not required i think for a connected graph
            if (i == graph.E) {
                return null;
            }
            Edge edge = graph.edges.get(i++);
            int x = unionFind.find(edge.src);
            int y = unionFind.find(edge.dest);
            if (x != y) {
                unionFind.union(x, y);
                result[j++] = edge;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        GraphE graph = new GraphE(4, 5, edges);

        KruskalMST kruskal = new KruskalMST();
        Edge[] result = kruskal.process(graph);
        System.out.println(Arrays.toString(result));
        //[[src: 2, dest: 3, weight: 4], [src: 0, dest: 3, weight: 5], [src: 0, dest: 1, weight: 10]]
    }
}