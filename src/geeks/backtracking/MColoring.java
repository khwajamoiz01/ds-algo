package geeks.backtracking;

import java.util.Scanner;

/**
 * Time Complexity: O(m^V)
 * Space Complexity: O(V)
 */
//https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
public class MColoring {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int e = sc.nextInt();
                int[][] adj = new int[n][n];
                for (int i = 0; i < e; i++) {
                    int u = sc.nextInt() - 1;
                    int v = sc.nextInt() - 1;
                    adj[u][v] = 1;
                    adj[v][u] = 1;
                }
                int[] colors = new int[n];
                System.out.println(mColor(adj, 0, n, m, colors) ? 1 : 0);
            }
        }
    }

    //conventional dfs type backtracking isn't used as that approach will fail for disconnected graph
    //as we cant find whether all vertices are processed for returning true in the base case
    //check with other backtracking problems
    static boolean mColor(int[][] adj, int u, int n, int m, int[] colors) {
        if (u == n)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(c, adj, u, n, m, colors)) {
                colors[u] = c;
                if (mColor(adj, u + 1, n, m, colors))
                    return true;
                colors[u] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int c, int[][] adj, int u, int n, int m, int[] colors) {
        for (int v = 0; v < n; v++) {
            if (adj[u][v] == 1 && colors[v] == c)
                return false;
        }
        return true;
    }

    void test() {
        int a = 100000000;
    }

}
