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

    static class Pointer {
        int maxSum = Integer.MIN_VALUE;
    }

    int maxPathSum(BTNode root) {
        Pointer p = new Pointer();
        maxPathSumUtil(root, p);
        return p.maxSum;
    }

    int maxPathSumUtil(BTNode root, Pointer p) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;
        int l = maxPathSumUtil(root.left, p);
        int r = maxPathSumUtil(root.right, p);
        if (root.left == null)
            return root.data + r;
        if (root.right == null)
            return root.data + l;
        p.maxSum = Math.max(p.maxSum, l + root.data + r);
        return root.data + Math.max(l, r);
    }

}