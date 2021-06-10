package geeks.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
public class KthSmallestElement {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int k = sc.nextInt();
                System.out.println(usingMaxHeap(ar, n, k));
            }
        }
    }

    /**
     * Time complexity - klogk + nlogk = nlogk
     * @param ar
     * @param n
     * @param k
     * @return
     */
    private static int usingMaxHeap(int[] ar, int n, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int i;
        //This will take Oklogk instead of only Ok
        //https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
        for (i = 0; i < k; i++) {
            heap.offer(ar[i]);
        }
        //if replaceMin is used {@link MinHeap} would take only logn but here poll and offer both takes OlogN
        for (; i < n; i++) {
            if (ar[i] < heap.peek()) {
                heap.poll();
                heap.offer(ar[i]);
            }
        }
        return heap.peek();
    }
}
