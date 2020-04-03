/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Combination.java, v 0.1 2019-12-15 23:38 khwaja.ali Exp 3
 */
//https://practice.geeksforgeeks.org/problems/four-elements/0
public class Combination {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++)
                    ar[i] = sc.nextInt();
                int x = sc.nextInt();
            }
        }
    }
}