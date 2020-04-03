/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

/**
 * @author khwaja.ali
 * @version $Id: Interleave.java, v 0.1 2020-03-29 9:26 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
public class Interleave {
    //Try to do in o(n2) space
    public boolean isInterLeave(String a, String b, String c) {
        /**
         * method 1 - find lcs(a, c) == length(a), remove chars of a from c, then lcs(b, c) == length(b)
         * failure - xy, yx, xyxy
         *
         * method 2 - freq of chars in (a + b) == freq of chars in (c) && lcs(a, c) == length(a) && lcs(b, c) == length(b)
         * failure - abc, bc, abccb
         */

        Integer[][][] dp = new Integer[a.length() + 1][b.length() + 1][c.length() + 1];
        return isInterLeave(a.toCharArray(), a.length(), b.toCharArray(), b.length(), c.toCharArray(), c.length(), dp);
    }

    boolean isInterLeave(char[] a, int i, char[] b, int j, char[] c, int k, Integer[][][] dp) {
        if (i == 0 && j == 0 && k >= 0)
            return true;
        if (k == 0)
            return false;

        if (i > 0 && j > 0 && c[k - 1] == a[i - 1] && c[k - 1] == b[j - 1])
            return isInterLeave(a, i - 1, b, j, c, k - 1, dp) || isInterLeave(a, i, b, j - 1, c, k - 1, dp);
        if (i > 0 && c[k - 1] == a[i - 1])
            return isInterLeave(a, i - 1, b, j, c, k - 1, dp);
        if (j > 0 && c[k - 1] == b[j - 1])
            return isInterLeave(a, i, b, j - 1, c, k - 1, dp);
        //return isInterLeave(a, i, b, j, c, k - 1, dp);// if extra chars allowed in c
        //XXY XXZ XXZXXXY
        return false;
    }

    void test() {
        String s = "";
        "".toCharArray();
    }
}