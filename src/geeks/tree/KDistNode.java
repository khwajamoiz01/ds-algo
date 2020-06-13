/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: KDistNode.java, v 0.1 2020-01-05 15:42 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
public class KDistNode {

    static void printkdown(BTNode node, int k) {
        if (node == null)
            return;
        if (k == 0)
            System.out.print(node.data + " ");
        else {
            printkdown(node.left, k - 1);
            printkdown(node.right, k - 1);
        }
    }

    static int printkdistanceNode(BTNode root, BTNode node, int k) {
        if (root == null)
            return -1;
        if (root == node) {
            printkdown(node, k);
            return k - 1;
        }
        int l = printkdistanceNode(root.left, node, k);
        int r = printkdistanceNode(root.right, node, k);
        if (l == 0) {
            System.out.print(root.data + " ");
        } else if (l > 0) {
            printkdown(root.right, l - 1);
            return l - 1;
        }
        if (r == 0) {
            System.out.print(root.data + " ");
        } else if (r > 0) {
            printkdown(root.left, r - 1);
            return r - 1;
        }
        return -1;
    }
}