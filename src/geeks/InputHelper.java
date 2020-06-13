/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: Input.java, v 0.1 2020-05-05 4:14 pm khwaja.ali Exp 3
 */
public class InputHelper {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            //when asked to take input t as no of test cases
            int t = sc.nextInt();
            //then question may ask to take input for each test case
            while (t-- > 0) {
                //now it can be to take some n as input
                int n = sc.nextInt();
                //may be u have take array of size n as input now
                int[] ar = new int[n];
                /**
                 * sc.nextLong();//for long
                 * sc.next();//for string
                 * sc.next().charAt(0);//for a char
                 */
                String result = performLogic(ar, n);
                System.out  .println(result);
            }
        }
    }

    private static String performLogic(int[] ar, int n) {
        String result = "";
        return result;
    }
}
