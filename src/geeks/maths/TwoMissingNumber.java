package geeks.maths;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-two-missing-numbers-set-2-xor-based-solution/
//same as MissingAndRepeating
//no practice option for this
public class TwoMissingNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(process(new int[]{1, 3, 5, 6}, 6)));
        System.out.println(Arrays.toString(process(new int[]{3, 4, 5, 6}, 6)));
        System.out.println(Arrays.toString(process(new int[]{1, 2, 3, 4}, 6)));

    }

    //{1,    3,    5, 6}
    //{1, 2, 3, 4, 5, 6}
    static int[] process(int[] ar, int n) {
        int xor = 0;
        for (int i = 0; i < ar.length; i++) {
            xor ^= ar[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int rsb = xor & -xor;
        int a = 0, b = 0;
        for (int i = 0; i < ar.length; i++) {
            if ((rsb & ar[i]) == 0)
                a ^= ar[i];
            else
                b ^= ar[i];
        }
        for (int i = 1; i <= n; i++) {
            if ((rsb & i) == 0)
                a ^= i;
            else
                b ^= i;
        }

        return new int[]{a, b};
    }
}
