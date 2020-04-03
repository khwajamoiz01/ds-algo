/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: ARTBALAN.java, v 0.1 2019-11-30 18:18 khwaja.ali Exp 3
 */
public class ARTBALAN {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                int[] fr = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    fr[ch - 65]++;
                }
                Arrays.sort(fr);
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < fr.length && fr[i] > 0; i++) {
                    min = Math.min(min, fr[i]);
                    max = Math.min(max, fr[i]);
                }

                System.out.println(Arrays.toString(fr));
            }
        }
    }
}