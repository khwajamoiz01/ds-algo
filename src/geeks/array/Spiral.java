/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Spiral.java, v 0.1 2020-01-26 12:10 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
class Spiral {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int[][] ar = new int[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        ar[i][j] = sc.nextInt();
                    }
                }
                int k = 0, l = 0;
                int D = Math.min(r / 2, c / 2);
                for (int d = 0; d < D; d++) {
                    for (int i = d; i < c - d - 1; i++) {
                        System.out.print(ar[d][i] + " ");
                    }
                    for (int i = d; i < r - d - 1; i++) {
                        System.out.print(ar[i][c - d - 1] + " ");
                    }
                    for (int i = c - d - 1; i > d; i--) {
                        System.out.print(ar[r - d - 1][i] + " ");
                    }
                    for (int i = r - d - 1; i > d; i--) {
                        System.out.print(ar[i][d] + " ");
                    }
                }
                if (r == c && r % 2 != 0) {
                    System.out.print(ar[D][D] + " ");
                }
                if (r < c && r % 2 != 0) {
                    for (int i = D; i < c - D; i++) {
                        System.out.print(ar[D][i] + " ");
                    }
                }
                if (c < r && c % 2 != 0) {
                    for (int i = D; i < r - D; i++) {
                        System.out.print(ar[i][D] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}