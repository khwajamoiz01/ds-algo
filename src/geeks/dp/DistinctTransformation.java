/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: DistinctTransformation.java, v 0.1 2020-03-22 4:44 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/ways-transforming-one-string-removing-0-characters/
//https://practice.geeksforgeeks.org/problems/distinct-transformations/0
public class DistinctTransformation {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char[] a = sc.next().toCharArray();
                char[] b = sc.next().toCharArray();
                System.out.println(process(a, a.length, b, b.length));
            }
        }
    }

    static int process(char[] a, int ai, char[] b, int bi) {
        if (bi == 0)
            return 1;
        if (ai == 0)
            return 0;
        if (a[ai - 1] == b[bi - 1])
            return process(a, ai - 1, b, bi - 1) + process(a, ai - 1, b, bi);
        return process(a, ai - 1, b, bi);
    }


}