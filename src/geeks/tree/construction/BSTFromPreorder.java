/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree.construction;

import geeks.tree.BTNode;
import geeks.tree.BinaryTree;

/**
 * @author khwaja.ali
 * @version $Id: BSTFromPreorder.java, v 0.1 2020-05-03 1:32 pm khwaja.ali Exp 3
 */
public class BSTFromPreorder {

    private static class Pointer {
        int val;

        Pointer(int val) {
            this.val = val;
        }
    }

    public static BTNode build(int[] preorder) {
        return buildUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, new Pointer(0));
    }

    //{10, 5, 1, 7, 40, 50}
    private static BTNode buildUtil(int[] preorder, int min, int max, Pointer cur) {
        if (cur.val >= preorder.length || preorder[cur.val] < min || preorder[cur.val] > max)
            return null;
        BTNode root = new BTNode(preorder[cur.val]);
        cur.val++;
        root.left = buildUtil(preorder, min, root.data, cur);
        root.right = buildUtil(preorder, root.data, max, cur);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {10, 5, 1, 7, 40, 50};
        BTNode root = build(preorder);
        BinaryTree.levelOrder(root);
        BinaryTree.inorderMorris(root);
    }
}