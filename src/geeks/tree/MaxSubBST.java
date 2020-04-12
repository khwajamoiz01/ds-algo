/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: MaxSubBST.java, v 0.1 2020-04-10 9:54 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/
//verify with geeks
public class MaxSubBST {

    static class Result {
        boolean isBst;
        int count;
        Integer min, max;

        Result(boolean isBst, int count, Integer min, Integer max) {
            this.isBst = isBst;
            this.count = count;
            this.min = min;
            this.max = max;
        }
    }

    static int largestBstCount = 0;

    static int largestBst(Node root) {
        largestBstCount = 0;
        largestBstUtil(root);
        return largestBstCount;
    }

    static Result largestBstUtil(Node root) {
        if (root == null) {
            return new Result(true, 0, null, null);
        }
        Result l = largestBstUtil(root.left);
        Result r = largestBstUtil(root.right);
        int count = l.count + r.count + 1;
        boolean isBst = isBst(root, l, r);
        if (isBst) {
            largestBstCount = Math.max(largestBstCount, count);
        }
        int min = (l.min != null) ? l.min : root.data;
        int max = (r.max != null) ? r.max : root.data;
        return new Result(isBst, count, min, max);
    }

    private static boolean isBst(Node root, Result l, Result r) {
        boolean isBst = l.isBst && r.isBst;
        isBst = (l.max != null) ? isBst && (root.data > l.max) : isBst;
        isBst = (r.min != null) ? isBst && (root.data < r.min) : isBst;
        return isBst;
    }

}
