/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

/**
 * @author khwaja.ali
 * @version $Id: Edge.java, v 0.1 2020-04-26 9:24 pm khwaja.ali Exp 3
 */
public class Edge {
    public int weight;
    public int src;
    public int dest;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public String toString() {
        return "[src: " + src + ", dest: " + dest + ", weight: " + weight + "]";
    }

}