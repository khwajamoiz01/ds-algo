/*
  Alipay.com Inc.
  Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.divide.and.conquer;

import java.util.Map;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: AllocateMinPages.java, v 0.1 2020-04-15 10:24 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/allocate-minimum-number-pages/
//https://www.geeksforgeeks.org/painters-partition-problem/

/**
 * This solutions gives TLE exceeded
 */
public class AllocateMinPages {

    //(15, 17, 20), 3, 2, 26
    //This method is modified version of the one in geeks but seems its not efficient
    //The complexity in worst case can go up to O(log(n!)) which is worse than O(n)
    //log(n) + log(n-1) + log(n-2) + ... + log(1) = log(n!)
    //for n = 8, log(n!) = 15.3
    static boolean isPossible(int[] ar, int n, int m, int min, int[] sum) {
        for (int i = 0; i < n; i++) {
            if (m == 0) {
                return false;
            }
            if (ar[i] > min)
                return false;
            int j = binSearch(ar, i, n - 1, min, sum);
            if (j == -1)
                return false;
            i = j;
            m--;
        }
        return true;
    }

    ////(15, 17, 20), 0, 2, 26
    static int binSearch(int[] ar, int i, int j, int min, int[] cumSum) {
        int index = -1;
        int s = i, e = j;
        while (s <= e) {
            int mid = (s + e) / 2;
            int sum = cumSum[mid] - ((i == 0) ? 0 : cumSum[i - 1]);
            if (sum < min) {
                index = mid;
                s = mid + 1;
            } else if (sum > min) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return index;
    }

    static int minPages(int[] ar, int n, int m) {
        if (n < m)
            return -1;
        int[] sum = new int[n];
        sum[0] = ar[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + ar[i];
        }
        int s = 0, e = sum[n - 1];
        int min = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (isPossible(ar, n, m, mid, sum)) {
                e = mid - 1;
                min = mid;
            } else {
                s = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int m = sc.nextInt();
                System.out.println(minPages(ar, n, m));
            }
        }
    }

    static int[] buildSum(int[] ar) {
        int[] sum = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            sum[i] = ar[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }
        return sum;
    }

    static int getSum(int[] sum, int s, int e) {
        if (s == 0)
            return sum[e];
        return sum[e] - sum[s - 1];
    }

    //accepted on practice
    //https://practice.geeksforgeeks.org/problems/the-painters-partition-problem/0
    static int minPagesDPApproach(int[] ar, int[] sum, int n, int k, Map<String, Integer> dp) {
        if (n == 0)
            return Integer.MIN_VALUE;
        if (k == 1)
            return getSum(sum, 0, n - 1);
        String key = n + "_" + k;
        if (!dp.containsKey(key)) {
            int curSum = 0;
            int min = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                curSum += ar[i];
                min = Math.min(min, Math.max(curSum, minPagesDPApproach(ar, sum, i, k - 1, dp)));
            }
            dp.put(key, min);
        }
        return dp.get(key);
    }
}