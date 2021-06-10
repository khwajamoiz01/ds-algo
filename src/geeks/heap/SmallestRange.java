/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.heap;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: SmallestRange.java, v 0.1 2019-12-15 16:01 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/
public class SmallestRange {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
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
        }
    }

    static class Node {
        int val;
        int i;
        int j;

        Node(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

    static void findSmallestRange(int[][] ar, int n, int k) {
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.val != b.val ? a.val - b.val : a.i - b.i;
            }
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            q.offer(new Node(ar[i][0], i, 0));
            max = Math.max(max, ar[i][0]);
        }
        int minRange = Integer.MAX_VALUE;
        int s = -1;
        while (true) {
            Node node = q.poll();
            if (max - node.val < minRange) {
                minRange = max - node.val;
                s = node.val;
            }
            if (node.j == n - 1)
                break;
            q.offer(new Node(ar[node.i][node.j + 1], node.i, node.j + 1));
            max = Math.max(max, ar[node.i][node.j + 1]);
        }
        System.out.println(s + " " + (s + minRange));
    }

    static class Pointer implements Comparable<Pointer> {
        int data, i, j;

        Pointer(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Pointer p) {
            return this.data - p.data;
        }
    }

    //practice accepted, compare with above
    static int[] findSmallestRange2(int[][] ar, int n, int k) {
        PriorityQueue<Pointer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            pq.offer(new Pointer(ar[i][0], i, 1));
            max = Math.max(max, ar[i][0]);
        }
        int minDiff = max - pq.peek().data;
        int[] res = {pq.peek().data, max};
        while (pq.peek().j < n) {
            Pointer p = pq.poll();
            pq.offer(new Pointer(ar[p.i][p.j], p.i, p.j + 1));
            max = Math.max(max, ar[p.i][p.j]);
            if (max - pq.peek().data < minDiff) {
                minDiff = max - pq.peek().data;
                res[0] = pq.peek().data;
                res[1] = max;
            }
        }
        return res;
    }
}