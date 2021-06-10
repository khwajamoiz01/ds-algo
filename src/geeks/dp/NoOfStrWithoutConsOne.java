package geeks.dp;

//https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s
//https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
public class NoOfStrWithoutConsOne {

    static long mod = (long) Math.pow(10, 9) + 7;

    long countStrings(int n) {
        return countStringsUtil(n, new long[n + 1]);
    }

    long countStringsUtil(int n, long[] dp) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 2;
        if (dp[n] == 0) {
            long res = (countStringsUtil(n - 1, dp) + countStringsUtil(n - 2, dp)) % mod;
            dp[n] = res;
        }
        return dp[n];
    }

}
