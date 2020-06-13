/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.linkedlist;

import geeks.tree.DllToBst;

/**
 * @author khwaja.ali
 * @version $Id: DoublyLinkedList.java, v 0.1 2020-05-02 11:54 pm khwaja.ali Exp 3
 */
public class DoublyLinkedList {
    public DLLNode root, tail;

    public void push(int data) {
        DLLNode dllNode = new DLLNode(data);
        if (tail == null) {
            root = dllNode;
            tail = dllNode;
            return;
        }
        tail.next = dllNode;
        tail.next.prev = tail;
        tail = tail.next;
    }

    public void print() {
        DLLNode cur = root;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}