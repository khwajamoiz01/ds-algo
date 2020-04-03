/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author khwaja.ali
 * @version $Id: Decode.java, v 0.1 2020-03-28 4:12 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/
public class Decode {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                i = 0;
                System.out.println(decodeSt("[" + s + "]"));
            }
        }
    }

    private static String decodeSt(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String sch = String.valueOf(s.charAt(i));
            if (!"]".equals(sch)) {
                st.push(sch);
            } else {
                String append = "";
                while (!"[".equals(st.peek())) {
                    String pch = st.pop();
                    append = pch + append;
                }
                st.pop();
                int multiply = 1;
                int num = 0;
                while (!st.isEmpty()) {
                    try {
                        int dig = Integer.parseInt(st.peek());
                        num = dig * multiply + num;
                        multiply *= 10;
                        st.pop();
                    } catch (Exception e) {
                        break;
                    }
                }
                num = num == 0 ? 1 : num;
                StringBuilder multiplyAppend = new StringBuilder();
                while (num-- > 0) {
                    multiplyAppend.append(append);
                }
                st.push(multiplyAppend.toString());
            }
        }
        return st.pop();
    }

    static int i = 0;

    private static String decode(String s) {
        StringBuilder sb = new StringBuilder();
        while (s.charAt(i) != ']') {
            if (s.charAt(i) == '[') {
            } else if (Character.isAlphabetic(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                int f = 0;
                while (s.charAt(i) != '[') {
                    f = f * 10 + Integer.parseInt(s.charAt(i) + "");
                    i++;
                }
                String next = decode(s);
                for (int k = 0; k < f; k++) {
                    sb.append(next);
                }
            }
            i++;
        }
        return sb.toString();
    }


}