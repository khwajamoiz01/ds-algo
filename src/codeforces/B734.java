/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package codeforces;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: B734.java, v 0.1 2019-10-13 13:56 khwaja.ali Exp 3
 */
public class B734 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k2 = sc.nextInt();
        int k3 = sc.nextInt();
        int k5 = sc.nextInt();
        int k6 = sc.nextInt();

        int min256 = Math.min(Math.min(k2, k5), k6);
        k2 = k2 - min256;
        k5 = k5 - min256;
        k6 = k6 - min256;

        int min32 = Math.min(k3, k2);
        k3 = k3 - min32;
        k2 = k2 - min32;
        System.out.println(256 * min256 + 32 * min32);
    }
}