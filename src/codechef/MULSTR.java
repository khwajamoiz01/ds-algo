/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package codechef;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: MULSTR.java, v 0.1 2020-02-03 21:34 khwaja.ali Exp 3
 */
//4416
//4*4=16
public class MULSTR {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.next();
            String output = find(s, s.length());
            System.out.println(output == null ? "Impossible" : output);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static String find(String s, int l) {
        if (s == null)
            return null;
        for (int i = 0; i < l - 2; i++) {
            for (int j = i + 1; j < l - 1; j++) {
                int a = Integer.parseInt(s.substring(0, i + 1));
                int b = Integer.parseInt(s.substring(i + 1, j + 1));
                int c = Integer.parseInt(s.substring(j + 1));
                if (a == b && a * b == c) {
                    return a + "*" + b + "=" + c;
                }
            }
        }
        return null;
    }
}