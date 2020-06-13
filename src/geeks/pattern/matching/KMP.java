/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.pattern.matching;

import java.util.Arrays;

/**
 * @author khwaja.ali
 * @version $Id: KMP.java, v 0.1 2020-04-08 9:51 pm khwaja.ali Exp 3
 */
public class KMP {

    //For the pattern “AAACAAAAAC”,
    //lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]
    //For the pattern "AAACAAAA",
    //lps[] is [0, 1, 2, 0, 1, 2, 3, 3]
    //yuywyuwyujyuywyy IMP
    private static int[] buildLPS(String pat) {
        //System.out.println(Arrays.toString("yuywyuwyujyuywyy".toCharArray()));
        int m = pat.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar to search step.
                if (len != 0) {
                    len = lps[len - 1];
                    // Also, note that we do not increment i here
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }


    public static void search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int[] lps = buildLPS(pat);

        int i = 0, j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
                if (j == m) {
                    System.out.println("Patter found at " + (i - m));
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    //abcabc
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(LPS("yuywyuwyujyuywyy")));
        //String txt = "ABABCABAB";
        System.out.println(Arrays.toString(buildLPS("AAACAAAA")));
        String txt = "AABAACAADAABAABA";
        String pat = "AABA";
        search(pat, txt);
    }
}