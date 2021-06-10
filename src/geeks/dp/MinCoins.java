package geeks.dp;

import java.util.Scanner;

//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
//accepted on practice, geeks sol is different, verify
public class MinCoins {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int v = sc.nextInt();
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int minChanges = change(ar, n, v, new Integer[n + 1][v + 1]);
                System.out.println(minChanges == Integer.MAX_VALUE ? -1 : minChanges);
            }
        }
    }

    static int change(int[] ar, int n, int v, Integer[][] dp) {
        if (v == 0)
            return 0;
        if (v < 0 || n == 0)
            return Integer.MAX_VALUE;
        if (dp[n][v] == null) {
            int include = change(ar, n, v - ar[n - 1], dp);
            if (include != Integer.MAX_VALUE)
                include += 1;
            int exclude = change(ar, n - 1, v, dp);
            dp[n][v] = Math.min(include, exclude);
        }
        return dp[n][v];
    }

}
