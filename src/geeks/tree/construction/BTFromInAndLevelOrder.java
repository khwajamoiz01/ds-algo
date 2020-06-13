/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree.construction;

import geeks.tree.BTNode;
import geeks.tree.BinaryTree;

/**
 * @author khwaja.ali
 * @version $Id: BTFromInAndLevelOrder.java, v 0.1 2020-05-03 5:07 pm khwaja.ali Exp 3
 */
public class BTFromInAndLevelOrder {

    public static BTNode build(int in[], int level[]) {
        return buildUtil(in, level, 0, in.length - 1);
    }

    private static BTNode buildUtil(int[] in, int[] level, int st, int end) {
        if (st > end)
            return null;

        boolean b = false;
        int ri = -1;
        for (int li = 0; li < level.length; li++) {
            for (int i = st; i <= end; i++) {
                if (level[li] == in[i]) {
                    ri = i;
                    b = true;
                    break;
                }
            }
            if (b) break;
        }

        BTNode root = new BTNode(in[ri]);
        root.left = buildUtil(in, level, st, ri - 1);
        root.right = buildUtil(in, level, ri + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {1, 0, 2};
        int[] level = {0, 1, 2};
        BTNode root = BTFromInAndLevelOrder.build(in, level);
        BinaryTree.inorderMorris(root);
    }
}