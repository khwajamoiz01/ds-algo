/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author khwaja.ali
 * @version $Id: Merge.java, v 0.1 2020-03-22 10:45 pm khwaja.ali Exp 3
 */
//https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1
//https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
public class Merge {


    public List<Integer> merge(Node a, Node b) {
        List<Integer> res = new ArrayList<>();
        if (a == null) {
            inorder(b, res);
        }
        if (b == null) {
            inorder(a, res);
        } else {
            boolean f1 = true, f2 = true;
            Stack<Node> st1 = new Stack<>();
            Node cur1 = a;
            Stack<Node> st2 = new Stack<>();
            Node cur2 = b;

            while (true) {
                if (f1) {
                    while (cur1 != null) {
                        st1.push(cur1);
                        cur1 = cur1.left;
                    }
                    cur1 = st1.pop();
                }
                if (f2) {
                    while (cur2 != null) {
                        st2.push(cur2);
                        cur2 = cur2.left;
                    }
                    cur2 = st2.pop();
                }
                if (cur1.data < cur2.data) {
                    res.add(cur1.data);
                    f1 = true;
                    f2 = false;
                    cur1 = cur1.right;
                } else {
                    res.add(cur2.data);
                    f1 = false;
                    f2 = true;
                    cur2 = cur2.right;
                }
                if (cur1 == null && st1.isEmpty()) {
                    res.add(cur2.data);
                    cur2 = cur2.right;
                    break;
                }
                if (cur2 == null && st2.isEmpty()) {
                    res.add(cur1.data);
                    cur1 = cur1.right;
                    break;
                }

            }
            while (cur1 != null || !st1.isEmpty()) {
                while (cur1 != null) {
                    st1.push(cur1);
                    cur1 = cur1.left;
                }
                cur1 = st1.pop();
                res.add(cur1.data);
                cur1 = cur1.right;
            }
            while (cur2 != null || !st2.isEmpty()) {
                while (cur2 != null) {
                    st2.push(cur2);
                    cur2 = cur2.left;
                }
                cur2 = st2.pop();
                res.add(cur2.data);
                cur2 = cur2.right;
            }
        }
        return res;
    }

    void inorder(Node n, List<Integer> res) {
        if (n == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        Node cur = n;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.data);
            cur = cur.right;
        }
    }

}