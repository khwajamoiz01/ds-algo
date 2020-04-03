/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.heap;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: SmallestRange.java, v 0.1 2019-12-15 16:01 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/
public class SmallestRange {
    public static void main(String[] args) {
//        1 3 5 7 9
//        0 2 4 6 8
//        2 3 5 7 11
//
//        1 2 3 4
//        5 6 7 8
//        9 10 11 12
//        int[][] ar = {{1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ar[][] = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = sc.nextInt();
            }
        }
        findSmallestRange(ar, n, k);
    }

    static void findSmallestRange(int[][] ar, int n, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int rs = 0, re = 0;
        int minDiff = Integer.MAX_VALUE;

        Node[] nodes = new Node[k];
        for (int i = 0; i < k; i++) {
            Node node = new Node(ar[i][0], i, 0);
            nodes[i] = node;
            max = Math.max(max, node.ele);
        }
        MinHeap<Node> minHeap = new MinHeap<>(nodes);

        while (true) {
            Node node = minHeap.getMin();
            min = node.ele;
            if (max - min < minDiff) {
                rs = min;
                re = max;
                minDiff = max - min;
            }
            if (node.j + 1 < n) {
                Node next = new Node(ar[node.i][node.j + 1], node.i, node.j + 1);
                minHeap.replaceMin(next);
                max = Math.max(max, next.ele);
            } else
                break;

        }
        System.out.print(rs + " " + re);
    }

    static class Node implements Comparable<Node> {
        Integer ele;
        int i;
        int j;

        Node(int e, int i, int j) {
            this.ele = e;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node o) {
            return ele.compareTo(o.ele);
        }
    }
}