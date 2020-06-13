/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package codechef;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: HS08TEST.java, v 0.1 2020-04-14 1:49 pm khwaja.ali Exp 3
 */
public class HS08TEST {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double n = sc.nextDouble();
            double x = sc.nextDouble();
            double res = (n % 5 == 0 && x - n - 0.5 > 0) ? x - n - 0.5 : x;
            System.out.println(String.format("%.2f", res));
        }
    }
}