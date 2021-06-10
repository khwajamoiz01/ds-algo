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

    static void printKDown(BTNode node, int k) {
        if (node == null)
            return;
        if (k == 0)
            System.out.print(node.data + " ");
        else {
            printKDown(node.left, k - 1);
            printKDown(node.right, k - 1);
        }
    }

    static int printKDistanceNode(BTNode root, BTNode node, int k) {
        if (root == null)
            return -1;
        if (root == node) {
            printKDown(node, k);
            return k - 1;
        }
        int l = printKDistanceNode(root.left, node, k);
        if (l == 0) {
            System.out.print(root.data + " ");
            return -1;
        } else if (l > 0) {
            printKDown(root.right, l - 1);
            return l - 1;
        }
        //returning above prevents iterating right child
        int r = printKDistanceNode(root.right, node, k);
        if (r == 0) {
            System.out.print(root.data + " ");
            return -1;
        } else if (r > 0) {
            printKDown(root.left, r - 1);
            return r - 1;
        }
        return -1;
    }
}