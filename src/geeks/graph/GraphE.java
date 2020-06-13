/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

import java.util.List;

/**
 * @author khwaja.ali
 * @version $Id: Graph.java, v 0.1 2020-04-27 10:50 pm khwaja.ali Exp 3
 */
public class GraphE implements IGraph {
    public int V;
    public int E;
    public List<Edge> edges;

    public GraphE(int v, int e, List<Edge> edges) {
        this.V = v;
        this.E = e;
        this.edges = edges;
    }
}
