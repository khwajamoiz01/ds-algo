
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package misc;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Test.java, v 0.1 2020-04-19 12:38 am khwaja.ali Exp 3
 */
public class FindTheExtraChar {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String a = sc.next();
            String b = sc.next();
            int xor = 0;
            for (int i = 0; i < a.length(); i++) {
                xor ^= a.charAt(i);
            }
            for (int i = 0; i < b.length(); i++) {
                xor ^= b.charAt(i);
            }
            System.out.println((char) xor);
        }
    }
}