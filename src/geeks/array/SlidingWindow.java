/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: SlidingWindow.java, v 0.1 2019-12-08 12:43 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
public class SlidingWindow {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int ar[] = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                dequeApproach(n, k, ar);
            }
        }
    }

    //accepted on practice
    private static ArrayList<Integer> dequeApproach(int n, int k, int[] ar) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int i;
        //10 9 2 1 8 3
        for (i = 0; i < n && i < k; i++) {
            while (!dq.isEmpty() && ar[dq.getLast()] <= ar[i])
                dq.removeLast();
            dq.addLast(i);
        }
        for (; i < n; i++) {
            res.add(ar[dq.getFirst()]);
            while (!dq.isEmpty() && dq.getFirst() <= i - k)
                dq.removeFirst();
            while (!dq.isEmpty() && ar[dq.getLast()] <= ar[i])
                dq.removeLast();
            dq.addLast(i);
        }
        res.add(ar[dq.getFirst()]);
        return res;
    }

    //TLE on practice
    private static void treeMapApproach(int n, int k, int[] ar) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int i = 0;
        for (; i < k; i++) {
            map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
        }
        for (; i < n; i++) {
            System.out.print(map.firstEntry().getKey() + " ");
            Integer firstFreq = map.remove(ar[i - k]);
            if (firstFreq - 1 > 0) {
                map.put(ar[i - k], firstFreq - 1);
            }
            map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
        }
        System.out.println(map.firstEntry().getKey());
    }

    private static void maxHeapApproach(int[] ar, int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.remove(1);
        Queue<Integer> q = new ArrayDeque<>();
    }

}





















