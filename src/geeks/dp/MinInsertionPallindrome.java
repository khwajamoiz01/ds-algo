package geeks.dp;

import java.util.Scanner;

//https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
public class MinInsertionPallindrome {
    public static void main (String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while(t-- > 0) {
                char[] ar = sc.next().toCharArray();
                int l = ar.length;
                System.out.println(formPall(ar, 0, l - 1, new Integer[l][l]));
            }
        }
    }
    static int formPall(char[] ar, int s, int e, Integer[][] dp) {
        if(s > e)
            return -1;

        if(s == e)
            return 0;

        if(s + 1 == e)
            return (ar[s] == ar[e]) ? 0 : 1;

        if(dp[s][e] == null) {
            if(ar[s] == ar[e])
                dp[s][e] = formPall(ar, s + 1, e - 1, dp);
            else
                dp[s][e] = Math.min(formPall(ar, s + 1, e, dp), formPall(ar, s, e - 1, dp)) + 1;
        }
        return dp[s][e];
    }
}
