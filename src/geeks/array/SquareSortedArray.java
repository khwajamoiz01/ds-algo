package geeks.array;

//https://leetcode.com/problems/squares-of-a-sorted-array/
//https://www.geeksforgeeks.org/sort-array-converting-elements-squares/
public class SquareSortedArray {
    public int[] sortedSquares(int[] ar) {
        int n = ar.length;
        int j = n;//if all negative
        for (int i = 0; i < n; i++) {
            if (ar[i] >= 0) {
                j = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            ar[i] = ar[i] * ar[i];
        }
        int i = j - 1;
        int[] res = new int[n];
        int k = 0;
        while (i >= 0 && j < n) {
            if (ar[i] <= ar[j]) {
                res[k++] = ar[i--];
            } else {
                res[k++] = ar[j++];
            }
        }
        while (i >= 0) {
            res[k++] = ar[i--];
        }
        while (j < n) {
            res[k++] = ar[j++];
        }
        return res;
    }
}
