/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Rearrange1.java, v 0.1 2020-03-13 12:25 am khwaja.ali Exp 3
 */
//https://practice.geeksforgeeks.org/problems/rearrange-a-string/0
//https://www.geeksforgeeks.org/rearrange-a-string-in-sorted-order-followed-by-the-integer-sum/
public class Rearrange1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char[] s = sc.next().toCharArray();
                Arrays.sort(s);
                int sum = 0;
                StringBuilder r = new StringBuilder();
                for (int i = 0; i < s.length; i++) {
                    int d = s[i];
                    if (d >= (int) 'A' && d <= (int) 'Z') {
                        r.append(s[i]);
                    } else {
                        sum += Integer.valueOf(s[i] + "");
                    }
                }
                r.append(sum);
                System.out.println(r);
            }
        }
    }

    void test() {
        Deque<Integer> deque = new ArrayDeque<>();
    }
}