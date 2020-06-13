/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: MaxPathSum.java, v 0.1 2020-03-22 2:46 pm khwaja.ali Exp 3
 */
// https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
// https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
public class MaxPathSum {

    public static int maxPathSum(BTNode root) {
        if (root == null)
            return 0;
        ms = Integer.MIN_VALUE;
        maxSum(root);
        return ms;
    }

    static int ms;

    static int maxSum(BTNode node) {
        if (node == null)
            return Integer.MIN_VALUE;
        if (node.left == null && node.right == null)
            return node.data;
        int l = maxSum(node.left);
        int r = maxSum(node.right);
        int psum = (l == Integer.MIN_VALUE || r == Integer.MIN_VALUE) ? Integer.MIN_VALUE : node.data + l + r;
        ms = Math.max(ms, psum);
        return node.data + Math.max(l, r);
    }
}