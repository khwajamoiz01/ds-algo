/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

/**
 * @author khwaja.ali
 * @version $Id: DigitTwoOccurence.java, v 0.1 2020-01-05 12:39 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/number-of-occurrences-of-2-as-a-digit-in-numbers-from-0-to-n/
public class DigitTwoOccurence {

    public static void main(String[] args) {
        int number = 1523;//5214;
        int len = String.valueOf(number).length();
        int count = 0;
        for (int digit = 0; digit < len; digit++) {
            count += count2sinRangeAtDigit(number, digit);
        }

        System.out.println(count);
    }

    public static long count2sinRangeAtDigit(int number, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowerOf10;
        int roundup = roundDown + nextPowerOf10;

        int digit = (number / powerOf10) % 10;

        // if the digit in spot digit is
        if (digit < 2) {
            return roundDown / 10;
        }

        if (digit == 2) {
            return roundDown / 10 + right + 1;
        }
        return roundup / 10;
    }

}