package geeks.dp;

import java.util.Arrays;

//https://www.geeksforgeeks.org/convert-to-strictly-increasing-integer-array-with-minimum-changes/
//https://practice.geeksforgeeks.org/problems/convert-to-strictly-increasing-array3351/1
public class StrictlyIncreasingSeq {
    public int process(int[] nums) {
        int n = nums.length;
        return n - getLIS(nums, n);
    }

    public int getLIS(int[] ar, int n) {
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(ar[i] > ar[j] && lis[i] <= lis[j] && i - j <= ar[i] - ar[j]) {
                    lis[i] = 1 + lis[j];
                }
            }
        }
        int res = lis[0];
        for(int i = 1; i < n; i++) {
            res = Math.max(res, lis[i]);
        }
        //System.out.println(res);
        return res;
    }
}
