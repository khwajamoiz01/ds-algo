package geeks.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DAGLongestPath {
    static class AdjListNode {
        int v;
        int w;

        AdjListNode(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    void process(List<List<AdjListNode>> adj, int V, int s) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            topoSort(adj, V, i, vis, st);
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[s] = 0;

        while (!st.isEmpty()) {
            int u = st.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                for (AdjListNode node : adj.get(u)) {
                    dist[node.v] = Math.max(dist[node.v], dist[u] + node.w);
                }
            }
        }
    }

    private void topoSort(List<List<AdjListNode>> adj, int V, int u, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;
        for (AdjListNode adjListNode : adj.get(u)) {
            if (!vis[adjListNode.v])
                topoSort(adj, V, adjListNode.v, vis, st);
        }
        st.push(u);
    }
}
