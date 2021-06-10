package geeks.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
//https://practice.geeksforgeeks.org/problems/valid-substring0624/1
public class LongestBalancedParenthesis {

    static int findMaxLen(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty())//might not be required
                    st.pop(); //either it is -1 or '('
                if (!st.isEmpty()) // this means above pop returned -1 or invalid bracket from else block
                    res = Math.max(res, i - st.peek());
                else
                    st.push(i); // for subsequent i - st.peek()
            }
        }
        return res;
    }

}
