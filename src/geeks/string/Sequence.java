/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

/*package whatever //do not write package name here */

import java.util.Scanner;
import java.util.Stack;

//https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
public class Sequence {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char[] ar = sc.next().toCharArray();
                long s = System.currentTimeMillis();
                btc = 0;
                //complexity seems exponential 10^n but it is not
                backtracking(ar);
                //GFGMethod3(new String(ar));
                //System.out.println("Time: " + (System.currentTimeMillis() - s));
                System.out.println("count: " + btc);
            }
        }
    }

    static int m3c = 0;

    static void GFGMethod3(String seq) {
        String result = "";
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i <= seq.length(); i++) {
            stk.push(i + 1);
            if (i == seq.length() || seq.charAt(i) == 'I') {
                while (!stk.empty()) {
                    result += String.valueOf(stk.peek());
                    result += " ";
                    stk.pop();
                }
            }
        }

        System.out.println(result);
    }

    static int btc = 0;

    private static void backtracking(char[] ar) {
        boolean[] d = new boolean[10];
        int[] res = new int[ar.length + 1];
        minNo(ar, d, 0, res);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static boolean minNo(char[] ar, boolean[] d, int i, int[] res) {
        if (i == res.length)
            return true;
        btc++;
        for (int num = 1; num <= 9; num++) {
            if (isSafe(ar, d, i, res, num)) {
                res[i] = num;
                d[num] = true;
                if (minNo(ar, d, i + 1, res))
                    return true;
                res[i] = 0;
                d[num] = false;
            }
        }
        return false;
    }

    private static boolean isSafe(char[] ar, boolean[] d, int i, int[] res, int num) {
        if (d[num])
            return false;
        if (i == 0)
            return true;
        if (ar[i - 1] == 'D' && res[i - 1] > num)
            return true;
        if (ar[i - 1] == 'I' && res[i - 1] < num)
            return true;

        return false;
    }
}