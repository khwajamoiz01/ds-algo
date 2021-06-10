package geeks.array;

import java.util.Scanner;

//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class MaxDifference {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int min = ar[0];
                int maxDiff = -1;//Integer.MAX_VALUE;
                for (int i = 1; i < n; i++) {
                    if (ar[i] > min) {
                        maxDiff = Math.max(maxDiff, ar[i] - min);
                    } else {
                        min = ar[i];
                    }
                }
                System.out.println(maxDiff);
            }
        }
    }

}
