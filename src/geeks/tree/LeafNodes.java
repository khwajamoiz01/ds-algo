/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: LeafNodes.java, v 0.1 2020-03-31 1:09 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/leaf-nodes-preorder-binary-search-treeusing-recursion/
public class LeafNodes {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                i = 0;
                printLeaf(ar, Integer.MIN_VALUE, Integer.MAX_VALUE);
                System.out.println();
            }
        }
    }

    static int i = 0;

    static boolean printLeaf(int[] ar, int min, int max) {
        if (i < ar.length && ar[i] >= min && ar[i] <= max) {
            int n = ar[i++];
            //Important : if you put recursive calls inside if
            //then the output will be wrong because the second
            //recursive call is not invoked if first fails
            boolean l = printLeaf(ar, min, n);
            boolean r = printLeaf(ar, n, max);
            if (!l && !r) {
                System.out.print(n + " ");
            }
            return true;
        }
        return false;
    }

}