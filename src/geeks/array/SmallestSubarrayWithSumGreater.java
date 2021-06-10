package geeks.array;

import java.util.Scanner;

//https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
public class SmallestSubarrayWithSumGreater {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                System.out.println(minSubArray(ar, n, x));
            }
        }
    }

    //1, 4, 45, 6, 0, 19
    //10, -2, 10 : 15
    //7, -2, 10 : 9
    static int minSubArray(int[] ar, int n, int x) {
        int i = 0, j = 0;
        int sum = 0;
        int minWin = Integer.MAX_VALUE;

        while (j < n) {
            sum += ar[j];
            //1. what if ar[i] > x? return 1

            //2. uncomment below for handling negative numbers, also do verify
            //while (i <= j && ar[i] < 0) {
            //    sum -= ar[i++];
            //}
            while (sum > x) {
                minWin = Math.min(minWin, j - i + 1);
                sum = sum - ar[i++];
            }
            j++;
        }
        return minWin;
    }
}
