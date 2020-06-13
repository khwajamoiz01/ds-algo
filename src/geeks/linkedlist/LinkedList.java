/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.linkedlist;

/**
 * @author khwaja.ali
 * @version $Id: LinkedList.java, v 0.1 2019-12-10 23:44 khwaja.ali Exp 3
 */
public class LinkedList {
    Node head;

    Node push(Node head, int data) {
        Node node = new Node(data);
        node.down = head;
        head = node;
        return head;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

}