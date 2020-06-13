/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author khwaja.ali
 * @version $Id: Pruning.java, v 0.1 2019-12-11 23:09 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
public class Pruning {

    boolean process(BTNode node, int sum, int k) {
        if (node == null)
            return false;
        sum += node.data;
        if (sum >= k)
            return true;
        boolean left = process(node.left, sum, k);
        boolean right = process(node.right, sum, k);
        node.left = !left ? null : node.left;
        node.right = !right ? null : node.right;
        return left || right;
    }

    void print(BTNode root) {
        if (root == null)
            return;
        Deque<BTNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                BTNode node = queue.removeFirst();
                System.out.print(node + " ");
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int k = 20;
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        root.left.left.left = new BTNode(8);
        root.left.left.right = new BTNode(9);
        root.left.right.left = new BTNode(12);
        root.right.right.left = new BTNode(10);
        root.right.right.left.right = new BTNode(11);
        root.left.left.right.left = new BTNode(13);
        root.left.left.right.right = new BTNode(14);
        root.left.left.right.right.left = new BTNode(15);


        System.out.println("Tree before truncation\n");
        Pruning pruning = new Pruning();
        pruning.print(root);

        pruning.process(root, 0, k);

        System.out.println("\n\nTree after truncation\n");
        pruning.print(root);
    }

}