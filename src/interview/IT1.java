package interview;

import java.util.Stack;

//inmobi
public class IT1 {

    public static void main(String[] args) {
        int V = 4;
        boolean[][] adj = new boolean[V][V];
        boolean[] vis = new boolean[V];
        adj[0][1] = true;
        adj[0][2] = true;
        adj[3][2] = true;
        /*
        A   X
       / \ /
      B   C

      A B C X

      B C A X
      X A C B
         */
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfs(st, i, adj, vis, V);
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
        System.out.println();
    }

    private static void dfs(Stack<Integer> st, int u, boolean[][] adj, boolean[] vis, int V) {
        vis[u] = true;
        for (int v = 0; v < V; v++) {
            if (adj[u][v] && !vis[v])
                dfs(st, v, adj, vis, V);
        }
        st.push(u);
    }
}
