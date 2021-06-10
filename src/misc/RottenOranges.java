package misc;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int ar[][] = {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int m = 3;
        int n = 5;
        System.out.println(processBFS(ar, m, n));
    }

    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] directions = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    private static int processBFS(int[][] ar, int m, int n) {
        int fresh = 0;
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i][j] == 1) {
                    fresh++;
                }
                if (ar[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }
        if (fresh == 0)
            return 0;
        if (q.isEmpty())
            return -1;

        int iterations = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                Pair p = q.poll();
                for (int[] dir : directions) {
                    int r = p.i + dir[0];
                    int c = p.j + dir[1];
                    if (isSafe(r, c, m, n) && ar[r][c] == 1) {
                        ar[r][c] = 2;
                        fresh--;
                        q.offer(new Pair(r, c));
                    }
                }
            }
            iterations++;
            if (fresh == 0)
                return iterations;
        }
        return -1;
    }

    private static boolean isSafe(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
}
