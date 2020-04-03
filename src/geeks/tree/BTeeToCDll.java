/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: BTeeToCDll.java, v 0.1 2020-01-08 00:54 khwaja.ali Exp 3
 */
/*
Sol1 - https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
Sol2 - below
 */
public class BTeeToCDll {

    Node prev = null;
    Node head = null;

    Node bTreeToClist(Node root) {
        convert(root);
        if (head != null) {
            head.left = prev;
            prev.right = head;
        }
        return head;
    }

    void convert(Node root) {
        if (root == null) {
            return;
        }
        bTreeToClist(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bTreeToClist(root.right);
    }
}