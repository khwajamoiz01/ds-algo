/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

/**
 * @author khwaja.ali
 * @version $Id: IPrimMST.java, v 0.1 2020-04-27 11:53 pm khwaja.ali Exp 3
 */
public interface IPrimMST {

    Edge[] process(IGraph graph);

    class PrimVertexData {
        public int weight;
        public int parent;

        public PrimVertexData(int w, int p) {
            weight = w;
            parent = p;
        }
    }
}