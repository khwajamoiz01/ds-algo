/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.btree;

/**
 * @author khwaja.ali
 * @version $Id: BTreeNode.java, v 0.1 2020-04-18 4:18 pm khwaja.ali Exp 3
 */
//untested
public class BTreeNode {
    int[] ar;
    int n;
    BTreeNode[] children;
    boolean isLeaf;

    BTreeNode(int degree, boolean isLeaf) {
        this.isLeaf = isLeaf;
        ar = new int[2 * degree - 1];
        children = new BTreeNode[2 * degree];
        this.n = 0;
    }

    void traverse() {
        int i;
        for (i = 0; i < n; i++) {
            if (!isLeaf)
                this.children[i].traverse();
            System.out.println(ar[i]);
        }
        if (!isLeaf)
            this.children[i].traverse();
    }

    BTreeNode search(int key) {
        int i = 0;
        while (i < n && key > ar[i]) {
            i++;
        }
        if (i < n && key == ar[i])
            return this;

        return isLeaf ? null : children[i].search(key);
    }
}