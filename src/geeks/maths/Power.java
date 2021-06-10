package geeks.maths;
/*package whatever //do not write package name here */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Power {
    static int mod = 1000000007;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                long n = sc.nextLong();
                long r = reverse(n);
                Map<Integer, Integer> dp = new HashMap<>();
                System.out.println(power(n, r, dp));
            }
        }
    }


    //Not sure which question is this
    static long power(long n, long r, Map<Integer, Integer> dp) {
        if (r == 0)
            return 1;
        if (r == 1)
            return n % 1000000007;
        long temp = power(n, r / 2, dp) % mod;
        long p = (temp * temp) % mod;
        if (r % 2 == 1)
            p = (p * n) % mod;
        //see handling of negative powers
        return p;
    }

    static long reverse(long n) {
        long rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return rev;
    }

    //https://www.geeksforgeeks.org/write-an-iterative-olog-y-function-for-powx-y
    public static void powXYIterative (String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while(t-- > 0) {
                long x = sc.nextInt();
                long y = sc.nextInt();
                long res = 1;
                int mod = 1000000007;
                while(y > 0) {
                    if (y % 2 == 1)
                        res = (res * x) % mod;
                    y = y / 2;
                    x = (x * x) % mod;
                }
                System.out.println(res);
            }
        }
    }
}