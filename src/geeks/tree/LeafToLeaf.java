/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: LeafToLeaf.java, v 0.1 2020-01-25 18:30 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
public class LeafToLeaf {
    static int sum = 0;

    public static int maxPathSum(BTNode root) {
        if (root == null)
            return 0;
        sum = 0;
        getSum(root);
        return sum;
    }

    static int getSum(BTNode root) {
        if (root == null)
            return 0;
        int l = getSum(root.left);
        int r = getSum(root.right);
        int psum = l + r + root.data;
        sum = Math.max(sum, psum);
        return root.data + Math.max(l, r);
    }
    void test(){
    }
}