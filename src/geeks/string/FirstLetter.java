/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: FirstLetter.java, v 0.1 2020-01-12 12:32 khwaja.ali Exp 3
 */
public class FirstLetter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        solution2(input);
    }

    //Solution 1 - similar to yours
    private static void solution1(String input) {
        //Important
        input = input + " ";
        String output = "";
        String word = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ')
                word = word + input.charAt(i);
            else {
                output = output + word.charAt(0);
                word = "";
            }
        }
        System.out.println(output);
    }

    //Solution 2 - better one
    private static void solution2(String input) {
        //Important
        input = " " + input;
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                output = output + input.charAt(i + 1);
            }
        }
        System.out.println(output);
    }
}