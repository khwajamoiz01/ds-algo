/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: Node.java, v 0.1 2019-12-10 21:14 khwaja.ali Exp 3
 */
public class BTNode {
    public BTNode left;
    public BTNode right;
    public int data;

    public BTNode(int data) {
        this.data = data;
    }

    BTNode(BTNode left, BTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}