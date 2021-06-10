/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.backtracking;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: WordBreak.java, v 0.1 2020-04-01 3:28 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
//https://www.geeksforgeeks.org/word-break-problem-dp-32/?ref=rp
//In geeks bt approach and dp is similar except bt appraoch provides result strings
//seems below solutions follows DP and not sure about bt
//bt -> backtracking
public class WordBreak {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                Set<String> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    set.add(sc.next());
                }
                String s = sc.next();
                List<String> res = new ArrayList<>();
                wordBreakBTForward(s, set, 0, "", res);
                Collections.sort(res);
                for (String resStr : res) {
                    System.out.print(resStr);
                }
                System.out.println();
            }
        }
    }

    static void wordBreakBTForward(String s, Set<String> set, int start, String resStr, List<String> res) {
        String str = "";
        for (int i = start; i < s.length(); i++) {
            str += s.charAt(i);
            if (set.contains(str)) {
                if (i == s.length() - 1) {
                    res.add("(" + resStr + str + ")");
                } else {
                    wordBreakBTForward(s, set, i + 1, resStr + str + " ", res);
                }
            }
        }
    }

    static void wordBreakBTBackward(String word, Set<String> set, int l, String resStr, List<String> res) {
        String str = "";
        for (int i = l - 1; i >= 0; i--) {
            str = word.charAt(i) + str;
            if (set.contains(str)) {
                if (i == 0) {
                    res.add("(" + str + resStr + ")");
                } else {
                    wordBreakBTBackward(word, set, i, " " + str + resStr, res);
                }
            }
        }
    }

    //possible dp appraoch, accepted on practice, but not on geeks
    static boolean wordBreakDP(String word, String[] ar, int n) {
        if (word.length() == 0)
            return true;
        if (n == 0)
            return false;

        if (word.contains(ar[n - 1])) {
            return wordBreakDP(word.replace(ar[n - 1], ""), ar, n - 1) ||
                    wordBreakDP(word, ar, n - 1);
        }
        return wordBreakDP(word, ar, n - 1);
    }
}