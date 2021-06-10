package geeks.stack;

import java.util.Scanner;
import java.util.Stack;

//https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
public class InfixToPostfix {

    static int priority(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '^')
            return 3;
        return -1;
    }

    //accepted on practice, still compare with geeks
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                Stack<Character> st = new Stack<>();
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    if (Character.isLetterOrDigit(ch)) {
                        res.append(ch);
                    } else if (ch == '(') {
                        st.push(ch);
                    } else if (ch == ')') {
                        while (!st.isEmpty()) {
                            char p = st.pop();
                            if (p == '(')
                                break;
                            res.append(p);
                        }
                    } else {
                        while (!st.isEmpty()) {
                            char p = st.peek();
                            if (p == '(' || priority(ch) > priority(p))
                                break;
                            res.append(st.pop());
                        }
                        st.push(ch);
                    }
                }
                while (!st.isEmpty())
                    res.append(st.pop());
                System.out.println(res.toString());
            }
        }
    }
}
