package geeks.dp;

//https://www.geeksforgeeks.org/minimum-increment-or-decrement-operations-required-to-make-the-array-sorted/
//no practice option, solution (recursive eq only) seems correct
public class MinIncDecOpArSorted {
    public static void main(String[] args) {
        int[] tc1 = {1, 2, 1, 4, 3};
        System.out.println(process(tc1));

        int[] tc2 = {1, 2, 2, 100};
        System.out.println(process(tc2));
    }

    static int process(int[] ar) {
        if (ar == null || ar.length == 0)
            return 0;
        int min = getMin(ar);
        int max = getMax(ar);
        return processDp(ar, ar.length, min, max);
    }

    private static int processDp(int[] ar, int n, int min, int max) {
        if (n == 0)
            return 0;
        int minOps = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int ops = Math.abs(ar[n - 1] - i) + processDp(ar, n - 1, min, i);
            minOps = Math.min(minOps, ops);
        }
        return minOps;
    }


    private static int getMin(int[] ar) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            min = Math.min(min, ar[i]);
        }
        return min;
    }

    private static int getMax(int[] ar) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            max = Math.max(max, ar[i]);
        }
        return max;
    }
}
