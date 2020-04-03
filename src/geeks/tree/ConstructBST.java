/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author khwaja.ali
 * @version $Id: ConstructBST.java, v 0.1 2020-01-26 14:39 khwaja.ali Exp 3
 */
public class ConstructBST {
    int a, b;

    public static void main(String[] args) {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructBST that = (ConstructBST) o;
        return a == that.a &&
                b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}