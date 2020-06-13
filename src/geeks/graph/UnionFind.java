/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.graph;

/**
 * @author khwaja.ali
 * @version $Id: UnionFind.java, v 0.1 2020-04-26 9:24 pm khwaja.ali Exp 3
 */
public class UnionFind {

    private Subset[] subsets;

    UnionFind(GraphE graph) {
        subsets = new Subset[graph.V];
        for (int i = 0; i < graph.V; i++) {
            subsets[i] = new Subset(i, 0);
        }
    }

    int find(int i) {
        if (subsets[i].parent == i)
            return i;
        subsets[i].parent = find(subsets[i].parent);
        return subsets[i].parent;
    }

    void union(int u, int v) {
        int us = find(u);
        int vs = find(v);
        if (subsets[us].rank < subsets[vs].rank) {
            subsets[us].parent = vs;
        } else if (subsets[us].rank > subsets[vs].rank) {
            subsets[vs].parent = us;
        } else {
            subsets[us].parent = vs;
            subsets[vs].rank++;
        }
    }

    boolean isCyclic(GraphE graph) {
        for (Edge edge : graph.edges) {
            int x = find(edge.src);
            int y = find(edge.dest);
            if (x == y) {
                return true;
            }
            union(x, y);
        }
        return false;
    }

    static class Subset {
        int parent;
        int rank;

        Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

}