package geeks.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/expression-contains-redundant-bracket-not/
//no practice seems correctd
public class RedundantBracket {
    public static void main(String[] args) {
        System.out.println(isRedundant("((a+b))"));
        System.out.println(isRedundant("(a+(b)/c)"));
        System.out.println(isRedundant("(a+b*(c-d))"));
    }

    static boolean isRedundant(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (st.peek() != '(') {//no empty check while peek/pop, assuming valid input
                    st.pop();
                    count++;//or instead of checking count, can check if ch == operator then redundant = false, like in geeks
                }
                st.pop();//removes '('
                if (count < 3)
                    return true;
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
