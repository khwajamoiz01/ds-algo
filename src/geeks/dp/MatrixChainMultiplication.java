package geeks.dp;

//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
//top down approach
public class MatrixChainMultiplication {
    static int matrixMultiplication(int n, int[] ar) {
        return dpUtil(ar, 0, n - 2, new int[n][n]);
    }

    static int dpUtil(int[] ar, int i, int j, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] == 0) {
            int minOp = Integer.MAX_VALUE;
            for (int k = i + 1; k <= j; k++) {
                int fh = dpUtil(ar, i, k - 1, dp);
                int sh = dpUtil(ar, k, j, dp);
                int op = fh + sh + ar[i] * ar[k] * ar[j + 1];
                minOp = Math.min(minOp, op);
            }
            dp[i][j] = minOp;
        }
        return dp[i][j];
    }
}
