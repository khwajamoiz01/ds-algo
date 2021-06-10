/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: MedianOfStream.java, v 0.1 2020-04-12 4:52 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
public class MedianOfStream {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
            int median = 0;
            for (int i = 0; i < n; i++) {
                if (ar[i] >= median) {
                    rightHeap.add(ar[i]);
                    if (rightHeap.size() - leftHeap.size() == 2) {
                        leftHeap.add(rightHeap.remove());
                    }
                } else {
                    leftHeap.add(ar[i]);
                    if (leftHeap.size() - rightHeap.size() == 2) {
                        rightHeap.add(leftHeap.remove());
                    }
                }
                if (leftHeap.size() > rightHeap.size()) {
                    median = leftHeap.peek();
                } else if (leftHeap.size() < rightHeap.size()) {
                    median = rightHeap.peek();
                } else {
                    median = (leftHeap.peek() + rightHeap.peek()) / 2;
                }
                System.out.println(median);
            }
        }
    }
}