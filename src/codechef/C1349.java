/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: C1349.java, v 0.1 2020-05-14 12:19 am khwaja.ali Exp 3
 */
public class C1349 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int qn = sc.nextInt();
            int[][] ar = new int[r][c];
            for (int i = 0; i < r; i++) {
                String row = sc.next();
                for (int j = 0; j < c; j++) {
                    ar[i][j] = row.charAt(j) - '0';
                }
            }
            Map<String, Integer> dp = new HashMap<>();
            for (int i = 0; i < qn; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                long iteration = sc.nextLong();
                System.out.println(processDp(ar, x - 1, y - 1, iteration, dp));
            }
        }
    }

    static int[][] dirs = {{0, -1}, {-1, 0}, {0, +1}, {+1, 0}};

    private static int processDp(int[][] ar, int i, int j, long n, Map<String, Integer> dp) {
        if (n == 0)
            return ar[i][j];
        if (!dp.containsKey(getKey(i, j, n))) {
            int pi = processDp(ar, i, j, n - 1, dp);
            dp.put(getKey(i, j, n), pi);
            for (int[] dir : dirs) {
                int u = i + dir[0];
                int v = j + dir[1];
                if (isSafe(u, v, ar)) {
                    int npi = processDp(ar, u, v, n - 1, dp);
                    if (pi == npi) {
                        dp.put(getKey(i, j, n), 1 - pi);
                        break;
                    }
                }
            }
        }
        return dp.get(getKey(i, j, n));
    }

    private static String getKey(int i, int j, long n) {
        return i + "" + j + "" + n;
    }

    private static boolean isSafe(int u, int v, int[][] ar) {
        return u >= 0 && u < ar.length && v >= 0 && v < ar[0].length;
    }

}