/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

/**
 * @author khwaja.ali
 * @version $Id: GraphM.java, v 0.1 2020-04-28 6:17 pm khwaja.ali Exp 3
 */
public class GraphM implements IGraph {
    public int V;
    public int[][] adjMat;

    public GraphM(int v, int[][] adjMat) {
        this.V = v;
        this.adjMat = adjMat;
    }
}