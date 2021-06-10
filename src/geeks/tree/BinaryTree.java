/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: Morris.java, v 0.1 2020-05-02 8:20 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
public class BinaryTree {

    BTNode root;

    BinaryTree(BTNode root) {
        this.root = root;
    }

    public static void inorderStack(BTNode root) {
        if (root == null)
            return;
        Deque<BTNode> st = new ArrayDeque<>();
        BTNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void inorderMorris(BTNode root) {
        if (root == null)
            return;
        BTNode cur = root, pre;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur + " ");
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    System.out.print(cur + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    //https://www.geeksforgeeks.org/iterative-preorder-traversal/
    //also see space optimized sol
    public static void preorderIterative(BTNode root) {
        if (root == null)
            return;
        Stack<BTNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            BTNode cur = st.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null) {
                st.push(cur.right);
            }
            if (cur.left != null) {
                st.push(cur.left);
            }
        }
        System.out.println();
    }

    //https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/1
    //practice accepted, similar to geeks space optimized iterative preorder
    public static List<Integer> preorderIterativeSpaceOptimized(BTNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<BTNode> st = new Stack<>();
        BTNode cur = root;
        while (true) {
            res.add(cur.data);
            if (cur.right != null)
                st.push(cur.right);
            if (cur.left != null)
                cur = cur.left;
            else if (!st.isEmpty())
                cur = st.pop();
            else break;
        }
        return res;
    }

    public static void postorderIterative(BTNode root) {
        if (root == null)
            return;
        Stack<BTNode> st = new Stack<>();
        Stack<BTNode> res = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            BTNode cur = st.pop();
            res.push(cur);
            if (cur.left != null)
                st.push(cur.left);
            if (cur.right != null)
                st.push(cur.right);
        }
        while (!res.isEmpty()) {
            System.out.print(res.pop() + " ");
        }
        System.out.println();
    }

    public static void levelOrder(BTNode root) {
        if (root == null)
            return;
        Deque<BTNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int h = queue.size();
            while (h-- > 0) {
                BTNode node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        /* Constructed binary tree is
               1
             /   \
            2      3
          /   \
         4     5
        */
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        BinaryTree.inorderStack(root);
        BinaryTree.inorderMorris(root);
    }

}