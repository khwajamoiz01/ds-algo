/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.stack;

import geeks.tree.Node;

import java.util.Stack;

/**
 * @author khwaja.ali
 * @version $Id: TreeMirror.java, v 0.1 2020-01-13 00:12 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/iterative-method-check-two-trees-mirror/
public class TreeMirror {

    boolean areMirror(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        Node cur1 = a, cur2 = b;
        while (true) {
            while (cur1 != null) {
                st1.push(cur1);
                cur1 = cur1.left;
            }
            Node t1 = st1.pop();
            cur1 = t1.right;

            while (cur2 != null) {
                st2.push(cur2);
                cur2 = cur2.right;
            }
            Node t2 = st2.pop();
            cur2 = t2.left;

            if (t1.data != t2.data)
                return false;

            boolean c1 = st1.isEmpty() && cur1 == null;
            boolean c2 = st2.isEmpty() && cur2 == null;
            if (c1 && c2)
                return true;
            if (c1 || c2)
                return false;
        }
    }

}