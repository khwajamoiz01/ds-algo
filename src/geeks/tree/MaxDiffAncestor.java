/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.tree;


/**
 * @author khwaja.ali
 * @version $Id: MaxDiffAncestor.java, v 0.1 2019-12-30 22:03 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
public class MaxDiffAncestor {

    int maxDiff(BTNode root) {
        min(root);
        return maxDiff;
    }

    int maxDiff = Integer.MIN_VALUE;

    int min(BTNode node) {
        if (node == null)
            return Integer.MAX_VALUE;

        if (node.left == null && node.right == null)
            return node.data;

        int min = Math.min(min(node.left), min(node.right));
        maxDiff = Math.max(maxDiff, node.data - min);
        return Math.min(node.data, min);
    }

}