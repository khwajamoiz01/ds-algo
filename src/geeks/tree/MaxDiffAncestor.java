/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.tree;


import java.util.HashMap;
import java.util.Map;

/**
 * @author khwaja.ali
 * @version $Id: MaxDiffAncestor.java, v 0.1 2019-12-30 22:03 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
public class MaxDiffAncestor {


    public static void main(String[] args) {

    }

    int maxDiff(Node root) {
        min(root);
        return maxDiff;
    }

    int maxDiff = Integer.MIN_VALUE;

    int min(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;

        if (node.left == null && node.right == null)
            return node.data;

        int min = Math.min(min(node.left), min(node.right));
        maxDiff = Math.max(maxDiff, node.data - min);
        return Math.min(node.data, min);
    }

    void test() {

    }

}