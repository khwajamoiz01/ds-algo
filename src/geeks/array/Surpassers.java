/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: Surpassers.java, v 0.1 2020-03-28 8:56 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-surpasser-count-of-each-element-in-array/
public class Surpassers {
    //Supports duplicate number
    static class Key {
        int i, el;

        Key(int i, int el) {
            this.i = i;
            this.el = el;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Key key = (Key) o;
            return i == key.i && el == key.el;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, el);
        }
    }

    //2, 4, 1, 3, 5
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                Key[] kar = new Key[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                    kar[i] = new Key(i, ar[i]);
                }
                Map<Key, Integer> res = new HashMap<>();
                surpassers(kar, 0, n - 1, res);
                for (int i = 0; i < n; i++) {
                    System.out.print(res.getOrDefault(new Key(i, ar[i]), 0) + " ");
                }
                System.out.println();
            }
        }
    }

    static void mergeAndCount(Key[] ar, int l, int m, int r, Map<Key, Integer> res) {
        Key[] left = Arrays.copyOfRange(ar, l, m + 1);
        Key[] right = Arrays.copyOfRange(ar, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < m - l + 1 && j < r - (m + 1) + 1) {
            if (left[i].el < right[j].el) {
                res.put(left[i], res.getOrDefault(left[i], 0) + (right.length - j));
                ar[k++] = left[i++];
            } else {
                ar[k++] = right[j++];
            }
        }
        while (i < m - l + 1) {
            ar[k++] = left[i++];
        }
        while (j < r - (m + 1) + 1) {
            ar[k++] = right[j++];
        }
    }

    static void surpassers(Key[] ar, int i, int j, Map<Key, Integer> res) {
        if (i < j) {
            int m = (i + j) / 2;
            surpassers(ar, i, m, res);
            surpassers(ar, m + 1, j, res);
            mergeAndCount(ar, i, m, j, res);
        }
    }

    void test() {
    }
}