/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: NumberOfTurns.java, v 0.1 2020-01-01 14:10 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
public class NumberOfTurns {
    static Node lca(Node root, int a, int b) {
        if (root == null)
            return null;
        if (root.data == a || root.data == b)
            return root;
        Node l = lca(root.left, a, b);
        Node r = lca(root.right, a, b);
        if (l == null)
            return r;
        if (r == null)
            return l;
        return root;
    }

    static int NumberOfTurn(Node root, int first, int second) {
        Node lca = lca(root, first, second);
        if (lca.data == first) {
            return turns(lca, second, 0);
        }
        if (lca.data == second) {
            return turns(lca, first, 0);
        }
        int a = turns(lca, first, 0);
        int b = turns(lca, second, 0);
        return a + b + 1;
    }

    static int turns(Node a, int b, int d) {
        if (a == null)
            return -1;
        if (a.data == b)
            return 0;
        int l = turns(a.left, b, -1);
        int r = turns(a.right, b, +1);
        if (l >= 0)
            return l + ((d == 1) ? 1 : 0);
        if (r >= 0)
            return r + ((d == -1) ? 1 : 0);
        return -1;
    }
}