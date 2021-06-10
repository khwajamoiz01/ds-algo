/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: SmallestWindow.java, v 0.1 2020-03-30 10:56 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
public class SmallestWindow {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int tc = sc.nextInt();
            while (tc-- > 0) {
                char[] s = sc.next().toCharArray();
                char[] t = sc.next().toCharArray();
                if (s.length < t.length) {
                    System.out.println(-1);
                    continue;
                }
                int count = 0;
                int[] sf = new int[26];
                int[] tf = new int[26];
                for (int i = 0; i < t.length; i++) {
                    tf[t[i] - 'a']++;
                }
                int sw = Integer.MAX_VALUE;
                int swj = -1;
                int i = 0, j = 0;
                while (i < s.length) {
                    int index = s[i] - 'a';
                    sf[index]++;
                    if (tf[index] > 0 && sf[index] <= tf[index]) {
                        count++;
                    }
                    while (j <= i && count == t.length) {
                        if (i - j + 1 < sw) {
                            sw = i - j + 1;
                            swj = j;
                        }
                        int jIndex = s[j] - 'a';
                        if (tf[jIndex] > 0 && sf[jIndex] <= tf[jIndex]) {
                            count--;
                        }
                        sf[jIndex]--;
                        j++;
                    }
                    i++;
                }
                System.out.println(sw == Integer.MAX_VALUE ? -1 : new String(s, swj, sw));
            }
        }
    }
}