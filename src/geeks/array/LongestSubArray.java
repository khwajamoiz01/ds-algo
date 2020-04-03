/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: LongestSubArray.java, v 0.1 2019-12-18 23:03 khwaja.ali Exp 3
 */
//https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k/0
public class LongestSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            int sum = 0;
            int max = 0;
            for (int i = 0; i < ar.length; i++) {
                sum += ar[i];

                if (!map.containsKey(sum))
                    map.put(sum, i + 1);

                if (map.containsKey(sum - k)) {
                    max = Math.max(max, i - map.get(sum - k) + 1);
                }
            }

            System.out.println(max);
        }
    }

    void lis(int ar[], int n, int k) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int sum = 0;
        int currentSize = 0;
        int max = 0;
        //{ 10, 5, 2, 7, 1, 9 }
        for (int i = 0; i < n; i++) {
            currentSize++;
            sum = sum + ar[i];
            deque.addLast(ar[i]);
            if (sum > k) {
                while (sum > k) {
                    sum = sum - deque.removeLast();
                    currentSize--;
                }
            } else if (sum == k) {
                max = Math.max(max, currentSize);
                sum = sum - deque.removeLast();
                currentSize--;
            }

        }

    }
}