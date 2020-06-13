/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author khwaja.ali
 * @version $Id: Paranthesis.java, v 0.1 2020-04-12 8:21 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
public class Parentheses {

    public static void main(String[] args) {
        char ch = '9';
        int ich = ch;
        System.out.println(ich);
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char[] ar = sc.next().toCharArray();
                int n = ar.length;
                Stack<Integer> st = new Stack<>();
                st.push(-1);
                int maxLen = 0;
                for (int i = 0; i < n; i++) {
                    if (ar[i] == '(') {
                        st.push(i);
                    } else {
                        st.pop();
                        if (!st.isEmpty()) {
                            maxLen = Math.max(maxLen, i - st.peek());
                        } else {
                            st.push(i);
                        }
                    }
                }
                System.out.println(maxLen);
            }
        }
    }
}