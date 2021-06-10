/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import geeks.linkedlist.DLLNode;
import geeks.linkedlist.DoublyLinkedList;

/**
 * @author khwaja.ali
 * @version $Id: DllToBst.java, v 0.1 2020-05-02 10:55 pm khwaja.ali Exp 3
 */
public class DllToBst {

    private static class Pointer {
        DLLNode cur;

        Pointer(DLLNode cur) {
            this.cur = cur;
        }
    }

    public BinaryTree convert(DoublyLinkedList dll) {
        int len = length(dll.root);
        Pointer p = new Pointer(dll.root);
        BTNode node = convertUtil(p, 0, len - 1);
        return new BinaryTree(node);
    }

    // 1 2 3 <- 4 -> 5 6 7
    private BTNode convertUtil(Pointer pointer, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        BTNode left = convertUtil(pointer, start, mid - 1);
        BTNode root = new BTNode(pointer.cur.data);
        root.left = left;
        pointer.cur = pointer.cur.next;
        BTNode right = convertUtil(pointer, mid + 1, end);
        root.right = right;
        return root;
    }

    private int length(DLLNode dllNode) {
        int l = 0;
        DLLNode cur = dllNode;
        while (cur != null) {
            l++;
            cur = cur.next;
        }
        return l;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.push(1);
        dll.push(2);
        dll.push(3);
        dll.push(4);
        dll.push(5);
        dll.push(6);
        dll.push(7);
        dll.print();
        DllToBst dllToBst = new DllToBst();
        BinaryTree btree = dllToBst.convert(dll);
        BinaryTree.levelOrder(btree.root);
    }
}