/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: LongestUniqChSubstring.java, v 0.1 2020-03-31 12:41 am khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
public class LongestUniqChSubstring {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char[] car = sc.next().toCharArray();
                int k = sc.nextInt();
                int[] freq = new int[26];
                int dis = 0;
                int maxLen = -1, len = 0;
                for (int i = 0; i < car.length; i++) {
                    len++;
                    int j = car[i] - 'a';
                    freq[j]++;
                    if (freq[j] == 1) {
                        dis++;
                    }
                    if (dis == k) {
                        maxLen = Math.max(maxLen, len);
                    }
                    while (dis > k) {
                        len--;
                        int pj = car[i - len] - 'a';
                        freq[pj]--;
                        if (freq[pj] == 0) {
                            dis--;
                        }
                    }
                }
                System.out.println(maxLen);
            }
        }
    }
}