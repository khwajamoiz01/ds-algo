package geeks.tree;

import java.util.*;

//https://www.geeksforgeeks.org/check-mirror-n-ary-tree/
//Below implementation is doing the similar thing as in geeks, but geeks one is better and iterative
public class MirrorNAryTree {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int e = sc.nextInt();
                Map<Integer, List<Integer>> adjList1 = new HashMap<>();
                Map<Integer, List<Integer>> adjList2 = new HashMap<>();
                input(sc, e, adjList1);
                input(sc, e, adjList2);
                boolean mirror = isMirror(adjList1, 1, adjList2, 1);
                System.out.println(mirror ? 1 : 0);
            }
        }
    }

    private static void input(Scanner sc, int e, Map<Integer, List<Integer>> adjList) {
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (!adjList.containsKey(u)) {
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(v);
        }
    }

    static boolean isMirror(Map<Integer, List<Integer>> adjList1, int i,
                            Map<Integer, List<Integer>> adjList2, int j) {
        if (i != j)
            return false;
        if (!adjList1.containsKey(i) && !adjList2.containsKey(j))
            return true;
        if (!adjList1.containsKey(i) || !adjList2.containsKey(j))
            return false;
        if (adjList1.get(i).size() != adjList2.get(j).size())
            return false;
        int n = adjList1.get(i).size();
        for (int k = 0; k <= n / 2; k++) {
            if (!isMirror(adjList1, adjList1.get(i).get(k),
                    adjList2, adjList2.get(j).get(n - k - 1)))
                return false;
        }
        return true;
    }


}
