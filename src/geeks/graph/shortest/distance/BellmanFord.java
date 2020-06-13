/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph.shortest.distance;

import geeks.graph.Edge;
import geeks.graph.GraphE;
import geeks.graph.IGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author khwaja.ali
 * @version $Id: BellmanFord.java, v 0.1 2020-04-29 12:31 am khwaja.ali Exp 3
 */
public class BellmanFord {

    //Time complexity - O(VE)
    public int[] process(IGraph graph) throws Exception {
        GraphE graphE = (GraphE) graph;

        int[] dist = new int[graphE.V];
        //O(V)
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        //O(VE)
        for (int i = 0; i < graphE.V - 1; i++) {
            for (Edge edge : graphE.edges) {
                if (dist[edge.src] != Integer.MAX_VALUE &&
                        dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }
        //O(E)
        for (Edge edge : graphE.edges) {
            if (dist[edge.src] != Integer.MAX_VALUE &&
                    dist[edge.src] + edge.weight < dist[edge.dest]) {
                throw new Exception("Negative weight cycle found");
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        int V = 5;
        int E = 8;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= 1000000; i++) {
//            sb.append("{\"index\":{\"_id\": \"" + i + "\"}}");
//            sb.append("\n");
//            sb.append("{\"name\": \"Test Recruiter " + i + "\", \"email\": \"" + "recruiter" + i + "@gmail.com\"}");
//            sb.append("\n");
//        }
//        System.out.println(sb);
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));
        GraphE graph = new GraphE(V, E, edges);
        BellmanFord bf = new BellmanFord();
        System.out.println(Arrays.toString(bf.process(graph)));
    }
}