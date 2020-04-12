/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: CuttingBinTree.java, v 0.1 2020-04-03 3:05 pm khwaja.ali Exp 3
 */
//Also understand geeks version
//https://www.geeksforgeeks.org/minimum-splits-in-a-binary-string-such-that-every-substring-is-a-power-of-4-or-6/
public class CuttingBinTree {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                int res = process(s, s.length());
                System.out.println(res == Integer.MAX_VALUE ? -1 : res);
            }
        }
    }

    static int process(String s, int n) {
        if (n == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            String str = s.substring(i, n);
            boolean isP5 = str.charAt(0) != '0'
                    && isPowOf5(Long.parseLong(str, 2));
            if (isP5) {
                int sp = process(s, i);
                if (sp != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + sp);
                }
            }
        }
        return min;
    }

    static boolean isPowOf5(long n) {
        long r = 0;
        while (n > 5) {
            r = n % 5;
            n = n / 5;
            if (r != 0) {
                return false;
            }
        }
        return n == 5 || n == 1;
    }

}