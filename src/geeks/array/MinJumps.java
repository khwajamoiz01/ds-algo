/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

/**
 * @author khwaja.ali
 * @version $Id: MinJumps.java, v 0.1 2020-01-27 22:55 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class MinJumps {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                //Integer[] dp = new Integer[n];
                //int jumps = minJumps(ar, 0, n, dp);
                //jumps = (jumps == Integer.MAX_VALUE) ? -1 : jumps;
                System.out.println(minJumpsN(ar));
            }
        }
    }

    static int minJumpsN(int[] arr) {
        if (arr.length <= 1)
            return 0;

        if (arr[0] == 0)
            return -1;

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return jump;

            maxReach = Math.max(maxReach, i + arr[i]);
            step--;

            if (step == 0) {
                jump++;
                step = maxReach - i;
                if (i >= maxReach)
                    return -1;
            }
        }
        return -1;
    }

    static int minJumps(int[] ar, int i, int n, Integer[] dp) {
        if (i >= n - 1)
            return 0;
        if (ar[i] == 0)
            return Integer.MAX_VALUE;
        if (dp[i] == null) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + ar[i] && j < n; j++) {
                int jumps = minJumps(ar, j, n, dp);
                jumps = (jumps == Integer.MAX_VALUE) ? jumps : jumps + 1;
                min = Math.min(min, jumps);
            }
            dp[i] = min;
        }
        return dp[i];
    }
}
