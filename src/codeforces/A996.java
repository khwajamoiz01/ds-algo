/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package codeforces;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: A996.java, v 0.1 2019-10-13 13:22 khwaja.ali Exp 3
 */
public class A996 {

    public static void main(String[] args) {
        int d[] = {100, 20, 10, 5, 1};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int o = 0;
        for (int i = 0; n != 0 && i < d.length; i++) {
            if (n < d[i]) {
                continue;
            }
            o = o + n/d[i];
            n = n % d[i];
        }
        System.out.println(o);
    }
}