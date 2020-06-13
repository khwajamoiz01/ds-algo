/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.avl;

/**
 * @author khwaja.ali
 * @version $Id: Node.java, v 0.1 2020-04-23 12:17 am khwaja.ali Exp 3
 */
public class Node {
    int data;
    int height;
    int count;

    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        height = 1;
        count = 1;
    }
}