package geeks.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/special-keyboard/0
//https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/

/**
 * GFG - As the number of A’s become large, the effect of pressing Ctrl-V more than 3 times starts to become
 * insubstantial as compared to just pressing Ctrl-A, Ctrl-C and Ctrl-V again.
 * TODO - Verify above statement mathematically
 */
public class SpecialKeyboard {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                System.out.println(maxA(n, new HashMap<>()));
            }
        }
        int[] ar = new int[10];
        Arrays.sort(ar, 3, 5);
    }

    static int maxA(int n, Map<Integer, Integer> dp) {
        if (n <= 6)
            return n;
        if (!dp.containsKey(n)) {
            int res = Integer.MIN_VALUE;
            res = Math.max(res, maxA(n - 3, dp) * 2);
            res = Math.max(res, maxA(n - 4, dp) * 3);
            res = Math.max(res, maxA(n - 5, dp) * 4);
            dp.put(n, res);
        }
        return dp.get(n);
    }

}
