/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Ternary.java, v 0.1 2020-03-19 2:33 pm khwaja.ali Exp 3
 */
public class Ternary {

    public static BTNode convertExp(String str, int i) {
        if (str == null || i >= str.length())
            return null;
        BTNode node = new BTNode(str.charAt(i));
        if (i + 1 < str.length() && str.charAt(i + 1) == '?') {
            node.left = convertExp(str, i + 2);
        }
        if (i + 1 < str.length() && str.charAt(i + 1) == ':') {
            node.right = convertExp(str, i + 2);
        }
        return node;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                BTNode node = convertExp(s, 0);
                print(node);
            }
        }
    }

    private static void print(BTNode root) {
        if (root == null)
            return;
        Deque<BTNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                BTNode node = queue.poll();
                System.out.print(node + " ");
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println();
        }
    }
}