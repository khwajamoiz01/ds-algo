/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author khwaja.ali
 * @version $Id: Pallindrome.java, v 0.1 2020-04-11 4:49 pm khwaja.ali Exp 3
 */
public class Palindrome {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"))) {
            int t = sc.nextInt();
            sc.nextLine();
            while (t-- > 0) {
                String s = sc.nextLine();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (isAN(s.charAt(i))) {
                        sb.append(s.charAt(i));
                    }
                }
                System.out.println(isPall(sb.toString().toLowerCase(), 0, sb.length() - 1) ? "YES" : "NO");
            }
        }
    }

    static boolean isPall(String s, int i, int j) {
        if (i > j)
            return false;
        if (i == j)
            return true;
        final boolean isSame = s.charAt(i) == s.charAt(j);
        if (i + 1 == j)
            return isSame;
        return isSame && isPall(s, i + 1, j - 1);
    }

    static boolean isAN(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        if (ch >= 'a' && ch <= 'z')
            return true;
        if (ch >= 'A' && ch <= 'Z')
            return true;
        return false;
    }
    void test() {
        Scanner sc;
    }

}