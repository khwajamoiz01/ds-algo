package geeks.divide.and.conquer;

import java.util.Scanner;

//https://www.geeksforgeeks.org/counting-inversions/
public class CountInversions {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                System.out.println(inversions(ar, 0, n - 1));
            }
        }
    }

    static long inversions(int[] ar, int i, int j) {
        if (i >= j)
            return 0;
        int mid = (i + j) / 2;
        long left = inversions(ar, i, mid);
        long right = inversions(ar, mid + 1, j);
        long mc = mergeAndCount(ar, i, mid, j);
        return left + mc + right;
    }

    static long mergeAndCount(int[] ar, int i, int mid, int j) {
        int[] merged = new int[j - i + 1];
        int k = 0;
        int ki = i;
        int kj = mid + 1;
        long count = 0;
        while (ki <= mid && kj <= j) {
            if (ar[ki] <= ar[kj])
                merged[k++] = ar[ki++];
            else {
                count += (mid - ki + 1);
                merged[k++] = ar[kj++];
            }
        }
        while (ki <= mid) {
            merged[k++] = ar[ki++];
        }
        while (kj <= j) {
            merged[k++] = ar[kj++];
        }
        for (k = 0; k < j - i + 1; k++) {
            ar[i + k] = merged[k];
        }
        return count;
    }
}
