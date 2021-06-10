package geeks.dp;


import java.util.Scanner;

public class LPS {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                System.out.println(method2(s));
            }
        }
    }

    /**
     * https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
     * Time complexity - O(n2)
     * Auxiliary space - O(1)
     *
     * @param s
     * @return
     */
    static String method2(String s) {
        int maxLen = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            //even case
            int low = i - 1;
            int high = i;
            while (isSafe(s, low, high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
            //odd
            low = i - 1;
            high = i + 1;
            while (isSafe(s, low, high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static boolean isSafe(String s, int low, int high) {
        return low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high);
    }

    /**
     * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
     * Time complexity - O(n2)
     * Auxiliary space - O(n2)
     *
     * @param s
     * @return
     */
    static String method1(String s) {
        int L = s.length();
        boolean[][] dp = new boolean[L][L];
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < L; i++) {
            dp[i][i] = true;
        }
        for (int i = L - 2; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        for (int len = 3; len <= L; len++) {
            for (int i = 0; i < L - (len - 1); i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
