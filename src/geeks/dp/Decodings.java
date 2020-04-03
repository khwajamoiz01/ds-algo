/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

/**
 * @author khwaja.ali
 * @version $Id: Decodings.java, v 0.1 2020-03-15 5:50 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;

public class Decodings {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String s = sc.next();
                Integer[] dp = new Integer[n + 1];
                System.out.println(validate(s, n) ? ways(s, 0, n, dp) : 0);
            }
        }
    }

    static boolean validate(String s, int n) {
        if (n == 0)
            return true;
        if (s.charAt(0) == '0')
            return false;
        if (n >= 2 && s.contains("00"))
            return false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                char ch = s.charAt(i - 1);
                if (ch != '1' && ch != '2')
                    return false;
            }
        }
        return true;
    }

    static int ways(String s, int i, int n, Integer[] dp) {

        if (i == n)
            return 1;
        if (s.charAt(i) == '0') //2108, 110
            return 0;
        if (i == n - 1)
            return 1;
        if (dp[i] == null) {
            int w = 0;
            if (s.charAt(i + 1) != '0') {
                w += ways(s, i + 1, n, dp);
            }
            int td = Integer.parseInt(s.substring(i, i + 2));
            if (td >= 1 && td <= 26) {
                w += ways(s, i + 2, n, dp);
            }
            dp[i] = w;
        }
        return dp[i];

    }

    void test() {
        int[] num = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] rom = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        Integer.reverse(1);
        int i = 864354781;
        Math.pow(0, 0);

    }
}