/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.tree;

import java.util.Stack;

/**
 * @author khwaja.ali
 * @version $Id: StackMinOperation.java, v 0.1 2019-12-08 20:25 khwaja.ali Exp 3
 */
public class ZigZag {

    void traverse(BTNode root) {
        if (root == null)
            return;

        Stack<BTNode> odd = new Stack<>();
        Stack<BTNode> even = new Stack<>();

        odd.push(root);

        while (!odd.isEmpty() || !even.isEmpty()) {
            while (!even.isEmpty()) {
                BTNode node = even.pop();
                System.out.println(node);
                if (node.left != null)
                    odd.push(node.left);
                if (node.right != null)
                    odd.push(node.right);
            }
            while (!odd.isEmpty()) {
                BTNode node = odd.pop();
                System.out.println(node);
                if (node.right != null)
                    even.push(node.right);
                if (node.left != null)
                    even.push(node.left);
            }
        }
    }
}