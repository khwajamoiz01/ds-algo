/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.linkedlist;

/**
 * @author khwaja.ali
 * @version $Id: Node.java, v 0.1 2019-12-10 23:43 khwaja.ali Exp 3
 */
public class Node {
    int data;
    Node next;
    Node down;

    Node(int d) {
        data = d;
        next = null;
        down = null;
    }
}