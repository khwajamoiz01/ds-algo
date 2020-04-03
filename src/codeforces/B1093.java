/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package codeforces;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: B1093.java, v 0.1 2019-10-13 16:12 khwaja.ali Exp 3
 */
public class B1093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            if (s.length() == 1) {
                System.out.println(-1);
            } else if (s.length() == 2) {
                if (s.charAt(0) == s.charAt(1))
                    System.out.println(-1);
                else
                    System.out.println(s);
            } else if (!isPall(s)) {
                System.out.println(s);
            } else {
                boolean possible = false;
                for (int j = 0; j < s.length() - 1; j++) {
                    if (s.charAt(j) != s.charAt(j + 1)) {
                        s = swap(s, j, j + 1);
                        possible = true;
                        break;
                    }
                }
                if (possible)
                    System.out.println(s);
                else
                    System.out.println(-1);
            }

        }

    }

    private static String swap(String s, int i, int j) {
        char[] ch = s.toCharArray();
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
        return new String(ch);
    }

    //abcd
    //0123
    private static boolean isPall(String s) {
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1))
                return false;
        }
        return true;
    }
}