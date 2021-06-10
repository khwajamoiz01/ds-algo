package geeks.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://practice.geeksforgeeks.org/problems/perfect-sum-problem/0
public class PerfectSumProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(ob.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(ob.readLine());
            int[] ar = new int[n];
            String[] strs = ob.readLine().trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(strs[i]);
            }
            int sum = Integer.parseInt(ob.readLine());
            System.out.println(subsetCount(n, ar, sum));
        }
    }

    static int mod = 1000000007;

    static int subsetCount(int n, int[] ar, int sum) {
        int[][] dp = new int[n + 1][sum + 1];//if Integer is used then practice throws TLE
        for (int[] dpp : dp) {
            Arrays.fill(dpp, -1);
        }
        return subsetCountUtil(ar, n, sum, dp);
    }

    static int subsetCountUtil(int[] ar, int n, int sum, int[][] dp) {
        if (sum < 0)
            return 0;
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][sum] == -1) {
            int included = subsetCountUtil(ar, n - 1, sum - ar[n - 1], dp) % mod;
            int excluded = subsetCountUtil(ar, n - 1, sum, dp) % mod;
            dp[n][sum] = (included + excluded) % mod;
        }
        return dp[n][sum];
    }

}
