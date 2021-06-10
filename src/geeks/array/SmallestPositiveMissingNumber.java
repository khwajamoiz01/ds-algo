package geeks.array;

import java.util.Scanner;

//https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
public class SmallestPositiveMissingNumber {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    ar[i] = ar[i] <= 0 ? Integer.MAX_VALUE : ar[i];
                }
                for (int i = 0; i < n; i++) {
                    int e = Math.abs(ar[i]);
                    if (e != Integer.MAX_VALUE && e - 1 < n) {
                        ar[e - 1] = ar[e - 1] > 0 ? -ar[e - 1] : ar[e - 1];
                    }
                }
                int i;
                for (i = 0; i < n; i++) {
                    if (ar[i] > 0)
                        break;
                }
                System.out.println(i + 1);
            }
        }
    }

    //geeks approach
    static int missingNumber(int ar[], int size) {
        int n = shift(ar, size);
        for (int i = 0; i < n; i++) {
            int index = Math.abs(ar[i]) - 1;
            if (index < n && ar[index] > 0)
                ar[index] *= -1;
        }
        int i;
        for (i = 0; i < n; i++) {
            if (ar[i] > 0)
                return i + 1;
        }
        return i + 1;
    }

    static int shift(int[] ar, int size) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (ar[i] > 0) {
                swap(ar, i, j++);
            }
        }
        return j;
    }

    static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
}

