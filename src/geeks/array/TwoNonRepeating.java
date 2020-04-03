/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: TwoNonRepeating.java, v 0.1 2019-12-14 13:14 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
public class TwoNonRepeating {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[2 * n + 2];
                for (int i = 0; i < ar.length; i++)
                    ar[i] = sc.nextInt();

                int xor = 0;
                for (int i = 0; i < ar.length; i++) {
                    xor ^= ar[i];
                }
                int setBit = xor & ~(xor - 1);
                int x = 0, y = 0;
                for (int i = 0; i < ar.length; i++) {
                    if ((ar[i] & setBit) > 0) {
                        x ^= ar[i];
                    } else {
                        y ^= ar[i];
                    }
                }
                System.out.println(x + " " + y);
            }
        }
    }
}