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
    Node head;  // head of list

    Node push(Node head, int data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node node = new Node(data);

        /* 3. Make next of new Node as head */
        node.down = head;

        /* 4. Move the head to point to new Node */
        head = node;

        /*5. return to link it back */
        return head;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

}