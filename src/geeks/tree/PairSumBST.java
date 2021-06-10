/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.Stack;

/**
 * @author khwaja.ali
 * @version $Id: PairSumBST.java, v 0.1 2020-01-11 23:49 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
//https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
public class PairSumBST {

    public static boolean findPair(BTNode root, int target) {

        Stack<BTNode> st1 = new Stack<>();
        Stack<BTNode> st2 = new Stack<>();

        BTNode cur1 = root;
        BTNode cur2 = root;

        boolean f1 = true, f2 = true;
        BTNode a = null, b = null;
        while (true) {
            if (f1) {
                while (cur1 != null) {
                    st1.push(cur1);
                    cur1 = cur1.left;
                }
                a = st1.pop();
                cur1 = a.right;
            }
            if (f2) {
                while (cur2 != null) {
                    st2.push(cur2);
                    cur2 = cur2.right;
                }
                b = st2.pop();
                cur2 = b.left;
            }
            if (a == b)
                break;

            if ((a.data + b.data) == target) {
                return true;
            }
            if ((a.data + b.data) < target) {
                f1 = true;
                f2 = false;
            }
            if ((a.data + b.data) > target) {
                f1 = false;
                f2 = true;
            }
        }
        return false;
    }
}