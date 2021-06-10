package geeks.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/merge-k-sorted-arrays/
public class MergeKSortedArray {

    static class Pointer implements Comparable<Pointer> {
        final int data;
        final int i;
        final int j;

        public Pointer(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Pointer p) {
            return this.data - p.data;
        }
    }

    public static List<Integer> mergeKArrays(int[][] ar, int k) {
        PriorityQueue<Pointer> heap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            heap.add(new Pointer(ar[i][0], i, 0));
        }
        while (!heap.isEmpty()) {
            Pointer pointer = heap.poll();
            result.add(pointer.data);
            if (pointer.j < k - 1) {
                heap.add(new Pointer(ar[pointer.i][pointer.j + 1], pointer.i, pointer.j + 1));
            }
        }
        return result;
    }

}
