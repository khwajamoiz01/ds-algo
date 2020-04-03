/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package codeforces;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: C369.java, v 0.1 2019-10-29 14:54 khwaja.ali Exp 3
 */
public class C369 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[][] = new int[n][3];
        int adj[][] = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            ar[i][0] = sc.nextInt();
            ar[i][1] = sc.nextInt();
            ar[i][2] = sc.nextInt();

            adj[ar[i][0]][ar[i][1]] = 1;
        }

        //TODO

    }

}