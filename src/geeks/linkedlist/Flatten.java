/**
 * Alipay.com Inc.
 * Copynext (c) 2004-2019 All nexts Reserved.
 */
package geeks.linkedlist;

import java.util.ArrayList;

/**
 * @author khwaja.ali
 * @version $Id: Flatten.java, v 0.1 2019-12-10 23:42 khwaja.ali Exp 3
 */
//some difference with java geeks solution, but looks fine
//https://www.geeksforgeeks.org/flattening-a-linked-list/
//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1 [ACCEPTED]
public class Flatten {

    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;
        Node rootNext = flatten(root.next);
        root.next = null;
        return merge(root, rootNext);
    }

    Node merge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.data < b.data) {
            a.down = merge(a.down, b);
            return a;
        } else {
            b.down = merge(a, b.down);
            return b;
        }
    }

    public static void main(String[] args) {
        LinkedList L = new LinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.next = L.push(L.head.next, 20);
        L.head.next = L.push(L.head.next, 10);

        L.head.next.next = L.push(L.head.next.next, 50);
        L.head.next.next = L.push(L.head.next.next, 22);
        L.head.next.next = L.push(L.head.next.next, 19);

        L.head.next.next.next = L.push(L.head.next.next.next, 45);
        L.head.next.next.next = L.push(L.head.next.next.next, 40);
        L.head.next.next.next = L.push(L.head.next.next.next, 35);
        L.head.next.next.next = L.push(L.head.next.next.next, 20);

        // flatten the list
        flattenIterative(L.head);

        L.print();
    }

    static void flattenIterative(Node root) {
        if (root == null || root.next == null)
            return;
        Node nl = new Node(0);
        Node tmp = root.next.next;
        Node a = root, b = root.next;
        Node c = nl;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                c.down = a;
                a = a.down;
                c = c.down;
            } else {
                c.down = b;
                b = b.down;
                c = c.down;
            }
        }
        if (a != null)
            c.down = a;
        if (b != null)
            c.down = b;

        nl.down.next = tmp;
        flattenIterative(nl.down);
    }
}