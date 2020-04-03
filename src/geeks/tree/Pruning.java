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

    boolean process(Node node, int sum, int k) {
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

    void print(Node root) {
        if (root == null)
            return;
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.removeFirst();
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(12);
        root.right.right.left = new Node(10);
        root.right.right.left.right = new Node(11);
        root.left.left.right.left = new Node(13);
        root.left.left.right.right = new Node(14);
        root.left.left.right.right.left = new Node(15);


        System.out.println("Tree before truncation\n");
        Pruning pruning = new Pruning();
        pruning.print(root);

        pruning.process(root, 0, k);

        System.out.println("\n\nTree after truncation\n");
        pruning.print(root);
    }

}