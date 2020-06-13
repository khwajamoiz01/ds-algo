/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.btree;


/**
 * @author khwaja.ali
 * @version $Id: BTree.java, v 0.1 2020-04-18 4:17 pm khwaja.ali Exp 3
 */
public class BTree {
    public BTreeNode root;
    public int degree;

    BTree(int degree) {
        this.degree = degree;
    }
}