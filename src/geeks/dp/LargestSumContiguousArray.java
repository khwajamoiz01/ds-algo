package geeks.dp;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1# accepted
public class LargestSumContiguousArray {
    int maxSubarraySum(int[] ar, int n) {
        int curSum = ar[0], maxSum = ar[0];
        for (int i = 1; i < n; i++) {
            curSum = curSum < 0 ? ar[i] : curSum + ar[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
