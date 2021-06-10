package geeks.dp;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
//https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
public class LongestBitonicSeq {
    public int process(int[] nums) {
        int[] lisFwd = getLisFwd(nums, nums.length);
        int[] lisBwd = getLisBwd(nums, nums.length);
        //System.out.println(Arrays.toString(lisFwd));
        //System.out.println(Arrays.toString(lisBwd));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, lisFwd[i] + lisBwd[i] - 1);
        }
        return max;
    }

    int[] getLisFwd(int[] ar, int n) {
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[i] > ar[j] && lis[i] <= lis[j]) {
                    lis[i] = 1 + lis[j];
                }
            }
        }
        return lis;
    }

    int[] getLisBwd(int[] ar, int n) {
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (ar[i] > ar[j] && lis[i] <= lis[j]) {
                    lis[i] = 1 + lis[j];
                }
            }
        }
        return lis;
    }


}
