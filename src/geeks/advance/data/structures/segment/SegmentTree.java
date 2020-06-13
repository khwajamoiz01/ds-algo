/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.segment;

/**
 * @author khwaja.ali
 * @version $Id: SegmentTree.java, v 0.1 2020-04-25 7:25 pm khwaja.ali Exp 3
 */
public class SegmentTree implements ISegmentTree {

    private int[] tree;
    private int n;

    SegmentTree(int[] ar) {
        this.n = ar.length;
        double log = Math.log(n) / Math.log(2);
        int height = (int) Math.ceil(log);
        int size = 2 * (int) Math.pow(2, height) - 1;
        this.tree = new int[2 * size - 1];
        construct(ar, 0, ar.length - 1, 0);
    }

    private int construct(int[] ar, int s, int e, int i) {
        if (s == e) {
            tree[i] = ar[s];
            return tree[i];
        }
        int mid = (s + e) / 2;
        tree[i] = construct(ar, s, mid, 2 * i + 1) + construct(ar, mid + 1, e, 2 * i + 2);
        return tree[i];
    }

    @Override
    public int getSum(int qe) {
        return getSum(0, qe);
    }

    @Override
    public int getSum(int qs, int qe) {
        return getSumUtil(qs, qe, 0, n - 1, 0);
    }

    private int getSumUtil(int qs, int qe, int ss, int se, int si) {
        if (qe < ss || qs > se)
            return 0;
        if (qs <= ss && qe >= se) {
            return tree[si];
        }
        int mid = (ss + se) / 2;
        return getSumUtil(qs, qe, ss, mid, 2 * si + 1) + getSumUtil(qs, qe, mid + 1, se, 2 * si + 2);
    }

    @Override
    public void update(int i, int diff) {
        //value should be difference and not the actual value
        updateUtil(i, diff, 0, n - 1, 0);
    }

    private void updateUtil(int i, int diff, int ss, int se, int si) {
        if (i < ss || i > se)
            return;
        tree[si] += diff;
        if (ss == se)
            return;
        int mid = (ss + se) / 2;
        updateUtil(i, diff, ss, mid, 2 * si + 1);
        updateUtil(i, diff, mid + 1, se, 2 * si + 2);
    }
}

interface ISegmentTree {
    void update(int i, int value);

    int getSum(int i);

    int getSum(int from, int to);
}
