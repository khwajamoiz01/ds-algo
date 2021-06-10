package interview;

import java.util.Arrays;

public class IT4 {
    public static void main(String[] args) {
        IT4 it = new IT4();
        int[] ar = new int[200000];
        Arrays.fill(ar, 1000000000);
        System.out.println(it.solution(ar));
    }

    public int solution(int[] ar) {
        if (ar == null || ar.length == 0)
            return -1;
        int n = ar.length;
        int[] lds = getLongestDecreasingSequence(ar, n);
        int[] ldsReverse = getLongestDecreasingSequenceReverse(ar, n);

        int result = -1;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, lds[i] + ldsReverse[i] + 1);
        }
        return result;
    }

    private int[] getLongestDecreasingSequence(int[] ar, int n) {
        int[] lis = new int[n];
        for (int i = 1; i < n; i++) {
            if (ar[i] <= ar[i - 1]) {
                lis[i] = lis[i - 1] + 1;
            }
        }
        return lis;
    }

    private int[] getLongestDecreasingSequenceReverse(int[] ar, int n) {
        int[] lis = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (ar[i] <= ar[i + 1]) {
                lis[i] = lis[i + 1] + 1;
            }
        }
        return lis;
    }
}
