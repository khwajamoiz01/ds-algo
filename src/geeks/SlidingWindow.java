/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

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
                for (int i = 0; i < n; i++)
                    ar[i] = sc.nextInt();

                Deque<Integer> q = new ArrayDeque<>();
                int i;
                for (i = 0; i < n && i < k; i++) {
                    while (!q.isEmpty() && ar[q.getLast()] <= ar[i])
                        q.removeLast();

                    q.addLast(i);
                }

                //0 1 2 3 4 5 6
                for (; i < n; i++) {
                    System.out.print(q.getFirst());

                    while (!q.isEmpty() && q.getFirst() <= i - k)
                        q.removeFirst();

                    while (!q.isEmpty() && ar[q.getLast()] <= ar[i])
                        q.removeLast();

                    q.addLast(i);
                }

                System.out.println(q.getFirst());
            }
        }

    }
}