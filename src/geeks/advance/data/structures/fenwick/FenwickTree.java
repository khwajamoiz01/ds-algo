/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.fenwick;

import java.util.Arrays;

/**
 * @author khwaja.ali
 * @version $Id: Fenwick.java, v 0.1 2020-04-25 1:20 pm khwaja.ali Exp 3
 * <p>
 * https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/#c217533
 * https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * https://www.youtube.com/watch?v=CWDQJGaN1gY
 * Tree represented in video is of sum while in geeks of update
 * <p>
 * Time complexity of building the tree is nlogn, update and getSum is logn
 */

//BinaryIndexTree
public class FenwickTree implements IFenwickTree {

    private int tree[];

    FenwickTree(int[] ar) {
        int n = ar.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, ar[i]);
        }
    }

    @Override
    public void update(int i, int value) {
        i = i + 1;
        while (i < tree.length) {
            tree[i] += value;
            int lastSetBit = i & (-i);
            i += lastSetBit;
        }
    }

    @Override
    public int getSum(int i) {
        int sum = 0;
        i = i + 1;
        while (i > 0) {
            sum += tree[i];
            int lastSetBit = i & (-i);
            i -= lastSetBit;
        }
        return sum;
    }

    @Override
    public int getSum(int from, int to) {
        return getSum(to) - getSum(from);
    }

    public static void main(String[] args) {
        int ar[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        FenwickTree fenwick = new FenwickTree(ar);
    }

}

interface IFenwickTree {

    void update(int i, int value);

    int getSum(int i);

    int getSum(int from, int to);
}