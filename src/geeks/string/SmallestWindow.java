/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.string;

/**
 * @author khwaja.ali
 * @version $Id: SmallestWindow.java, v 0.1 2020-03-30 10:56 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
public class SmallestWindow {


    public static String smallestWindow(String s, String t) {
        char[] str = s.toCharArray();
        char[] pat = t.toCharArray();
        if (str.length < pat.length)
            return "-1";
        int[] pfreq = new int[26];
        for (int i = 0; i < pat.length; i++) {
            pfreq[pat[i] - 'a']++;
        }
        //abcdbe db
        //timetopractice toc
        int[] window = new int[26];
        int count = 0, len = 0, minLen = Integer.MAX_VALUE, minLenIndex = -1;
        for (int i = 0; i < str.length; i++) {
            len++;
            int j = str[i] - 'a';
            window[j]++;
            if (pfreq[j] > 0 && window[j] <= pfreq[j]) {
                count++;
                while (count == pat.length) {
                    if (len < minLen) {
                        minLen = len;
                        minLenIndex = i - len + 1;
                    }
                    len--;
                    int pj = str[i - len] - 'a';
                    window[pj]--;
                    if (pfreq[pj] > 0 && window[pj] < pfreq[pj]) {
                        count--;
                    }
                }
            }
        }
        return minLenIndex == -1 ? "-1" : s.substring(minLenIndex, minLenIndex + minLen);
    }

}