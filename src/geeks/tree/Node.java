/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: Node.java, v 0.1 2019-12-10 21:14 khwaja.ali Exp 3
 */
public class Node {
    public Node left;
    public Node right;
    public int data;

    Node(int data) {
        this.data = data;
    }

    Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}