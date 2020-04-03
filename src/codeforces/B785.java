/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package codeforces;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: B785.java, v 0.1 2019-10-13 18:35 khwaja.ali Exp 3
 */
public class B785 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int an[][] = new int[n][2];
        int minR1 = Integer.MAX_VALUE, maxL1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            an[i][0] = sc.nextInt();
            maxL1 = Math.max(maxL1, an[i][0]);
            an[i][1] = sc.nextInt();
            minR1 = Math.min(minR1, an[i][1]);
        }
        int m = sc.nextInt();
        int am[][] = new int[m][2];
        int minR2 = Integer.MAX_VALUE, maxL2 = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            am[i][0] = sc.nextInt();
            maxL2 = Math.max(maxL2, am[i][0]);
            am[i][1] = sc.nextInt();
            minR2 = Math.min(minR2, am[i][1]);
        }
        System.out.println(Math.max(Math.max(maxL2 - minR1, maxL1 - minR2), 0));
    }
}